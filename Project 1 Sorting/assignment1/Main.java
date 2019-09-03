/* 
 * This file is how you might test out your code.  Don't submit this, and don't 
 * have a main method in SortTools.java.
 */

package assignment1;
public class Main {
	public static void main(String [] args) {

		// call your test methods here
		// SortTools.isSorted() etc.

		int arr[] = { 2, 3, 4, 10, 40 };
		int y[] = SortTools.insertGeneral(arr,arr.length,34);
		for(int i =0;i<y.length;i++){
			System.out.println(y[i]);
		}
	}
}
