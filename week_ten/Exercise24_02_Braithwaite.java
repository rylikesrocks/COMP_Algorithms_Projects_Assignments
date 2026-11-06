
public class Exercise24_02_Braithwaite {
    public static class Node<E> {
        E element;
        Node<E> next;

        public Node(E e){
            element = e;
        }
    }

    public static class MyLinkedList<E>{
        Node<E> head = null;
        Node<E> tail = null;

        public void addFirst(E data){
            Node<E> add_node = new Node<>(data);
            add_node.next = head;
            head = add_node;
            if(tail == null){
                tail = add_node;
            }
        }

        public boolean contains(Object o){
            Node<E> theNode = head;
            while(theNode != null){
                if(java.util.Objects.equals(theNode.element, o)){
                    return true;
                }
                theNode = theNode.next;
            }
            return false;
        }

        public E get(int index){
            Node<E> theNode = head;
            E failed = null;
            int count = 0;
            try{
                while (theNode != null){
                    if(count == index){
                        return theNode.element;
                    }
                    theNode = theNode.next;
                    count++;
                }
            return failed;
            }catch(Exception e){
                System.out.println("The specified value " + index + " was not found inside the LinkedList");
                return failed;
            }
        }

        public int indexOf(Object o){
            Node<E> theNode = head;
            int count = 0;
            while(theNode != null){
                if(java.util.Objects.equals(theNode.element, o)){
                    return count;
                }
                theNode = theNode.next;
                count++;
            }
            return -1;
        }

        public int lastIndexOf(Object o){
            Node<E> theNode = head;
            int count = 0;
            int index = -1;
            while(theNode != null){
                if(java.util.Objects.equals(theNode.element, o)){
                    index = count;
                }
                theNode = theNode.next;
                count++;
            }
            return index;
        }

        public void set(int index, E e){
            Node<E> theNode = head;
            boolean success = false;
            int count = 0;
            while(theNode != null){
                if(count == index){
                    theNode.element = e;
                    success = true;
                }
                theNode = theNode.next;
                count++;
            }
            if(success == false){
                System.out.println("The Specified index doesn't exist!");
            }
        }

        @Override
        public String toString(){
            Node<E> theNode = head;
            System.out.println("MyLinkedList Values: ");
            while(theNode != null){
                System.out.print(theNode.element + ", ");
                theNode = theNode.next;
            }
            return "--End of List--";
        }
    }

    public static void main(String[] args) {
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addFirst("Data");
        testList.addFirst("String");
        testList.addFirst("String");
        testList.addFirst("Integer");
        testList.addFirst("Boolean");
        testList.addFirst("Double");
        testList.addFirst("Long");
        testList.addFirst("Character");

        System.out.println(testList.get(6));
        System.out.println(testList.lastIndexOf("String"));
        System.out.println(testList.indexOf("String")); 
        System.out.println(testList.contains("Data"));
        System.out.println(testList.contains("Char"));
        testList.set(10, "List");
        System.out.println(testList);


    }
}

//Credit to Claude for helping with debugging errors and syntax bugs
//https://www.geeksforgeeks.org/java/implementing-a-linked-list-in-java-using-class/ and textbook credit for helping understand linkedList implementation.