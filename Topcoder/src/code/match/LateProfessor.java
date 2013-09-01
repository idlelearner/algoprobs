package code.match;

public class LateProfessor {

	public static void main(String[] args) {
		LateProfessor l = new LateProfessor();
		// System.out.println(l.getProbability(1000, 600, 1, 17000, 17000));
		// System.out.println(l.getProbability(20, 30, 10, 90, 90));
		System.out.println(l.getProbability(101, 230, 10, 654, 17890));
	}
	

	public double getProbability(int waitTime, int walkTime, int lateTime,
			int bestArrival, int worstArrival) {
		if (walkTime <= lateTime)
			return 0.0;
		int val = 0;
		int reachTime = waitTime + walkTime;
		int curWaitTime = waitTime;
		while (reachTime <= worstArrival) {
			if (bestArrival <= reachTime) {
				if (curWaitTime >= bestArrival) {
					val += (reachTime - curWaitTime - lateTime) <= 0 ? 0
							: (reachTime - curWaitTime - lateTime);
				} else {
					val += (reachTime - bestArrival - lateTime) <= 0 ? 0
							: (reachTime - bestArrival - lateTime);
				}
			}
			curWaitTime = reachTime + waitTime;
			reachTime = curWaitTime + walkTime;
		}

		int t = worstArrival - bestArrival == 0 ? 1 : worstArrival
				- bestArrival;
		if (val == 0)
			return 1.0;

		return (double) val / t;
	}
}