import java.util.*;

public class Exercise24_04_Braithwaite {
    public static class Stack<E> extends java.util.ArrayList<E>{
        private final ArrayList<E> gen;
        private int top;

        //Constructor initializing the arraylist and top.
        public Stack(){
            this.gen = new ArrayList<>();
            top = -1;
        }
        //Push method adding to the top of the stack.
        public void push(E gen){
            this.gen.add(gen);
            top++;
        }
        //Pop method removing from the top of the list.
        public E pop(){
            if(top < 0){
                throw new IndexOutOfBoundsException("Cannot pop on an empty stack");
            }
            E tempEl = this.gen.get(top);
            this.gen.remove(top);
            top--;
            return tempEl;

        }
        //Peek method to look at the top index value.
        public E peek(){
            return this.gen.get(top);
        }
        //isEmpty override to account for top.
        @Override 
        public boolean isEmpty(){
            return top < 0;
        }
        //getSize method to return top and the size of the stack by decimal value. -1 if size is empty;
        public int getSize(){
            return top;
        }
    }
    //Method to check for prime numbers
    public static boolean primeEnergy(int number){
        if(number <= 1){
            return false;
        }else if(number == 2){
            return true;
        }
        return (number % 2 != 0);
    }
    //Main and testing.
    public static void main(String[] args) {
        Stack<Integer> newStack = new Stack<>();
        int containCont = 0;
        int cont = 0;

        System.out.println("Ascending order push(): ");
        while(containCont != 50){
            if(primeEnergy(cont)){
                newStack.push(cont);
                System.out.print(cont + " ");
                containCont++;
            }
            cont++;
        }

        System.out.println("\nDescending order pop(): ");
        while(!newStack.isEmpty()){
            System.out.print(newStack.pop() + " ");
        }

        //The reason that the found numbers are printed in descending order rather than ascending is stack follows the LIFO principle.
        //Pop() removes the top element of the stack, so in this case it would be the highest number, then works its way down the stack.
        //Push() on the other hand adds to the top of the stack, hence why the order is ascending when printing Push().
        //Its basically just like counting up, then switching and counting down for the two methods.
    }
}
