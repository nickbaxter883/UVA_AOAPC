//Code Refactoring
package vol1.numberTheory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Problem10879 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/numberTheory/Problem10879");
		int numCases = Integer.parseInt(br.readLine());
		for (int i=1; i<=numCases; i++) {
			long n = Long.parseLong(br.readLine());
			Map<Long, Integer> pf = primeFactorization(n);
			Iterator<Long> iter = pf.keySet().iterator();
			long m1 = iter.next();
			long m2;
			if (pf.get(m1) > 1) {
				m2 = m1*m1;
			}
			else {
				m2 = iter.next();
			}
			
			System.out.println("Case #" + i + ": " + n + " = " + m1 + " * " + (n/m1) + " = " + m2 + " * " + (n/m2));
		}
	}
	
	private static Map<Long, Integer> primeFactorization(long number) {
		Map<Long, Integer> pf = new TreeMap<Long, Integer>();
		
		for (long i=2; i<=Math.sqrt(number); i++) {
			while (number%i == 0) {
				//System.out.println(number);
				number /= i;
				if (pf.containsKey(i)) {
					pf.put(i, pf.get(i)+1);
				}
				else {
					pf.put(i, 1);
				}
			}
		}
		if (number != 1) {
			pf.put(number, 1);
		}
		return pf;
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
