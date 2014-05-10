//Mad Numerologist
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem10785 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/sorting/Problem10785");
		String consonantList = "JSBKTCLDMVNWFXGPYHQZR";
		String vowelList = "AUEOI";
		
		int numSets = Integer.parseInt(br.readLine());
		for (int set=1; set<=numSets; set++) {
			int length = Integer.parseInt(br.readLine());
			int numConsonants = length>>1;
			int numVowels = length-numConsonants;
						
			ArrayList<Character> consonants = new ArrayList<Character>(numConsonants);
			ArrayList<Character> vowels = new ArrayList<Character>(numVowels);
			
			for (int index=0; index<numConsonants; index++)
				consonants.add(consonantList.charAt(index/5));
			for (int index=0; index<numVowels; index++)
				vowels.add(vowelList.charAt(index/21));
			
			//System.out.println(consonants);
			//System.out.println(vowels);
			
			Collections.sort(consonants);
			Collections.sort(vowels);
			
			StringBuilder luckyName = new StringBuilder();
			for (int index=0; index<length; index++) {
				if (index%2 == 0)
					luckyName.append(vowels.get(index/2));
				else
					luckyName.append(consonants.get(index/2));
			}
			System.out.println("Case " + set + ": " + luckyName);
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
