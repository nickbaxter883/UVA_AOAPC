//Skew Binary
package vol1.numberTheory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem575 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/numberTheory/Problem575");
		
		while (true) {
			String skewBinary = new StringBuilder(br.readLine()).reverse().toString();
			if (skewBinary.equals("0"))
				break;
						
			long total = 0;
			for(int i=0; i<skewBinary.length(); i++) {
				if (skewBinary.charAt(i) == '0')
					continue;
				
				//System.out.println(" " + ((1<<(i+1)) - 1));
				total += (skewBinary.charAt(i)-'0')*((1<<(i+1)) - 1);
			}
			System.out.println(total);
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
