//Expressions
package unsolved;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem11234 {
	private static BufferedReader br;
	private static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;
		
		public Node (T data, Node<T> left, Node<T> right) {
			this.left = left;
			this.data = data;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol2/lists/Problem11234");
		
		int numExpressions = Integer.parseInt(br.readLine());
		for (int i=0; i<numExpressions; i++) {
			String expression = br.readLine();
			Stack<Node<Character>> stack = new Stack<Node<Character>>();
			
			for (char symbol : expression.toCharArray()) {
				if (Character.isLowerCase(symbol)) {
					stack.push(new Node<Character>(symbol, null, null));
				}
				else {
					Node<Character> b = stack.pop();
					Node<Character> a = stack.pop();
					
					stack.push(new Node<Character>(symbol, a, b));
				}
			}
			
			Queue<Node<Character>> nodes = new LinkedList<Node<Character>>();
			nodes.add(stack.peek());
			String result = "";
			
			while (!nodes.isEmpty()) {
				Node<Character> next = nodes.remove();
				result = next.data + result;
				
				if (next.left != null) {
					nodes.add(next.left);
				}
				if (next.right != null) {
					nodes.add(next.right);
				}
			}
			
			System.out.println(result);
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
