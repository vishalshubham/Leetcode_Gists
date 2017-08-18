package Graphs;

import java.awt.Point;
import java.util.*;
public class LineIntersection {
	
	public Point getIntersection(Point s1, Point e1, Point s2, Point e2) {
		int num1 = (int) (e1.getY() - s1.getY());
		int den1 = (int) (e1.getX() - s1.getX());

		int num2 = (int) (e2.getY() - s2.getY());
		int den2 = (int) (e2.getX() - s2.getX());
		
		double c1 = ((s1.getY() * den1) - (s1.getX() * num1)) / den1;
		double c2 = ((s2.getY() * den2) - (s2.getX() * num2)) / den2;
		
		double x = (c2-c1)/((num1/den1) - (num2/den2));
		double y = ((num1/den1) * x) + c1;
		
		System.out.println(x + "-" + y);
		
		Point res = new Point();
		res.setLocation(x, y);
		return res;
	}
	
	public static void main(String args[]) {
		LineIntersection l = new LineIntersection();
		
		Point s1 = new Point(4,1);
		Point e1 = new Point(2,3);
		Point s2 = new Point(4,4);
		Point e2 = new Point(1,1);
		
		Point p = l.getIntersection(s1, e1, s2,e2);
	}
}
