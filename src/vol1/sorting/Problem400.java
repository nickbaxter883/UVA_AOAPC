//Unix ls
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem400 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/sorting/Problem400");
		
		String line;
		final int terminalWidth = 60;
		
		while ((line = br.readLine()) != null) {
			int numNames = Integer.parseInt(line);
			int maxLength = 0;
			
			ArrayList<String> names = new ArrayList<String>();
			for (int n=0; n<numNames; n++) {
				line = br.readLine();
				names.add(line);
				if (line.length() > maxLength)
					maxLength = line.length();
			}
			Collections.sort(names);
			
			int numColumns = (terminalWidth-maxLength) / (maxLength+2) + 1;
			int remainingSpace = (terminalWidth-maxLength) % (maxLength+2);
			int numRows = names.size() / numColumns;
			if (names.size() % numColumns != 0)
				numRows++;
			
			for (int i=0; i<terminalWidth; i++)
				System.out.print("-");
			System.out.println();
			
			for (int row=0; row<numRows; row++) {
				for (int col=0; col<numColumns; col++) {
					int index = col*numRows + row;
					
					String name = "";
					if (index < names.size()) {
						name = names.get(index);
						System.out.print(name);
					}
					
					int spaces = (maxLength - name.length()) +
							((col == numColumns-1) ? remainingSpace : 2);
					for (int i=0; i<spaces; i++)
						System.out.print(" ");
				}
				System.out.println();
			}
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
