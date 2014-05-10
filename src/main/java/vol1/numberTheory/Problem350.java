//Pseudo-Random Numbers
package vol1.numberTheory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Problem350 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/numberTheory/Problem350");
		
		int round = 1;
		while (true) {
			String[] pseudoGenerator = br.readLine().trim().split("\\s+");
			int Z = Integer.parseInt(pseudoGenerator[0]);
			int I = Integer.parseInt(pseudoGenerator[1]);
			int M = Integer.parseInt(pseudoGenerator[2]);
			int L = Integer.parseInt(pseudoGenerator[3]);
			if (M == 0) {
				break;
			}
			
			Map<Integer, Integer> sequence = new HashMap<Integer, Integer>();
			int cnt=0;
			while (!sequence.containsKey(L)) {
				sequence.put(L, cnt);
				L = (L*Z + I) % M;
				cnt++;
			}
			System.out.println("Case " + round + ": " + (cnt - sequence.get(L)));
			round++;
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
