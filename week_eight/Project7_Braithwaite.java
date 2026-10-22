import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Project7_Braithwaite {

//Part A code

    public static class Pair<A,B>{
        private final A value;
        private final B valueTwo;

        public Pair(A value, B valueTwo){
            this.value = value;
            this.valueTwo = valueTwo;
        }

        public Pair(){
            this.value = null;
            this.valueTwo = null;
        }

        public A getKey(){ return value; }

        public B getValue(){ return valueTwo; }

        public static <A,B> Pair<A,B> of(A value, B valueTwo){
            return new Pair<>(value, valueTwo);
        }

        @Override 
        public String toString(){
            return "The value of index A is:" + value + " The value of index B is: " + valueTwo;
        }

        @Override 
        public boolean equals(Object obj){
            if(this == obj){
                return true;
            }
            if(obj == null) {
                return false;
            }
            if(this.getClass() != obj.getClass()){
                return false;
            }
            Pair<?, ?> other = (Pair<?,?>) obj;
            return this.value == other.value && Objects.equals(this.valueTwo, other.valueTwo);
        }

        @Override
        public int hashCode(){
            return Objects.hash(value,valueTwo);
        }
    }

    public static class Triple<A, B, C> extends Pair<A,B>{
        private final C valueThree;

        public Triple(A value, B valueTwo, C valueThree){
            super(value, valueTwo);
            this.valueThree = valueThree;
        }

        public C getValThree(){
            return valueThree;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj){
                return true;
            }
            if(obj == null){
                return false;
            }
            if(this.getClass() != obj.getClass()){
                return false;
            }
            Triple<?,?,?> triple = (Triple<?,?,?>) obj;
            return super.equals(obj) && Objects.equals(this.valueThree, triple.valueThree);
        }
        @Override
        public int hashCode(){
            return Objects.hash(super.value, super.valueTwo, valueThree);
        }

        @Override 
        public String toString(){
            return "The value of index A is:" + super.value + " The value of index B is: " + super.valueTwo + " The value of index C is: " + valueThree;
        }
    }
    
//Part B Code

    public static class SortedArray<T extends Comparable<T>>{
        private T[] array;
        private int maxIndex;

        public final void sort(T[] array){
            if(array == null){
                throw new NullPointerException("Array cannot be null!");
            }
            for(int i = 1; i < maxIndex; i++){
                T pos = array[i];
                int constant;
                for(constant = i-1; constant >= 0 && array[constant].compareTo(pos) > 0; constant--){
                    array[constant + 1] = array[constant];
                }
                array[constant + 1] = pos;
            }
        }

        public void adjust(){ 
            if(array == null){
                throw new ArrayIndexOutOfBoundsException("Error: Attempting to adjust/insert on a null array!");
            } else {
            int diffCap = array.length * 2;
            array = Arrays.copyOf(array, diffCap);
            }
        }

        public SortedArray(T[] array){
            this.array = array;
            this.maxIndex = array.length;
            sort(array);
        }

        public void insert(T element){
            if (array == null){
                throw new NullPointerException("Array cannot be null!");
            }
            if(maxIndex == array.length){
                adjust();
                if(array[maxIndex] == null){
                    array[maxIndex] = element;
                    maxIndex++;
                }
            } else {
                array[maxIndex] = element;
                maxIndex++;
            }
            sort(array);

        }

        public void remove(T element){
            boolean success = false;
            for(int i = 0; i < maxIndex; i++){
                if(array[i].equals(element)){
                    array[i] = null;
                    T temp = array[i];
                    array[i] = array[maxIndex - 1];
                    array[maxIndex - 1] = temp;
                    success = true;
                    break;
                }
            }
            if(success == true){
            maxIndex--;
            sort(array);
            }
        }
        public T get(int i){
            return array[i];
        }
        public int size(){
            return maxIndex;
        }
        @Override 
        public String toString(){
            System.out.print("Array values:");
            for(int i = 0; i < array.length - 1; i++){
                System.out.print(" " + array[i]);
            }
            return " " + array[array.length - 1];
        }

        public int binarySearch(T element){
            int lowPointer = 0;
            int highPointer = maxIndex - 1;
            while(lowPointer <= highPointer){
                int middleIndex = (lowPointer + highPointer) / 2;
                T middleValue = array[middleIndex];

                if(element.compareTo(middleValue) == 0){
                    return middleIndex;
                } else if (element.compareTo(middleValue) < 0){
                    highPointer = middleIndex - 1;
                } else if(element.compareTo(middleValue) > 0){
                    lowPointer = middleIndex + 1;
                }
            }
            return -1;
        }
    }


//Part C Code

    public static <T> void swap(T[] arr, int i, int j){
        int temp = i;
        arr[i] = arr[j];
        arr[j] = arr[temp];
    }


    public static double sumList(List<? extends Number> list){
        double maximum = 0;
        for(Number number : list){
                maximum = maximum + number.doubleValue();
            }
        return maximum;
    }
    public static <T extends Comparable<T>> T max(List<T> list){
        T greatestValue = list.get(0);
        for(int i = 0; i < list.size(); i++ ){
            if(greatestValue.compareTo(list.get(i)) < 0){
                greatestValue = list.get(i);
            }
        }
        return greatestValue;
    }

    public static void main(String[] args) {

//Part A testing

        Pair<String, Integer> nameBirthday = new Pair<>("Jasmine", 1998); //Correct Safety
        System.out.println(nameBirthday.getKey());
        System.out.println(nameBirthday.getValue());
        // Pair<String, String> incorrectBirthday = new Pair<>("Josh", 1988); // Type safety, program throws a compile time error instead of crashing and throwing a stack trace Uncomment for testing

//Part B Testing

        Integer[] testListOne = {500, 600, 44, 29, 33};
        String[] testListTwo = {"Jimmy", "Abigail", "Ben", "Zane", "Chris"};
        Double[] testListThree = {99.4, 106.9, 109.99, 5000.2, 33.7};

        SortedArray<Integer> testOne = new SortedArray<>(testListOne);
        System.out.println(testOne);
        System.out.println(testOne.binarySearch(29));
        testOne.remove(600);
        testOne.insert(700);
        System.out.println(testOne.size());
        System.out.println(testOne.get(4));

        SortedArray<String> testTwo = new SortedArray<>(testListTwo);
        System.out.println(testTwo);
        System.out.println(testTwo.binarySearch("Zane"));
        testTwo.remove("Zane");
        testTwo.insert("Zack");
        System.out.println(testTwo.size());
        System.out.println(testTwo.get(4));

        SortedArray<Double> testThree = new SortedArray<>(testListThree);
        System.out.println(testThree);
        System.out.println(testThree.binarySearch(55.4));
        testThree.remove(5000.2);
        testThree.insert(400.567);
        System.out.println(testThree.size());
        System.out.println(testThree.get(2));

//Part C Testing

        List<Integer> newList = new ArrayList<>();
        newList.add(500);
        newList.add(600);
        newList.add(44);
        newList.add(29);
        newList.add(33);

        System.out.println("\n" + newList);
        swap(testListOne, 4, 1);
        System.out.println(sumList(newList));
        System.out.println(max(newList));

    }
}

//Used Claude and GPT for some logic debugging help, and fixing errors.
//Credit to: https://www.youtube.com/watch?v=NFhOrxtXXcM for helping with remembering what binary search does
//Credit to https://www.geeksforgeeks.org/java/overriding-equals-method-in-java/ for override equals logic and hashMap
