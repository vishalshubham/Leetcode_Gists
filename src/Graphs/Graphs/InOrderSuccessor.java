package Graphs;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}

public class InOrderSuccessor {
	
	public TreeNode successor(TreeNode tree) {
		if(tree==null) return null;
		
		if(tree.right!=null) {
			tree=tree.right;
			while(tree.left!=null) {
				tree=tree.left;
			}
			return tree;
		}
		else {
			if(tree.parent.left == tree) return tree.parent;
			else {
				while(tree.parent!=null && tree.parent.right == tree) {
					tree = tree.parent;
				}
				return tree.parent!=null? tree.parent : null;
			}
		}
	}
	
	public void inOrder(TreeNode tree) {
		if(tree==null) return;
		
		inOrder(tree.left);
		System.out.print(tree.val + " ");
		inOrder(tree.right);
	}
	
	public static void main(String args[]) {
		
		TreeNode node12 = new TreeNode(12, null, null, null);
		TreeNode node11 = new TreeNode(11, null, null, null);
		TreeNode node10 = new TreeNode(10, null, null, null);
		TreeNode node9 = new TreeNode(9, null, null, null);
		TreeNode node8 = new TreeNode(8, null, null, null);
		TreeNode node7 = new TreeNode(7, null, null, null);
		TreeNode node6 = new TreeNode(6, null, null, null);
		TreeNode node5 = new TreeNode(5, null, null, null);
		TreeNode node4 = new TreeNode(4, null, null, null);
		TreeNode node3 = new TreeNode(3, null, null, null);
		TreeNode node2 = new TreeNode(2, null, null, null);
		TreeNode node1 = new TreeNode(1, null, null, null);
		
		node1.left = node2;
		node1.right = node6;
		node1.parent = null;
		
		node2.left = node3;
		node2.right = node4;
		node2.parent = node1;
		
		node3.left = null;
		node3.right = null;
		node3.parent = node2;
		
		node4.left = node5;
		node4.right = null;
		node4.parent = node2;
		
		node5.left = null;
		node5.right = null;
		node5.parent = node4;

		node6.left = node10;
		node6.right = node7;
		node6.parent = node1;
		
		node7.left = node8;
		node7.right = node9;
		node7.parent = node6;
		
		node8.left = null;
		node8.right = null;
		node8.parent = node7;
		
		node9.left = null;
		node9.right = null;
		node9.parent = node7;
		
		node10.left = null;
		node10.right = node11;
		node10.parent = node6;
		
		node11.left = node12;
		node11.right = null;
		node11.parent = node10;
		
		node12.left = null;
		node12.right = null;
		node12.parent = node11;
		
		InOrderSuccessor i = new InOrderSuccessor();
		TreeNode n = i.successor(node1);
		System.out.println(node1.val + " - " + (n==null? null : n.val));
		n = i.successor(node2);
		System.out.println(node2.val + " - " + (n==null? null : n.val));
		n = i.successor(node3);
		System.out.println(node3.val + " - " + (n==null? null : n.val));
		n = i.successor(node4);
		System.out.println(node4.val + " - " + (n==null? null : n.val));
		n = i.successor(node5);
		System.out.println(node5.val + " - " + (n==null? null : n.val));
		n = i.successor(node6);
		System.out.println(node6.val + " - " + (n==null? null : n.val));
		n = i.successor(node7);
		System.out.println(node7.val + " - " + (n==null? null : n.val));
		n = i.successor(node8);
		System.out.println(node8.val + " - " + (n==null? null : n.val));
		n = i.successor(node9);
		System.out.println(node9.val + " - " + (n==null? null : n.val));
		n = i.successor(node10);
		System.out.println(node10.val + " - " + (n==null? null : n.val));
		n = i.successor(node11);
		System.out.println(node11.val + " - " + (n==null? null : n.val));
		n = i.successor(node12);
		System.out.println(node12.val + " - " + (n==null? null : n.val));
		
		
		System.out.println("InOrder");
		i.inOrder(node1);
	}
}
