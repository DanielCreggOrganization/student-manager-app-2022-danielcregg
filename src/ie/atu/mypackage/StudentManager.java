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

	// Check if student ID is valid
	public boolean studentIdFormatValidator(String studentId) {
		// Check if student ID is valid
		if (studentId == null) {
			System.err.println("Student NOT added! - Student ID can not be null");
			return false;
		} else if (!(studentId.matches("G00\\d{6}"))) {
			System.err.println("Student NOT added! - Student ID " + studentId + " does not match the format G00123456");
			return false;
		} else {
			return true;
		}
	}

	// Returns true if duplicate is detected and false if not
	public boolean studentDuplicateDetector(Student student) {
		if (student == null) {
			System.err.println("Student Duplicate Detector: Input can not be null!");
			return false;
		}
		// Check if a valid student ID was entered
		if (studentIdFormatValidator(student.getStudentId())) {
			for (Student studentObject : studentList) {
				if (student.getStudentId().equals(studentObject.getStudentId())) {
					System.out.println("Student ID " + student.getStudentId() + " is already on the List");
					return true;
				}
			}
			return false;
		}
		return false;
	}

	/* Returns true if duplicate is detected and false if not. */
	public boolean studentDuplicateDetector(String studentId) {
		// Check if a valid student ID was entered
		if (studentIdFormatValidator(studentId)) {
			for (Student studentObject : studentList) {
				if (studentId.equals(studentObject.getStudentId())) {
					System.err.println("Student ID " + studentId + " already on List");
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
	public boolean updateStudentName(String studentId, String newName) {
		Student studentObject = findStudentByID(studentId);
		if (studentObject != null) {
			studentObject.setFirstName(newName);
			System.out.println("Student name updated!");
			return true;
		}
		System.err.println("Student name NOT updated!");
		return false;
	}

	// Show total number of Students in List
	public void showTotalStudents() {
		System.out.println(this.studentList.size());
	}

	// Show total number of Students in List
	public int totalStudents() {
		return this.studentList.size();
	}

	// Print all student details in table
	public void printAllStudentDetails() {
		System.out.println("ID, NAME, AGE");
		System.out.println("===========================");
		for (Student studentObject : studentList) {
			System.out.println(studentObject.getStudentId() + ", " +
					studentObject.getFirstname() + ", " + studentObject.getAge());
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
				Student newStudent = new Student(studentFieldValues[0], studentFieldValues[1],
						Integer.parseInt(studentFieldValues[2]));
				this.addStudentToList(newStudent); // Add student to the studentList
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
				bufferedstudentFileWriterStream.write(studentObject.getStudentId() + "," + studentObject.getFirstname()
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
