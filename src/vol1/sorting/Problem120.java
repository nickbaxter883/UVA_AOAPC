//Stacks of Flapjacks
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
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
			Stack<Integer> pancakeStack = new Stack<Integer>();
			while (sc.hasNextInt())
				pancakeStack.push(sc.nextInt());
			
			System.out.println(pancakeData);
			System.out.println(pancakeStack.toString());
			flip(pancakeStack, 0);
			System.out.println(pancakeStack.toString());
		}
	}
	
	private static void flip(Stack<Integer> stack, int pos) throws Exception {
		if (pos < 0 || pos > stack.size())
			throw new Exception();
		
		System.out.println(stack.size());
		LinkedList<Integer> queue = new LinkedList<Integer>(); 
		for (int i=0; i<stack.size()-pos; i++) {
			queue.add(stack.pop());
		}
		System.out.println("-> " + stack.toString());
		System.out.println("-> " + queue.toString());
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
