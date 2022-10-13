package ie.atu.mypackage;

public class Student {

	// Instance Variables
	private String name;
	private int age;
	// Add studentId

	// Constructor
	public Student() {
		name = "null";
		age = 0;
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Getters and Setter
	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// Method to print students name and age
	public void printStudentDetails() {
		System.out.println("Name: " + this.name + ", " + "Age: " + this.age);
	}

} // End class
