//Box of Bricks
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Problem591 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem591");
		int set = 1;
		while (true) {
			int numStacks = Integer.parseInt(br.readLine());
			if (numStacks == 0)
				break;
			
			String[] stacks = br.readLine().trim().split("\\s+");
			ArrayList<Integer> stackHeights = new ArrayList<Integer>();
			for (String stack : stacks)
				stackHeights.add(Integer.parseInt(stack));
			
			int total = 0;
			for (Integer height : stackHeights)
				total += height;
			int average = total/numStacks;
			
			int moved = 0;
			for (Integer height : stackHeights)
				if (height > average)
					moved += (height - average);
			
			//if (set != 1)
				//System.out.println();
			System.out.println("Set #" + set);
			System.out.println("The minimum number of moves is " + moved + ".");
			System.out.println();
			set++;
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
