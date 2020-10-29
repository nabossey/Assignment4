// Imports
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A CourseDBManager Test Unit 
 *
 * @author nanaa
 * 
 */
public class CourseDBManager_STUDENT_Test {
	// Class Variables
	private CourseDBManager cm = new CourseDBManager();
	private File inputFile, outputFile;
	private String text;

	@Before
	public void setUp() throws Exception {
		// Variables
		cm = new CourseDBManager();
		text = "Alec\nBat\nDog\nXray\nZebra";
	}

	@After
	public void tearDown() throws Exception {
		cm = null;
	}

	@Test
	public void testConcordanceArray() {
		// Variables
		ArrayList<String> words = cm.createCourseDBArray(text);
		
		// Checks
		assertEquals(words.get(0), "Alec: 1\n".toLowerCase());
		assertEquals(words.get(1), "Bat: 2\n".toLowerCase());
		assertEquals(words.get(2), "Dog: 3\n".toLowerCase());
		assertEquals(words.get(3), "Xray: 4\n".toLowerCase());
		assertEquals(words.get(4), "Zebra: 5\n".toLowerCase());
	}

	@Test
	public void testConcordanceFileA() {
		// Variables
		ArrayList<String> words = new ArrayList<String>();
		inputFile = new File("Student_Test_A_In.txt");
		outputFile = new File("Student_Test_A_Out.txt");
		
		try {
			// Variables
			PrintWriter in = new PrintWriter(inputFile);
			
			// Write To New file
			in.print("CourseDBXilo\nZoo\nCourseDB");
			in.close();
			PrintWriter outFile = new PrintWriter(outputFile);
			outFile.print(" ");
			
			// Create file & scan
			cm.createCourseDBFile(inputFile, outputFile);
			Scanner scan = new Scanner(outputFile);
			while (scan.hasNext()) {
				words.add(scan.nextLine());
			}
			scan.close();
			outFile.close();
		 
			assertEquals(words.get(0), "CourseDB: 1, 4");
			assertEquals(words.get(1), "xilo: 2");
			assertEquals(words.get(2), "zoo: 3");
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	public void testCourseDBFileB() {
		try {
			inputFile = new File("Student_Test_B_In.txt");
			inputFile.setReadable(false);
			outputFile = new File("Student_Test_B_Out.txt");
			PrintWriter outFile = new PrintWriter(outputFile);
			outFile.print(" ");
			cm.createCourseDBFile(inputFile, outputFile);
			assertTrue("This should have raised an exception", false);
			outFile.close();
		} catch (FileNotFoundException e) {
			assertTrue("This should have raised a FileNotFoundexception", true);
		} catch (Exception e) {}
	}
}
