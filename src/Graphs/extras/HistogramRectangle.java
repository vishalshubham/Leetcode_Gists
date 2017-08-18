package extras;
import java.util.*;

public class HistogramRectangle {
	
	public int getMaxRect(int[] arr) {
		Stack<Integer> values = new Stack<Integer>();
		Stack<Integer> position = new Stack<Integer>();
		int max = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(position.empty() || values.peek()<arr[i]) {
				position.push(i);
				values.push(arr[i]);
			}
			else if(values.peek()>arr[i]){
				int index = 0;
				int value = 0;
				while(!position.empty() && values.peek()>arr[i]) {
					
					index = position.pop();
					value = values.pop();
					max = Math.max(max, value * (i-index));
				}
				values.push(arr[i]);
				position.push(index);
			}
		}
		
		while(!values.empty()) {
			int index = position.pop();
			int value = values.pop();
			max = Math.max(max, value * (arr.length - index));
		}
		return max;
	}
	
	public static void main(String args[]) {
		HistogramRectangle h = new HistogramRectangle();
		int[] arr = {1,1,1,1,1};
		System.out.println("Max area: " + h.getMaxRect(arr));
	}
}
