//The Collatz Sequence
package vol0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem694 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol0/Problem694");
		int count = 1;
		
		while (true) {
			String[] numbers = br.readLine().trim().split("\\s+");
			long a = Integer.parseInt(numbers[0]);
			int limit = Integer.parseInt(numbers[1]);
			if (a <= 0) {
				break;
			}
			
			long savedA = a;
			int numTerms = 1;
			while (a != 1) {
				if (a % 2 == 0) {
					a /= 2;
				}
				else {
					a = a*3 + 1;
				}
				if (a > limit) {
					break;
				}
				numTerms++;
			}
			
			System.out.println("Case " + count + ": A = " + savedA +
					", limit = " + limit + ", number of terms = " + numTerms);
			count++;
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
