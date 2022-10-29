package ie.atu.mypackage;

public class Main {
    public static void main(String[] args) {
        // Create student list
        StudentManager studentManagerObject1 = new StudentManager();

        studentManagerObject1.readStudentDataFromCSVFile("./resources/students.csv");
        studentManagerObject1.addStudentToList("G00666666", "Sarah", 29);
        studentManagerObject1.printTotalNumberOfStudents();
        studentManagerObject1.updateStudentName("G00111111", "Billy");
        studentManagerObject1.printStudentList();

        studentManagerObject1.writeStudentDataToCSVFile("./resources/students.csv");

        studentManagerObject1.finStudentsByAge(20);
        studentManagerObject1.findStudentsByName("Sarah");
        studentManagerObject1.findStudentsByFirstNameAndAge("Sarah", 20);
        studentManagerObject1.findStudentsByAgeRange(21, 50);
    }
}
