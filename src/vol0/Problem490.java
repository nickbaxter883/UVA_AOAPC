//Rotating Sentences
package vol0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Problem490 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol0/Problem490");
		ArrayList<String> sentences = new ArrayList<String>();
		String line;
		int maxLine = 0;
		while ((line = br.readLine()) != null) {
			sentences.add(line);
			if (maxLine < line.length()) {
				maxLine = line.length();
			}
		}
		
		for (int i=0; i<maxLine; i++) {
			for (int j=sentences.size()-1; j>=0; j--) {
				if (sentences.get(j).length()-1 < i) {
					System.out.print(" ");
				}
				else {
					System.out.print(sentences.get(j).charAt(i));
				}
			}
			System.out.println();
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
