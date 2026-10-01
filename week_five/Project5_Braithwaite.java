import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


//Part A program starts

class StackOverflowException extends RuntimeException{
    public StackOverflowException(String message){
        super(message);
    }
}


class StackUnderflowException extends RuntimeException{
    public StackUnderflowException(String message){
        super(message);
    }
}

class BoundedStack<T>{
    private final T[] array;
    private int peak;
    private final int capacity;

//To take care of the warning message, because it isn't detrimental to our code (at least not yet), we can supress the error messages with @SupressWarnings("unchecked"), to supress all warnings with unchecked values/casts
//Java tells us that this is bad because of the risks of casting raw types with unchecked exceptions, but it won't definitively cause an error or crash our code.

    @SuppressWarnings("unchecked")
    public BoundedStack(int capacityAmount){
        this.capacity = capacityAmount;
        this.array = (T[]) new Object[capacity];
        this.peak = -1;
    }
//Included comment code in case try catch block was needed here, wasn't sure if error needed to be handled in part A. Uncomment if handling was intended.
    public void push(T element) throws StackOverflowException{
        //try{
        if ((peak + 1) >= capacity){
            throw new StackOverflowException("Error: Stack Overflow in BoundedStack -- Requested input, " + (peak + 2) + " exceeds existing capacity of " + (peak + 1) + " with a maximum of " + capacity);
        }
            array[++peak] = element;
        //}catch (StackOverflowException er){
            //System.out.println(er);
            //System.exit(1);
        //}
    }
//Same down here, wasn't sure for pop() or peek()
    public void pop() throws StackUnderflowException{
        //try {
            if((peak + 1) == 0){
                throw new StackUnderflowException("Error: Attempt to remove top of BoundedStack while current stack items is at " + (peak + 1) + ". Maximum capacity is " + capacity);
            }
        //} catch (StackUnderflowException er) {
            //System.out.println(er);
           // System.exit(1);
        //}
        array[peak] = null;
        peak--;
    }

    public T peek() throws StackUnderflowException{
        //try {
            if ((peak + 1) == 0){
                throw new StackUnderflowException("Error: Attempting to view a stack list, BoundedStack, that is null. Stack items: " + (peak + 1) + " Maximum capacity: " + capacity);
            }
        //} catch (StackUnderflowException er) {
            //System.out.println(er);
            //System.exit(1);
        //}
        return array[peak];
    }

    public boolean isEmpty(){
        return (peak + 1) == 0;
    }

    public boolean isFull(){
        return (peak + 1) == capacity;
    }

    public int size(){
        return peak + 1;
    }

    public int capacity(){
        return capacity;
    }

    @Override 
    public String toString(){
        for(int i = 0; i < array.length; i++){
            System.out.println("Array index " + i + " Value: " + array[i]);
        }
        return "print completed";
    }
}

//Part B Code Starts

class SafeFileReader{
    
    File samples = new File("sample.txt"/*"smple.txt"*/); 
    public ArrayList<String> readData = new ArrayList<>();

    public void ReadFile(){
        int linesRead = 0;
        try (BufferedReader input = new BufferedReader(new FileReader(samples))){
            String var;
            while ((var = input.readLine()) != null){
                linesRead++;
                readData.add(var);
                if ((var = input.readLine()) == null){
                    break;
                } else {
                    linesRead++;
                    readData.add(var);
                }
            }
            System.out.println(readData);
        }catch(FileNotFoundException er){
            System.out.println("Error: File " + samples + " not found in working directory");
        }catch(IOException er){
            System.out.println("Error: an Input or Output operation has failed!");
        } finally {
            System.out.println("Lines Read: " + linesRead);
        }
    }
}

//Testing Code
public class Project5_Braithwaite {
    public static void main(String[] args) {

//Part A Testing

        BoundedStack<Integer> stack = new BoundedStack<>(1);
        BoundedStack<Integer> stackTwo = new BoundedStack<>(0);

        stack.push(10);
//      stack.push(2);
//      stackTwo.peek();
//      stackTwo.pop();
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.capacity());

//Part B Testing

        SafeFileReader file = new SafeFileReader();
        file.ReadFile();

    }
}

//Claude used for debugging explanations, prompt(s): why am I getting an arrayindex exception instead of my predefined stack overflow, just explain no solution code : explain logic error for line 112, why is it adding null at the end of the array? no solution code

//Used https://www.geeksforgeeks.org/dsa/implement-stack-using-array/ and https://www.baeldung.com/java-warning-unchecked-cast for help understanding the data structure of stacks and array implementation, as well as unchecked casting.

/*
Analysis:
The reason we use RuntimeException for an extension instead is because we want our declared exceptions to be associated with actual runtime exceptions such as IO, Index, etc.
Another reason could be that we don't want our custom exceptions to be checked, or forcefully caught by the compiler outside of declaration for the methods we originally structured the exceptions for, due to the fact that they don't need to always be caught/declared.
In other words, the custom exceptions were built exclusively for push(), pop(), and peek(), not for the entire environment, and not to be always caught.

If an exception is thrown inside the try-with-resources block, the block will automatically close and the resources will automatically close with it. That way, resources aren't stuck open, and nothing is overwritten.
*/