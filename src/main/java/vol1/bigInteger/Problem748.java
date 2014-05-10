//Exponentiation
package vol1.bigInteger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;

public class Problem748 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/bigInteger/Problem748");
		String line;
		while ((line = br.readLine()) != null) {
			String[] numbers = line.trim().split("\\s+");
			BigDecimal R = new BigDecimal(numbers[0]);
			int n = Integer.parseInt(numbers[1]);
			
			String answer = R.pow(n).toPlainString();
			if (answer.charAt(0) == '0') {
				answer = answer.substring(1);
			}
			int i = answer.length()-1;
			while (answer.charAt(i) == '0') {
				i--;	
			}
			answer = answer.substring(0, i+1);
			
			System.out.println(answer);
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
