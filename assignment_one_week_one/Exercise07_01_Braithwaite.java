import java.util.ArrayList;


public class Exercise07_01_Braithwaite{

    static ArrayList<Integer> gradeInput = new ArrayList<>();
    static ArrayList<String> letterGrades = new ArrayList<>();
    static int highestGrade = 0;

    public static void classInput(){
        java.util.Scanner input = new java.util.Scanner(System.in);
        java.util.Scanner gInput = new java.util.Scanner(System.in);
        int grade;
        System.out.println("How many students are in your class?");
        int studentN = input.nextInt();


            for(int i = 0; i < studentN; i++){
                System.out.println("Please input grade for student " + i + " (grade should be 100 to 0):");
                grade = gInput.nextInt();
                gradeInput.add(grade);
        }
    }

    public static void gradeAnalysis(){
        for (int i = 0; i < gradeInput.size(); i++){
            if (highestGrade < (gradeInput.get(i))){
                highestGrade = gradeInput.get(i);
            }
        }
        System.out.println("Highest grade is:" + " " + highestGrade + "\n");
        int isA = highestGrade - 10;
        int isB = highestGrade - 20;
        int isC = highestGrade - 30;
        int isD = highestGrade - 40;
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

            System.out.println("Student: " + i + " Score: " + gradeInput.get(i) + " Letter Grade: " + letterGrades.get(i));
        }
    }

public static void main(String[] args) {
        classInput();
        gradeAnalysis();
    }
}