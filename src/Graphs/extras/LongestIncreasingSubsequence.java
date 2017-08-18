package extras;
import java.util.*;

public class LongestIncreasingSubsequence {
   
    public int lengthOfLIS(int[] arr) {
        if(arr.length==0 || arr.length == 1) return arr.length;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> t = new ArrayList<Integer>();
        t.add(arr[0]);
        map.put(1, t);
        
        for(int i=1; i<arr.length; i++){
            int size = map.size();
            boolean flag = false;
            
            for(int j=size; j>=1; j--){
                ArrayList<Integer> list = map.get(j);
                int last = list.get(list.size()-1);
                int last2 = list.size()>=2 ? list.get(list.size()-2) : Integer.MAX_VALUE;
                
                if(last<arr[i] && last2>arr[i]){
                    ArrayList<Integer> llist = new ArrayList<Integer>(list);
                    llist.add(arr[i]);
                    map.put(j+1, llist);
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                for(int j=1; j<=map.size(); j++){
                    
                    ArrayList<Integer> list = new ArrayList<>(map.get(j));   
                    int last2 = list.size()>=2 ? list.get(list.size()-2) : Integer.MIN_VALUE;
                    
                    if(list.get(list.size()-1)>arr[i] && last2<arr[i]){
                        list.set(list.size()-1, arr[i]);
                        map.put(j, list);   
                        break;
                    }
                }
            }
        }
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            System.out.println(entry.getValue().toString());
        }
        
        return map.size();
    }
    
    public static void main(String args[]) {
    		LongestIncreasingSubsequence s = new LongestIncreasingSubsequence();
    		int[] arr = {4,10,4,3,8,9};
    		s.lengthOfLIS(arr);
    }
    
    
    /*public int lengthOfLIS(int[] nums) {
        if(nums.length==0 || nums.length == 1) return nums.length;
        
        int[] max = new int[nums.length];
        max[0] = 1;
        int maxLen = 1;
        
        for(int i=1; i<nums.length; i++){
            max[i] = 1;
            int temp = 1;
            for(int j=i-1; j>=0; j--){
                int num = nums[j];
                if(nums[i] > num) {
                    max[i] = max[i] > max[j] + 1 ? max[i] : max[j] + 1;
                    maxLen = Math.max(maxLen, max[i]);
                }
            }
        }
        return maxLen;
    }*/
}