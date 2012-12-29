//Factoring Large Numbers
package vol1.numberTheory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.TreeMap;

public class Problem10392 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/numberTheory/Problem10392");
		
		while (true) {
			String line = br.readLine();
			long number = Long.parseLong(line);
			if (number < 0) {
				break;
			}
			
			Map<Long, Integer> pf = primeFactorization(number);
			for (long prime : pf.keySet()) {
				for (int i=0; i<pf.get(prime); i++) {
					System.out.println("    " + prime);
				}
			}
			System.out.println();
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
