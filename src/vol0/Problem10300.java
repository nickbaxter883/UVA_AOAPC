//Ecological Premium
package vol0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10300 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol0/Problem10300");
		int testCases = Integer.parseInt(br.readLine());
		for (int i=1; i<=testCases; i++) {
			
			int sum = 0;
			int numFarmers = Integer.parseInt(br.readLine());
			for (int j=1; j<=numFarmers; j++) {
				
				String[] farmValues = br.readLine().trim().split("\\s+");
				int area = Integer.parseInt(farmValues[0]);
				int env = Integer.parseInt(farmValues[2]);
				
				sum += area*env;
			}
			System.out.println(sum);
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
