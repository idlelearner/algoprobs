package code.fourfiftythree;

public class TheSoccerDivTwo {
	public static void main(String[] args) {
		// int points[] = { 5, 9, 11, 9, 10, 9 };
		int points[] = { 4, 7, 7, 7, 7, 6, 5, 5 };
		TheSoccerDivTwo s = new TheSoccerDivTwo();
		System.out.println(s.find(points));
	}

	public int find(int p[]) {
		int s = 0, a = 0, b = 0;
		p[0] += 3;
		for (int i = 1; i < p.length; i++) {
			if (p[i] > p[0])
				a++;
			else if (p[i] == p[0])
				s++;
			else if (p[0] - p[i] >= 3)
				b++;
		}
		s = Math.max(s - a - b - 1, 0);
		return a + s / 2 + s % 2 + 1;
	}
}
