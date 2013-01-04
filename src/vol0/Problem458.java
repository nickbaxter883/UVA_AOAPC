//The Decoder
package vol0;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Problem458 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		//br = getBufferedReader(args, "/input/vol0/Problem458");
		DataInputStream in = new DataInputStream(System.in);
		DataOutputStream out = new DataOutputStream(System.out);

		try {
			while (true) {
				byte b = in.readByte();
				if (b == 10 || b == 13) {
					out.write((char)b);
				}
				else {
					out.write((char)(b-7));
				}
			}
		}
		catch (EOFException e) {
			out.flush();
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
