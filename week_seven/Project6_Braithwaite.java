import java.util.Random;

public class Project6_Braithwaite {
    public static class SortingAlgorithms{
        //Selection sort algorithm
        public static void selectionSort(int[] arr){
            for(int i = 0; i < arr.length - 1; i++){
                int minimumVal = i;
                for(int current = i + 1; current < arr.length; current++){
                    if(arr[current] < arr[minimumVal]){
                        minimumVal = current;
                    }
                }
                int temporary = arr[i];
                arr[i] = arr[minimumVal];
                arr[minimumVal] = temporary;
            }
        }
        //Insertion sort algorithm
        public static void insertionSort(int[] arr){
            for(int i = 1; i < arr.length; i++){
                int position = arr[i];
                int count;
                for(count = i - 1; count >= 0 && arr[count] > position; count--){
                    arr[count + 1] = arr[count];
                }
                arr[count + 1] = position;
            }
        }
        //Main splitter/sorter for mergeSort
        public static void mergeSort(int[] arr){
        int check = arr.length;
        if(check > 1){
            int[] leftPart = new int[arr.length / 2];
            System.arraycopy(arr, 0, leftPart, 0, arr.length / 2);
            int[] rightPart = new int[arr.length - (arr.length / 2)];
            System.arraycopy(arr, arr.length / 2, rightPart, 0, arr.length - arr.length / 2);

            mergeSort(leftPart);
            mergeSort(rightPart);

            merge(leftPart, rightPart, arr);
        }

        }
        //Helper to merge two lists together
        public static void merge(int[] arr1, int[] arr2, int[] temporary){
            int sizeOne = arr1.length;
            int sizeTwo = arr2.length;

            int iterOne = 0;
            int iterTwo = 0;
            int control = 0;

            while(iterOne < sizeOne && iterTwo < sizeTwo){
                if(arr1[iterOne] <= arr2[iterTwo]){
                    temporary[control] = arr1[iterOne];
                    iterOne++;
                }else{
                    temporary[control] = arr2[iterTwo];
                    iterTwo++;
                }
                control++;
            }

            while(iterOne < sizeOne){
                temporary[control] = arr1[iterOne];
                iterOne++;
                control++;
            }
            while(iterTwo < sizeTwo){
                temporary[control] = arr2[iterTwo];
                iterTwo++;
                control++;
            }
        }
    }

    //Testing

    public static void main(String[] args) {
        //Verification Method
        int[] test = {5, 10, 3, 5, 7, 9, 20, 50000, 70, 80, 10000};
        int[] testInsert = {256, 935, 24, 10, 11, 1, 3, 4, 2, 5, 900000};
        int[] testMerge = {99, 567, 1080, 999999, 5671, 324, 8, 792};
        SortingAlgorithms.selectionSort(test);
        SortingAlgorithms.insertionSort(testInsert);
        SortingAlgorithms.mergeSort(testMerge);
        for(int i = 0; i < test.length; i++){ System.out.print(test[i] + " "); }
        System.out.println("");
        for(int i = 0; i < testInsert.length; i++){ System.out.print(testInsert[i] + " "); }
        System.out.println( "");
        for(int i = 0; i < testMerge.length; i++){ System.out.print(testMerge[i] + " "); }
        System.out.println("\n");


        //Benchmarking

        //Tests for selectionSort(), insertionSort(), and mergeSort()

        //Note, I am running tests for each of these using the for loop down below, and documenting it, just not writing out all the code for each sort method.

        for(int i = 1; i <= 5; i++){
            int[] benchmarkOneK = new Random().ints(1000, 0, 1000).toArray();
            int[] benchmarkFiveK = new Random().ints(5000, 0, 5000).toArray();
            int[] benchmarkTenK = new Random().ints(10000, 0, 10000).toArray();
            int[] benchmarkFiftyK = new Random().ints(50000, 0, 50000).toArray();
            System.out.println("Test Number " + i);
            System.out.println("Control Time is: " + System.nanoTime());
            SortingAlgorithms.insertionSort(benchmarkTenK);
            System.out.println("End time is: " + System.nanoTime());

        }
    }
}


/*

Analysis:

1. Each of my measured times roughly follow the idea of Big-O Theory. O(n^2) holds relatively true for both selection and insertion sort, although the times are faster.
Selection sort is pretty quadratic in it's growth, and stays relatively consistent throughout the test runs, runtime growing exponentially in relation to the amount of data.
Insertion sort is interesting, because it is a lot more efficient than selection sort with a lower amount of data. This is where insertion sort excels, and only until around extreme amounts of data does it become vastly inneficient.
Merge sort is the most consistent out of all of these algorithms, and follows O(n) very consistently. When the amount of data doubles, the runtime doubles. For lower data-amounts it rivals insertion sort cloesely, but becomes extrememly efficient with large data-amounts.

2. Insertion sort doesn't directly follow O(n^2) like selection sort does. I believe this is because the method that insertion uses is different to selection. It picks apart a list and "inserts"
it into one that would be naturally sorted. However, as the amount of data grows, I believe that insertion would reach closer to O(n^2).
The method of sorting is still quadratic, and the amount of time that insertion takes to sort would also grow quadratically.

3. For selection sort, I would expect an array size of 1,000,000 to be significantly slower than insertion.
Following O(n^2), which is what insertion sort does with large data sets, I would expect it to take around 15 minutes to complete, due to "insert" method into a sublist which is naturally faster than selection.
Selection sort still generally follow O(n^2), but it takes longer because it has to iterate through every "check," meaning it has no insertion or divide and conquer method. Selection sort is roughly 2 times slower than insertion, so I would think it would take 30-45 minutes.
Merge sort would follow O(n) very closely. A data amount of 1,000,000 would likely take 1 or 2 seconds.



//Credit to Claude for helping with logic debugging

// https://www.geeksforgeeks.org/dsa/merge-sort/ https://www.geeksforgeeks.org/dsa/selection-sort-algorithm-2/ and https://www.geeksforgeeks.org/dsa/insertion-sort-algorithm/ for help with further understanding the structure of these algorithms.


*/