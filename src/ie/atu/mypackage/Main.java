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
        Student studentObject2 = new Student("G00111111", "Tom", 21);
        studentObject2.printStudentDetails();
        
        Student studentObject3 = new Student("G00111111", "Tom", 21);
        
        StudentManager studentManagerObject1 = new StudentManager();
        
        studentManagerObject1.showTotalStudents();

        studentManagerObject1.addStudentToList(studentObject1);
        studentManagerObject1.addStudentToList(studentObject2);
        studentManagerObject1.addStudentToList(studentObject3);
        studentManagerObject1.addStudentToList("GOO123456", "John", 20);
        studentManagerObject1.updateStudentName("G00123456", "William"); 
        
        //studentManagerObject1.printAllStudentDetails();
        
        studentManagerObject1.showTotalStudents();
        studentManagerObject1.findStudentByID("G0012346");
        studentManagerObject1.removeStudentFromList(studentObject1);
        studentManagerObject1.removeStudentFromList("G00222222");
        
        studentManagerObject1.showTotalStudents();
        
        userInput.close();
        
    } // End main method

} // End Main class
