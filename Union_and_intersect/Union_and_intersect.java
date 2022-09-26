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
    
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		boolean bool = true;
		while(bool) {
			System.out.print("Enter size of array 1: ");
			int n = sc.nextInt();
			System.out.print("Enter size of array 2: ");
			int m = sc.nextInt();
			int arr[] =new int[n];
			int arr1[] = new int [m];
			System.out.println("Values of first array (increasing order): ");
			for(int i =0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println("Values of Second array (increasing order): ");
			for(int i =0;i<m ;i++) {
				arr1[i] = sc.nextInt();
			}
			
			
			//System.out.println("Calculating...");
			ArrayList<Integer> res = new ArrayList<Integer>();
			res = union(arr, arr1, n, m);
			System.out.print("Union is:");
			System.out.print(res);
			res.clear();
			res = intersection(arr, arr1, n, m);
			System.out.print("\nIntersection: ");
			System.out.print(res);
			System.out.println();
			System.out.println("Redo?(Y/N)");
			String s = sc.next();
			if(s.equalsIgnoreCase("Y")) {
				System.out.flush(); 
				//System.out.println("********************************************************\nSTART\n********************************************************");
				for(int i =0; i<101; i++) {
					System.out.print("*");
					Thread.sleep(30);
					if(i == 50) {
						System.out.println("\nSTARTING");
//						System.out.println();
					}
//					
				}
				System.out.println();
			}
			else { System.out.println("Exiting...");
			System.exit(0);
			}
		}
		sc.close();
		
	}
	public static ArrayList<Integer> intersection(int arr[], int arr1[], int n, int m) {
		ArrayList<Integer>res = new ArrayList<Integer>();
		//approach: two pointer approach
		
		//we check if the arr element is smaller than arr2 element
		//if yes then we increase the pointer of first arr and do not insert that element in res list
		
		//else if the element of arr is greater than arr2 element
		//then we increase the pointer of arr2
		//also we don't insert in the res list
		
		//else if the element of arr is equal to arr2 element
		//then we store the element inside the arraylist and increase the pointer of both arrays
		//
		
		int first =0, second = 0;
		while(first<arr.length && second<arr1.length) {
			if(arr[first]>arr1[second]) {
				second++;
			}
			else if(arr[first]<arr1[second]) {
				//System.out.println(first);
				first++;
			}
			else {
				//System.out.println(first);
				res.add(arr[first]);
			    first++;
			    second++;
				}			
		}
		
		return res;
	}
	
	
	public static ArrayList<Integer> union(int[] A, int[] B,int n, int m){
		ArrayList<Integer> res = new ArrayList<Integer>();
		//[1,2,6,7,8]
		//[1,3,4]
		//[1,2,3,4,6,7,8]
		
		//approach:
		//if we encounter 1st element is greater than second element; 
					//here first element corresponds to first array and second to second array
		//then we can check if second element(smaller) is inside the arraylist or not?
		//if not then we can enter it inside the arraylist and move to "next iteration"; second++
		
		//else if we encounter the 1st element is smaller than second element 
		//then we can check if the first element is inside the arraylist or not?
		//if not then we can enter it inside the arraylist and move to next iteration; first++
		
		//else if we encounter the first element is equal to second element
		//then we can check if the first element is inside the arraylist or not?
		//if not then we proceed to enter it inside list ; first++, second++
		
		//also we will have the case where we need to enter more elements those are left inside the bigger array
		//therefore we will store the index of the last iterated index of both array and then we can proceed to enter 
		//then we can proceed to enter residual elements but we will check if they were already present inside the arraylist or not
		
		int first =0, second =0;
		while(first<n && second<m) {
			if(A[first]>B[second]) {
				if(res.isEmpty() || res.get(res.size()-1) != B[second]) {
					res.add(B[second]);
				}
				second++;
			}
			else if(A[first]<B[second]) {
				if(res.isEmpty() || res.get(res.size()-1) != A[first]) {
					res.add(A[first]);
				}
				first++;
			}
			else {
				if(res.isEmpty() || res.get(res.size()-1) != B[second]) {
					res.add(B[second]);
				}
				first++;
				second++;
			}
		}
		//System.out.println(res);
		while(first<n) {
			if(res.get(res.size()-1)!=A[first]) {
				res.add(A[first]);
			}
			first++;
		}
		while(second<m) {
			if(res.get(res.size()-1)!=B[second]) {
				res.add(B[second]);
			}
			second++;
		}
		return res;
	}
	
}
