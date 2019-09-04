/* 
 * This file is how you might test out your code.  Don't submit this, and don't 
 * have a main method in SortTools.java.
 */

package assignment1;
import java.util.*;

public class Main {
	public static void main(String [] args) {

		// call your test methods here
		// SortTools.isSorted() etc.

		/**is sorted test cases**/
		System.out.println("** SortTools.isSorted ** \n\n");

		int a[] = {};
        int a1[] = {1};
		int a2[] = {1,1};
		int a3[] = {1,2,1};
		int a4[] = {1,2,3,4,5,4,3,2,1};

		System.out.println("False =" + SortTools.isSorted(a,a.length));
		System.out.println("True =" + SortTools.isSorted(a1,a1.length));
		System.out.println("False =" + SortTools.isSorted(a1,a1.length-1));
		System.out.println("True =" + SortTools.isSorted(a2,a2.length));
		System.out.println("True =" + SortTools.isSorted(a3,a3.length-1));
		System.out.println("False =" + SortTools.isSorted(a3,a3.length));
		System.out.println("False =" + SortTools.isSorted(a4,a4.length));
		System.out.println("True =" + SortTools.isSorted(a4,a4.length-4));


		/** find test cases**/
		System.out.println("\n\n** SortTools.Find ** \n\n");

		int find[] = {1,4,6,70,99};
		int find2[] = {1,1,2,3,3};
		System.out.println("0 =" + SortTools.find(find,find.length,1));
		System.out.println("0 =" + SortTools.find(find,find.length-1,1));
		System.out.println("-1 =" + SortTools.find(find,find.length-1,99));
		System.out.println("3 =" + SortTools.find(find,find.length-1,70));
		System.out.println("1 =" + SortTools.find(find,find.length-3,4));
		System.out.println("-1 =" + SortTools.find(find,find.length-3,40));
		System.out.println("0 =" + SortTools.find(find,find.length-4,1));
		System.out.println("-1 =" + SortTools.find(find,find.length-4,10));
		System.out.println("2 or 3  ="+SortTools.find(find2,find2.length,3));
		System.out.println("0 or 1  =" + SortTools.find(find2,find2.length,1));
		System.out.println("2 =" + SortTools.find(find2,find2.length-2,2));
		int find3[] ={1, 1, 1, 1, 2};
		System.out.println("-1 =" + SortTools.find(find3,find3.length-1,40));


		/**General insert test**/
		System.out.println("\n\n** SortTools.insertGeneral ** \n\n");


		int gen[] = {12,14,67,77,88,99};
		int gen2[] = {1,2,2,2,3};
		System.out.println("12,14,67,77,88,91,99" + Arrays.toString(SortTools.insertGeneral(gen,gen.length,91)) + SortTools.isSorted(SortTools.insertGeneral(gen,gen.length,91),gen.length));
		System.out.println("12,14,67,77,88,99" + Arrays.toString(SortTools.insertGeneral(gen,gen.length,99)) + SortTools.isSorted(SortTools.insertGeneral(gen,gen.length,99),gen.length));
		System.out.println("12,14,67,77" + Arrays.toString(SortTools.insertGeneral(gen,gen.length-2,77)) + SortTools.isSorted(SortTools.insertGeneral(gen,gen.length-2,77),gen.length-2));
		System.out.println("12,14,67,77,88" + Arrays.toString(SortTools.insertGeneral(gen,gen.length-2,88)) + SortTools.isSorted(SortTools.insertGeneral(gen,gen.length-2,88),gen.length-2));

		System.out.println("12,14" + Arrays.toString(SortTools.insertGeneral(gen,gen.length-5,14)) + SortTools.isSorted(SortTools.insertGeneral(gen,gen.length-5,14),gen.length-5));

		System.out.println("1,2,2,2,3" + Arrays.toString(SortTools.insertGeneral(gen2,gen2.length,2)) + SortTools.isSorted(SortTools.insertGeneral(gen2,gen2.length,2),gen2.length));
		System.out.println("0,1,2,2,2,3" + Arrays.toString(SortTools.insertGeneral(gen2,gen2.length,0)) + SortTools.isSorted(SortTools.insertGeneral(gen2,gen2.length,0),gen2.length));
		System.out.println("1,2" + Arrays.toString(SortTools.insertGeneral(gen2,gen2.length-4,2)) + SortTools.isSorted(SortTools.insertGeneral(gen2,gen2.length-4,2),gen2.length-4));

		/**Insert in place test**/

		System.out.println("\n\n** SortTool.insertInPlace ** \n\n");

		int n;
		int in[] = {1,12,14,17,19,24};
		n = SortTools.insertInPlace(in,in.length-1,12);
		System.out.println("1,12,14,17,19,24"+ Arrays.toString(in)+SortTools.isSorted(in,in.length-1)+n+"== 5");
		int in2[] = {1,12,14,17,19,24};
		n = SortTools.insertInPlace(in2,in.length-3,24);
		System.out.println("1,12,14,24,19,24"+ Arrays.toString(in2)+SortTools.isSorted(in2,in2.length-3+1)+n+"== 4");
		int in3[] = {1,12,14,17,19,24};
		n = SortTools.insertInPlace(in3,in.length-5,1);
		System.out.println("1,12,14,17,19,24"+ Arrays.toString(in3)+SortTools.isSorted(in3,in3.length-5) + n + "== 1");
		int in4[] = {1,12,14,17,19,24};
		n = SortTools.insertInPlace(in4,in.length-5,0);
		System.out.println("0,1,14,17,19,24"+ Arrays.toString(in4)+SortTools.isSorted(in4,in4.length-5+1)  +n + "== 2");
		int in5[] = {1,12,14,17,19,24};
		n = SortTools.insertInPlace(in5,in.length-5,2);
		System.out.println("1,2,14,17,19,24"+ Arrays.toString(in5)+SortTools.isSorted(in5,in5.length-5+1)+ n + "== 2");


		/**insertion sort test**/

		System.out.println("\n\n** SortTools.insertSort ** \n\n");

		int x1[] = {9,8,7,6,5,4,3,2,1};
		int x2[] = {9,8,7,6,5,4,3,2,1};
		int x3[] = {9,8,7,6,5,4,3,2,1};

		int arr[] = {1,2,3,4,5};
		int arr2[] = {1,2,3,4,5};

		int x[] = {1,4,2,8,0,3};
		int xa[] = {1,4,2,8,0,3};
		int xb[] = {1,4,2,8,0,3};
		int xc[] = {1,4,2,8,0,3};

		SortTools.insertSort(x1,x1.length);
		System.out.println(Arrays.toString(x1) + " == 1,2,3,4,5,6,7,8,9");

		SortTools.insertSort(x2,x2.length-5);
		System.out.println(Arrays.toString(x2) + " == 6,7,8,9,5,4,3,2,1");

		SortTools.insertSort(x3,x3.length-8);
		System.out.println(Arrays.toString(x3) + " == 9,8,7,6...2,1");

		SortTools.insertSort(arr,arr.length);
		System.out.println(Arrays.toString(arr) + " == 1,2,3,4,5");

		SortTools.insertSort(arr2,arr2.length-2);
		System.out.println(Arrays.toString(arr2) + " == 1,2,3,4,5");

		SortTools.insertSort(x,x.length);
		System.out.println(Arrays.toString(x) + " == 0,1,2,3,4,8");

		SortTools.insertSort(xa,xa.length-1);
		System.out.println(Arrays.toString(xa) + " == 0,1,2,4,8,3");

		SortTools.insertSort(xb,xb.length-3);
		System.out.println(Arrays.toString(xb) + " == 1,2,4,8,0,3");

		SortTools.insertSort(xc,xc.length-5);
		System.out.println(Arrays.toString(xc) + " == 1,4,2,8,0,3");

	}
}
