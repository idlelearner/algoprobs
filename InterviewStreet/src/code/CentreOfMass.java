package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CentreOfMass {

	public static void main(String[] args) throws IOException {

		// getting inputs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// No. of inputs
		int k = Integer.parseInt(br.readLine());
		int inputs[] = new int[k];

		// weights
		String[] strs = br.readLine().split(" ");
		for (int i = 0; i < k; i++)
			inputs[i] = Integer.parseInt(strs[i]);

		// Allowed magic spells
		int m[][] = new int[k][k];
		for (int i = 0; i < k; i++) {
			String ipStr = br.readLine();
			for (int j = 0; j < k; j++)
				m[i][j] = ipStr.charAt(j) == 'Y' ? 1 : 0;
		}

		// complete the spells
		CentreOfMass centreOfMass = new CentreOfMass();
		centreOfMass.completeSpells(m);

		// sort to make the maximise center of mass
		centreOfMass.sortVals(inputs, m);

		// Output
		for (int i = 0; i < inputs.length; i++)
			System.out.print(inputs[i] + " ");
	}

	// transitivity..complete the other possible combinations
	//1->2,2->3 then 1->3
	void completeSpells(int m[][]) {
		int l = m[0].length;
		for (int k = 0; k < l; k++)
			for (int i = 0; i < l; i++)
				for (int j = 0; j < l; j++)
					if (m[i][k] == 1 && m[k][j] == 1)
						m[i][j] = 1;

	}

	// bubble sort to sort the vals if it is allowed
	void sortVals(int a[], int m[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j] && m[i][j] == 1) {
					a[i] ^= a[j];
					a[j] ^= a[i];
					a[i] ^= a[j];
				}

			}
		}
	}
}
