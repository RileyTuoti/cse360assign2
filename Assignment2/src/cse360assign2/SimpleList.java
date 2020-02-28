package cse360assign2;
/**
 * Code written by Riley Tuoti
 * Class ID # 231
 * Assignment # 2
 *
 * This class provides 10 simple methods to do stuff to our class variables list, which is an array of integers 
 * and count which is an integer of how many ints we have in our array list. SimpleList returns an empty array of size 10.
 * add adds its parameter to the front of the array, pushing back any numbers already in the array.
 * remove removes the parameter from the array list.
 * count returns the class variable count. toString returns a string of all the numbers in our array separated by commas.
 * search returns the index of the first parameter found.
 * getAtIndex returns the node at index from parameter, used for testing.
 * 4 new methods are added per assignment2 instruction. Very simple additions.
 *
 * @author Riley Tuoti
 * @version 2.0
 */


public class SimpleList {

	private int[] list;
	public int size;
	private int count;
	
	/**
	 * This method creates an array of 10 integers, unfilled and initializes count. Called which class SimpleList is created.
	 * @param none.
	 * @return Nothing.
	 */
	
	public SimpleList() {
		list = new int[10];
		count = 0;
		size = 10;
	}
	
	/**
	 * This method adds an integer to our array to the head at index 0.
	 * If the array is full then increase the size by 50%. Round down.
	 * @param numAdd The number that is added to the head of array list.
	 * @return Nothing.
	 */
	
	public void add(int numAdd) {
		if (count < 1) {
			list[count] = numAdd;
			count++;
		}
		else if (count == size) { //else if at max capacity
			size = size + (size / 2);
			int[] newList = new int[size]; //size is now increased by 50%
			
			for (int newListIterator = 0; newListIterator < count; newListIterator++) { //copy the array over
				newList[newListIterator] = list[newListIterator];
			}
			
			list = newList;
			
			for (int iterator = size - 1; iterator > 0; iterator--) { //to shift the array after adding to head
				list[iterator] = list[iterator - 1];
			}
			list[0] = numAdd;
			
			count++;
		}
		else {
			for (int iterator = size - 1; iterator > 0; iterator--) { //to shift the array after adding to head
				list[iterator] = list[iterator - 1];
			}
			list[0] = numAdd;
			
			count++;
		}
	}
	
	/**
	 * This method removes all instances of a number from the array list.
	 * If the list has more than 25% empty places, the decrease the size of the list
	 * @param numRemove This is the number we wish to exterminate from the array.
	 * @return Nothing.
	 */
	
	public void remove(int numRemove) {
		
		if ((size/4) >= (size - count) && size > 1) {
			size = size - (size/4); //decrease size by 25%
			
			int[] newList = new int[size]; //size is now decreased by 25%
			
			for (int newListIterator = 0; newListIterator < count; newListIterator++) { //copy the array over
				newList[newListIterator] = list[newListIterator];
			}
			
			list = newList;
			
		}
		
		for (int iterator = 0; iterator < count; iterator++) {
			
			if (list[iterator] == numRemove) {
				
				for (int insideIterator = iterator; insideIterator < size - 1; insideIterator++) {
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
	
	/**
	 * This method appends the parameter to the end of the array instead of the front.
	 * If the list is full then increase the size of the array by 50% to make room.
	 * @param numAdd This parameter is the new integer we are adding to the array.
	 * @return none.
	 */
	
	public void append(int numAdd) {
		if (count < 1) {
			list[count] = numAdd;
			count++;
		}
		else if (count == size) { //else if at max capacity
			size = size + (size / 2);
			int[] newList = new int[size]; //size is now increased by 50%
			
			for (int newListIterator = 0; newListIterator < count; newListIterator++) { //copy the array over
				newList[newListIterator] = list[newListIterator];
			}
			
			list = newList;
		
			list[count] = numAdd;
			
			count++;
		}
		else {
			
			list[count] = numAdd;
			
			count++;
		}
	}
	
	/**
	 * This method returns the first element in the list. If the list is empty return -1.
	 * @param none.
	 * @return int	Returns the first element in the list or -1 if the list is empty.
	 */
	
	public int first() {
		if (count != 0) //if the list is NOT empty
			return list[0];
		else 
			return -1;
	}
	
	/**
	 * This method returns the last element in the list. If the list is empty return -1.
	 * @param none.
	 * @return int	Returns the last element in the list or -1 if the list is empty.
	 */
	
	public int last() {
		if (count != 0) //if the list is NOT empty
			return list[count - 1];
		else 
			return -1;
	}
	
	/**
	 * This method returns the number of possible locations in the list.
	 * @param none.
	 * @return int	Returns the number of possible locations in the list.
	 */
	
	public int size() {
		return size;
	}
	
}
