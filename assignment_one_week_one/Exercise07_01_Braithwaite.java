import java.util.ArrayList;


public class Exercise07_01_Braithwaite{

    //Declaration of global variables & arraylists

    static ArrayList<Double> gradeInput = new ArrayList<>();
    static ArrayList<String> letterGrades = new ArrayList<>();
    static double highestGrade = 0;

    //Class input method to take # of students from the user

    public static void classInput(){
        java.util.Scanner input = new java.util.Scanner(System.in);
        java.util.Scanner gInput = new java.util.Scanner(System.in);
        double grade;
        System.out.println("How many students are in your class?");
        int studentN = input.nextInt();      

     //Getting grades for each student in the class and adding them to the gradeInput ArrayList

            for(int i = 0; i < studentN; i++){
                System.out.println("Please input grade for student " + (i + 1) + " (grade should be 100 to 0):");
                grade = gInput.nextDouble();
                gradeInput.add(grade);
        }
    }

    //Grade Analysis Method to determine the highest grade and assign letter grades to each student

    public static void gradeAnalysis(){
        for (int i = 0; i < gradeInput.size(); i++){
            if (highestGrade < (gradeInput.get(i))){
                highestGrade = gradeInput.get(i);
            }
        }

        System.out.println("Highest grade is:" + " " + highestGrade + "\n");

    //Calculating the letter grades based on the highest grade and adding them to the letterGrades ArrayList

        double isA = highestGrade - 10;
        double isB = highestGrade - 20;
        double isC = highestGrade - 30;
        double isD = highestGrade - 40;
        for (int i = 0; i < gradeInput.size(); i++){
            if(gradeInput.get(i) >= isA){
                letterGrades.add("A");
            }else if(gradeInput.get(i) >= isB){
                letterGrades.add("B");
            }else if(gradeInput.get(i) >= isC){
                letterGrades.add("C");
            }else if (gradeInput.get(i) >= isD){
                letterGrades.add("D");
            }else{
                letterGrades.add("F");
            }

    //Outputting the results for each student with their score and letter grade

            System.out.println("Student: " + (i + 1) + " Score: " + gradeInput.get(i) + " Letter Grade: " + letterGrades.get(i));
        }
    }

    //Main Method to call the classInput and gradeAnalysis methods
public static void main(String[] args) {
        classInput();
        gradeAnalysis();
    }
}