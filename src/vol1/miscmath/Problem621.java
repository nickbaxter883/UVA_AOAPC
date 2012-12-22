//Secret Research
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem621 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem621");
		String line;
		int numExperiments = Integer.parseInt(br.readLine());
		for (int experiment=0; experiment<numExperiments; experiment++) {
			line = br.readLine();
			if (validRecord(line))
				System.out.println(checkRecord(line));
		}
	}
	
	private static boolean validRecord(String record) {
		while (true) {
			switch (checkRecord(record)) {
			case '+':
				return true;
			case '-':
				record = record.substring(0, record.length()-2);
				break;
			case '*':
				record = record.substring(1, record.length()-1);
				break;
			case '?':
				record = record.substring(3);
				break;
			case '!':
				return false;
			default:
				System.err.println("Invalid checkRecord state");	
			}
		}
	}
	private static char checkRecord(String record) {
		if (record.equals("1") || record.equals("4") || record.equals("78"))
			return '+';
		if (record.endsWith("35"))
			return '-';
		if (record.startsWith("9") && record.endsWith("4"))
			return '*';
		if (record.startsWith("190"))
			return '?';
		
		return '!';
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
