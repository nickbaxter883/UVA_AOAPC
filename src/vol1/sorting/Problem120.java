//Stacks of Flapjacks
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Problem120 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/sorting/Problem120");
		
		String pancakeData;
		while ((pancakeData = br.readLine()) != null) {
			Scanner sc = new Scanner(pancakeData);
			System.out.println(pancakeData);
			
			Stack<Integer> pancakeStack = new Stack<Integer>();
			ArrayList<Integer> sorted = new ArrayList<Integer>();
			
			while (sc.hasNextInt()) {
				int pancake = sc.nextInt();
				pancakeStack.push(pancake);
				sorted.add(pancake);
			}
			
			//Because problem reads top to bottom
			flip(pancakeStack, 0);
			Collections.sort(sorted);
			//Largest pancakes are on bottom
			Collections.reverse(sorted);
			
			for (int i=0; i<pancakeStack.size(); i++) {
				Integer goal = sorted.get(i);
				if (pancakeStack.get(i) != goal) {
					//Find a later occurance in stack
					int location = pancakeStack.lastIndexOf(goal);
					if (location != pancakeStack.size()-1) {
						//Flip it to end
						flip(pancakeStack, location);
						System.out.print((location+1) + " ");
					}
					
					//Flip it where its supposed to go
					flip(pancakeStack, i);
					System.out.print((i+1) + " ");
					//System.out.println(pancakeStack.toString());
				}
			}
			System.out.println(0);
		}
	}
	
	private static void flip(Stack<Integer> stack, int pos) throws Exception {
		if (pos < 0 || pos > stack.size())
			throw new Exception();
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int iterations = stack.size()-pos;
		for (int i=0; i<iterations; i++) {
			queue.add(stack.pop());
		}
		while (!queue.isEmpty()) {
			stack.push(queue.remove());
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
