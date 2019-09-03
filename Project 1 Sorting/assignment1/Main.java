/* 
 * This file is how you might test out your code.  Don't submit this, and don't 
 * have a main method in SortTools.java.
 */

package assignment1;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) {

		// call your test methods here
		// SortTools.isSorted() etc.


		/*
		single element
		double element
		-1 element
		-2 elements
		 */

		int arr[] = {1,2,4,5,0,0};
		SortTools.insertInPlace(arr,arr.length-2,0);
		System.out.println(Arrays.toString(arr));
	}
}
