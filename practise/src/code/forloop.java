package code;

import java.io.File;

/**
 * puzzle to check the value of r
 * 
 * @author Dhass
 * 
 */
public class forloop {
	public static void main(String[] args) {
		int r = 0, n = 10;
		for (int i = 1; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				for (int k = 1; k <= j; k++)
					r++;
		System.out.println(r);

	}
}
