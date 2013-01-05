//Triangle Wave
package vol0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem488 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol0/Problem488");
		
		int numWaves = Integer.parseInt(br.readLine());
		for (int wave=1; wave<=numWaves; wave++) {
			br.readLine();
			int amplitude = Integer.parseInt(br.readLine());
			int frequency = Integer.parseInt(br.readLine());
			
			//Store wave pattern in a string for performance
			String waveForm = "";
			for (int i=1; i<=amplitude; i++) {
				for (int k=0; k<i; k++) {
					waveForm += i;
				}
				if (amplitude > 1) {
					waveForm += '\n';
				}
			}
			for (int i=amplitude-1; i>0; i--) {
				for (int k=0; k<i; k++) {
					waveForm += i;
				}
				if (i != 1) {
					waveForm += '\n';
				}
			}
			
			//Print that wave pattern several times
			for (int i=1; i<=frequency; i++) {
				if (i != 1) {
					System.out.println("\n");
				}
				System.out.print(waveForm);
			}
			
			System.out.println();
			if (wave != numWaves) {
				System.out.println();
			}
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
