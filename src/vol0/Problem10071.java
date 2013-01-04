//Back to High School Physics
package vol0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10071 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol0/Problem10071");
		String line;
		while ((line = br.readLine()) != null) {
			String[] particleData = line.trim().split("\\s+");
			int v = Integer.parseInt(particleData[0]);
			int t = Integer.parseInt(particleData[1]);
			
			System.out.println(2*v*t);
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
