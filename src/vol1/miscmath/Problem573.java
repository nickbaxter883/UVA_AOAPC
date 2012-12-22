//The Snail
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem573 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem573");
		
		while (true) {
			String wellStats = br.readLine();
			String[] stats = wellStats.trim().split("\\s+");
			int H = Integer.parseInt(stats[0]);
			float U = Integer.parseInt(stats[1]);
			int D = Integer.parseInt(stats[2]);
			float F = Integer.parseInt(stats[3]);
			F = F/100 * U;
			
			if (H == 0)
				break;
			
			float distance = 0;
			int day = 1;
			while (true) {
				//System.out.print(distance + " " + U + " ");
				if (U > 0)
					distance += U;
				
				//System.out.print(distance + " ");
				if (distance > H) {
					System.out.println("success on day " + day);
					break;
				}
				
				U -= F;
				distance -= D;
				//System.out.println(distance);
				
				if (distance < 0) {
					System.out.println("failure on day " + day);
					break;
				}
				day++;
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
