//Ant on a Chessboard
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem10161 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem10161");
		int second;
		while ((second = Integer.parseInt(br.readLine())) != 0) {
			int rank = (int)Math.floor(Math.sqrt(second-1));
			int x = rank+1;
			int y = rank+1;
			int diagonal = rank*rank + rank + 1;
			int diff = Math.abs(second - diagonal);
			
			if (rank%2 == 0) {
				if (second > diagonal)
					x -= diff;
				else
					y -= diff;
			}
			else {
				if (second > diagonal)
					y -= diff;
				else
					x -= diff;
			}
			System.out.println(x + " " + y);
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
