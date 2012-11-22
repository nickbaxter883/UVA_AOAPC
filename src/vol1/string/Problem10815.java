//Andys first dictionary
package vol1.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem10815 {
	public static void main(String[] args) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + "/input/vol1/string/Problem10815");
		else
			stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);
		
		String line;
		TreeSet<String> dictionary = new TreeSet<String>();
		while ((line = br.readLine()) != null) {
			Pattern pattern = Pattern.compile("[a-zA-Z]+");
			Matcher matcher = pattern.matcher(line);
			while (matcher.find())
				dictionary.add(matcher.group().toLowerCase());
		}
		
		Iterator<String> iter = dictionary.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
	}
}
