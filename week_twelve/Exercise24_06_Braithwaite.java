import java.util.*;
public class Exercise24_06_Braithwaite {
    static class MyPriorityQueue<E>{
        Comparator<E> comp;
        private ArrayList<E> backedList;

// Main priority queue code

        public MyPriorityQueue(Comparator<E> comp){
            this.comp = comp;
            backedList = new ArrayList<>();
        };

//Finding left, right, and parent values.

        public static int parent(int i){
            return (i - 1) /2;
        }

        public static int leftChild(int i){
            return (2 * i) + 1;
        }
        
        public static int rightChild(int i){
            return (2 * i) + 2;
        }

// Move up code to sift up through the list, used after adding

        public void moveUp(){
            int i = backedList.size() - 1;

            while(i > 0){

                if(comp.compare(backedList.get(i), backedList.get(parent(i))) >= 0){
                    break;
                }

                Collections.swap(backedList, i, parent(i));
                i = parent(i);
            }
        }

//MoveDown to sift down through the list, used after removing

        public void moveDown(int i){
            int max = i;

            if (leftChild(i) < backedList.size() && comp.compare(backedList.get(leftChild(i)), backedList.get(max)) < 0){
                max = leftChild(i);
            }

            if (rightChild(i) < backedList.size() && comp.compare(backedList.get(rightChild(i)), backedList.get(max)) < 0){
                max = rightChild(i);
            }
            if(i != max){
                Collections.swap(backedList, i, max);
                moveDown(max);
            }
        }

//Simple enqueue code, add object, swap

        public void enqueue(E object){
            backedList.add(object);
            moveUp();
        }

//Dequeue more complicated, set temporary obj, remove said obj, then sift down and return temp obj, unless the queue is empty

        public E dequeue(){
            if(backedList.isEmpty()){
                throw new NoSuchElementException("Queue is Empty");
            }
            int conts = backedList.size() - 1;
            E root = backedList.get(0);
            E save = backedList.remove(conts);

            if(backedList.isEmpty()){
                return root;
            }else{
                backedList.set(0, save);
                moveDown(0);
                return root;
            }
        }

        @Override 
        public String toString(){
            System.out.println("Printed Deque: ");
            for(E item : backedList){
                System.out.print(item + " ");
            }
            return "[Completed]";
        }
    }

    //Testing 

    public static void main(String[] args) {
        Comparator<String> comparative = Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER);
        MyPriorityQueue<String> mnCityNames = new MyPriorityQueue<>(comparative);

        mnCityNames.enqueue("Rochester");
        mnCityNames.enqueue("MinnEaPolIs");
        mnCityNames.enqueue("hoUstoN");
        mnCityNames.enqueue("WINONA");
        mnCityNames.enqueue("St. Paul");

        for(int i = 0; i < 5; i++){
            System.out.println(mnCityNames.dequeue());
        }
    }
}


//Credit to Claude and https://www.geeksforgeeks.org/dsa/priority-queue-using-binary-heap/ for syntax and logic/debugging help
