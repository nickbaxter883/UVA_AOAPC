//Just the Facts
package vol1.numberTheory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Problem568 {
	static BufferedReader br;
		
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/numberTheory/Problem568");
		String line;
		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			
			ArrayList<Integer> factors = new ArrayList<Integer>(n+1);
			for (int i=0; i<=n; i++) {
				factors.add(i);
			}
			
			int fivepower=5;
			int twopower = 2;
			while (fivepower <= n) {
				for (int i=1; i*fivepower <=n; i++) {
					factors.set(i*twopower, factors.get(i*twopower)/2);
					factors.set(i*fivepower, factors.get(i*fivepower)/5);
				}
				twopower *= 2;
				fivepower *= 5;
			}
			
			int remainder = 1;
			for (int i=1; i<=n; i++) {
				factors.set(i, factors.get(i) % 10);
				remainder = remainder*factors.get(i) % 10;
				//System.out.print(factors.get(i) + " ");
			}
			
			//System.out.println();
			System.out.printf("%5d -> %d\n", n, remainder);
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
