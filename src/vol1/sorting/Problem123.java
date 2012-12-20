//Searching Quickly
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem123 {
	static BufferedReader br; 
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/sorting/Problem123");
				
		ArrayList<String> ignoreList = new ArrayList<String>();
		ArrayList<String> titles = new ArrayList<String>();
		TreeMap<String, ArrayList<String>> kwicIndex =
				new TreeMap<String, ArrayList<String>>();
		
		String line;
		while ((line = br.readLine()).compareTo("::") != 0)
			ignoreList.add(line.trim());
		while ((line = br.readLine()) != null)
			titles.add(line.trim().toLowerCase());
		
		for (String title : titles) {
			Pattern pattern = Pattern.compile("\\w+");
			Matcher matcher = pattern.matcher(title);
			while (matcher.find()) {
				String word = matcher.group();
				if (ignoreList.contains(word))
					continue;
				
				//match is a keyword
				StringBuilder formatted = new StringBuilder(title);
				formatted.replace(matcher.start(), matcher.end(), word.toUpperCase());
				
				if (!kwicIndex.containsKey(word))
					kwicIndex.put(word, new ArrayList<String>());
				kwicIndex.get(word).add(formatted.toString());
				
				//System.out.println(formatted);
			}
		}
		for (String key : kwicIndex.keySet())
			for (String formatted : kwicIndex.get(key))
				System.out.println(formatted);
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
