//Decode the tape
package vol1.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10878 {
	public static void main(String[] args) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + "/input/vol1/string/Problem10878");
		else
			stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);
		
		//Read the top edge
		br.readLine();
		String line;
		while ((line = br.readLine()).compareTo("___________") != 0) {
			//Chop unused characters
			line = line.substring(2, 6) + line.substring(7, line.length()-1);
			//Translate
			line = line.replace(" ", "0");
			line = line.replace("o", "1");
			//Decode
			char messageChar = (char)Integer.parseInt(line, 2);
			System.out.print(messageChar);
		}
	}
}
