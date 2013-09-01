package code.evernote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CircularBuffer {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// getting inputs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// No. of inputs
		int N = Integer.parseInt(br.readLine());
		String circularBuffer[] = new String[N];
		Arrays.fill(circularBuffer, "");
		String input = br.readLine();
		int addIndex = 0, removeIndex = 0;
		int[] priority = new int[N];
		int count = 0;
		while (!input.equals("Q")) {
			String[] strs = input.split(" ");
			if (strs[0].equals("A")) {
				int loopN = Integer.parseInt(strs[1]);
				for (int i = 0; i < loopN; i++) {
					addIndex = addIndex % N;
					circularBuffer[addIndex] = br.readLine();
					int curPriority = priority[removeIndex % N];
					priority[addIndex] = count++;
					if (curPriority < priority[removeIndex % N])
						removeIndex++;
					addIndex++;
				}
			} else if (strs[0].equals("R")) {
				int loopN = Integer.parseInt(strs[1]);
				for (int i = 0; i < loopN; i++) {
					removeIndex = removeIndex % N;
					circularBuffer[removeIndex] = "";
					removeIndex++;
				}
			} else if (strs[0].equals("L")) {
				for (int i = 0, j = removeIndex; i < N; i++) {
					if (circularBuffer[j % N].equals(""))
						break;
					System.out.println(circularBuffer[j % N]);
					j++;
				}
			}
			input = br.readLine();
		}

	}
}
