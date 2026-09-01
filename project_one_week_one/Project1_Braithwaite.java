// Braithwaite, Rylan, Project 1, Grade Manager

import java.lang.*;
import java.util.*;

class GradeManager{

    //Record class to hold student name and grade, arraylists to hold student names and grades, and sum to calculate the average grade.

    record Student(String name, double grade) {}
    static ArrayList<Double> studentGrades = new ArrayList<>();
    static ArrayList<String> student = new ArrayList<>();
    static double sum = 0;

    //Method to add a student and their grade to the respective arraylists.

    public static void addStudent(String name, double grade){
        student.add(name);
        studentGrades.add(grade);
    }

    //Method to remove a student and their grade from the respective arraylists.

    public static void removeStudent(String name){
        for(int i = 0; i < student.size(); i++){
            if(student.get(i).equals(name)){
                student.remove(i);
                studentGrades.remove(i);
            }
        }
    }

    //Method to calculate the average grade of the students in the class.

    public static double averageGrade(){
       sum = 0;
       for(int i = 0; i < student.size(); i++){
        sum += studentGrades.get(i);
       }
       double average = sum / student.size();
       System.out.println("Average grade: " + average);
       return average;
    }

    //Method to get the highest grade in the class.

    public static void getHighest(){
        double highest = 0;
        for(double grade : studentGrades){
            if(grade > highest){
                highest = grade;
            }
        }
        System.out.println("Highest grade: " + highest);
    }

    //Method to get the lowest grade in the class.

    public static void getLowest(){
        double lowest = 100;
        for(double grade : studentGrades){
            if (grade < lowest){
                lowest = grade;
            }
        }
        System.out.println("Lowest grade: " + lowest);
    }

    //Method to sort the students by their grades in descending order and display their rank, name, and grade.

    public static void sortStudents(){
        ArrayList<Student> sortedStudent = new ArrayList<>();
        for(int i = 0; i < student.size(); i++){
            sortedStudent.add(new Student(student.get(i), studentGrades.get(i))); //Loop through to link the student names and grades together in a new arraylist of Student records.
        }
        sortedStudent.sort(Comparator.comparingDouble(Student::grade).reversed()); //Sort the new arraylist of Student records by grade in descending order.
        for(int i = 0; i < sortedStudent.size(); i++){
            System.out.println("Rank:" + " " + (i + 1) + "\nName: " + sortedStudent.get(i).name() + "\nGrade: " + sortedStudent.get(i).grade() + "\n\n");
        }
    }
}

public class Project1_Braithwaite {
    public static void main(String[] args) {
        //Uncomment to test the GradeManager class with sample data

        /*
        GradeManager.addStudent("Jane Doe", 85.5);
        GradeManager.addStudent("Joel Miller", 73.0);
        GradeManager.addStudent("Jim Beam", 78.0);
        GradeManager.addStudent("Cyberdyne Systems Model 101", 99.9);
        GradeManager.addStudent("Sarah Connor", 95.0);
        GradeManager.addStudent("Michael Scott", 70.0);
        GradeManager.addStudent("Jesse Pinkman", 52.0);
        GradeManager.addStudent("Buzz Lightyear", 0.0);
        GradeManager.addStudent("Walter White", 98.0);
        GradeManager.addStudent("Homer Simpson", 33.0);
        */

        // Edge Cases
        GradeManager.removeStudent("Jimmy Bean"); // Attempt to remove a student not in the list
        GradeManager.getHighest(); // Get the highest grade in the class
        GradeManager.getLowest(); // Get the lowest grade in the class
        GradeManager.averageGrade(); // Get the average grade in the class

        //Sorting students by grade and displaying the results

        GradeManager.sortStudents();
    }
}