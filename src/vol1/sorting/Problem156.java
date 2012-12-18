//AnAnagrams
package vol1.sorting;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Problem156 {
	static Scanner sc;
	
	public static void main(String[] args) throws Exception {
		sc = getScanner(args, "/input/vol1/sorting/Problem156");
		
		ArrayList<String> domain = new ArrayList<String>();
		HashMap<String, Boolean> anagram = new HashMap<String, Boolean>();
		String word;
		
		while ((word = sc.next()).compareTo("#") != 0) {
			domain.add(word);
		}
		Collections.sort(domain);
		
		for (String s : domain) {
			String reduced = getReduced(s);
			if (anagram.containsKey(reduced))
				anagram.put(reduced, true);
			else
				anagram.put(reduced, false);
		}
		for (String s : domain) {
			String reduced = getReduced(s);
			if (anagram.get(reduced) == false)
				System.out.println(s);
		}
	}
	
	private static String getReduced(String str) {
		char[] letters = str.toLowerCase().toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}
	
	private static Scanner getScanner(String[] args, String path) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + path);
		else
			stdin = new InputStreamReader(System.in);
		
		return new Scanner(stdin);
	}
}
