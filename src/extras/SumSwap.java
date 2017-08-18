
// CTCI : 16.21

import java.util.*;

public class SumSwap {

	public void getNumbers(int[] arr1, int[] arr2) {
		int sum1 = 0;
		for(int i=0; i<arr1.length; i++) {
			sum1 += arr1[i];
		}
		int sum2 = 0;
		for(int i=0; i<arr2.length; i++) {
			sum2 += arr2[i];
		}
		
		int diff = (sum1 - sum2)/2;
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int i=0;
		int j=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]-arr2[j] == diff) {
				System.out.println("i + j: " + arr1[i] + "-" + arr2[j]);
				break;
			}
			else if(arr1[i]-arr2[j] > diff) {
				j++;
			}
			else {
				i++;
			}
		}
	}
	
	public static void main(String args[]) {
		SumSwap s = new SumSwap();
		int[] arr1 = {4,1,2,1,1,2};
		int[] arr2 = {3,6,3,3};
		s.getNumbers(arr1, arr2);
	}
}
