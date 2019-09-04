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
		int key = v; int low = 0; int high = n-1;
		while(low<=high){ //when low>high than you have looked through all elements
			int mid = (low+high)/2;
			if(key<x[mid]){
				high = mid-1; //readjust high to mid - 1 because key is < than mid element
			}
			else if(key>x[mid])
				low = mid+1; //re-adjust low to mid + 1 because key is > than the mid element
			else
				return mid;
		}
		//if(low == high && x[low] == key)
		//	return low;
        return -1; //key not found
    }

	/**
	 * This method returns a newly created array containing the first n elements of x, and v.
	 * @param x is the array
	 * @param n is the number of elements to be copied from x
	 * @param v is the value to be added to the new array
	 * @return a new array containing the first n elements of x, and v
	 */
	public static int[] insertGeneral(int[] x, int n, int v){
		//x is an array n is the number of elements in x
		//if x contains v copy over all elements of x into y
		//other wise copy over and add the element v to the new array y in the right spot

		if(find(x,n,v) != -1) { //O(logn) + O(n) = O(n) so no impact on time complexity
			int[] y = new int[n]; //new array y
			if (n >= 0) System.arraycopy(x, 0, y, 0, n); //just copy over into y
			return y;
		}
		else{ //y needs to have element V added in as sorted
			int[] y = new int[n+1];
			int i = 0;
			while(i<n && v>x[i]){ //copy untill reach position where new elements should be added
			    y[i]=x[i];
			    i++;
            }
			y[i] = v; //add new element
			while(i<n){
			    y[i+1]= x[i]; //copy over remaining part of array
			    i++;
            }
			return y;
		}
	}

	/**
	 * This method inserts a value into the array and ensures it's still sorted
	 * @param x is the array
	 * @param n is the number of elements in the array
	 * @param v is the value to be added
	 * @return n if v is already in x, otherwise returns n+1
	 */
	public static int insertInPlace(int[] x, int n, int v){
		//there is a dummy spot at the end of the array
		//find position, place, shift over
		if(find(x,n,v) != -1) //if V is in the array return n
			return n;
		else{ //insert v into the array
			//find index
			//shift over from index to n
			//place at index

			int index = 0; int i = 0;
			while(i<n){
				if(x[i]<v){
					index++;
				}
				i++;
			}
			for(i = n;i>index;i--){
				x[i] = x[i-1];
			}
			x[index] = v;
		}
        return n+1;
    }

	/**
	 * This method sorts a given array using insertion sort
	 * @param x is the array to be sorted
	 * @param n is the number of elements of the array to be sorted
	 */
	public static void insertSort(int[] x, int n){
		for(int i = 1;i<n;i++){
			int element = x[i];
			for(int j = i-1;j>=0;j--){
				if(x[j]>element){ //swap elements to the front if its smaller than the current element
					x[j+1] = x[j];
					x[j] = element;
				}
			}
		}
    }
}
