package extras;

import java.util.*;
// http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
public class ItemAssociation {

	HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
	
	
	public void addEdge(String s1, String s2) {
		LinkedList<String> list1 = map.containsKey(s1) ? map.get(s1) : new LinkedList<String>();
		LinkedList<String> list2 = map.containsKey(s2) ? map.get(s2) : new LinkedList<String>();
		list1.add(s2);
		list2.add(s1);
		System.out.println(s1 + Arrays.toString(list1.toArray()));
		System.out.println(s2 + Arrays.toString(list2.toArray()));
		map.put(s1, list1);
		map.put(s2, list2);
	}
	
	public void DFSUtil(String s1, HashMap<String, Boolean> visited) {
		visited.put(s1, true);
		System.out.print(s1 + " ");
		
		LinkedList<String> iter = map.get(s1);
		for(String str : iter) {
			if(!visited.containsKey(str) || (visited.containsKey(str) && !visited.get(str))) {
				DFSUtil(str, visited);
			}
		}
	}
	
	public void DFS(String s1) {
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		DFSUtil(s1, visited);
	}
	
	public static void main(String args[]) {
		ItemAssociation i = new ItemAssociation();
		
		i.addEdge("Item1", "Item2");
		i.addEdge("Item2", "Item3");
		i.addEdge("Item4", "Item5");
		
		i.DFS("Item1");
	}
}
