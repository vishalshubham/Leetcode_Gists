package Graphs;

import java.util.Arrays;

public class LivingPeople {

	public int getMax(int[] birth, int[] death) {
		
		int max = 0;
		int curr = 0;
		int i = 0;
		int j = 0;
		
		while(i<birth.length && j<death.length) {
			if(birth[i]<=death[j]) {
				curr++;
				i++;
			}
			else {
				curr--;
				j++;
			}
			max = Math.max(max, curr);
			System.out.println("Max " + max);
		}
		return max;
	}
	
	public static void main(String args[]) {
		int[] birth = {12, 20, 10, 01, 10, 73, 13, 15, 83, 75};
		int[] death = {15, 90, 98, 72, 98, 74, 98, 98, 99, 94};
		Arrays.sort(birth);
		Arrays.sort(death);
		
		System.out.println(Arrays.toString(birth));
		System.out.println(Arrays.toString(death));
		
		System.out.println(new LivingPeople().getMax(birth, death));
	}
}
