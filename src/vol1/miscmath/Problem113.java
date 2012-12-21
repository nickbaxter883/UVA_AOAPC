//Power of Cryptography
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;

public class Problem113 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem113");
		
		String line;
		while ((line = br.readLine()) != null) {
			Integer root = Integer.parseInt(line);
			BigInteger number = new BigInteger(br.readLine());
			BigInteger nextGuess = BigInteger.TEN.pow(
				number.toString().length() / root);
			//System.out.println("Guessing " + nextGuess + " for " +
					//root + " root of " + number);
			BigInteger guess, delta;
			
			int cnt = 0;
			do {
				cnt++;
				guess = nextGuess;
				delta = number.divide(guess.pow(root-1)).subtract(guess)
						.divide(new BigInteger(root.toString()));
				nextGuess = guess.add(delta);
			} while (!nextGuess.equals(guess));
			
			System.out.println(guess + " (" + cnt + " tries)");
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
