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

	// Find student by ID. Returns null if student is not found.
	public Student findStudentObjectByID(String studentId) {
		// Search all student objects in the student list
		for (Student studentObject : studentList) {
			// Compare IDs to ID passed in
			if (studentId.equals(studentObject.getStudentId())) {
				// If a match is found return the student object
				return studentObject;
			}
		}
		// If no match is found return null
		return null;
	}

	// Returns true if student on list
	public boolean isOnList(String studentId) {
		return studentList.contains(findStudentObjectByID(studentId));
	}

	public void findStudentsByName(String firstName) {
		// Search all student objects in the student list
		for (Student studentObject : studentList) {
			// Compare IDs to ID passed in
			if (firstName.equals(studentObject.getFirstName())) {
				// If a match is found print the student details to console
				System.out.println(studentObject.toString());
			}
		}
	}

	public void finStudentsByAge(int age) {
		// Search all student objects in the student list
		for (Student studentObject : studentList) {
			// Compare IDs to ID passed in
			if (age == studentObject.getAge()) {
				// If a match is found print the student details to console
				System.out.println(studentObject.toString());
			}
		}
	}

	public void findStudentsByFirstNameAndAge(String firstName, int age) {
		// Search all student objects in the student list
		for (Student studentObject : studentList) {
			// Compare IDs to ID passed in
			if (studentObject.getFirstName().equals(firstName) && studentObject.getAge() == age) {
				// If a match is found print the student details to console
				System.out.println(studentObject.toString());
			}
		}
	}

	public Student findStudentsByAgeRange(int minAge, int maxAge) {
		// Search all student objects in the student list
		for (Student studentObject : studentList) {
			// Compare IDs to ID passed in
			if (studentObject.getAge() >= minAge  && studentObject.getAge() <= maxAge) {
				// If a match is found print the student details to console
				System.out.println(studentObject.toString());
			}
		}
		// If no match is found return null
		return null;
	}

	// Add student to list
	public boolean addStudentToList(String studentId, String name, int age) {
		// Check student details are vaild and if student is NOT already on list
		if (Student.isValid(studentId, name, age) && !isOnList(studentId)) {
			// Create student object with valid details and add student to the list
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
	public boolean updateStudentName(String studentId, String newName) {
		if (Student.studentIdIsValid(studentId) && Student.firstNameIsValid(newName)) {
			// Find student object by ID
			Student studentToUpdate = findStudentObjectByID(studentId);
			// If student is found update name
			if (studentToUpdate != null) {
				// Save old name
				String oldName = studentToUpdate.getFirstName();
				// Set new name
				studentToUpdate.setFirstName(newName);
				// Print message to console showing old and new name
				System.out.println("Student with ID: " + studentId + " updated name from " + oldName + " to " + newName);
			}
		}
		// If student ID is invalid or new name is invalid  or if student is not found return false
		return false;
	}

	// Show total number of Students in List
	public void printTotalNumberOfStudents() {
		System.out.println(this.studentList.size());
	}

	// Print student list to console
	public void printStudentList() {
		System.out.println("ID,NAME,AGE");
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
	} // End read method

	// Write student details to file
	public void writeStudentDataToCSVFile(String pathToStudentCSVFile) {
		File studentCSVFile = null;
		FileWriter studentFileWriterStream = null;
		BufferedWriter bufferedstudentFileWriterStream = null;
		try {
			// Create a buffered file writer which can write one line at a time
			studentCSVFile = new File(pathToStudentCSVFile);
			studentFileWriterStream = new FileWriter(studentCSVFile);
			bufferedstudentFileWriterStream = new BufferedWriter(studentFileWriterStream);

			// Write column headers to CSV file
			bufferedstudentFileWriterStream.write("ID,Firstname,Age" + "\n");

			// Write out student data from studentList to buffer and flush it to CSV file
			for (Student studentObject : studentList) {
				bufferedstudentFileWriterStream.write(studentObject.getStudentId() + "," + studentObject.getFirstName()
						+ "," + studentObject.getAge() + "\n");
				bufferedstudentFileWriterStream.flush(); // Flush buffer and transfer buffer data to the file
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
