//Where is the Marble
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem10474 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/sorting/Problem10474");
		
		int counter = 1;
		while (processGame(counter)) {
			counter++;
		}
	}
	
	private static Boolean processGame(int counter) throws Exception {
		String[] nq = br.readLine().split(" ");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		int n = Integer.parseInt(nq[0]);
		int q = Integer.parseInt(nq[1]);
		
		if (n == 0)
			return false;
		
		System.out.println("CASE# " + counter + ":");
		for (int i=0; i<n; i++) {
			numbers.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(numbers);
		for (int i=0; i<q; i++) {
			int find = Integer.parseInt(br.readLine());
			int location = Collections.binarySearch(numbers, find);
			if (location >= 0) {
				while (location > 0 &&
						numbers.get(location-1) == find) {
					location--;
				}
				System.out.println(find + " found at " + (location+1));
			}
			else
				System.out.println(find + " not found");
		}
		return true;
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
