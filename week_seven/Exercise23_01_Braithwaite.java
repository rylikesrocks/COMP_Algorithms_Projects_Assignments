import java.util.Comparator;

//Natural BubbleSort Implementation.

public class Exercise23_01_Braithwaite {
    public static <E extends Comparable<E>> void bubbleSort(E[] list){
        for(int i = 1; i < list.length; i++){
            for (int j = 0; j < list.length - i; j++){
                if (list[j].compareTo(list[j + 1]) > 0){
                    E temporary = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temporary;
                }
            }
        }
    }

//BubbleSort with comparator implementation.

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator){
        for(int i = 1; i < list.length; i++){
            for (int j = 0; j < list.length - i; j++){
                if (comparator.compare(list[j], list[j + 1]) >= 1){
                    E temporary = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temporary;
                }
            }
        }
    }

//Testing
    public static void main(String[] args) {
        Integer[] testList = {44, 23, 198, 647, 10, 4, 72 , -2};
        String[] testListTwo = {"Jeremy", "CCoOL", "wHacK", "Pow", "zAm"};
        Comparator<String> insensitive = (s1, s2) -> s1.compareToIgnoreCase(s2);
        bubbleSort(testList);
        bubbleSort(testListTwo, insensitive);
        for (int i = 0; i < testListTwo.length; i++){
            System.out.print(testListTwo[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < testList.length; i++){
            System.out.print(testList[i] + " ");
        }
    }
}

//Used Claude for some debugging help
//https://www.geeksforgeeks.org/java/java-comparator-interface/ for comparator interface help, and the textbook for bubblesort for-loop understanding
//https://www.youtube.com/watch?v=tj5sLSFjVj4&t=444s for help remembering lambdas.