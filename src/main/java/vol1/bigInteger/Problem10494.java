//If We Were a Child Again
package vol1.bigInteger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;

public class Problem10494 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/bigInteger/Problem10494");
		String line;
		while ((line = br.readLine()) != null) {
			String[] operands = line.trim().split("\\s+");
			BigInteger a = new BigInteger(operands[0]);
			BigInteger b = new BigInteger(operands[2]);
			BigInteger result;
			
			if (operands[1].equals("/")) {
				result = a.divide(b);
			}
			else if (operands[1].equals("%")) {
				result = a.mod(b);
			}
			else {
				throw new Exception();
			}
			
			System.out.println(result);
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
