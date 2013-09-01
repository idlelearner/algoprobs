package code.designpatterns;

/**
 * State design pattern
 * @author Dhass
 *
 */
interface Season {
	public void theSeason(SeasonContext context);
}

class Winter implements Season {

	@Override
	public void theSeason(SeasonContext context) {
		System.out.println("Winter is now.");
		context.setSeason(new Spring());
	}

}

class Spring implements Season {

	@Override
	public void theSeason(SeasonContext context) {
		System.out.println("Spring is now");
		context.setSeason(new Summer());
	}

}

class Summer implements Season {

	@Override
	public void theSeason(SeasonContext context) {
		System.out.println("Summer is now");
		context.setSeason(new Autumn());
	}

}

class Autumn implements Season {

	@Override
	public void theSeason(SeasonContext context) {
		System.out.println("Autumn is now");
		context.setSeason(new Winter());
	}

}

class SeasonContext {
	private Season season;

	public SeasonContext() {
		this.season = new Winter();
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public void whatTheSaeson() {
		season.theSeason(this);
	}
}

public class StateDesignPattern {
	public static void main(String[] args) {
		SeasonContext sc = new SeasonContext();
		sc.whatTheSaeson();
		sc.whatTheSaeson();
		sc.whatTheSaeson();
		sc.whatTheSaeson();
	}
}
