package extras;

import java.util.*;

public class ProjectBuildOrder {

	HashMap<Character, ArrayList<Character>> map = new HashMap<Character, ArrayList<Character>>(); 
	HashSet<Character> set = new HashSet<Character>();
	
	/*public ArrayList<Character> getSequence() {
		
	}*/
	
	public void addSeq(char a, char b) {
		
		ArrayList<Character> temp = map.containsKey(a) ? map.get(a) : new ArrayList<Character>();
		temp.add(b);
		map.put(a, temp);
		set.add(a);
		set.add(b);
	}
	
	public static void main(String args[]) {
		ProjectBuildOrder o = new ProjectBuildOrder();
		o.addSeq('a', 'b');
	}
}
