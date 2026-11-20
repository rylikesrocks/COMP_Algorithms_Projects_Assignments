import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Random;

public class Project10_Braithwaite {
    public static class Node<E>{
        E element;
        Node<E> next;

        public Node(E e){
            this.element = e;
        }
    }

//Stack and Queue Code implementation

    public static class MyStack<E>{
        Node<E> head;
        Node<E> tail;
        Node<E> top;
        int size;

        public MyStack(){
            this.head = null;
            this.tail = null;
            this.top = null;
            this.size = 0;
        }

//Push, pop, and peek methods. IsEmpty is based on top, not size

        public void push(E element){
            Node<E> new_node = new Node<>(element);
            if(head == null && tail == null){
                new_node.next = head;
                head = new_node;
                top = new_node;
                size++;
            }else{
                new_node.next = top;
                top = new_node;
                size++;
            }
        }

        public E pop(){
            if(top == null){
                throw new EmptyStackException();
            }
            E el = top.element;
            top = top.next;
            size--;
            return el;
        }

        public E peek(){
            if(top == null){
                throw new EmptyStackException();
            }
            return top.element;
        }

        public boolean isEmpty(){
            return top == null;
        }

        public int size(){
            return size;
        }
    }

    public static class MyQueue<E>{
        Node<E> head;
        Node<E> tail;
        int size;

        public MyQueue(){
            this.head = null;
            this.tail = null;
            size = 0;
        }

//Offer and Poll methods, offer adds elements, poll removes.

        public void offer(E element){
            Node<E> new_node = new Node<>(element);
            if(head == null){
                head = new_node;
                tail = new_node;
                size++;
            }else{
                head.next = new_node;
                head = new_node;
                size++;
            }
        }

        public E poll(){
            if(tail == null){
                throw new NoSuchElementException("Exception: attempting to dequeue on an empty queue");
            }
            E toll = tail.element;
            tail = tail.next;
            size--;
            return toll;
        }

//Peek returns the tail element instead of a top node.

        public E peek(){
            if(tail == null){
                throw new NoSuchElementException("Exception: attempting to dequeue on an empty queue");
            }
            return tail.element;
        }

        public boolean isEmpty(){
            return head == null;
        }

        public int size(){
            return size;
        }
    }

//IsBalanced checks the balance of parenthesis types {[()]}, and determines first error position

    public boolean isBalanced(String expression){
        MyStack<Character> stack = new MyStack<>();
        boolean balance = false;
        int posCheck = 0;
        for(int i = 0; i < expression.length(); i++){
            char tempChar = expression.charAt(i);
            if(tempChar == '{' || tempChar == '[' || tempChar == '('){
                stack.push(tempChar);
        }else if(tempChar == '}' || tempChar == ']' || tempChar == ')'){
            if(stack.isEmpty()){
                System.out.println("ERROR: String is not balanced, first detected position at " + posCheck);
                return balance;
            }

        char checker = stack.pop();
        if((tempChar == ')' && checker != '(') || (tempChar == ']' && checker != '[') || (tempChar == '}' && checker != '{')){
            System.out.println("ERROR: String is not balanced, first detected position at " + posCheck);
            return balance; 
        }   
    }
    posCheck++;
}
    if(stack.isEmpty()){
        balance = true;
        return balance;
    }
    return balance;
    }

//Min heap that implements parent, leftChild, and rightChild. Utilizes this and extractMin to sort.

    public static class MinHeap<E extends Comparable<E>>{
        E[] array;
        int size;
        int capacity;

        @SuppressWarnings("unchecked")
        public MinHeap(int cap){
            this.array = (E[]) new Comparable[cap];
            this.size = 0;
            this.capacity = cap;
        }

        public int parent(int i){
            return (i - 1) / 2;
        }

        public int leftChild(int i){
            return (2*i) + 1;
        }

        public int rightChild(int i){
            return (2*i) + 2;
        }

        public void siftUp(int i, E[] array){
            while(i > 0){

                if(array[parent(i)].compareTo(array[i]) <= 0){
                    break;
                }
                E temporary = array[parent(i)];
                array[parent(i)] = array[i];
                array[i] = temporary;
                i = parent(i);
            }
        }

        public void siftDown(int i, E[] array){
            int maximum = i;

            if(leftChild(i) < size && array[leftChild(i)].compareTo(array[maximum]) < 0){
                maximum = leftChild(i);
            }
            if(rightChild(i) < size && array[rightChild(i)].compareTo(array[maximum]) < 0){
                maximum = rightChild(i);
            }
            if(i != maximum){
                E temporary = array[i];
                array[i] = array[maximum];
                array[maximum] = temporary;
                siftDown(maximum, array);
            }
        }

        public void insert(E element){
            if(size >= capacity){
                throw new IndexOutOfBoundsException("ERROR: insertion point is greater than capacity, remove an element!");
            }
            array[size] = element;
            size++;
            siftUp(size - 1, array);
        }

        public E extractMin(){
            if(size == 0){
                throw new NoSuchElementException("ERROR: Empty queue, attempt to extract an empty value throws exception! Capacity & Size: " + capacity + ", " + size);
            }
            E minimum = array[0];
            array[0] = array[size - 1];
            size--;
            siftDown(0, array);
            return minimum;
        }

        public E peekMin(){
            return array[0];
        }

        public int size(){
            return size;
        }
    }

    //Main testing

    public static void main(String[] args) {
        Project10_Braithwaite classy = new Project10_Braithwaite();
        System.out.println(classy.isBalanced("([)]"));
        System.out.println(classy.isBalanced("{([])}"));

        int[] array = new Random().ints(20, 1, 20).toArray();

        MinHeap<Integer> minHeap = new MinHeap<>(20);
        MyStack<String> stack = new MyStack<>();
        MyQueue<Character> queue = new MyQueue<>();

        stack.push("John");
        stack.push("Sarah");
        stack.push("Mark");
        stack.push("Gertrude");
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());

        queue.offer('J');
        queue.offer('S');
        queue.offer('M');
        queue.offer('G');
        System.out.println(queue.poll());




        for(int i = 0; i < array.length; i++){
            minHeap.insert(array[i]);
        }
        System.out.println("Heap Sort Showcase: ");
        for(int i = 0; i < 20; i++){
            System.out.print(minHeap.extractMin() + " ");
        }
    }
}


//Credit to Claude for syntax and logic debugging help
//Credit to https://www.geeksforgeeks.org/dsa/priority-queue-using-binary-heap/ & https://www.geeksforgeeks.org/dsa/java-program-to-check-for-balanced-brackets-in-an-expression-well-formedness-using-stack/ for min heap code explanation and IsBalanced help.