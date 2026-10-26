import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Exercise20_01_Braithwaite {
    public static String fileSorter(){
        List<String> valueList = new ArrayList<>();
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the file name: ");

            File fileName = new File(input.nextLine());
            try (Scanner scanner = new Scanner(fileName)) {
                while(scanner.hasNext()){
                    String word = scanner.next();
                    if(!word.isEmpty() && Character.isLetter(word.charAt(0))){
                        valueList.add(word);
                    }
                }
            }
            Collections.sort(valueList);
            System.out.println(valueList);
            
        }catch(FileNotFoundException e){
            System.err.println("Error: file not found exception " + e.getMessage());
        }
        return "Completed";
    }

    public static void main(String[] args) {
        fileSorter();
    }
}
