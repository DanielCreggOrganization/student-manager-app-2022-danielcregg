package ie.atu.mypackage;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

	private static final Student[] StudentList = null;
	// Instance Variables
	private List<Student> studentList;
	
	// Constructor
	public StudentManager() {
		this.studentList = new ArrayList<>();
	}

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
		for (Student studentObject: studentList) {
			if (newStudent.getStudentId().equals(studentObject.getStudentId())){
				System.out.println("Student already in List");
				return false;
			}
		}
		return this.studentList.add(newStudent);
	}
	
	public boolean addStudentToList(String studentId, String name, int age) {
		Student newStudent = new Student(studentId, name, age);
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
	
	public boolean removeStudentFromList(String studentId) {
		for(Student studentObject : studentList) {
			if (studentId.equals(studentObject.getStudentId())){
				return studentList.remove(studentObject);
			} // End if
		} // End for
		return false;
	}
	
	// Remove student from list given studendID
	
	// Update student name
	
	// Find student 
	
	// Show total number of Students in List
	public void showTotalStudents() {
		System.out.println(this.studentList.size());
	}
	
	// Show total number of Students in List
	public int totalStudents() {
		return this.studentList.size();
	}
	
}
