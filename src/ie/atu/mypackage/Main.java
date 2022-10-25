package ie.atu.mypackage;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // This is the main method.
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        // System.out.println("Please input an Integer: ");
        // userInput.nextInt();
        // Create student list
        StudentManager studentManagerObject1 = new StudentManager();

        studentManagerObject1.addStudentToList("G00111111", "Tom", 20);
        studentManagerObject1.addStudentToList("G00222222", "Joe", 21);
        studentManagerObject1.addStudentToList("G00333333", "Pat", 22);
        studentManagerObject1.showTotalStudents();
        studentManagerObject1.printAllStudentDetails();
<<<<<<< HEAD
=======
        studentManagerObject1.removeStudentFromList(studentObject2);
        studentManagerObject1.removeStudentFromList("G00222222");


        studentManagerObject1.loadStudentsFromCSVFile("./resources/students.csv");
        studentManagerObject1.showTotalStudents();
        studentManagerObject1.printAllStudentDetails();
        studentManagerObject1.addStudentToList("G00333333", "Jill", 24);
        studentManagerObject1.printAllStudentDetails();
        studentManagerObject1.saveStudentsToCSVFile("./resources/students.csv");
>>>>>>> 1b5150c (updates io)

        userInput.close();

    } // End main method
} // End Main class
