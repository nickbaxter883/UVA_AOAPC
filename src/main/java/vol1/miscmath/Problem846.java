//Steps
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem846 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem846");
		
		int numWalks = Integer.parseInt(br.readLine());
		for (int walk=0; walk<numWalks; walk++) {
			
			String[] track = br.readLine().trim().split("\\s+");
			int beginning = Integer.parseInt(track[0]);
			int end = Integer.parseInt(track[1]);
			
			int distance = end - beginning;
			if (distance == 0) {
				System.out.println(0);
				continue;
			}
			
			int x = (int)Math.ceil(Math.sqrt(distance));
			if (distance > x*(x-1))
				System.out.println(2*x-1);
			else
				System.out.println(2*x-2);
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
