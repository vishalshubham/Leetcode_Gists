package extras;

import java.util.*;

public class KeypadCombinations {

	char[][] value= {{},{},
					{'a','b','c'},
					{'d','e','f'},
					{'g','h','i'},
					{'j','k','l'},
					{'m','n','o'},
					{'p','q','r','s'},
					{'t','u','v'},
					{'w','x','y','z'}};
	
	public List<String> getWords(int num){
		HashSet<String> res = new HashSet<String>();
		res.add("");
		HashSet<String> tRes = new HashSet<String>();
		
		String s = num + "";
		
		for(int i=0; i<s.length(); i++) {
			tRes.addAll(res);
			res.clear();
			
			char c = s.charAt(i);
			char[] temp = value[c - '0'];
			HashSet<String> set = new HashSet<String>();
			
			for(char cc : temp) {
				for(String str : tRes) {
					String t = str + cc;
					set.add(t);
				}
			}
			res.addAll(set);
			tRes.clear();
		}
		
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(res);
		System.out.println(list.size());
		return list;
	}
	
	public static void main(String args[]) {
		KeypadCombinations k = new KeypadCombinations();
		System.out.println(k.getWords(7686));
	}
}
