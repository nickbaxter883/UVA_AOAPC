//Palindromes
package vol1.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem401 {
	public static void main(String[] args) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + "/input/vol1/string/Problem401");
		else
			stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);
		
		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.trim();
			boolean isPalindrome = checkPalindrome(line);
			boolean isMirror = checkMirror(line);
			
			if (isPalindrome && isMirror)
				System.out.println(line + " -- is a mirrored palindrome.");
			else if (isPalindrome)
				System.out.println(line + " -- is a regular palindrome.");
			else if (isMirror)
				System.out.println(line + " -- is a mirrored string.");
			else
				System.out.println(line + " -- is not a palindrome.");
			System.out.println();
		}
	}
	
	private static boolean checkPalindrome(String line) {
		for (int i=0; i<line.length()/2; i++) {
			char ch1 = line.charAt(i);
			char ch2 = line.charAt(line.length()-i-1);
			if (ch1 != ch2)
				return false;
		}
		return true;
	}
	
	private static boolean checkMirror(String line) {
		for (int i=0; i<line.length()/2; i++) {
			char ch1 = line.charAt(i);
			char ch2 = line.charAt(line.length()-i-1);
			
			if (!hasInverse(ch1))
				return false;
			if (isSymmetric(ch1)) {
				if (ch2 != ch1)
					return false;
			}
			else if (!isPair(ch1, ch2))
				return false;
		}
		
		//Check the center character of an odd length pattern
		if (line.length()%2 == 1) {
			char center = line.charAt(line.length()/2);
			if (!isSymmetric(center))
				return false;
		}
		
		return true;
	}
	
	private static boolean hasInverse(char ch) {
		switch(ch) {
		case 'B': case 'C': case 'D': case 'F': case 'G':
		case 'K': case 'N': case 'P': case 'Q': case 'R':
		case '4': case '6': case '7': case '9':
			return false;
		}
		return true;
	}
	
	private static boolean isSymmetric(char ch) {
		switch (ch) {
		case 'A': case 'H': case 'I': case 'M': case 'O':
		case 'T': case 'U': case 'V': case 'W': case 'X':
		case 'Y': case '1': case '8':
			return true;
		}
		return false;
	}
	
	private static boolean isPair(char ch1, char ch2) {
		switch(ch1) {
		case 'E':
			if (ch2 == '3')
				return true;
			break;
		case '3':
			if (ch2 == 'E')
				return true;
			break;
		case 'J':
			if (ch2 == 'L')
				return true;
			break;
		case 'L':
			if (ch2 == 'J')
				return true;
			break;
		case 'S':
			if (ch2 == '2')
				return true;
			break;
		case '2':
			if (ch2 == 'S')
				return true;
			break;
		case 'Z':
			if (ch2 == '5')
				return true;
			break;
		case '5':
			if (ch2 == 'Z')
				return true;
			break;
		default:
			return false;
		}
		return false;
	}
}
