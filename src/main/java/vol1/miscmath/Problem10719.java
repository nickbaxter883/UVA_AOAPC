//Quotient Polynomial
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Problem10719 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem10719");
		
		String kString;
		while ((kString = br.readLine()) != null) {
			
			ArrayList<Integer> quotient = new ArrayList<Integer>();
			int remainder = 0;
			int k = Integer.parseInt(kString);
			
			String[] poly = br.readLine().trim().split("\\s+");
			for (String coeff : poly) {
				int nextCoeff = Integer.parseInt(coeff);
				
				remainder = nextCoeff + remainder*k;
				quotient.add(remainder);
			}
			
			System.out.print("q(x):");
			for (int i=0; i<quotient.size()-1; i++)
				System.out.print(" " + quotient.get(i));
			
			System.out.println();
			System.out.println("r = " + remainder);
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
