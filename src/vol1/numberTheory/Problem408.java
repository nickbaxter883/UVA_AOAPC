//Uniform Generator
package vol1.numberTheory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem408 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/numberTheory/Problem408");
		String line;
		while ((line = br.readLine()) != null) {
			String[] numbers = line.split("\\s+");
			int a = Integer.parseInt(numbers[0]);
			int b = Integer.parseInt(numbers[1]);
			
			System.out.printf("%10d%10d    ", a, b);
			if (gcd(a, b) == 1) {
				System.out.println("Good Choice");
			}
			else {
				System.out.println("Bad Choice");
			}
			System.out.println();
		}
	}
	
	private static int gcd (int a, int b) {
		int temp = a;
		a = Math.max(a, b);
		b = Math.min(temp, b);
		
		while (b != 0) {
			temp = b;
			b = a % b;
			a = temp;
		}
		return a;
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
