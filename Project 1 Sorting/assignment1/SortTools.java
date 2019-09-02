// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * <Student Name>
 * <Student EID>
 * <5-digit Unique No.>
 * Fall 2018
 * Slip days used: 
 */

package assignment1;
public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */

	public static boolean isSorted(int[] x, int n) {
		//Check if length or n == 0 if true return false
		if((x.length == 0) || n == 0){
			return false;
		}

		//iterate through n elements to see if any element is less than the previous element
		//one iteration through entire array O(n)
		for(int i = 1;i<n;i++){
			if(x[i]<x[i-1])
				return false;
		}

		//if finishes iterating through than the array is sorted in non-decreasing order
		return true;
	}

	/**
	 * This method returns the index of value v within array x.
	 * @param x is the array
	 * @param n is the size of the input to be checked
	 * @param v is the value to be searched for within x
	 * @return index of v if v is contained within x. -1 if v is not contained within x
	 */
	public static int find(int[] x, int n, int v) {
		//O(log(n)) -> binary search
		int key = v; int low = 0; int high = n;

		while(low<=high){ //when low>high than you have looked through all elements
			int mid = (low+high)/2;
			if(x[mid] == key) //if x[mid] == key ie the number searching for than we are done
				return mid;
			else if(key>x[mid]){
				low = mid+1; //readjust low to mid +1 because key is greater than mid element
			}
			else
				high = mid-1; //re-adjust high to mid-1 because key is less than the mid element
		}
        return -1;
    }

	/**
	 * This method returns a newly created array containing the first n elements of x, and v.
	 * @param x is the array
	 * @param n is the number of elements to be copied from x
	 * @param v is the value to be added to the new array
	 * @return a new array containing the first n elements of x, and v
	 */
	public static int[] insertGeneral(int[] x, int n, int v){
		// stub only, you write this!
		// TODO: complete it
        return null;
    }

	/**
	 * This method inserts a value into the array and ensures it's still sorted
	 * @param x is the array
	 * @param n is the number of elements in the array
	 * @param v is the value to be added
	 * @return n if v is already in x, otherwise returns n+1
	 */
	public static int insertInPlace(int[] x, int n, int v){
		// stub only, you write this!
		// TODO: complete it
        return -1;
    }

	/**
	 * This method sorts a given array using insertion sort
	 * @param x is the array to be sorted
	 * @param n is the number of elements of the array to be sorted
	 */
	public static void insertSort(int[] x, int n){
    }
}
