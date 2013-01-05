//Linear Cellular Automata
package vol0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Problem457 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol0/Problem457");
		
		int testCases = Integer.parseInt(br.readLine());
		for (int t=1; t<=testCases; t++) {
			br.readLine();
			
			ArrayList<Integer> dna = new ArrayList<Integer>();
			String[] dnaStrands = br.readLine().trim().split("\\s+");
			for (String s : dnaStrands) {
				dna.add(Integer.parseInt(s));
			}
			
			int[] cultureDishes = new int[40];
			int[] nextDishes = new int[40];
			cultureDishes[19] = 1;
			printDishes(cultureDishes);
			
			for (int i=0; i<49; i++) {
				for (int j=0; j<cultureDishes.length; j++) {
					int k = cultureDishes[j];
					if (j != 0) {
						k += cultureDishes[j-1];
					}
					if (j != cultureDishes.length-1) {
						k += cultureDishes[j+1];
					}
					
					nextDishes[j] = dna.get(k);
				}
				cultureDishes = nextDishes.clone();
				printDishes(cultureDishes);
			}
			
			if (t != testCases) {
				System.out.println();
			}
		}
	}
	
	private static void printDishes(int[] dishes) {
		for (int i=0; i<dishes.length; i++) {
			switch(dishes[i]) {
			case 0:
				System.out.print(" ");
				break;
			case 1:
				System.out.print(".");
				break;
			case 2:
				System.out.print("x");
				break;
			case 3:
				System.out.print("W");
				break;
			}
		}
		System.out.println();
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
