package code.fourfifty;

public class EnemyTowers {

	int tot, hp, attT, noT1, noT2;

	public static void main(String[] args) {
		EnemyTowers e = new EnemyTowers();
		System.out.println(e.attack(200, 50, 3, 10, 5));
		System.out.println(e.attack1(200, 50, 3, 10, 5));
	}

	public int attack(int myUnits, int hpT, int attackT, int numWodT,
			int numStoT) {
		hp = hpT;
		attT = attackT;
		noT1 = numWodT;
		noT2 = numStoT;
		tot = myUnits;
		int v = solve(0, tot);
		return v == Integer.MAX_VALUE ? -1 : v;
	}

	int solve(int l, int r) {
		if (l == r)
			return Math.max(check(l, noT1), check(tot - l, noT2));
		if (l + 1 == r)
			return Math.min(Math.max(check(l, noT1), check(tot - l, noT2)),
					Math.max(check(r, noT1), check(tot - r, noT2)));
		int mid = (l + r) / 2;
		int res1 = check(mid, noT1);
		int res2 = check(tot - mid, noT2);
		if (res1 == res2)
			return res1;
		else if (res1 < res2)
			return solve(0, mid);
		else
			return solve(mid, r);
	}

	int check(int noOfSol, int tower) {
		int val = 0;
		int tot = tower * hp;
		while (tot > 0 && noOfSol > 0) {
			val++;
			tot = tot - noOfSol;
			if (tot <= 0)
				return val;
			noOfSol = noOfSol - ((int) Math.ceil((double) tot / hp)) * attT;
		}
		return Integer.MAX_VALUE;
	}
	
	
	public int attack1(int myUnits, int hpT, int attackT, int numWodT, int numStoT){
		int val=0;
		int noOfSol = myUnits;
		int totTow = numWodT*hpT + numStoT*hpT;
		while(totTow>0 && noOfSol>0){
			val++;
			totTow=totTow-noOfSol;
			if(totTow<=0)
				break;
			noOfSol = noOfSol - ((int) Math.ceil((double)totTow / hpT))*attackT;
			if(noOfSol<0 || (noOfSol==0 && totTow>0))
				return -1;
		}
		return val;
	}
}