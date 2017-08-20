import java.util.*;

class Nodee{
	int val;
	Nodee left;
	Nodee right;
	public Nodee(int val) {
		this.val = val;
	}
}

public class RelationsToTree {
	public Nodee getTree(int[][] arr) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		HashSet<Integer> parentSet = new HashSet<Integer>();
		HashSet<Integer> childSet = new HashSet<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			ArrayList<Integer> temp = map.containsKey(arr[i][0]) ? map.get(arr[i][0]) : new ArrayList<Integer>();
			temp.add(arr[i][1]);
			map.put(arr[i][0], temp);
			parentSet.add(arr[i][0]);
			childSet.add(arr[i][1]);
		}
		
		parentSet.removeAll(childSet);
		int head = -1;
		for(int i : parentSet) head = i;
		
		Nodee n = new Nodee(head);
		Stack<Nodee> stack = new Stack<Nodee>();
		stack.push(n);
		
		while(!stack.empty()) {
			Nodee temp = stack.pop();
			ArrayList<Integer> list = map.containsKey(temp.val) ? map.get(temp.val) : null;
			if(list!=null) {
				Nodee left = new Nodee(list.get(0));
				temp.left = left;
				stack.push(left);
				if(list.size()==2) {
					Nodee right = new Nodee(list.get(1)); 
					temp.right = right;
					stack.push(right);
				}
			}
		}
		return n;
	}
	
	public static void main(String args[]) {
		int[][] arr = {{1, 2},{2, 3},{2, 4},{1, 5},{5, 6},{6, 7}};
		Nodee res = new RelationsToTree().getTree(arr);
		
		Stack<Nodee> s = new Stack<Nodee>();
		s.push(res);
		while(!s.empty()) {
			Nodee temp = s.pop();
			System.out.println(temp.val);
			if(temp.left!=null) s.push(temp.left);
			if(temp.right!=null) s.push(temp.right);
		}
	}
}
