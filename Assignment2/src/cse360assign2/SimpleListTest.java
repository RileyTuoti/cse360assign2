package cse360assign2;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/* Code written by Riley Tuoti
   Class ID # 231
   Assignment # 1
 
   This class tests SimpleList's methods by providing two cases for each method, one which
   should pass and one which should fail.
*/
 

public class SimpleListTest {
	
	//This method tests simple addition to an array, it should pass.
	
	@Test
	public void addToArray() {
		SimpleList testList = new SimpleList();
		
		testList.add(500);
		
		assertEquals(500, testList.getAtIndex(0));
	}
	
	//This method tests that the function add actually adds to the front, it should fail.
	
	@Test
	public void addToFront() {
		SimpleList testList = new SimpleList();
		
		testList.add(500);
		testList.add(400);
		testList.add(10);
		
		assertEquals(500, testList.getAtIndex(0));
	}
	
	//This method removes a number from the middle then checks if its still there, it should fail.
	
	@Test
	public void removeFromMiddle() {
		SimpleList testList = new SimpleList();
	
		testList.add(500);
		testList.add(400);
		testList.add(10);		
		
		testList.remove(400);
		
		assertEquals(400, testList.getAtIndex(1));
	}
	
	//This method removes the first number from list then checks if it has shifted down. It should pass.
	
	@Test
	public void removeFromFront() {
		SimpleList testList = new SimpleList();
		
		testList.add(500);
		testList.add(400);
		testList.add(10);	
		
		testList.remove(10);
		
		assertEquals(400, testList.getAtIndex(0));
	}

	
	//This method checks if count is actually counting the number correctly after additions then deletions.
	//It should pass.
	
	@Test
	public void testCount() {
		SimpleList testList = new SimpleList();
		
		testList.add(500);
		testList.add(400);
		testList.add(400);
		testList.add(400);
		testList.add(10);	
		
		testList.remove(10);
		testList.remove(400);
		testList.remove(500);
		
		
		assertEquals(2, testList.count());
	}
	
	//Tests count before and then after addition and deletion then addition again, it should fail.
	
	@Test
	public void countBeforeAndAfter() {
		SimpleList testList = new SimpleList();
		
		testList.add(500);
		testList.add(400);
		testList.add(10);	
		
		int countBefore = testList.count();
		
		testList.remove(10);
		testList.remove(400);
		testList.remove(500);
		
		testList.add(500);
		testList.add(400);
		testList.add(10);
		testList.add(400);
		testList.add(10);
		
		assertEquals(countBefore + 5, testList.count());
	}
	
	//Tests the simple toString method, making sure the commas are in the correct place. It should pass.
	
	@Test
	public void simpleToString() {
		SimpleList testList = new SimpleList();
		
		testList.add(500);
		testList.add(400);
		testList.add(400);
		testList.add(10);	
		
		testList.remove(400);
		
		String expected = "10 400 500";
		
		assertEquals(expected, testList.toString());
	}
	
	//Tests the toString with a full array of 10 and then adding another one. Should fail.
	
	@Test
	public void toStringFull() {
		SimpleList testList = new SimpleList();
		
		testList.add(500);
		testList.add(400);
		testList.add(10);	
		testList.add(1000);
		testList.add(35);
		testList.add(4);
		testList.add(2);
		testList.add(1);
		testList.add(60);
		testList.add(99);
		testList.add(85);
		
		
		String expected = "85, 99, 60, 1, 2, 4, 35, 1000, 10, 400, 500";
		
		assertEquals(expected, testList.toString());
	}
	
	//Tests the search function whether or not it gets the right index. This one should Pass.
	
	@Test
	public void testIndexGetter() {
		SimpleList testList = new SimpleList();
		
		testList.add(500);
		testList.add(400);
		testList.add(10);	
		
		int actualIndex = testList.search(400);
		
		assertEquals(1, actualIndex);
	}
	
	//Does the same as the function above but deletes the number before checking its index, should fail.
	
	@Test
	public void testSearchAfterDeletion() {
		SimpleList testList = new SimpleList();
		
		testList.add(500);
		testList.add(400);
		testList.add(10);	
		
		testList.remove(400);

		int actualIndex = testList.search(400);
		
		assertEquals(1, actualIndex);
		
	}
	
}
