//Immediate Decodability
package vol1.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Problem644 {
	public static void main(String[] args) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + "/input/vol1/string/Problem644");
		else
			stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);
		
		String line;
		int i = 1;
		ArrayList<String> codes = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			if (line.compareTo("9") != 0) {
				codes.add(line);
			}
			else {
				System.out.println("Set " + i + " is " + processCodes(codes));
				codes.clear();
				i++;
			}
		}
	}
	
	static String processCodes(ArrayList<String> codes) {
		Collections.sort(codes);
		Iterator<String> iter = codes.iterator();
		String prev = iter.next();
		while (iter.hasNext()) {
			String next = iter.next();
			if (next.startsWith(prev))
				return "not immediately decodable";
			prev = next;
			//System.out.println(iter.next());
		}
		return "immediately decodable";
	}
}
