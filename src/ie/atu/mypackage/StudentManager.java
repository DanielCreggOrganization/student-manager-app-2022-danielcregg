package ie.atu.mypackage;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

	// Instance Variables
	private List<Student> studentList;
	
	// Constructor
	public StudentManager() {
		this.studentList = new ArrayList<>();
	}

	// Create second constructor which takes arraylist as input
//	public StudentManager(List<Student> studentList) {
//		this.studentList = studentList;
//	}
	
	// Getter
	public List<Student> getStudentList(){
		return this.studentList;
	}
	
	// Setter
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	// Add student to list
	public boolean addStudentToList(Student newStudent) {
		// Check student does not have an empty ID
		for (Student studentObject: studentList) {
			// Check if student is already on list 
			if (newStudent.getStudentId().equals(studentObject.getStudentId())){
				System.out.println("Student already in List");
				return false;
			}
		}
		return this.studentList.add(newStudent);
	}
	
	// Check if student ID is valid
//	public boolean studentIdFormatValidator(String studentId) {
//		// Check if student ID is valid
//		if (studentId == null) {
//			System.out.println("Student NOT added! - Student ID can not be null");
//			return false;
//		} else if (studentId.isBlank()) {
//			System.out.println("Student NOT added! - Student ID can not be empty");
//			return false;
//		} else if (!(studentId.matches("G00\\d{6}"))) {
//			System.out.println("Student NOT added! - Student ID must match the format G00123456");
//			return false;
//		} else {
//			return true;
//		}
//	}
	
	public boolean addStudentToList(String studentId, String name, int age) {
		Student newStudent = new Student(studentId, name, age);
		// Check if a valid student ID was entered
//		if (studentId == null) {
//			System.out.println("Student NOT added! - Student ID can not be null");
//			return false;
//		} else if (studentId.isBlank()) {
//			System.out.println("Student NOT added! - Student ID can not be empty");
//			return false;
//		} else if (!(studentId.matches("G00\\d{6}"))) {
//			System.out.println("Student NOT added! - Student ID must match the format G00123456");
//			return false;
//		}

		for (Student studentObject: studentList) {
			if (studentId.equals(studentObject.getStudentId())){
				System.out.println("Student already in List");
				return false;
			}
		}
		
		return this.studentList.add(newStudent);
	}
	
	// Remove Student from list
	public boolean removeStudentFromList(Student newStudent) {
		return this.studentList.remove(newStudent);
	}
	
	// Remove student from list given studendID
	public boolean removeStudentFromList(String studentId) {
		for(Student studentObject : studentList) {
			if (studentId.equals(studentObject.getStudentId())){
				return studentList.remove(studentObject);
			} // End if
		} // End for
		return false;
	}
	
	// Find student by ID
	public Student findStudentByID(String studentId) {
	
		// Check if a valid student ID was entered
		if (studentId == null) {
			System.out.println("Student ID can not be null");
			return null;
		} else if (studentId.isBlank()) {
			System.out.println("Student ID can not be empty");
			return null;
		} else if (!(studentId.matches("G00\\d{6}"))) {
			System.out.println("Student ID must match the format G00123456");
			return null;
		}
		
		for(Student studentObject : studentList) {
			if (studentId.equals(studentObject.getStudentId())){
				System.out.println("Student with ID " + studentId + " was found!");
				return studentObject;
			} // End if
		} // End for
		System.err.println("Student with ID " + studentId + " was NOT found!");
		return null;
	}
	
	// Update student name
	public void updateStudentName(String studentId, String newName) {
		Student studentObject = findStudentByID(studentId);
		if(studentObject != null) {
			studentObject.setName(newName);
		}
	}
	
	// Show total number of Students in List
	public void showTotalStudents() {
		System.out.println(this.studentList.size());
	}
	
	// Show total number of Students in List
	public int totalStudents() {
		return this.studentList.size();
	}
	
//	// Print all student details in table
//	public void printAllStudentDetails() {
//		System.out.println("ID\tNAME\tAGE");
//		System.out.println("=====================");
//		for(Student studentObject : studentList) {
//			System.out.println(studentObject.getStudentId() + "\t, " + studentObject.getName() + "\t, " + studentObject.getAge());
//		}
//		System.out.println("=====================");
//	}
	
}// End class
