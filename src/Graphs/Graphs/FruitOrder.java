package Graphs;

import java.util.*;

public class FruitOrder {
	
	public int isWinner(List<List<String>> orders, List<String> order) {
		
		if(orders.size()==0 || order.size()==0) return 0;
		
		int index = 0;
		
		for(List<String> list : orders) {
			for( int i=0; i< list.size(); i++) {
				String s = list.get(i);
				if(!s.equalsIgnoreCase("anything")) {
					int temp = search(order, s, index);
					if(temp!=-1) {
						index = temp+1;
					}
					else {
						return 0;
					}
				}
				else {
					index++;
				}
			}
		}
		return 1;
	}
	
	public int search(List<String> order, String fruit, int index) {
		for(int i=index; i<order.size(); i++) {
			if(order.get(i).equals(fruit)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String args[]) {
		FruitOrder f = new FruitOrder();
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		List<String> l3 = new ArrayList<String>();
		l1.add("anything");
		l1.add("apple");
		
		l3.add("banana");
		l3.add("anything");
		l3.add("banana");
		
		
		List<List<String>> orders = new ArrayList<List<String>>();
		orders.add(l1);
		orders.add(l2);
		orders.add(l3);
		
		List<String> order = new ArrayList<String>();
		order.add("banana");
		order.add("apple");
		order.add("apple");
		order.add("apple");
		
		order.add("banana");
		order.add("banana");
		order.add("banana");
		
		System.out.println("Is winner: "+ f.isWinner(orders, order));
	}
}
