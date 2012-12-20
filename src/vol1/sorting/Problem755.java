//487--3279
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.TreeMap;

public class Problem755 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/sorting/Problem755");
		
		int numDataSets = Integer.parseInt(br.readLine());
		br.readLine();
		for (int dataSet=0; dataSet<numDataSets; dataSet++) {
			int numEntries = Integer.parseInt(br.readLine());
			TreeMap<String, Integer> numberCounts = new TreeMap<String, Integer>();
			
			for (int entry=0; entry<numEntries; entry++) {
				String phoneNumber = standardize(br.readLine());
				if (numberCounts.containsKey(phoneNumber))
					numberCounts.put(phoneNumber, numberCounts.get(phoneNumber) + 1);
				else
					numberCounts.put(phoneNumber, 1);
			}
			
			boolean noDuplicates = true;
			for (String number : numberCounts.keySet()) {
				if (numberCounts.get(number) == 1)
					continue;
				
				noDuplicates = false;
				System.out.println(number.substring(0, 3) + "-" +
					number.substring(3) + " " + numberCounts.get(number));
			}
			if (noDuplicates)
				System.out.println("No duplicates.");
			
			br.readLine();
			if (dataSet != numDataSets-1)
				System.out.println();
		}
	}
	
	private static String standardize(String number) {
		StringBuilder builder = new StringBuilder();
		for (int i=0; i<number.length(); i++) {
			switch (number.charAt(i)) {
			case '-':
				break;
			case 'A': case 'B': case 'C':
				builder.append(2);
				break;
			case 'D': case 'E': case 'F':
				builder.append(3);
				break;
			case 'G': case 'H': case 'I':
				builder.append(4);
				break;
			case 'J': case 'K': case 'L':
				builder.append(5);
				break;
			case 'M': case 'N': case 'O':
				builder.append(6);
				break;
			case 'P': case 'R': case 'S':
				builder.append(7);
				break;
			case 'T': case 'U': case 'V':
				builder.append(8);
				break;
			case 'W': case 'X': case 'Y':
				builder.append(9);
				break;
			default:
				builder.append(number.charAt(i));
			}
		}
		return builder.toString();
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
