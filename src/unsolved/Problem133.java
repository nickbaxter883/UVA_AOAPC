//The Dole Queue
package unsolved;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

public class Problem133 {
	private static BufferedReader br;
		
	public static void main(String[] args) throws Exception {
        System.out.println("Testing");
		br = getBufferedReader(args, "/input/vol2/lists/Problem133");
		String line;
		while (true) {
			line = br.readLine();
			String[] numbers = line.trim().split("\\s+");
			int n = Integer.parseInt(numbers[0]);
			int k = Integer.parseInt(numbers[1]);
			int m = Integer.parseInt(numbers[2]);
			if (n == 0) {
				break;
			}
			
			List<Integer> queue = new LinkedList<Integer>();
			for (int i=1; i<=n; i++) {
				queue.add(i);
			}
			
			int counterClockwise = (k-1) % queue.size();
			int clockwise = (queue.size() - (m%queue.size())) % queue.size();
			while (true) {
				System.out.printf("%3d", queue.remove(counterClockwise));
				if (queue.size() == 0) {
					break;
				}
				if (clockwise > counterClockwise || clockwise == queue.size()) {
					clockwise--;
				}
				if (counterClockwise == 0) {
					counterClockwise = queue.size()-1;
				}
				else {
					counterClockwise--;
				}
				
				if (clockwise != counterClockwise) {
					System.out.printf("%3d", queue.remove(clockwise));
					if (counterClockwise > clockwise) {
						if (counterClockwise == 0) {
							counterClockwise = queue.size()-1;
						}
						else {
							counterClockwise--;
						}
					}
				}
				if (queue.size() == 0) {
					break;
				}
				
				System.out.print(",");
				counterClockwise = (counterClockwise + k) % queue.size();
				clockwise = (clockwise + queue.size() - (m%queue.size())) % queue.size();
			}
			System.out.println();
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
