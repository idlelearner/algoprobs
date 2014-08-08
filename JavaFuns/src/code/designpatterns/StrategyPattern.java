package code.designpatterns;

interface FootballStrategy {

	public void adhereTactic(String team);

}

class AttackTactic implements FootballStrategy {

	@Override
	public void adhereTactic(String team) {
		System.out.println(team + " will play in attacking football!");
	}

}

class DefenceTactic implements FootballStrategy {

	@Override
	public void adhereTactic(String team) {
		System.out.println(team + " will make emphasis on defence!");
	}

}

class TacticContext {

	private FootballStrategy strategy = null;

	public void selectTactic(String team) {
		strategy.adhereTactic(team);
	}

	public FootballStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(FootballStrategy strategy) {
		this.strategy = strategy;
	}

}

public class StrategyPattern {
	public static void main(String[] args) {

		String team1 = "Barcelona";
		String team2 = "Real Madrid";

		TacticContext context = new TacticContext();

		context.setStrategy(new AttackTactic());
		context.selectTactic(team1);

		context.setStrategy(new DefenceTactic());
		context.selectTactic(team2);

	}
}
