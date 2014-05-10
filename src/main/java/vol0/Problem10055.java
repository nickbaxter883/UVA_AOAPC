//Hashmat the Brave Warrior
package vol0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10055 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol0/Problem10055");
		String line;
		while ((line = br.readLine()) != null) {
			String[] armies = line.trim().split("\\s+");
			long a = Long.parseLong(armies[0]);
			long b = Long.parseLong(armies[1]);
			
			System.out.println(Math.abs(a - b));
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
