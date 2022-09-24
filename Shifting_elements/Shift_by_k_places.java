//package Practice;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//import java.util.Collections;

//import java.util.stream.Stream;

public class ProblemA {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean bool = true;
		while(bool) {
			
		
			System.out.print("Enter the number of elements for the array: ");
			int n = sc.nextInt();
			System.out.print("Start entering elements with space: ");
			int[] arr = new int[n];
			for(int i =0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			System.out.print("Enter the number of shifts to be performed: ");
			int k = sc.nextInt();
			System.out.println();
			System.out.print("Choose 1 for left shift or 2 for right shift: ");
	
			Solution obj = new Solution();
			while(true) {
				boolean flag = true;
				switch(sc.nextInt()) {
					case 1: obj.reverse_left(arr, arr.length, k);
							break;
							
					case 2: obj.reverse_right(arr, arr.length, k);
							break;
							
					default:System.out.println(); 
							System.out.print("Wrong choice\nChoose 1 for left shift or 2 for right shift: ");
							flag = false;
							continue;
				}
				if(flag) break;
			}
			System.out.println();
			System.out.print("Array after shift: ");
			for(int i = 0; i<n;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println("\nStart over? Type \"Y\" or \"N\"");
			String choice = sc.next(); //use next not nextLine
			
			if(choice.compareTo("N") == 0) bool = false;
			if(choice.compareTo("Y") == 0) System.out.println("****************************************************************");
		}
	}
	
}
class Solution{
	public final void reverse_left(int[] arr, int n, int k) {
		k = k%n; //bringing k to the range under n
		reverse(arr, 0, k-1); //since it's left thus first k elements will be reversed
		reverse(arr, k, n-1); //other half
		reverse(arr, 0, n-1); //whole array reverse
	}
	
	public final void reverse_right(int[] arr, int n, int k) {
		k = k%n; //bringing k to the range under n
		reverse(arr, 0, n-k-1); //since it's right thus first n-k elements will be reversed
		reverse(arr, n-k, n-1); //other half
		reverse(arr, 0, n-1); //whole array reversal
		
	}
	
	public void reverse(int[] arr, int start, int last) {
		while(start<last) swap(arr, start++, last--); //code reusability
	}
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
}
