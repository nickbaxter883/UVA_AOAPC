//Where's Waldorf
package vol1.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Problem10010 {
	static ArrayList<String> wordSearch;
	static String word;
	static int x, y;
	
	public static void main(String[] args) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + "/input/vol1/string/Problem10010");
		else
			stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);
		
		int numCases = Integer.parseInt(br.readLine());
				
		for (int n=0; n<numCases; n++) {
			br.readLine();
			
			//Grid dimensions
			String[] gridDimensions = br.readLine().split(" ");
			int gridLength = Integer.parseInt(gridDimensions[0]);
			int gridWidth = Integer.parseInt(gridDimensions[1]);
			
			//Grid content
			wordSearch = new ArrayList<String>(gridLength);
			for (int rowIndex=0; rowIndex<gridLength; rowIndex++)
				wordSearch.add(br.readLine());
			
			//Word list
			int numWords = Integer.parseInt(br.readLine());
			for (int wordIndex=0; wordIndex<numWords; wordIndex++) {
				word = br.readLine();
				
				outside:
				for (y=0; y<gridLength; y++) {
					for (x=0; x<gridWidth; x++) {
						//check first letter
						if (!(wordSearch.get(y).charAt(x)+"").equalsIgnoreCase(word.charAt(0)+""))
							continue;
						
						if (checkDirections()) {
							System.out.println((y+1) + " " + (x+1));
							break outside;
						}
					}
				}
			}
			if (n<numCases-1)
				System.out.println();
		}
	}
	
	private static boolean checkDirections() {
		//Determine bounds for safe array access and speed check
		boolean left = (x+1 >= word.length());
		boolean right = (x+word.length() <= wordSearch.get(0).length());
		boolean top = (y+1 >= word.length());
		boolean bottom = (y+word.length() <= wordSearch.size());
		
		if ((left && checkDir(-1, 0)) ||
			(left && top && checkDir(-1, -1)) ||
			(top && checkDir(0, -1)) ||
			(top && right && checkDir(1, -1)) ||
			(right && checkDir(1, 0)) ||
			(right && bottom && checkDir(1, 1)) ||
			(bottom && checkDir(0, 1)) ||
			(bottom && left && checkDir(-1, 1)))
			return true;
			
		return false;
	}

	private static boolean checkDir(int xMov, int yMov) {
		for (int i=1; i<word.length(); i++) {
			if (!(word.charAt(i)+"").equalsIgnoreCase(
					wordSearch.get(y+yMov*i).charAt(x+xMov*i)+""))
				return false;
		}
		return true;
	}
}
