//List of Conquests
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.TreeMap;

public class Problem10420 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/sorting/Problem10420");
		
		@SuppressWarnings("unused")
		int numberCases = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> conquests = getAffairs();
		for (String s : conquests.keySet())
			System.out.println(s +  " " + conquests.get(s));
	}
	
	private static TreeMap<String, Integer> getAffairs() throws Exception {
		TreeMap<String, Integer> countryCounts = new TreeMap<String, Integer>();
		String affair;
		while ((affair = br.readLine()) != null) {
			String country = affair.substring(0, affair.indexOf(" "));
			if (countryCounts.containsKey(country)) {
				Integer occurances = countryCounts.get(country);
				countryCounts.put(country, occurances+1);
			}
			else {
				countryCounts.put(country, 1);
			}
		}
		return countryCounts;
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
