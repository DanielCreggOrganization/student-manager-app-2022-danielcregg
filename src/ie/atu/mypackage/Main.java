package ie.atu.mypackage;

public class Main {

    // This is the main method.
    public static void main(String[] args) {
        // Create student list
        StudentManager studentManagerObject1 = new StudentManager();

        studentManagerObject1.readStudentDataFromCSVFile("./resources/students.csv");
        studentManagerObject1.addStudentToList("G00666666", "Sarah", 29);
        studentManagerObject1.printTotalNumberOfStudents();;
        studentManagerObject1.printStudentList();
        studentManagerObject1.writeStudentDataToCSVFile("./resources/students.csv");
        studentManagerObject1.getStudentList().contains(studentManagerObject1.findStudentByID("G00666666"));

        // userInput.close();

    } // End main method
} // End Main class
