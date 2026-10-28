import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Project8_Braithwaite {

    //Part A code

    public static void frequencyCounter(){
        HashMap<String, Integer> map = new HashMap<>();
        List<String> onlyOnce = new ArrayList<>();
        TreeMap<String, Integer> tree = new TreeMap<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a file name to be counted: ");

        File file = new File(in.nextLine());
        try {
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                String temp = input.next();
                if(!temp.isEmpty() && Character.isLetter(temp.charAt(0))){
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                }
            }
            for(String key : map.keySet()){
                tree.put(key, map.get(key));
            }
            for(String key : map.keySet()){
                if(map.get(key) == 1){
                    onlyOnce.add(key);
                }
            }

            List<Map.Entry<String, Integer>> topTen = new ArrayList<>(map.entrySet());
            Comparator<Map.Entry<String, Integer>> orderFrequency = Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed();

            topTen.sort(orderFrequency);
            System.out.println("\nList Sorted by Frequency: " + topTen);
            System.out.println("\nAlphabetically Sorted List: " + tree);
            System.out.println("\nWords that only appear Once: " + onlyOnce);
            
            in.close();
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found! " + e.getMessage());
        }
    }

    //Part B code

    public static void idReaderTime(int[] list){
        long start;
        long end;

        List<Integer> listSorted = new ArrayList<>();
        List<Integer> sortThenSearch = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            listSorted.add(list[i]);
            sortThenSearch.add(list[i]);
        }

        HashSet<Integer> hashSorted = new HashSet<>();
        HashSet<Integer> hashSort = new HashSet<>(listSorted);
        System.out.println("List of unique ids: " + hashSort);
        TreeSet<Integer> treeSort = new TreeSet<>(listSorted);
        System.out.println("List of unique Sorted ids: " + treeSort);

        List<Integer> duplicateOne = new ArrayList<>();
        List<Integer> duplicateTwo = new ArrayList<>();

        start = System.nanoTime();
        for(Integer in : listSorted){
            if(hashSorted.add(in)){
            }else{
                duplicateOne.add(in);
            }
        }
        end = System.nanoTime();
        System.out.println("End: " + (end - start));

        start = System.nanoTime();
        sortThenSearch.sort(null);
        for(int i = 1; i < sortThenSearch.size(); i++){
            if(sortThenSearch.get(i - 1).equals(sortThenSearch.get(i))){
                    duplicateTwo.add(sortThenSearch.get(i));
            }
        }
        end = System.nanoTime();
        System.out.println("End: " + (end - start));


        List<Integer> duplicateThree = new ArrayList<>();

        start = System.nanoTime();
        for(int j = 0; j < listSorted.size() - 1; j++){
            int dupe = j;
            for(int i = j + 1; i < list.length; i++){
                if(listSorted.get(i).equals(listSorted.get(dupe))){
                    duplicateThree.add(listSorted.get(i));
                }
            }
        }
        end = System.nanoTime();
        System.out.println("End: " + (end - start));
    }

    public static void main(String[] args) {
        int[] test = new Random().ints(50, 1, 28).toArray();
        idReaderTime(test);
        frequencyCounter();
    }

}

//Collection Selection Analysis:

/*
1. For this one, I would choose a stack due to the sheer number of users at a time, and the powerful search() method to look for a currently logged in user.
2. For number two, the most important performance characteristic is adding flexibility, not search time. I would choose a Deque or LinkedList for this one because it has that addLast, removeLast, etc.
3. For number three I would choose a List or ArrayList for this structure. Iterating by ID order can be a very linear process and makes opportunity for both Binary and Linear searech. Retrieving elements is very easy with Array.get(index).
4. For number 4 I would select a Hash collection, most likely a HashSet. This is because ordering is not important, and the most important performance aspect is lookup by O(1).

Credit to Claude for helping me with some logic errors, and figuring out syntax.

*/
