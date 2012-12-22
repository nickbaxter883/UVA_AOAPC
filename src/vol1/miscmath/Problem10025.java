//The ? 1 ? 2 ? ... ? n = k problem
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10025 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem10025");
		String line;
		
		int numNumbers = Integer.parseInt(br.readLine());
		br.readLine();
		for (int number=0; number<numNumbers; number++) {
			//Solution to negative case is symmetric to positive case
			int k = Math.abs(Integer.parseInt(br.readLine()));
			
			//k can be 0 which smallest sequence is 1+2-3 (special case)
			if (k == 0) {
				System.out.println(3);
			}
			else {
				/*
				 *n | possible k         | (n+1)/2 | n%2 + 1
				 *1 | 1                  | 1       | 2
				 *2 | 1 3                | 1       | 1
				 *3 | 0 2 4 6            | 2       | 2
				 *4 | 0 2 4 6 8 10       | 2       | 1
				 *5 | 1 3 5 7 9 11 13 15 | 3       | 2
				 *...
				 *
				 *The nth set (possible k) can be produced by adding or subtracting n
				 *	from any number in the (n-1)st set (*)
				 *As a result the largest sum produced by any n is triangular
				 *Given k find an n such that (n-1)n/2 < k < n(n+1)/2
				 *Rewritten as n-1 < 2k/n < n+1
				 *	substituting n=sqrt(2k) yields
				 *	sqrt(2k)-1 < sqrt(2k) < sqrt(2k)+1
				 *All possible numbers for a particular n
				 *	are either all odd or all even by (*) and
				 *	are the same evenness as (n+1)/2
				 *Thus if (n+1)/2 and k are not the same evenness then
				 *	n must be adjusted by n%2 + 1 in order to
				 *	reach the next set with matching evenness
				 */
				
				int n = (int)Math.round(Math.sqrt(2*k));
				//System.out.println("Guess is " + n);
				
				if ((n+1)/2 % 2 != k%2)
					n += (n%2 + 1);
				
				System.out.println(n);
			}
			
			if (number != numNumbers-1)
				System.out.println();
			br.readLine();
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
