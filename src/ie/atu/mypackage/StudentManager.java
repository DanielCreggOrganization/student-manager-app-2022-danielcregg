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
		return this.studentList.add(newStudent);
	}
	
	public boolean addStudentToList(String name, int age) {
		Student newStudent = new Student(name, age);
		return this.studentList.add(newStudent);
	}
	
	// Delete Student from list
	public boolean removeStudentFromList(Student newStudent) {
		return this.studentList.remove(newStudent);
	}
	
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
