//How Many Zeros and How Many Digits?
package vol1.numberTheory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Problem10061 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/numberTheory/Problem10061");
		String line;
		while ((line = br.readLine()) != null) {
			String[] numbers = line.trim().split("\\s+");
			int n = Integer.parseInt(numbers[0]);
			int base = Integer.parseInt(numbers[1]);
			
			double product = 1;
			int length = 1;
			for (int i=2; i<=n; i++) {
				product *= i;
				while (product >= base) {
					product /= base;
					length++;
				}
			}
			
			int numZeros = Integer.MAX_VALUE;
			Map<Integer, Integer> pf = primeFactorization(base);
			for (Integer prime : pf.keySet()) {
				int numFactorialFactors = getNumFactors(n, prime);
				int numPrimeComponents = numFactorialFactors / pf.get(prime);
				if (numPrimeComponents < numZeros) {
					numZeros = numPrimeComponents;
				}
				//System.out.println("There are " + numFactorialFactors + " factors of " + prime);
			}
			System.out.println(numZeros + " " + length);
		}
	}
	
	private static int getNumFactors(int n, int x) {
		int power = x;
		int count = 0;
		while (power <= n) {
			count += n / power;
			power *= x;
		}
		return count;
	}
	
	private static Map<Integer, Integer> primeFactorization(int number) {
		Map<Integer, Integer> pf = new HashMap<Integer, Integer>();
		
		for (int i=2; i<=number/2; i++) {
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
