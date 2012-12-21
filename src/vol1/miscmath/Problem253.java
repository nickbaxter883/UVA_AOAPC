//Cube Painting
package vol1.miscmath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem253 {
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/miscmath/Problem253");
		String line;
		while ((line = br.readLine()) != null) {
			String depiction1 = line.substring(0, 6);
			String depiction2 = line.substring(6);
			//System.out.println(depiction1 + " vs " + depiction2);
			boolean isRotation = false;
			
			List<Character> cube1 = new ArrayList<Character>();
			List<Character> cube2 = new ArrayList<Character>();
			for (Character ch : depiction1.toCharArray())
				cube1.add(ch);
			for (Character ch : depiction2.toCharArray())
				cube2.add(ch);
			
			free:
			//Visit all faces
			for (char axis : "xyxyxy".toCharArray()) {
				//For each face visit all rotations
				for (int rotation=0; rotation<4; rotation++) {
					//System.out.println(cube1.toString());
					if (cube1.equals(cube2)) {
						isRotation = true;
						break free;
					}
					rotate(cube1, 'z', 1);
				}
				rotate(cube1, axis, 1);
			}
			
			if (isRotation)
				System.out.println("TRUE");
			else
				System.out.println("FALSE");
		}
	}
	
	private static List<Character> rotate (List<Character> cube, char axis, int times) {
		int[] permuteSet = {};
		switch (axis) {
		case 'x': permuteSet = new int[] { 0, 1, 5, 4 }; break;
		case 'y': permuteSet = new int[] { 0, 3, 5, 2 }; break;
		case 'z': permuteSet = new int[] { 1, 3, 4, 2 }; break;
		}
		
		List<Character> rotationList = new ArrayList<Character>();
		for (int face : permuteSet)
			rotationList.add(cube.get(face));
		
		Collections.rotate(rotationList, times);
		for (int i=0; i<4; i++)
			cube.set(permuteSet[i], rotationList.get(i));
		
		return cube;
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
