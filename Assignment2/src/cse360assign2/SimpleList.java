package cse360assign2;
/**
 * Code written by Riley Tuoti
 * Class ID # 231
 * Assignment # 1
 *
 * This class provides 6 simple methods to do stuff to our class variables list, which is an array of integers 
 * and count which is an integer of how many ints we have in our array list. SimpleList returns an empty array of size 10.
 * add adds its parameter to the front of the array, pushing back any numbers already in the array.
 * remove removes the paramter from the array list.
 * count returns the class variable count. toString returns a string of all the numbers in our array separated by commas.
 * search returns the index of the first parameter found.
 * getAtIndex returns the node at index from parameter, used for testing.
 *
 * @author Riley Tuoti
 * @version 1.0
 */


public class SimpleList {

	private int[] list;
	private int count;
	
	/**
	 * This method creates an array of 10 integers, unfilled and initializes count. Called which class SimpleList is created.
	 * @param none.
	 * @return Nothing.
	 */
	
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	/**
	 * This method adds an integer to our array to the head at index 0.
	 * @param numAdd The number that is added to the head of array list.
	 * @return Nothing.
	 */
	
	public void add(int numAdd) {
		if (count < 1) {
			list[count] = numAdd;
			count++;
		}
		else {
			for (int iterator = 9; iterator > 0; iterator--) { //to shift the array after adding to head
				list[iterator] = list[iterator - 1];
			}
			list[0] = numAdd;
			
			if(count < 10)
				count++;
		}
	}
	
	/**
	 * This method removes all instances of a number from the array list.
	 * @param numRemove This is the number we wish to exterminate from the array.
	 * @return Nothing.
	 */
	
	public void remove(int numRemove) {
		for (int iterator = 0; iterator < count; iterator++) {
			
			if (list[iterator] == numRemove) {
				
				for (int insideIterator = iterator; insideIterator < 9; insideIterator++) {
					list[insideIterator] = list[insideIterator + 1]; //to shift the array after deletion
				}
				count--;
				return;
			}
		}
	}
	
	/**
	 * This method returns the number of numbers in the array list.
	 * @param none.
	 * @return int Returns the count of numbers in the array list.
	 */	
	
	public int count() {
		return count;
	}
	
	/**
	 * This method returns a string of integers from our array list separated by commas.
	 * @param none.
	 * @return String Returns the string of our array separated by commas.
	 */
	
	public String toString() {
		String finalString = "";
		
		for (int iterator = 0; iterator < count - 1; iterator++) {
			finalString += list[iterator];
			finalString += " ";
		}
		if (count != 0)
			finalString += list[count - 1];
		return finalString;
	}
	
	/**
	 * This method searches for the parameter int in the array list and returns the index to where it lies.
	 * @param numSearch This parameter is the number that will be searched for in the array list.
	 * @return int Return the index to where the first parameter is located in the array list.
	 */
	
	public int search(int numSearch) {
		int numInside = -1;
		
		for (int iterator = 0; iterator < count; iterator++) {
			if (list[iterator] == numSearch) {
				numInside = iterator;
				iterator = 10; 
			}
		}
		return numInside;
	}

	/**
	 * This method returns the integer in list at the index desired, used for testing.
	 * @param indexDesired This parameter is the index of the number that will be returned in the array list.
	 * @return int Return the number of the index desired inside of the array list.
	 */
	
	public int getAtIndex(int indexDesired) {
		return list[indexDesired];
	}
	
}
