//Marvelous Mazes
package vol0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem445 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol0/Problem445");
		String mazeInstr;
		while ((mazeInstr = br.readLine()) != null) {
					
			int count = 0;
			for (char sprite : mazeInstr.toCharArray()) {
				if (sprite == '!') {
					System.out.println();
				}
				else if (sprite >= '0' && sprite <= '9') {
					count += sprite-'0';
				}
				else {
					for (int i=0; i<count; i++) {
						if (sprite == 'b') {
							System.out.print(" ");
						}
						else {
							System.out.print(sprite);
						}
					}
					count = 0;
				}
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
