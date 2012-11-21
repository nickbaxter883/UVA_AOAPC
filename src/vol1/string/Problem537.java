//Artificial Intelligence?
package vol1.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem537 {
	
	public static void main(String[] args) throws Exception{
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + "/input/vol1/string/Problem537");
		else
			stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);
		
		String line, equation;
		Matcher matcher;
		Pattern pattern = Pattern.compile("([IUP])=([0-9]+(\\.[0-9]+)?)[mkM]?([AVW])");
		int numCases = Integer.parseInt(br.readLine());
		for (int i=1; i<=numCases; i++) {
			line = br.readLine();
			matcher = pattern.matcher(line);
			
			matcher.find();
			equation = matcher.group(0);
			char concept1 = matcher.group(1).charAt(0);
			double value1 = Double.parseDouble(matcher.group(2));
				if (equation.contains("m"))
					value1 /= 1000;
				else if (equation.contains("k"))
					value1 *= 1000;
				else if (equation.contains("M"))
					value1 *= 1000000;
			
			matcher.find();
			equation = matcher.group(0);
			char concept2 = matcher.group(1).charAt(0);
			double value2 = Double.parseDouble(matcher.group(2));
				if (equation.contains("m"))
					value2 /= 1000;
				else if (equation.contains("k"))
					value2 *= 1000;
				else if (equation.contains("M"))
					value2 *= 1000000;
			
			double answer = 0.0;
			char lval = ' ', unit = ' ';
			if ((concept1 == 'I' && concept2 == 'U') ||
				(concept1 == 'U' && concept2 == 'I')) {
				lval = 'P';
				unit = 'W';
				answer = value1 * value2;
			}
			if (concept1 == 'P' && concept2 == 'I') {
				lval = 'U';
				unit = 'V';
				answer = value1 / value2;
			}
			if (concept1 == 'P' && concept2 == 'U') {
				lval = 'I';
				unit = 'A';
				answer = value1 / value2;
			}
			if (concept1 == 'I' && concept2 == 'P') {
				lval = 'U';
				unit = 'V';
				answer = value2 / value1;
			}
			if (concept1 == 'U' && concept2 == 'P') {
				lval = 'I';
				unit = 'A';
				answer = value2 / value1;
			}
			
			System.out.println("Problem #" + i);
			System.out.printf("%c=%.2f%c\n", lval, answer, unit);
			
			//if (i != numCases)
				System.out.println();
		}
	}
}
