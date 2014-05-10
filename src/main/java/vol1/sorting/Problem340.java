//Master Mind Hints
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem340 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = getBufferedReader(args, "/input/vol1/sorting/Problem340");
		
		int counter = 1;
		while (Integer.parseInt(br.readLine()) != 0) {
			System.out.println("Game " + counter + ":");
			counter++;
			processGame(br);
		}
	}

	private static void processGame(BufferedReader br) throws Exception
	{
		String answer = br.readLine().replace(" ",  "");
		while (true) {
			String guess = br.readLine().replace(" ",  "");
			if (guess.contains("0"))
				break;
			processGuess(guess.toCharArray(), answer.toCharArray());
		}
	}
	
	private static void processGuess(char[] test, char[] reference)
	{
		int strong = 0;
		for (int iterateIndex=0; iterateIndex<test.length; iterateIndex++) {
			char findChar = test[iterateIndex];
			if (findChar == reference[iterateIndex]) {
				test[iterateIndex] = '-';
				reference[iterateIndex] = '-';
				strong++;
			}
		}
		
		int weak = 0;
		for (int iterateIndex=0; iterateIndex<test.length; iterateIndex++) {
			if (test[iterateIndex] == '-')
				continue;

			for (int searchIndex=0; searchIndex<reference.length; searchIndex++) {
				if (reference[searchIndex] == '-')
					continue;
				
				if (test[iterateIndex] == reference[searchIndex]) {
					test[iterateIndex] = '-';
					reference[searchIndex] = '-';
					weak++;
				}
			}
		}
		
		System.out.println("    (" + strong + "," + weak + ")");
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
