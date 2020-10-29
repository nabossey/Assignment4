/**
 * A basic data element implementation
 * 
 *@author nanaa
 */
public class CourseDBElement implements java.lang.Comparable<CourseDBElement> {
	// Class Variables
	protected String word;
	protected java.util.LinkedList<Integer> lines;

	/**
	 * Standard constructor
	 * @param string2 
	 * @param string 
	 * @param j 
	 * @param i 
	 * 
	 * @param String word
	 * @throws None
	 */
	public CourseDBElement(String w, int i, int j, String string, String string2) {	
		// Variables
		this.word = w.trim().toLowerCase().replaceAll("[\\?\\+\\,\\.\\!\\_\\\"\\;]", "");
		this.lines = new java.util.LinkedList<Integer>();
	}
	
	public CourseDBElement(String crnStr) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Add page number to page list
	 * 
	 * @param Integer page num
	 * @throws None
	 */
	public void addPage(int p) {
		this.addLine(p);
	}
	
	/**
	 * A logically named implementation of addPage
	 * 
	 * @param Integer line num
	 * @throws None
	 */
	public void addLine(int l) {
		// Checks
		if (this.lines.indexOf(l) >= 0) { return; }
		
		// Add
		this.lines.add(l);
	}
	
	/**
	 * Get DataElement Word
	 * 
	 * @param None
	 * @return String word
	 * @throws None
	 */
	public String getWord() {
		return this.word;
	}
	
	/**
	 * Get DataElement Line List
	 * 
	 * @param None
	 * @return LinkedList lines
	 * @throws None
	 */
	public java.util.LinkedList<Integer> getList() {
		// Variables
		java.util.LinkedList<Integer> list = new java.util.LinkedList<Integer>();
		
		// Loops
		for (int line : this.lines) {
			list.add(line);
		}
		
		// Sort
		java.util.Collections.sort(list, new java.util.Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;
			}
		});
		
		// Return
		return list;
	}
	
	/**
	 * Get DataElement HashCode
	 * 
	 * @param None
	 * @return Integer hashcode
	 * @throws None
	 */
	public int hashCode() {
		return this.word.hashCode();
	}
	
	/**
	 *DataElement Class
	 * 
	 * @param None
	 * @return String class
	 * @throws None
	 */
	public String toString() {
		return this.word + ": " + this.getList().toString().replace("[", "").replace("]", "");
	}
	
	/**
	 * Compare two DataElements
	 * 
	 * @param CourseDBElement e1
	 * @return Integer comparison
	 * @throws None
	 */
	public int compareTo(CourseDBElement e1) {
		return e1.getWord().compareTo(this.getWord());
	}

	public void setCRN(int parseInt) {
		// TODO Auto-generated method stub
		
	}

	public Object getCRN() {
		// TODO Auto-generated method stub
		return null;
	}
}
