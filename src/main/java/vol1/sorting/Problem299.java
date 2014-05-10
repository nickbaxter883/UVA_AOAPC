//Train Swapping
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem299 {
	private static Scanner reader;
	
	public static void main(String[] args) throws Exception {
		reader = (Scanner)getInput(1, args, "/input/vol1/sorting/Problem299");
		
		long numCases = reader.nextInt();
		for (long n=0; n<numCases; n++) {
			int numSwaps = 0;
			int length = reader.nextInt();
						
			ArrayList<Integer> trains = new ArrayList<Integer>();
			for (int i=0; i<length; i++)
				trains.add(reader.nextInt());
			
			for (int j=0; j<length; j++) {
				for (int i=0; i<length-1-j; i++) {
					if (trains.get(i) > trains.get(i+1)) {
						int temp = trains.get(i);
						trains.set(i,trains.get(i+1));
						trains.set(i+1, temp);
						numSwaps++;
					}
				}
			}
			//for (int t : trains)
				//System.out.print(t + " ");
			System.out.println("Optimal train swapping takes " + numSwaps + " swaps.");
		}
	}
	
	private static Object getInput(int type, String[] args, String path) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + path);
		else
			stdin = new InputStreamReader(System.in);
		
		switch (type) {
		case 0:
			return new BufferedReader(stdin);
		case 1:
			return new Scanner(stdin);
		default:
			throw new Exception();
		}
	}
}
