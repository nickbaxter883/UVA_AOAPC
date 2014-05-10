//Automatic Editing
package vol1.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

public class Problem10115 {
	public static final boolean DEBUG = false;
	
	public static class Rule {
		String statement;
		String replacement;
		
		Rule (String statement, String replacement) {
			this.statement = statement;
			this.replacement = replacement;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + "/input/vol1/string/Problem10115");
		else
			stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);
		
		int numRules = 0;
		ArrayList<Rule> rules = new ArrayList<Rule>();
		while ((numRules = Integer.parseInt(br.readLine())) != 0) {
			for (int i=0; i<numRules; i++) {
				rules.add(new Rule(br.readLine(), br.readLine()));
			}
			
			String line = br.readLine();
			//System.out.println(line);
			
			Iterator<Rule> iter = rules.iterator();
			while (iter.hasNext()) {
				Rule nextRule = iter.next();
				while (line.contains(nextRule.statement)) {
					line = line.replaceFirst(nextRule.statement, nextRule.replacement);
					debug("\"" + nextRule.statement + "\" -> \"" +
							nextRule.replacement + "\"");
				}
			}
			System.out.println(line);
		}
	}
	
	public static void debug(String message) {
		if (DEBUG == true)
			System.out.println(message);
	}
}