package ie.atu.mypackage;

public class Student {

	// Instance Variables
	private String studentId;
	private String firstname;
	private int age;

	// Constructors
	public Student() {
		firstname = "null";
		age = 0;
	}
	
	public Student(String studentId) {
		this.studentId = studentId;
	}

	public Student(String studentId, String name, int age) {
		this.studentId = studentId;
		this.firstname = name;
		this.age = age;
	}
	
	// Getters and Setters
	public String getName() {
		return this.firstname;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getAge() {
		return this.age;
	}

	public void setName(String name) {
		this.firstname = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// Method to print students name and age
	public void printStudentDetails() {
		System.out.println("ID: " + this.studentId + ", Name: " + this.firstname + ", Age: " + this.age);
	}

} // End class