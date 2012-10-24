//Cat in the Hat
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Problem107 {
	public static void main(String[] args) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + "/input/vol1/miscmath/Problem107");
		else
			stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);
		
		int k1, k2;
		int g, base, x, n;
		int notWorking, totalHeight;
		while (true) {
			String[] powers = br.readLine().split(" ");
			k2 = Integer.parseInt(powers[0]);
			k1 = Integer.parseInt(powers[1]);
			if(k1 == 0 && k2 == 0)
				break;
			if (k1 == 1 && k2 == 1) {
				x = 0;
				n = 0;
			}
			else {
				HashMap<Integer,Integer> k2pf = primeFactorization(k2);
				//System.out.println(k2pf.toString());
				
				//g is the largest possible exponent
				g = gcd(k2pf.values());
				//System.out.println(g);
				if (g == 1) {
					x = 1;
					n = k1;
				}
				else {
					base = (int)Math.pow(k2, 1/(double)g);
					//System.out.println(base + " ^ " + g);
					HashMap<Integer, Integer> gpf = primeFactorization(g);
					//System.out.println(gpf.toString());
					Iterator<Integer> iter = gpf.keySet().iterator();
					
					x = findExponent(base, g, k1, gpf, iter);
					n = (int)Math.pow(base, g/x)-1;
				}
			}
			
			if (n <= 1)
				notWorking = x;
			else
				notWorking = (k1-1)/(n-1);
			
			totalHeight = 0;
			for (int i=0; i<=x; i++)
				totalHeight += Math.pow(n, i)*Math.pow(n+1, x-i);
			
			//System.out.println("n="+n+" x="+x);
			System.out.println(notWorking + " " + totalHeight);
		}
	}

	private static int findExponent(int base, int exp, int goal,
			HashMap<Integer, Integer> exppf, Iterator<Integer> expIter) {
		int expBase = expIter.next();
		do {
			if (expIter.hasNext()) {
				int subresult = findExponent(base, exp, goal, exppf, expIter);
				if (subresult != -1)
					return subresult;
			}
			if (Math.pow(base-1, exp) == goal)
				return exp;	
			
			exp /= expBase;
			base = (int)Math.pow(base, expBase);
			exppf.put(expBase, exppf.get(expBase)-1);
			
		} while (exp%expBase == 0);
		
		if (Math.pow(base-1, exp) == goal)
			return exp;
		return -1;
	}

	private static int gcd(Collection<Integer> values) {
		if (values.size() == 1)
			return (Integer)values.toArray()[0];
		
		Iterator<Integer> iter = values.iterator();
		int smaller, larger, temp;
		smaller = iter.next();
		while (iter.hasNext()) {
			larger = iter.next();
			//swap correct order
			if (smaller > larger) {
				temp = larger;
				larger = smaller;
				smaller = temp;
			}
			//iterative modulus
			while ((temp = larger % smaller) != 0) {
				larger = smaller;
				smaller = temp;
			}
		}
		return smaller;
	}

	private static HashMap<Integer, Integer> primeFactorization(int num) {
		if (num <= 0)
			return null;
		
		HashMap<Integer,Integer> factors = new HashMap<Integer,Integer>();
		for (int i=2; i<=num/2;) {
			if (num%i == 0) {
				//increment exp
				if (factors.get(i) == null)
					factors.put(i, 1);
				else
					factors.put(i, factors.get(i)+1);
				
				//divide out and reset
				num /= i;
				i=2;
				continue;
			}
			i++;
		}
		//increment exp
		if (factors.get(num) == null)
			factors.put(num, 1);
		else
			factors.put(num, factors.get(num)+1);
		
		return factors;
	}
}
