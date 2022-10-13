package ie.atu.mypackage;

import java.util.Scanner;

public class Main {  

    // This is the main method.
    public static void main(String[] args) {
    	
    	Scanner userInput = new Scanner(System.in);
    	
    	//System.out.println("Please input an Integer: ");
    	//userInput.nextInt();
        
        // Create Student Object
        Student studentObject1 = new Student();
        studentObject1.printStudentDetails();
        
        Student studentObject2 = new Student("Tom", 21);
        studentObject2.printStudentDetails();
        
        StudentManager studentManagerObject1 = new StudentManager();
        
        studentManagerObject1.showTotalStudents();

        studentManagerObject1.addStudentToList(studentObject1);
        studentManagerObject1.addStudentToList("Jim", 22);
        
        studentManagerObject1.showTotalStudents();
        
        studentManagerObject1.removeStudentFromList(studentObject1);
        
        studentManagerObject1.showTotalStudents();
        
        userInput.close();
        
    } // End main method

} // End Main class
