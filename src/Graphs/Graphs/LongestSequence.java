package Graphs;
import java.util.*;

public class LongestSequence {
   public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            
            if(map.containsKey(num)) continue;
            
            int left = map.containsKey(num-1) ? map.get(num-1) : 0;
            int right = map.containsKey(num+1) ? map.get(num+1) : 0;
            
            map.put(num, left + right + 1);
            
            max = Math.max(max, left + right + 1);
            
            if(left!=0){
                map.put(num-left, left + right + 1);
            }
            if(right!=0){
                map.put(num+right, left + right + 1);
            }
        }
        return max;
    }
   
   	public static void main(String args[]) {
   		LongestSequence l = new LongestSequence();
   		int[] nums = {1,3,5,2,4};
   		System.out.println(l.longestConsecutive(nums));
   	}
}