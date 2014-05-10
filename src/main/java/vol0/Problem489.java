//Hangman Judge
package vol0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

public class Problem489 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol0/Problem489");
		nextRound:
		while (true) {
			int round = Integer.parseInt(br.readLine());
			if (round == -1) {
				break;
			}
			System.out.println("Round " + round);
			
			String answer = br.readLine();
			String guesses = br.readLine();
			
			int hits = 0;
			Set<Character> used = new HashSet<Character>();
			String blank = "";
			for (int i = 0; i < answer.length(); i++) {
				blank += '*';
			}
			
			for (char ch : guesses.toCharArray()) {
				if (answer.indexOf(ch) == -1 && !used.contains(ch)) {
					hits++;
					if (hits >= 7) {
						System.out.println("You lose.");
						continue nextRound;
					}
				}
				else {
					answer = answer.replace(ch, '*');
					if (answer.equals(blank)) {
						System.out.println("You win.");
						continue nextRound;
					}
				}
				used.add(ch);
			}

			System.out.println("You chickened out.");
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
