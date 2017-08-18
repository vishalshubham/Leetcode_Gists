package Graphs;
import java.util.*;

class Node{
	int val;
	Node left;
	Node right;
	public Node(int val) {
		this.val = val;
	}
}

public class RelationsToTree {
	public Node getTree(int[][] arr) {
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
		
		Node n = new Node(head);
		Stack<Node> stack = new Stack<Node>();
		stack.push(n);
		
		while(!stack.empty()) {
			Node temp = stack.pop();
			ArrayList<Integer> list = map.containsKey(temp.val) ? map.get(temp.val) : null;
			if(list!=null) {
				Node left = new Node(list.get(0));
				temp.left = left;
				stack.push(left);
				if(list.size()==2) {
					Node right = new Node(list.get(1)); 
					temp.right = right;
					stack.push(right);
				}
			}
		}
		return n;
	}
	
	public static void main(String args[]) {
		int[][] arr = {{1, 2},{2, 3},{2, 4},{1, 5},{5, 6},{6, 7}};
		Node res = new RelationsToTree().getTree(arr);
		
		Stack<Node> s = new Stack<Node>();
		s.push(res);
		while(!s.empty()) {
			Node temp = s.pop();
			System.out.println(temp.val);
			if(temp.left!=null) s.push(temp.left);
			if(temp.right!=null) s.push(temp.right);
		}
	}
}
