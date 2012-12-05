//Tree's a Crowd
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Problem152 {
	private static BufferedReader br;
	private static class Point {
		double x, y, z;
		Point(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/sorting/Problem152");
		
		ArrayList<Point> trees = new ArrayList<Point>();
		int[] histogram = new int[10];
		String line;
		
		while((line = br.readLine().trim()) != null) {
			String[] input = line.split("\\s+");
			double x = Double.parseDouble(input[0]);
			double y = Double.parseDouble(input[1]);
			double z = Double.parseDouble(input[2]);
			if (x == 0 && y == 0 && z == 0)
				break;
			
			trees.add(new Point(x, y, z));
		}
		
		for (Point i : trees) {
			double minDistance = 10;
			for (Point j : trees) {
				if (i == j)
					continue;
				
				double distance = getDistance(i, j);
				if (distance < minDistance)
					minDistance = distance;
			}
			if (minDistance < 10) {
				int bin = (int)Math.floor(minDistance);
				histogram[bin]++;
			}
		}
		
		for (int i=0; i<10; i++)
			System.out.printf("%4d", histogram[i]);
		System.out.println();
	}
	
	private static double getDistance(Point p1, Point p2) {
		double xdiff = p1.x - p2.x;
		double ydiff = p1.y - p2.y;
		double zdiff = p1.z - p2.z;
		return Math.sqrt(xdiff*xdiff + ydiff*ydiff + zdiff*zdiff);
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
