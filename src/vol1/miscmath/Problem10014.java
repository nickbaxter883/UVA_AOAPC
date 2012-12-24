//Simple Calculations
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Problem10014 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem10014");
		int testCases = Integer.parseInt(br.readLine());
		br.readLine();
		
		for (int test=0; test<testCases; test++) {
			int n = Integer.parseInt(br.readLine());
			double a0 = Double.parseDouble(br.readLine());
			double aNp1 = Double.parseDouble(br.readLine());
			
			ArrayList<Double> c = new ArrayList<Double>();
			for (int i=0; i<n; i++)
				c.add(Double.parseDouble(br.readLine()));
			br.readLine();
			
			System.out.printf("%.2f\n", computeA1(a0, aNp1, c));
			if (test != testCases-1)
				System.out.println();
		}
	}
	
	private static double computeA1 (double a0, double aNp1, ArrayList<Double> c) {
		double sum = 0;
		int n = c.size();
		
		for (int i=0; i<n; i++)
			sum += (n-i)*c.get(i);
		
		return (aNp1 + n*a0 - 2*sum) / (n+1);
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
