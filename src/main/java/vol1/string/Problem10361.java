//Automatic Poetry
package vol1.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10361 {

	public static void main(String[] args) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + "/input/vol1/string/Problem10361");
		else
			stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);
		
		int numCases = Integer.parseInt(br.readLine());
		for (int i=0; i<numCases; i++) {
			String line1 = br.readLine();
			String piece1 = line1.substring(0, line1.indexOf('<'));
			String piece2 = line1.substring(line1.indexOf('<')+1, line1.indexOf('>'));
			String piece3 = line1.substring(line1.indexOf('>')+1, line1.lastIndexOf('<'));
			String piece4 = line1.substring(line1.lastIndexOf('<')+1, line1.lastIndexOf('>'));
			String piece5 = line1.substring(line1.lastIndexOf('>')+1);

			System.out.println(piece1+piece2+piece3+piece4+piece5);
			
			String line2 = br.readLine();
			System.out.println(line2.substring(0, line2.length()-3) +
				piece4 + piece3 + piece2 + piece5);
		}
	}
}
