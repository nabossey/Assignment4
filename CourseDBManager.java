import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CourseDBManager implements CourseDBManagerInterface {

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDBElement get(int crn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createCourseDBFile(File inputFile, File outputFile) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<String> createCourseDBArray(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
