package CodeSmell;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import CodeSmell.DuplicateCodeCheck;

/*This unit test creates an instance of myClass and calls the AA() and AB() methods 
 * to populate an ArrayList with their return values. The hasDupes() method is then 
 * called to check for any duplicate entries in the ArrayList, and the test asserts 
 * that the result is true, which indicates that there is indeed duplicate code in myClass.*/

public class WhiteBoxTestDuplicateCode {
	
    
	  @Test
	    public void testDuplicateCodeCheck() {
	        myClass code = new myClass();
	        ArrayList<String> lines = new ArrayList<>();
	        lines.add(code.AA());
	        lines.add(code.AB());
	        boolean result = hasDupes(lines);
	        assertTrue(result);
	    }

	    private boolean hasDupes(ArrayList<String> lines) {
	        for (int i = 0; i < lines.size(); i++) {
	            for (int j = i + 1; j < lines.size(); j++) {
	                if (lines.get(i).equals(lines.get(j))) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
}
