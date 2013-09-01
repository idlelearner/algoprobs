package code.dynamicprogramming;

/**
 * Dynamic programming to find denominations
 * 
 * @author Dhass
 * 
 */
public class Denominations {

	public static void main(String[] args) {
		int coins[] = { 1, 2, 5, 10, 50, 100, 500, 1000 };
		Denominations d = new Denominations();
		System.out.println(d.getDenomination(coins, 5553));
	}

	// Dynamic programming to get the least number for coins for a amount
	int getDenomination(int coins[], int val) {
		int v[] = new int[val + 1];
		for (int i = 0; i <= val; i++)
			v[i] = i;
		for (int i = 1; i <= val; i++) {
			for (int j = 0; j < coins.length; j++)
				if (i == coins[j])
					v[i] = 1;
				else if (i > coins[j]) {
					v[i] = Math.min(v[i], (v[i - coins[j]]) + 1);
				} else
					break;
		}
		return v[val];
	}
}
