//The Other Two Trees
package vol1.simpleGeometry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10250 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/simpleGeometry/Problem10250");
		String line;
		while ((line = br.readLine()) != null) {
			String[] coords = line.trim().split("\\s+");
			double x1 = Double.parseDouble(coords[0]);
			double y1 = Double.parseDouble(coords[1]);
			double x2 = Double.parseDouble(coords[2]);
			double y2 = Double.parseDouble(coords[3]);
			
			if (x1 == x2 && y1 == y2) {
				System.out.println("Impossible.");
			}
			else {
				//midpoint
				double mx = (x1+x2)/2;
				double my = (y1+y2)/2;
				
				//shift to origin
				x1 -= mx;
				y1 -= my;
				x2 -= mx;
				y2 -= my;
				
				//Rotate
				double temp = x1;
				x1 = -y1;
				y1 = temp;
				
				temp = x2;
				x2 = -y2;
				y2 = temp;
				
				//unshift
				x1 += mx;
				y1 += my;
				x2 += mx;
				y2 += my;
				
				System.out.printf("%.10f %.10f %.10f %.10f\n", x1, y1, x2, y2);
			}
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
