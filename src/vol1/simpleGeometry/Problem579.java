//ClockHands
package vol1.simpleGeometry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem579 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/simpleGeometry/Problem579");
		
		while (true) {
			String[] times = br.readLine().trim().split(":");
			double h = Integer.parseInt(times[0]);
			double m = Integer.parseInt(times[1]);
			if (h == 0 && m == 0) {
				break;
			}
			
			double angle = Math.abs((h+m/60)/12 - m/60) * 360;
			angle = 180 - Math.abs(angle-180);
			
			System.out.printf("%.3f\n", angle);
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
