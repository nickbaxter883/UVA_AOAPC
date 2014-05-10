//Hartals
package vol2.lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10050 {
	private static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol2/lists/Problem10050");
		
		int numTestCases = Integer.parseInt(br.readLine());
		for (int testCase=1; testCase<=numTestCases; testCase++) {
			
			int numDays = Integer.parseInt(br.readLine());
			boolean[] hartals = new boolean[numDays];
			
			int numParties = Integer.parseInt(br.readLine());
			for (int party=1; party<=numParties; party++) {
				
				int hartalParam = Integer.parseInt(br.readLine());
				for (int partyStrike=hartalParam-1; partyStrike<numDays; partyStrike+=hartalParam) {
					hartals[partyStrike] = true;
				}
			}
			
			for (int fridays=5; fridays<numDays; fridays+=7) {
				hartals[fridays] = false;
			}
			for (int saturdays=6; saturdays<numDays; saturdays+=7) {
				hartals[saturdays] = false;
			}
			
			int numStrikes = 0;
			for (int day=0; day<numDays; day++) {
				if (hartals[day] == true) {
					numStrikes++;
				}
			}
			
			System.out.println(numStrikes);
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
