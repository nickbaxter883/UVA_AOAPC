//Multiplying by Rotation
package unsolved;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem550 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/numberTheory/Problem550");
		String line;
		while ((line = br.readLine()) != null) {
			String[] input = line.split("\\s+");
			
			/*BigInteger base = new BigInteger(input[0]);
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
										
					//System.out.println(numerator.divide(denominator));
					System.out.println(x);
					break;
				}
								
			} while (true);*/
			
			int base = Integer.parseInt(input[0]);
			int firstDigit = Integer.parseInt(input[1]);
			int multiplier = Integer.parseInt(input[2]);
			
			int carry = 0;
			int lsb = firstDigit;
			int count = 0;
			do {
				lsb = lsb*multiplier + carry;
				carry = lsb / base;
				lsb = lsb % base;
				count++;
			} while (!(lsb == firstDigit && carry == 0));
			
			System.out.println(count);
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
