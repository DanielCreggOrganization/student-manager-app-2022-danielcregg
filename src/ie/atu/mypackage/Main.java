/******************************************************************************
 *  Compilation:  javac Main.java
 *  Execution:    java Main
*
 *  Prints "Hello World!" to console.
*
 ******************************************************************************/
package ie.atu.mypackage;

import java.util.Scanner;

public class Main {  

    // This is the main method.
    public static void main(String[] args) {
    	
    	Scanner userInput = new Scanner(System.in);
    	
    	System.out.println("Please input an Integer: ");
    	userInput.nextInt();
        
        // This statement prints "Hello World" to the console.
        System.out.println("Hello World!");
        
        // Create Student Object
        Student studentObject1 = new Student();
        System.out.println(       studentObject1.toString()     );
        
        StudentManager studentManagerObject1 = new StudentManager();
        System.out.println(studentManagerObject1.toString());
        
        
        userInput.close();
        
    } // End main method

} // End Main class
