import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A CourseDBStructure implementation
 * 
 * @author nanaa
 * @param 
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	// Class Variables
    protected java.util.Hashtable<Integer, java.util.LinkedList<CourseDBElement>> table; 
    protected int size = 0; 
    protected double factor = 1.5;
    protected int minimum = 2;
    protected java.util.ArrayList<String> blocked = new java.util.ArrayList<String>(java.util.Arrays.asList("and", "the"));
    protected boolean found = false;
    protected boolean initialized = false;
	public Array[] hashTable;
    
    /**
     * Class Constructor
     * 
     * @param String words
     * @param Integer size
     * @throws None
     */
	public CourseDBStructure(String w, int s) {
		// Variables
		this.size = s;
		this.table = new java.util.Hashtable<Integer, java.util.LinkedList<CourseDBElement>>(s, (float) this.factor);
	}

	/**
	 * Class Constructor
	 * 
     * @param Integer size
     * @throws None
	 */
	public CourseDBStructure(int s) {
		this.size = s;
		this.table = new java.util.Hashtable<Integer, java.util.LinkedList<CourseDBElement>>(s, (float) this.factor);
		this.initialized = true;
	}	 

	/**
	 * Add New Word
	 * 
	 * 
	 * @param String word
	 * @param Integer line
	 * @throws None
	 */
	public void add(String w, int l) {
		// Variables
		CourseDBElement element = new CourseDBElement(w, l, l, w, w);
		int hashcode = Math.abs(element.hashCode()) % this.getTableSize();
		
		// Checks
		if (element.getWord().length() <= this.minimum) { return; }
		if (this.blocked.indexOf(element.getWord()) >= 0) { return; }
		if (this.table.containsKey(hashcode) == true) {
			// Variables
			this.found = false;
			java.util.LinkedList<CourseDBElement> item = this.table.get(hashcode);
			
			// Loops
			item.forEach((v) -> {
				// Checks
				if (!v.getWord().equals(element.getWord())) { return; }
				
				v.addLine(l);
				this.found = true;
			});
			
			// Checks
			if (this.found == false) {
				item.add(element);
				element.addLine(l);
			}
		} else {
			this.table.put(hashcode, new java.util.LinkedList<CourseDBElement>());
			this.table.get(hashcode).push(element);
			this.table.get(hashcode).get(0).addPage(l);
		}
	} 

	/**
	 * Display All Elements
	 * 
	 * @param None
	 * @return String elements (name: pg, pg, pg)
	 * @throws None
	 */
	public java.util.ArrayList<String> showAll() {
		// Variables
		java.util.ArrayList<String> result = new java.util.ArrayList<String>();
		
		// Loop (HashMap)
		this.table.forEach((k, list) -> {
			// Sort (LinkedList)
			java.util.Collections.sort(list, new java.util.Comparator<CourseDBElement>() {
				@SuppressWarnings("unused")
				public int compare11(CourseDBElement e1, CourseDBElement e2) {
					return java.text.Collator.getInstance().compare(e1.getWord(), e2.getWord());
				}

				@SuppressWarnings("unused")
				public int compare1(CourseDBElement arg0, CourseDBElement arg1) {
					// TODO Auto-generated method stub
					return 0;
				}

				@SuppressWarnings("unused")
				public int compare111(CourseDBElement o1, CourseDBElement o2) {
					// TODO Auto-generated method stub
					return 0;
				}

				public int compare(CourseDBElement o1, CourseDBElement o2) {
					// TODO Auto-generated method stub
					return 0;
				}

				@SuppressWarnings("unused")
				public int compare1111(CourseDBElement arg0, CourseDBElement arg1) {
					// TODO Auto-generated method stub
					return 0;
				}
			});
			
			// Loop (LinkedList)
			list.forEach((word) -> {
				result.add(word.toString());
			});
		});
		
		// Sort (Final Result)
		java.util.Collections.sort(result, new java.util.Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return java.text.Collator.getInstance().compare(s1, s2);
			}
		});
		
		// Return
		return result;
	}
	
	/**
	 * Get Size Of Table
	 * 
	 * @param None
	 * @return Integer table size
	 * @throws None
	 */
	public int getTableSize() {
		return this.size;
	}
	
	/**
	 * Get An ArrayList of Words At Specified Index
	 * 
	 * @param Integer index
	 * @return ArrayList<String> words
	 * @throws None
	 */
	public java.util.ArrayList<String> getWords(int index) {
		// Variables
		java.util.ArrayList<String> words = new java.util.ArrayList<String>();
		java.util.LinkedList<CourseDBElement> element = this.table.get(index);
		
		// Checks
		if (element != null) {
			element.iterator().forEachRemaining((e) -> {
				words.add(e.getWord());
			});
		}
		
		// Return
		return words;
	}
	   
	/**
	 * Get An ArrayList of Pages At Specified Index
	 * 
	 * @param Integer index
	 * @return ArrayList<LinkedList<Integer>> pages
	 * @throws None
	 */
	public java.util.ArrayList<java.util.LinkedList<Integer>> getPageNumbers(int index) {
		// Variables
		java.util.ArrayList<java.util.LinkedList<Integer>> pages = new java.util.ArrayList<java.util.LinkedList<Integer>>();
		java.util.LinkedList<CourseDBElement> element = this.table.get(index);
		
		// Checks
		if (element != null) {
			element.iterator().forEachRemaining((e) -> {
				pages.add(e.getList());
			});
		}
		
		// Return
		return pages;
	}

	@Override
	public void add(CourseDBElement element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}	
}
