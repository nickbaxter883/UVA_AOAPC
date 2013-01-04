//Product
package vol1.bigInteger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;

public class Problem10106 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/bigInteger/Problem10106");
		String line;
		while ((line = br.readLine()) != null) {
			BigInteger a = new BigInteger(line);
			BigInteger b = new BigInteger(br.readLine());
			
			System.out.println(a.multiply(b));
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
