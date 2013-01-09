//Matrix Chain Multiplication
package vol2.lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Stack;

public class Problem442 {
	private static BufferedReader br;
	public static class Matrix {
		int rows, cols;
		
		public Matrix(int rows, int cols) {
			this.rows = rows;
			this.cols = cols;
		}
	}
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol2/lists/Problem442");
		String line;
		
		int numMatrices = Integer.parseInt(br.readLine());
		HashMap<Character, Matrix> matrices = new HashMap<Character, Matrix>();
		for (int i=1; i<=numMatrices; i++) {
			line = br.readLine();
			String[] matrix = line.trim().split("\\s+");
			matrices.put(matrix[0].charAt(0),
				new Matrix(Integer.parseInt(matrix[1]), Integer.parseInt(matrix[2])));
		}
		
		outer:
		while ((line = br.readLine()) != null) {
			Stack<Matrix> expression = new Stack<Matrix>();
			int i = 0;
			int totalMultiplications = 0;
			
			while (i < line.length()) {	
				char currentChar = line.charAt(i);
				
				if (currentChar == ')') {
					
					Matrix m2 = expression.pop();
					Matrix m1 = expression.pop();
					if (m1.cols != m2.rows) {
						System.out.println("error");
						continue outer;
					}
					
					totalMultiplications += m1.rows * m1.cols * m2.cols;
					expression.push(new Matrix(m1.rows, m2.cols));
				}
				else if (currentChar != '(') {
					expression.push(matrices.get(currentChar));
				}
				
				i++;
			}
			
			System.out.println(totalMultiplications);
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
