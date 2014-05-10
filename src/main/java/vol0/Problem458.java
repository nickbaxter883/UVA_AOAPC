//The Decoder
package vol0;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;

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
}
