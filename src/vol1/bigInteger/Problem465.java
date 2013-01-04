//Overflow
package vol1.bigInteger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;

public class Problem465 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/bigInteger/Problem465");
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			
			BigInteger max = new BigInteger("" + Integer.MAX_VALUE);
			String[] operands = line.trim().split("\\s+");
			
			BigInteger a = new BigInteger(operands[0]);
			if (a.compareTo(max) == 1) {
				System.out.println("first number too big");
			}
			BigInteger b = new BigInteger(operands[2]);
			if (b.compareTo(max) == 1) {
				System.out.println("second number too big");
			}
			BigInteger result;
			
			if (operands[1].equals("+")) {
				result = a.add(b);
			}
			else if (operands[1].equals("*")) {
				result = a.multiply(b);
			}
			else {
				throw new Exception();
			}
			
			if (result.compareTo(max) == 1) {
				System.out.println("result too big");
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
