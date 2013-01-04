//Integer Inquiry
package vol1.bigInteger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;

public class Problem424 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/bigInteger/Problem424");
		String line;
		BigInteger sum = BigInteger.ZERO;
		while ((line = br.readLine()) != null) {
			BigInteger number = new BigInteger(line.trim());
			sum = sum.add(number);
		}
		System.out.println(sum);
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
