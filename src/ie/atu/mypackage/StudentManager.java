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
	public StudentManager(List<Student> studentList) {
		this.studentList = studentList;
	}

	// Getter
	public List<Student> getStudentList() {
		return this.studentList;
	}

	// Setter
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	// Check if student ID is valid
	public boolean studentIdFormatValidator(String studentId) {
		// Check if student ID is valid
		if (studentId == null) {
			System.out.println("Student NOT added! - Student ID can not be null");
			return false;
		} else if (!(studentId.matches("G00\\d{6}"))) {
			System.out.println("Student NOT added! - Student ID must match the format G00123456");
			return false;
		} else {
			return true;
		}
	}

	/* Returns true if duplicate is detected and false if not. */
	public boolean studentDuplicateDetector(String studentId) {
		// Check if a valid student ID was entered
		if (studentIdFormatValidator(studentId)) {
			for (Student studentObject : studentList) {
				if (studentId.equals(studentObject.getStudentId())) {
					System.out.println("Student ID " + studentId + " already on List");
					return true;
				}
			}
			return false;
		}
		return false;
	}

	// Find student by ID
	public Student findStudentByID(String studentId) {
		// Check if a valid student ID was entered
		if (studentIdFormatValidator(studentId)) {

			for (Student studentObject : studentList) {
				if (studentId.equals(studentObject.getStudentId())) {
					System.out.println("Student with ID " + studentId + " was found!");
					return studentObject;
				} // End if
			} // End for
			System.err.println("Student with ID " + studentId + " was NOT found!");
			return null;
		}
		return null;
	}

	// Add student to list
	public boolean addStudentToList(Student newStudent) {
		if (studentIdFormatValidator(newStudent.getStudentId())) {
			if (studentDuplicateDetector(newStudent.getStudentId())) {
				return false;
			} else {
				// ID format good and no duplicate found. Adding student to the list
				return this.studentList.add(newStudent);
			}
		}
		return false; // If studentIdFormatValidator detects mis formatted id
	}

	public boolean addStudentToList(String studentId, String name, int age) {
		Student newStudent = new Student(studentId, name, age);
		// Check if a valid student ID was entered
		if (studentIdFormatValidator(newStudent.getStudentId())) {
			if (studentDuplicateDetector(newStudent.getStudentId())) {
				return false;
			} else {
				// ID format good and no duplicate found. Adding student to the list
				return this.studentList.add(newStudent);
			}
		}
		return false; // If studentIdFormatValidator detects mis formatted id
	}

	// Remove Student from list
	public boolean removeStudentFromList(Student newStudent) {
		return this.studentList.remove(newStudent);
	}

	// Remove student from list given studendID
	public boolean removeStudentFromList(String studentId) {
		if (studentIdFormatValidator(studentId)) {
			for (Student studentObject : studentList) {
				if (studentId.equals(studentObject.getStudentId())) {
					return studentList.remove(studentObject);
				} // End if
			} // End for
		}
		return false;
	}

	// Update student name
	public void updateStudentName(String studentId, String newName) {
		Student studentObject = findStudentByID(studentId);
		if (studentObject != null) {
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

	// // Print all student details in table
	// public void printAllStudentDetails() {
	// System.out.println("ID\tNAME\tAGE");
	// System.out.println("=====================");
	// for(Student studentObject : studentList) {
	// System.out.println(studentObject.getStudentId() + "\t, " +
	// studentObject.getName() + "\t, " + studentObject.getAge());
	// }
	// System.out.println("=====================");
	// }

}// End class
