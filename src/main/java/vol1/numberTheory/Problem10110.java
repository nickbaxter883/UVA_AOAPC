//Light More Light
package vol1.numberTheory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10110 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/numberTheory/Problem10110");
		
		while (true) {
			long n = Long.parseLong(br.readLine());
			if (n == 0) {
				break;
			}
			
			/*boolean changed = true;
			int exp = 0;
			
			while (n%2 == 0) {
				n /= 2;
				exp++;
			}
			if (exp%2 == 1) {
				System.out.println("no");
				continue;
			}
			
			for (long i=3; i<=n; i+=2) {
				exp = 0;
				while (n%i == 0) {
					n /= i;
					exp++;
				}
				
				if (exp%2 == 1) {
					changed = false;
					break;
				}
			}*/
			
			if (Math.pow((int)Math.sqrt(n), 2) == n) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
	
	private static BufferedReader getBufferedReader(String[] args, String path) throws Exception {
		Reader stdin;
		if (args.length == 1) {
			stdin = new FileReader(args[0] + path);
		}
		else {
			stdin = new InputStreamReader(System.in);
		}
		
		return new BufferedReader(stdin);
	}
}
