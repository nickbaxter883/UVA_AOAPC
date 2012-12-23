//Factstone Benchmark
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10916 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem10916");
		while (true) {
			int year = Integer.parseInt(br.readLine());
			if (year == 0)
				break;
			
			int wordSize = (int)Math.pow(2, (year-1940)/10);
			
			double total = 0;
			int count = 1;
			while (total < wordSize) {
				count++;
				total += log2(count);
			}
			System.out.println(count-1);
		}
	}
	
	private static double log2(int base) {
		return Math.log(base)/Math.log(2);
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
