package vol1.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem401 {
	public static void main(String[] args) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + "/input/vol1/String/Problem401");
		else
			stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);
		
		String line = "";
		while ((line = br.readLine()) != null) {
			boolean isPalindrome = checkPalindrome(line);
			boolean isMirror = checkMirror(line);
			
			if (isPalindrome && isMirror)
				System.out.println(line + " -- is a mirrored palindrome.");
			else if (isPalindrome)
				System.out.println(line + " -- is a regular palindrome.");
			else if (isMirror)
				System.out.println(line + " -- is a mirror.");
			else
				System.out.println(line + " -- is not a palindrome.");
			System.out.println();
		}
	}
	
	private static boolean checkPalindrome(String line) {
		for (int i=0; i<line.length()/2-1; i++) {
			char ch1 = line.charAt(i);
			
			char ch2 = line.charAt(line.length()-i-1);
			if (ch1 != ch2)
				return false;
		}
		return true;
	}
	
	private static boolean checkMirror(String line) {
		for (int i=0; i<line.length()/2-1; i++) {
			char ch1 = line.charAt(i);
			char ch2 = line.charAt(line.length()-i-1);
			
			switch (ch1) {
			case 'B': case 'C': case 'D': case 'F': case 'G':
			case 'K': case 'N': case 'P': case 'Q': case 'R':
			case '4': case '6': case '7': case '9':
				return false;
			case 'A': case 'H': case 'I': case 'M': case 'O':
			case 'T': case 'U': case 'V': case 'W': case 'X':
			case 'Y': case '1': case '8':
				if (ch2 != ch1)
					return false;
				break;
			case 'E':
				if (ch2 != '3')
					return false;
				break;
			case '3':
				if (ch2 != 'E')
					return false;
				break;
			case 'J':
				if (ch2 != 'L')
					return false;
				break;
			case 'L':
				if (ch2 != 'J')
					return false;
				break;
			case 'S':
				if (ch2 != '2')
					return false;
				break;
			case '2':
				if (ch2 != 'S')
					return false;
				break;
			case 'Z':
				if (ch2 != '5')
					return false;
				break;
			case '5':
				if (ch2 != 'Z')
					return false;
				break;
			}
		}
		return true;
	}
}
