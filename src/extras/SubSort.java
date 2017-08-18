
import java.util.*;

public class SubSort {

	public void getIndex(int[] arr) {
		if(arr.length==1) return;
		
		int i=0;
		int j=arr.length-1;
		
		for(int x=1; x<=j; x++) {
			if(arr[x]<arr[x-1]) {
				i=x-1;
				break;
			}
		}
			
		
		for(int x=arr.length-2; x>=0; x--) {
			if(arr[x]>arr[x+1]) {
				j=x+1;
				break;
			}
		}
		
		int max = arr[0];
		int min = arr[arr.length-1];
		
		for(int x=1; x<=j; x++) {
			max = Math.max(max, arr[x]);
		}
		for(int x=arr.length-2; x>=i; x--) {
			min = Math.min(min, arr[x]);
		}
		
		for(; i>=0; i--) {
			if(arr[i]<=min) {
				i++;
				break;
			}
		}
		for(; j<arr.length; j++) {
			if(arr[j]>=max) {
				j--;
				break;
			}
		}
		
		System.out.println("Answer is: " + i + " - " + j);
	}
	
	public static void main(String args[]) {
		SubSort s = new SubSort();
		int[] arr = {1,2,4,7,10,11,8,12,5,6,16,18,19};
		s.getIndex(arr);
	}
}
