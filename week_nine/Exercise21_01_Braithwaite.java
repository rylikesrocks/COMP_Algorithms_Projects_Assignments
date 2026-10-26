import java.util.*;

public class Exercise21_01_Braithwaite {


    public static void main(String[] args) {
        LinkedHashSet<String> hashOne = new LinkedHashSet<>();
        LinkedHashSet<String> hashTwo = new LinkedHashSet<>();

        hashOne.add("Charlie");
        hashOne.add("Jacob");
        hashOne.add("Cecelia");
        hashOne.add("Sarah");
        @SuppressWarnings("unchecked")
        LinkedHashSet<String> clone = (LinkedHashSet<String>) hashOne.clone();
        
        hashTwo.add("Sarah");
        hashTwo.add("William");
        hashTwo.add("Bennedict");
        hashTwo.add("Michelle");
        hashTwo.add("Jacob");

        //Computing the union

        clone.addAll(hashTwo);
        System.out.println("Union: " + clone);
        clone.removeAll(clone);

        clone.add("Charlie");
        clone.add("Jacob");
        clone.add("Cecelia");
        clone.add("Sarah");
        
        //Computing the difference

        clone.removeAll(hashTwo);
        System.out.println("Difference: " + clone);
        clone.removeAll(clone);

        clone.add("Charlie");
        clone.add("Jacob");
        clone.add("Cecelia");
        clone.add("Sarah");

        //Computing the intersecion

        clone.retainAll(hashTwo);
        System.out.println("Intersection: " + clone);
        clone.removeAll(clone);

        clone.add("Charlie");
        clone.add("Jacob");
        clone.add("Cecelia");
        clone.add("Sarah");
    }
}

//LinkedHashSet was chosen due to the ordering of elements in the set. HashSets are regularly unordered, so declaring a HashSet instead of a LinkedSet
//would look way different than it does now. LinkedHashSets have the capability to order the set based on insertion order, HashSets don't