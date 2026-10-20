import java.util.Arrays;

public class Exercise19_01_Braithwaite {
    public static class GenericStack<E>{
        private E[] backingArray;
        int currentSize;
        int currentTop;

        @SuppressWarnings ("unchecked")
        public GenericStack(){
            this.currentSize = 0;
            this.backingArray = (E[]) new Object[5];
            this.currentTop = -1;
        }

        public void push(E value){
            if(currentSize == (backingArray.length)){
                adjust();
            }
            backingArray[++currentTop] = value;
            currentSize++;
        }

        public E pop(){
            if(currentSize == 0){
                throw new IndexOutOfBoundsException("Error: pop() attempt on an empty stack.");
            }
            E poppedVal = backingArray[currentTop];
            backingArray[currentTop] = null;
            --currentTop;
            --currentSize;
            System.out.println(poppedVal);
            return poppedVal;
        }

        public E peek(){
            if(currentSize == 0){
                throw new IndexOutOfBoundsException("Error: peek() attempt on an empty stack.");
            }
            return backingArray[currentTop];
        }

        public boolean isEmpty(){
            if(currentSize == 0){
                return true;
            }else{
            return false;
            }
        }

        public Integer getSize(){
            return backingArray.length;
        }

        @SuppressWarnings ("unchecked")
        public void adjust(){
            E[] oldValue = (E[]) new Object[backingArray.length];
            System.arraycopy(backingArray, 0, oldValue, 0, backingArray.length);
            int adjustedCap = backingArray.length * 2;
            backingArray = Arrays.copyOf(oldValue, adjustedCap);

        }
    }

    //Testing

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        GenericStack<String> stackTwo = new GenericStack<>();

        System.out.println(stack.isEmpty());
        stack.push(10);
        stack.push(5);
        stack.push(4);
        stack.push(20);
        System.out.println(stack.getSize());
        stack.push(40);
        stack.push(50);
        System.out.println(stack.peek());
        System.out.println(stack.getSize());
        stack.pop();
        System.out.println(stack.isEmpty());

    //Second stack Testing

        System.out.println(stackTwo.isEmpty());
        stackTwo.push("Walter White");
        stackTwo.push("Hank Hill");
        stackTwo.push("Beavis");
        stackTwo.push("Butthead");
        System.out.println(stackTwo.getSize());
        stackTwo.push("Tony Hawk");
        stackTwo.push("Jesse Pinkman");
        stackTwo.pop();
        System.out.println(stackTwo.getSize());
        System.out.println(stackTwo.peek());
        System.out.println(stackTwo.isEmpty());
        


    }
}
