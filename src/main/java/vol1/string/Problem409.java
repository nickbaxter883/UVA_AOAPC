//Excuses Excuses
package vol1.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Problem409 {
	public static void main(String[] args) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + "/input/vol1/string/Problem409");
		else
			stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);
		
		int setNum = 0;
		int numKeywords, numExcuses;
		String line;
		
		while ((line = br.readLine()) != null) {
			setNum++;
			numKeywords = Integer.parseInt(line.substring(0, line.indexOf(" ")));
			numExcuses = Integer.parseInt(line.substring(line.indexOf(" ")+1));
			
			ArrayList<String> keywords = new ArrayList<String>();
			for (int i=1; i<=numKeywords; i++) {
				line = br.readLine();
				keywords.add(line);
			}
			
			int maxMatches = 0;
			Iterator<String> iter;
			ArrayList<String> worstExcuses = new ArrayList<String>();
			for (int i=1; i<=numExcuses; i++) {
				line = br.readLine();
				
				int numMatches = 0;
				iter = keywords.iterator();
				while (iter.hasNext()) {
					Pattern pattern = Pattern.compile("(^|[^a-zA-Z])" + iter.next() + "($|[^a-zA-Z])");
					Matcher matcher = pattern.matcher(line.toLowerCase());
					if (matcher.find()) {
						numMatches++;
						while (matcher.find(matcher.end()-1)) { numMatches++; }
					}
				}
				if (numMatches == maxMatches)
					worstExcuses.add(line);
				if (numMatches > maxMatches) {
					worstExcuses.clear();
					maxMatches = numMatches;
					worstExcuses.add(line);
				}
			}
						
			System.out.println("Excuse Set #" + setNum);
			iter = worstExcuses.iterator();
			while (iter.hasNext()) {
				System.out.println(iter.next());
			}
			System.out.println();
			//System.out.println("Matches " + maxMatches);
		}
	}
}
