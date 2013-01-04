//Inscribed Circles and Isosceles Triangles
package vol1.simpleGeometry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem375 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/simpleGeometry/Problem375");
		int numTests = Integer.parseInt(br.readLine());
		for (int i=1; i<=numTests; i++) {
			br.readLine();
			String[] bh = br.readLine().trim().split("\\s+");
			double b = Double.parseDouble(bh[0]);
			double h  = Double.parseDouble(bh[1]);
			double circumference = 0, nextHeight;
			
			while (true) {
				double r = b*h / (Math.sqrt(4*h*h + b*b) + b);
				if (r < 0.000001) {
					break;
				}
				circumference += 2*Math.PI*r;
								
				nextHeight = h - 2*r;
				b = nextHeight/h * b;
				h = nextHeight;
			}
			
			if (i != 1) {
				System.out.println();
			}
			System.out.printf("%13.6f\n", circumference);
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
