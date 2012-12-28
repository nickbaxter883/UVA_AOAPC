//Multiplying by Rotation
package unsolved;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;

public class Problem550 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/numberTheory/Problem550");
		String line;
		while ((line = br.readLine()) != null) {
			String[] input = line.split("\\s+");
			
			BigInteger base = new BigInteger(input[0]);
			BigInteger firstDigit = new BigInteger(input[1]);
			BigInteger multiplier = new BigInteger(input[2]);
			
			BigInteger denominator = multiplier.multiply(base).subtract(BigInteger.ONE);
			BigInteger numerator = BigInteger.ZERO;
			BigInteger power = BigInteger.ONE;
			
			long x = 0;
			do {
				x++;
				power = power.multiply(base);
				numerator = firstDigit.multiply(power.subtract(BigInteger.ONE));
				
				if (numerator.mod(denominator).equals(BigInteger.ZERO)) {
					/*if (numerator.divide(denominator).multiply(multiplier).multiply(base).multiply(base)
					 * .divide(power).mod(base).equals(BigInteger.ZERO)) {
						continue;
					}*/
					
					System.out.println(numerator.divide(denominator));
					//System.out.println(x);
					break;
				}
								
			} while (true);
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
