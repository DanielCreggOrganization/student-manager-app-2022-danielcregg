package ie.atu.mypackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

	// Find student by ID
	public Student findStudentObjectByID(String studentId) {
		// Check if a valid student ID was passed
		if (Student.studentIdIsValid(studentId)) {
			// Search all student objects in the student list and compare student ID to the one passed
			for (Student studentObject : studentList) {
				// If a match is found return the student object
				if (studentId.equals(studentObject.getStudentId())) {
					System.out.println("Student with ID " + studentId + " was on list!");
					return studentObject;
				} // End if
			} // End for
			System.err.println("Student with ID " + studentId + " is not on the list!");
			return null;
		}
		return null;
	}

	// Returns true if student on list
	public boolean isOnList(String studentId) {
		// Check if a valid student ID was entered
		return studentList.contains(findStudentObjectByID(studentId));
	}

	// Add student to list
	public boolean addStudentToList(String studentId, String name, int age) {
		// Check if a valid student details are vaild and if student is NOT already on list
		if (Student.isValid(studentId, name, age) && !isOnList(studentId)) {
			// ID format good and not on list already; add student to the list
			Student newStudent = new Student(studentId, name, age);
			return this.studentList.add(newStudent);
		}
		// If student details are invalid or if student is already on list return false
		return false;
	}

	// Remove student from list given studendID
	public boolean removeStudentFromList(String studentId) {
		return studentList.remove(findStudentObjectByID(studentId));
	}

	// Update student name
	public void updateStudentName(String studentId, String newName) {
		findStudentObjectByID(studentId).setFirstName(newName);
		System.out.println("Student with ID: " + studentId + " updated name to " + newName);
	}

	// Show total number of Students in List
	public void printTotalNumberOfStudents() {
		System.out.println(this.studentList.size());
	}

	// Print student list to console
	public void printStudentList() {
		System.out.println("ID, NAME, AGE");
		System.out.println("===========================");
		for (Student studentObject : studentList) {
			System.out.println(studentObject.toString());
		}
		System.out.println("===========================");
	}

	// Read student details from file
	public void readStudentDataFromCSVFile(String pathToStudentCSVFile) {
		File studentCSVFile = null;
		FileReader studentCSVFileReader = null;
		BufferedReader bufferedStudentCSVFileReader = null;
		String bufferData = null; // Used to store lines of data we read from the buffer

		// Create a file reader
		try {
			studentCSVFile = new File(pathToStudentCSVFile);
			studentCSVFileReader = new FileReader(studentCSVFile);
			// Add a buffer to the file reader
			bufferedStudentCSVFileReader = new BufferedReader(studentCSVFileReader);
			// Read first line of file and discard it. It contains column headers.
			bufferedStudentCSVFileReader.readLine();

			while ((bufferData = bufferedStudentCSVFileReader.readLine()) != null) {
				// System.out.println(bufferData);
				String[] studentFieldValues = bufferData.split(",");
				// System.out.println(Arrays.toString(studentFieldValues));
				String studentId = studentFieldValues[0];
				String firstName = studentFieldValues[1];
				int age = Integer.parseInt(studentFieldValues[2]);
				this.addStudentToList(studentId, firstName, age); // Add student to the studentList
			}
			System.out.println("Student data read from CSV file located at " + pathToStudentCSVFile);
		} catch (NullPointerException npExc) {
			System.err.println("ERROR: Students NOT saved to file!");
			npExc.printStackTrace();
		} catch (FileNotFoundException fnfExc) {
			System.err.println("ERROR: Students NOT saved to file!");
			fnfExc.printStackTrace();
		} catch (IOException IOExc) {
			System.err.println("ERROR: Students NOT saved to file!");
			IOExc.printStackTrace();
		} finally {
			try {
				// Flushes buffer, which transfers buffer data to the file, then closes buffer.
				bufferedStudentCSVFileReader.close();
				// Close the file reader stream
				studentCSVFileReader.close();
			} catch (IOException IOExc) {
				System.err.println("ERROR: Could not close the buffer file reader!");
				IOExc.printStackTrace();
			} // End catch
		} // End finally
	} // End load method

	// Write student details to file
	public void writeStudentDataToCSVFile(String pathToStudentCSVFile) {
		File studentCSVFile = null;
		FileWriter studentFileWriterStream = null;
		BufferedWriter bufferedstudentFileWriterStream = null;
		try {
			studentCSVFile = new File(pathToStudentCSVFile);
			studentFileWriterStream = new FileWriter(studentCSVFile);
			bufferedstudentFileWriterStream = new BufferedWriter(studentFileWriterStream);
			bufferedstudentFileWriterStream.write("ID, Firstname, Age" + "\n");

			// Write out student data from studentList to buffer and flush it to CSV file
			for (Student studentObject : studentList) {
				bufferedstudentFileWriterStream.write(studentObject.getStudentId() + "," + studentObject.getFirstName()
						+ "," + studentObject.getAge() + "\n");
				// bufferedstudentFileWriterStream.write(studentObject.findAllFieldValuesInCSVFormat()
				// + "\n");
				bufferedstudentFileWriterStream.flush(); // Flushes buffer which transfers buffer data to the file
			}
			System.out.println("Student data written to CSV file located at " + pathToStudentCSVFile);
		} catch (NullPointerException npExc) {
			System.err.println("ERROR: Students NOT saved to file!");
			npExc.printStackTrace();
		} catch (FileNotFoundException fnfExc) {
			System.err.println("ERROR: Students NOT saved to file!");
			fnfExc.printStackTrace();
		} catch (IOException IOExc) {
			System.err.println("ERROR: Students NOT saved to file!");
			IOExc.printStackTrace();
		} finally {
			try {
				// Close buffer
				bufferedstudentFileWriterStream.close();
				// Close file writer
				studentFileWriterStream.close();
			} catch (IOException IOExc) {
				System.err.println("ERROR: Could not close the buffer or file writer!");
				IOExc.printStackTrace();
			} // End catch
		} // End finally
	} // End Save method

}// End class
