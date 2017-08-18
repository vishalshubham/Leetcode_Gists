
import java.util.*;

public class BabyNames2 {
	
	public int getTotal(String str, HashMap<String, Boolean> visited, HashMap<String, HashSet<String>> links, HashMap<String, Integer> counts) {
		int total = 0;
		if(!visited.get(str)) {
			visited.put(str, true);
			total += counts.get(str);
			if(links.containsKey(str)) {
				HashSet<String> set = links.get(str);
				for(String temp : set) {
					total += getTotal(temp, visited, links, counts);
				}
			}
		}
		return total;
	}
	
	public static void main(String args[]) {
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		HashMap<String, HashSet<String>> links = new HashMap<String, HashSet<String>>();
		
		counts.put("John", 10);
		counts.put("Jon", 3);
		counts.put("Davis", 2);
		counts.put("Kari", 3);
		counts.put("Johnny", 11);
		counts.put("Carlton", 8);
		counts.put("Carleton", 2);
		counts.put("Jonathan", 9);
		counts.put("Carrie", 5);
		
		visited.put("John", false);
		visited.put("Jon", false);
		visited.put("Davis", false);
		visited.put("Kari", false);
		visited.put("Johnny", false);
		visited.put("Carlton", false);
		visited.put("Carleton", false);
		visited.put("Jonathan", false);
		visited.put("Carrie", false);
		
		String[][] maps = {{"Jonathan", "John"},{"Jon","Johnny"},{"Johnny","John"},{"Kari","Carrie"},{"Carlton","Carleton"}};
		
		for(int i=0; i<maps.length; i++) {
			if(links.containsKey(maps[i][0])) {
				HashSet<String> set = links.get(maps[i][0]);
				set.add(maps[i][1]);
				links.put(maps[i][0], set);
			} else {
				HashSet<String> set = new HashSet<String>();
				set.add(maps[i][1]);
				links.put(maps[i][0], set);
			}
			
			if(links.containsKey(maps[i][1])) {
				HashSet<String> set = links.get(maps[i][1]);
				set.add(maps[i][0]);
				links.put(maps[i][1], set);
			} else {
				HashSet<String> set = new HashSet<String>();
				set.add(maps[i][0]);
				links.put(maps[i][1], set);
			}
		}
		
		BabyNames2 b = new BabyNames2();
		for(Map.Entry<String, Boolean> entry : visited.entrySet()) {
			if(!entry.getValue()) {
				int total = b.getTotal(entry.getKey(), visited, links, counts);
				System.out.println(entry.getKey() + " - " + total);
			}
		}
	}
}
