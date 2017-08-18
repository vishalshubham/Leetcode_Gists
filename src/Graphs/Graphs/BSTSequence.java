package Graphs;

import java.util.*;

class TreeNodee{
	int val;
	TreeNodee left;
	TreeNodee right;
	
	public TreeNodee(int val, TreeNodee left, TreeNodee right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BSTSequence {
	
	public ArrayList<ArrayList<TreeNodee>> getAllSequences(TreeNodee tree){
		
		if(tree.left==null && tree.right==null) {
			ArrayList<ArrayList<TreeNodee>> temp = new ArrayList<ArrayList<TreeNodee>>();
			ArrayList<TreeNodee> t = new ArrayList<TreeNodee>();
			t.add(tree);
			print("single ", t);
			temp.add(t);
			return temp;
		}
		
		ArrayList<ArrayList<TreeNodee>> leftTemp = null;
		ArrayList<ArrayList<TreeNodee>> rightTemp = null;
		
		if(tree.left!=null) leftTemp = getAllSequences(tree.left);
		if(tree.right!=null) rightTemp = getAllSequences(tree.right);
		
		ArrayList<ArrayList<TreeNodee>> result = new ArrayList<ArrayList<TreeNodee>>();
		
		System.out.println("Node " + tree.val);
		if(leftTemp!=null) System.out.println(leftTemp.size());
		if(rightTemp!=null) System.out.println(rightTemp.size());
		
		if(leftTemp!=null && rightTemp!=null && leftTemp.size()>0 && rightTemp.size()>0) {
			for(ArrayList<TreeNodee> list1 : leftTemp) {
				for(ArrayList<TreeNodee> list2 : rightTemp) {
					ArrayList<TreeNodee> current = new ArrayList<TreeNodee>();
					current.addAll(list1);
					current.add(tree);
					current.addAll(list2);
					result.add(current);
					print("multi", current);
					System.out.println();
					current.clear();
					current.addAll(list2);
					current.add(tree);
					current.addAll(list1);
					result.add(current);
					print("multi", current);
				}
			}
		}
		else if((leftTemp!=null && leftTemp.size()>0) || (rightTemp!=null && rightTemp.size()>0)) {
			
			if(leftTemp.size()>0) {
				
				for(ArrayList<TreeNodee> n : leftTemp) {
					ArrayList<TreeNodee> current = new ArrayList<TreeNodee>();
					for(TreeNodee nn : n) {
						current.add(nn);
						current.add(tree);
					}
					result.add(current);
				}
			}
			else {
				for(ArrayList<TreeNodee> n : rightTemp) {
					ArrayList<TreeNodee> current = new ArrayList<TreeNodee>();
					for(TreeNodee nn : n) {
						current.add(tree);
						current.add(nn);
					}
					result.add(current);
				}
			}
		}
		return result;
	}
	
	public void print(String s, ArrayList<TreeNodee> node) {
		System.out.print(s + " ");
		for(TreeNodee nodee: node) {
			System.out.print( nodee.val + " ");
		}
	}
	
	public static void main(String args[]) {
		TreeNodee node12 = new TreeNodee(12, null, null);
		TreeNodee node11 = new TreeNodee(11, null, null);
		TreeNodee node10 = new TreeNodee(10, null, null);
		TreeNodee node9 = new TreeNodee(9, null, null);
		TreeNodee node8 = new TreeNodee(8, null, null);
		TreeNodee node7 = new TreeNodee(7, null, null);
		TreeNodee node6 = new TreeNodee(6, null, null);
		TreeNodee node5 = new TreeNodee(5, null, null);
		TreeNodee node4 = new TreeNodee(4, null, null);
		TreeNodee node3 = new TreeNodee(3, null, null);
		TreeNodee node2 = new TreeNodee(2, null, null);
		TreeNodee node1 = new TreeNodee(1, null, null);
		
		node1.left = node2;
		node1.right = null;
		
		node2.left = node3;
		node2.right = node4;
		
		node3.left = null;
		node3.right = null;
		
		node4.left = node5;
		node4.right = null;
		
		node5.left = null;
		node5.right = null;

		/*node6.left = node10;
		node6.right = node7;
		
		node7.left = node8;
		node7.right = node9;
		
		node8.left = null;
		node8.right = null;
		
		node9.left = null;
		node9.right = null;*/
		
		/*node10.left = null;
		node10.right = node11;
		
		node11.left = node12;
		node11.right = null;
		
		node12.left = null;
		node12.right = null;*/
		
		BSTSequence b = new BSTSequence();
		ArrayList<ArrayList<TreeNodee>> res = b.getAllSequences(node1);
		
		for(ArrayList<TreeNodee> list: res) {
			for(TreeNodee node : list) {
				System.out.print(node.val + " ");
			}
			System.out.println();
		}
	}
}
