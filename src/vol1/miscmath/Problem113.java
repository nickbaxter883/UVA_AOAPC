//Power of Cryptography
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;

public class Problem113 {
	static BufferedReader br;
	static final boolean DEBUG = false;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem113");
		
		String line;
		while ((line = br.readLine()) != null) {
			Integer root = Integer.parseInt(line);
			BigInteger number = new BigInteger(br.readLine());
			/*if (number.equals(BigInteger.ONE)) {
				System.out.println(1);
				continue;
			}*/
			
			BigInteger nextGuess = BigInteger.TEN.pow(
				number.toString().length() / root + 1);
			debug("Guessing " + nextGuess + " for " +
					root + " root of #" + number.toString().length() + "\n");
			BigInteger guess, delta, ndelta, remainder;
			
			int cnt = 0;
			while (true) {
				cnt++;
				guess = nextGuess;
				ndelta = number.divide(guess.pow(root-1)).subtract(guess);
				delta = ndelta.divide(new BigInteger(root.toString()));
				remainder = ndelta.remainder(new BigInteger(root.toString()));
				nextGuess = guess.add(delta);
				
				if (//delta.equals(BigInteger.ZERO) &&
					!remainder.equals(BigInteger.ZERO))
					nextGuess = nextGuess.subtract(BigInteger.ONE);
				
				if (nextGuess.pow(root).equals(number))
					break;
				debug("g" + nextGuess + " nd" + ndelta +
					" d" + delta + "\n");
			}
			
			debug("(" + cnt + " tries)\n");
			System.out.println(nextGuess);
		}
	}
	
	private static void debug (String msg) {
		if (DEBUG)
			System.out.print(msg);
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
