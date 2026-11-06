import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Project9_Braithwaite {
    public static class Node<E>{
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E e){
            element = e;
        }
    }

    public static class MyLinkedList<E> implements Iterable<E>{
        Node<E> head;
        Node<E> tail;
        private int size;

        public MyLinkedList(){
            head = new Node<>(null);
            tail = new Node<>(null);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(E e){
            Node<E> newVal = new Node<>(e);
            Node<E> afterFirst = head.next;

            
            newVal.next = afterFirst;
            newVal.prev = head;
            head.next = newVal;
            afterFirst.prev = newVal;
            size++;
        }

        public void addLast(E e){
            Node<E> newVal = new Node<>(e);
            Node<E> beforeLast = tail.prev;

            newVal.prev = beforeLast;
            newVal.next = tail;
            tail.prev = newVal;
            beforeLast.next = newVal;
            size++;
        }

        public void add(int index, E e){
            Node<E> newVal = new Node<>(e);
            Node<E> sentinel = head;
            int count = 0;
            while(count != index){
                sentinel = sentinel.next;
                count++;
            }
            Node<E> sentinelClone = sentinel.next;
            newVal.next = sentinelClone;
            newVal.prev = sentinel;
            sentinelClone.prev = newVal;
            sentinel.next = newVal;
            size++;
        }

        public void removeFirst() throws NullPointerException{
            if(head.next == tail && tail.prev == head){
                throw new NullPointerException("List is empty! Please add to list using addFirst(), addLast(), or add()");
            }
            Node<E> removeFlag = head.next;
            Node<E> flag = removeFlag.next;
            flag.prev = head;
            head.next = flag;
            
            size--;
        }
        public void removeLast() throws NullPointerException{
            if(head.next == tail && tail.prev == head){
                throw new NullPointerException("List is empty! Please add to the list using addFirst(), addLast(), or add()");
            }
            Node<E> removeFlag = tail.prev;
            Node<E> flag = removeFlag.prev;
            flag.next = tail;
            tail.prev = flag;
            removeFlag.next = null;
            removeFlag.prev = null;
            
            size--;
        }
        public void remove(int index) throws Exception{
            if(head.next == tail && tail.prev == head){
                throw new NullPointerException("List is empty! Please add to the list using addFirst(). addLast(), or add(), Index may also be invalid!");
            }
            int count = 0;
            Node<E> removeFlag = head.next;
            if(index >= size || index < 0){
                throw new IndexOutOfBoundsException("Invalid index, please enter a valid index between 0 and the maximum index value of the List. Use size() to get the size of the List.");
            }
            while(count != index){
                removeFlag = removeFlag.next;
                count++;
            }
            Node<E> flagNext = removeFlag.next;
            Node<E> flagPrev = removeFlag.prev;
            flagNext.prev = flagPrev;
            flagPrev.next = flagNext;
            removeFlag.next = null;
            removeFlag.prev = null;
        }

        public E get(int index){
            Node<E> getIndex = head.next;
            int count = 0;
            if(index >= size || index < 0){
                throw new IndexOutOfBoundsException("Invalid Index! Please enter an index between 0 and the size of the List");
            }
            while(count != index){
                getIndex = getIndex.next;
                count++;
            }
            return getIndex.element;
        }

        public void set(int index, E e){
            Node<E> getIndex = head.next;
            int count = 0;
            if(index >= size || index < 0){
                throw new IndexOutOfBoundsException("Invalid Index! Please enter an index between 0 and the size of the List");
            }
            while(count != index){
                getIndex = getIndex.next;
                count++;
            }
            getIndex.element = e;
        }

        public int indexOf(E e){
            Node<E> getNode = head.next;
            int count = 0;
            while(count < size){
                if(getNode.element == e){
                    return count;
                }
                getNode = getNode.next;
                count++;
            }
            return -1;
        }

        public boolean contains(E e){
            Node<E> getNode = head.next;
            int count = 0;
            while(count < size){
                if(getNode.element == e){
                    return true;
                }
            }
            return false;
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return head.next == tail;
        }

        public void clear(){
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void reverse(){
            int counter = 0;
            Node<E> sent = head.next;
            while(counter != size){
                Node<E> placeHolder = sent.next;
                // 1st. placeHolder = Jasmine
                // 2nd. placeHolder = Parker
                // 3rd. placeHolder = John
                // 4th. placeHolder = null;
                sent.next = sent.prev;
                // 1st. sent.next (next element) = null (prev element)
                // 2nd. sent.next = Lilly
                // 3rd. sent.next = Jasmine
                // 4th. (final) sent.next = Parker
                sent.prev = placeHolder;
                // 1st. sent.prev (previous element) = Jasmine
                // 2nd. sent.prev = Parker
                // 3rd. sent.prev = John
                // 4th. sent.prev = null
                sent = placeHolder;
                //1st. sent (current element) = Jasmine
                //2nd sent = Parker
                //3rd. sent = John
                //4th sent = null
                counter++;

                //End 1. The first node to be adjusted is null as shown by sent.next. The last element (first) of the list becomes Lilly where the first element becomes Jasmine. sent.prev reveals this.
                //End 2. The second node to be adjusted is Jasmine, as she as placed just before Lilly at the end of the list, swapped with Parker.
                //End 3. The third node to be adjusted is Parker, and he is placed before Jasmine at the end of the list.
                //End 4. The final node swappped is null, John is already in position but swapped with null (technically the tail of the list), and placed just behind Parker.
            }
            Node<E> og = head.next;
            head.next = tail.prev;
            tail.prev = og;

            head.next.prev = head;
            tail.prev.next = tail;

            // Sets head and tail back to normal to reorder the list porperly, and so head.next doesn't break when printing the list.
        }

        @Override 
        public String toString(){
            Node<E> showElements = head.next;
            int count = 0;
            System.out.println("List Elements: ");
            while(count < size){
                System.out.print(showElements.element + " ");
                showElements = showElements.next;
                count++;
            }
            return "\n--End of List--";
        }

        @Override 
        public Iterator<E> iterator(){
            return new ListIterator();
        }

        public class ListIterator implements Iterator<E>{
            Node<E> index = head;

            @Override 
            public boolean hasNext() {
                return index != tail;
            }

            @Override
            public E next(){
                if (!hasNext()){
                    throw new NoSuchElementException("next() has no next element in the List");
                }
                index = index.next;
                return index.element;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList<String> test = new MyLinkedList<>(); 
        MyLinkedList<Integer> performanceTest = new MyLinkedList<>();
        ArrayList<Integer> arrPerfTest = new ArrayList<>();
        Random randNum = new Random();
        int count = 0;

        int numPicker = randNum.nextInt(50);
        int middle = 99999 / 2;

        //Time Testing: Adding elements

        System.out.println("Adding Elements Test:");

        long start = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            performanceTest.addFirst(numPicker);
        }
        long end = System.nanoTime();
        System.out.println("Linked List Time: " + (end - start) + "ns");

        start = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            arrPerfTest.add(numPicker);
        }
        end = System.nanoTime();
        System.out.println("Array List Time: " + (end - start) + "ns");

        //Time Testing: Random Access

        System.out.println("Random Access Test: ");

        start = System.nanoTime();
        performanceTest.get(middle);
        end = System.nanoTime();
        System.out.println("Linked List Time: " + (end - start) + "ns");

        start = System.nanoTime();
        arrPerfTest.get(middle);
        end = System.nanoTime();
        System.out.println("Array List Time: " + (end - start) + "ns");

        //Time Testing: Iteration

        System.out.println("Iteration Test: ");

        start = System.nanoTime();
        for(Integer element : performanceTest){
            count++;
        }
        end = System.nanoTime();
        System.out.println("Linked List Time: " + (end - start) + "ns");

        start = System.nanoTime();
        for(Integer element : arrPerfTest){
            count++;
        }
        end = System.nanoTime();
        System.out.println("Array List Time: " + (end - start) + "ns");

        /*
        Analysis:
        These results make sense due to how both ArrayLists and LinkedLists work.
        LinkedLists don't have the luxury of index-based iteration, so looking from node to node takes longer than looking at a set of numbers
        ArrayLists are faster in iteration because of this, they can simply count indexes and reach a location faster than a Linked List would
        In almost every aspect of iteration, an ArrayList beats out the LinkedList because of this fact.
        Despite this, Linked Lists are still very useful for insertion at different varying indexes, because it doesn't need to restructure an entire list for one addition, all it needs to do is relink a couple pointers.
        */

        //Regular Testing

        test.addFirst("John");
        test.addFirst("Parker");
        test.addFirst("Jasmine");
        test.addFirst("Lilly");
        System.out.println(test.get(0));

        //Reversal Test P.S. check above for description of reversal.

        System.out.println("Reverse Test: ");
        System.out.println(test);
        test.reverse();
        System.out.println(test);
    }
 }

 //Credit to Claude with helping with logic errors and syntax bugs.
 //Credit to https://www.geeksforgeeks.org/dsa/doubly-linked-list-using-sentinel-nodes/ for helping understand Doubly LinkedLists and their operations.

