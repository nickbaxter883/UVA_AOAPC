//Myacm Triangles
package vol1.simpleGeometry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem10112 {
	static private BufferedReader br;
	
	static private class Point {
		char name;
		int x, y;
		
		Point (char name, int x, int y) {
			this.name = name;
			this.x = x;
			this.y = y;
		}
	}
	
	static private class Triangle {
		private Point p1, p2, p3;
		
		Triangle (Point p1, Point p2, Point p3) {
			this.p1 = p1;
			this.p2 = p2;
			this.p3 = p3;
		}
		
		public boolean has (Point p) {
			if (p == p1 || p == p2 || p == p3) {
				return true;
			}
			return false;
		}
		
		public boolean encloses (Point p) {
			
			int side1 = side(p, p1, p2);
			int side2 = side(p, p2, p3);
			int side3 = side(p, p3, p1);
			
			if (side1 != 0 && (side1 == -side2 || side1 == -side3)) {
				return false;
			}
			if (side2 != 0 && (side2 == -side1 || side2 == -side3)) {
				return false;
			}
			if (side3 != 0 && (side3 == -side1 || side3 == -side2)) {
				return false;
			}
			
			return true;
		}
		
		private int side (Point p, Point p1, Point p2) {
			int a1 = p2.x - p1.x;
			int a2 = p2.y - p1.y;
			int b1 = p.x - p1.x;
			int b2 = p.y - p1.y;
			
			int dotProd = a1*b2 - a2*b1;
			if (dotProd < 0) {
				return -1;
			}
			if (dotProd > 0) {
				return 1;
			}
			return 0;
		}
		
		public int area() {
			return Math.abs((p3.y-p1.y)*(p2.x-p1.x) - (p2.y-p1.y)*(p3.x-p1.x));
		}
		
		@Override
		public String toString() {
			ArrayList<Character> names = new ArrayList<Character>();
			names.add(p1.name);
			names.add(p2.name);
			names.add(p3.name);
			Collections.sort(names);
			
			String name = "";
			for (Character ch : names) {
				name += ch;
			}
			return name;
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/simpleGeometry/Problem10112");
		
		while (true) {
			int numPoints = Integer.parseInt(br.readLine());
			if (numPoints == 0) {
				break;
			}
			
			List<Point> field = new ArrayList<Point>();
			for (int i=1; i<=numPoints; i++) {
				String[] pointData = br.readLine().trim().split("\\s+");
				char pointName = pointData[0].charAt(0);
				int x = Integer.parseInt(pointData[1]);
				int y = Integer.parseInt(pointData[2]);
				
				field.add(new Point(pointName, x, y));
			}
			
			int maxArea = 0;
			Triangle maxPoly = null;
			for (int i=0; i<field.size()-2; i++) {
				for (int j=i+1; j<field.size()-1; j++) {
					innerLoop:
					for (int k=j+1; k<field.size(); k++) {
						
						Triangle powerTri = new Triangle(field.get(i), field.get(j), field.get(k));
												
						for (Point p : field) {
							if (powerTri.has(p)) {
								continue;
							}
							if (powerTri.encloses(p)) {
								continue innerLoop;
							}
						}
							
						//No points are in the triangle
						int area = powerTri.area();
						if (maxArea < area) {
							maxArea = area;
							maxPoly = powerTri;
						}
					}
				}
			}
			System.out.println(maxPoly.toString());
		}
	}
	
	private static BufferedReader getBufferedReader(String[] args, String path) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + path);
		else
			stdin = new InputStreamReader(System.in);
		
		return new BufferedReader(stdin);
	}
}
