package extras;

import java.util.*;
import java.lang.*;
import java.math.BigInteger;

public class Extra {
	public static void main(String args[]) {
		Character c = 'P';
		BigInteger b = new BigInteger("100000000000000");	
		BigInteger b1 = new BigInteger("100000000000000");	
		
		System.out.println(b.equals(b1));
		
		System.out.println(new StringBuilder("hello").append("i").toString());
		
		LinkedList<Integer> l1 = new LinkedList<>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		
		LinkedList<Integer> ll = l1;
		int i = 0;
		while(i<ll.size()) {
			System.out.print(ll.get(i) + " - ");
			i++;
		}
		System.out.println("null");
		
		LinkedList<Integer> ls = (LinkedList<Integer>) ll.clone();
		
		i = 0;
		while(i<ls.size()) {
			System.out.print(ls.get(i) + " - ");
			i++;
		}
		System.out.println("null");
		
		ls.set(3, 9);
		
		i = 0;
		while(i<ls.size()) {
			System.out.print(ls.get(i) + " - ");
			i++;
		}
		System.out.println("null");
		
		i = 0;
		while(i<ll.size()) {
			System.out.print(ll.get(i) + " - ");
			i++;
		}
		System.out.println("null");
	}
}
