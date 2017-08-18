package Graphs;

public class MergeSort {

	public void merge(int[] arr, int l, int m, int r) {
		int size1 = m-l+1;
		int size2 = r-m;
		
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];
		
		for(int i=0; i<size1; i++) arr1[i] = arr[i+l];
		for(int i=0; i<size2; i++) arr2[i] = arr[i+m+1];
		
		int i=0, j=0, k=l;
		
		while(i<size1 && j<size2) {
			if(arr1[i]<arr2[j]) {
				arr[k] = arr1[i];
				i++;
			}
			else {
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}
		
		while(i<size1) {
			arr[k] = arr1[i];
			k++;
			i++;
		}
		while(j<size2) {
			arr[k] = arr2[j];
			k++;
			j++;
		}
		
	}
	
	public void mergeSort(int[] arr, int l, int r) {
		if(l<r) {
			int mid = (l+r)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	}
	
	public void print(int[] arr) {
		for(int i: arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = {1,3,-2,4,7,6};
		ms.print(arr);
		ms.mergeSort(arr, 0, arr.length-1);
		ms.print(arr);
	}
}
