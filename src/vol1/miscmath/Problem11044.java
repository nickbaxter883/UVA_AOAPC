//Searching for Nessy
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem11044 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem11044");
		int tests = Integer.parseInt(br.readLine());
		for (int t=0; t<tests; t++) {
			String[] dimensions = br.readLine().trim().split("\\s+");
			int m = Integer.parseInt(dimensions[0]);
			int n = Integer.parseInt(dimensions[1]);
			
			System.out.println((n/3)*(m/3));
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
