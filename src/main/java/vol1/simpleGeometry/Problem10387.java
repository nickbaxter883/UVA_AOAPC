//Billiard
package vol1.simpleGeometry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10387 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/simpleGeometry/Problem10387");
		while (true) {
			String[] poolNumbers = br.readLine().trim().split("\\s+");
			double a = Integer.parseInt(poolNumbers[0]);
			double b = Integer.parseInt(poolNumbers[1]);
			double s = Integer.parseInt(poolNumbers[2]);
			double m = Integer.parseInt(poolNumbers[3]);
			double n = Integer.parseInt(poolNumbers[4]);
			
			if (a == 0) {
				break;
			}
			
			double A = Math.toDegrees(Math.atan((double) (b*n)/(a*m)));
			double V = Math.sqrt(a*a*m*m + b*b*n*n)/s;
			
			System.out.printf("%.2f %.2f\n", A, V);
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
