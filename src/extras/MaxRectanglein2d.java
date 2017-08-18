
import java.util.*;

public class MaxRectanglein2d {
	public int getMaxRectangle(int[] arr){
        
        Stack<Integer> values = new Stack<Integer>();
        Stack<Integer> position = new Stack<Integer>();
        int max = 0;
        
        for(int i=0; i<arr.length; i++){
            int peek = values.empty() ? 0 : values.peek();
            if(values.empty() || peek < arr[i]){
                values.push(arr[i]);
                position.push(i);
            }
            else if(arr[i] < peek){
                int index = 0;
                int value = 0;
                
                while(!values.empty() && values.peek()>arr[i]){
                    index = position.pop();
                    value = values.pop();
                    max = Math.max(max, value * (i-index));
                }
                position.push(index);
                values.push(arr[i]);
            }
        }
        
        while(!values.empty()){
            int index = position.pop();
            int value = values.pop();
            max = Math.max(max, value * (arr.length-index));
        }
        return max;
    }
    
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length ==0 || matrix[0].length ==0) return 0;
        
        int[] arr = new int[matrix[0].length];
        Arrays.fill(arr, 0);
        int max = 0;
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]=='1') arr[j] += 1;
                else arr[j] = 0;   
            }
            max = Math.max(max, getMaxRectangle(arr));
        }
        return max;
    }
    
    public static void main(String args[]) {
    		char[][] arr = {{'0','1'},{'1','0'}};
    		MaxRectanglein2d m = new MaxRectanglein2d();
    		int size = m.maximalRectangle(arr);
    		System.out.println("Size: " + size);
    }
}
