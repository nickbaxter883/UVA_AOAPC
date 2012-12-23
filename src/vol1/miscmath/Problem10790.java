//How Many Points of Intersection?
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10790 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem10790");
		
		int count = 1;
		while (true) {
			String[] nk = br.readLine().trim().split("\\s+");
			long n = Long.parseLong(nk[0]);
			long k = Long.parseLong(nk[1]);
			if (n == 0)
				break;
			
			long intersections = n*k*(n-1)*(k-1)/4;
			System.out.println("Case " + count + ": " + intersections);
			count++;
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
