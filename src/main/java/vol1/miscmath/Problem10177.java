//(2-3-4)-D Sqr-Rects-Cubes-Boxes?
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;

/* Sd = sum i=1 to n (i^d)
 * Td = (sum i=1 to n i)^d = (n(n+1)/2)^d
 * Rd = Td - Sd
 */

public class Problem10177 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem10177");
		String line;
		while ((line = br.readLine()) != null) {
			BigInteger n = new BigInteger(line);
			
			BigInteger sumOfLengths =
					( n
					.multiply(n.add(BigInteger.ONE)) )
					.divide(new BigInteger("2"));
			BigInteger totalBoxes;
			
			BigInteger sumOfSquares =
					( n
					.multiply(n.add(BigInteger.ONE))
					.multiply(n.multiply(new BigInteger("2")).add(BigInteger.ONE)) )
					.divide(new BigInteger("6"));
			totalBoxes = sumOfLengths.pow(2);
			System.out.print(sumOfSquares + " " + totalBoxes.subtract(sumOfSquares) + " ");
			
			BigInteger sumOfCubes =
					( n
					.multiply(n)
					.multiply(n.add(BigInteger.ONE))
					.multiply(n.add(BigInteger.ONE)) )
					.divide(new BigInteger("4"));
			totalBoxes = sumOfLengths.pow(3);
			System.out.print(sumOfCubes + " " + totalBoxes.subtract(sumOfCubes) + " ");
			
			BigInteger sumOfHypers =
					( (new BigInteger("6")).multiply(n.pow(5))
					.add(
					(new BigInteger("15")).multiply(n.pow(4)))
					.add(
					(new BigInteger("10")).multiply(n.pow(3)))
					.subtract(n) )
					.divide(new BigInteger("30"));
			totalBoxes = sumOfLengths.pow(4);
			System.out.print(sumOfHypers + " " + totalBoxes.subtract(sumOfHypers));
			System.out.println();			
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
