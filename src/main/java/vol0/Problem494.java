//Kindergarten Counting Game
package vol0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem494 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol0/Problem494");
		String line;
		while ((line = br.readLine()) != null) {
			Pattern wordPattern = Pattern.compile("[a-zA-Z]+");
			Matcher wordSearcher = wordPattern.matcher(line);
			int count = 0;
			
			while (wordSearcher.find()) {
				count++;
			}
			System.out.println(count);
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
