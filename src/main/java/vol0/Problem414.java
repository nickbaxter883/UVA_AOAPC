//Machined Surfaces
package vol0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem414 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol0/Problem414");
		
		while (true) {
			int rows = Integer.parseInt(br.readLine());
			if (rows == 0) {
				break;
			}
			int totalSpace = 0;
			int minSpace = Integer.MAX_VALUE;
			for (int i=1; i<=rows; i++) {
				String line = br.readLine();
				int beginning = line.indexOf(" ");
				int ending = line.lastIndexOf(" ");
				int space;
				
				if (beginning == -1) {
					space = 0;
				}
				else {
					space = ending - beginning + 1;
				}
				
				totalSpace += space;
				if (minSpace > space) {
					minSpace = space;
				}
			}
			
			System.out.println(totalSpace - rows*minSpace);
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
