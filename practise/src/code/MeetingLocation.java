package code;

class Location {

	public int x;
	public int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

/**
 * Given the set of location 
 * Find the point which could be the meeting point 
 * for the people by travelling minimum distance
 * 
 * @author Dhass
 * 
 */
public class MeetingLocation extends Location {

	public int amountOfPeople;

	public MeetingLocation(int x, int y, int amountOfPeople) {
		super(x, y);
		this.amountOfPeople = amountOfPeople;
	}

	public Location moveLowestCost(int n, int m,
			MeetingLocation... meetingLocations) {
		Location newLocation = new Location(0, 0);
		int minCostX = Integer.MAX_VALUE, minCostY = Integer.MAX_VALUE;
		for (int x = 0; x < m; x++) {
			int costX = 0;
			for (MeetingLocation location : meetingLocations) {
				costX += location.amountOfPeople
						* calculateAbsDistance(x, location.x);
			}
			if (minCostX > costX) {
				minCostX = costX;
				newLocation.x = x;
			}
		}
		for (int y = 0; y < n; y++) {
			int costY = 0;
			for (MeetingLocation location : meetingLocations) {
				costY += location.amountOfPeople
						* calculateAbsDistance(y, location.y);
			}
			if (minCostY > costY) {
				minCostY = costY;
				newLocation.y = y;
			}
		}
		return newLocation;
	}

	public static int calculateAbsDistance(int x, int x1) {
		if (x >= x1) {
			return x - x1;
		} else {
			return x1 - x;
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		MeetingLocation m = new MeetingLocation(0, 0, 0);
		Location newLoc = m.moveLowestCost(3, 4, new MeetingLocation(0, 1, 4),
				new MeetingLocation(1, 3, 3), new MeetingLocation(2, 0, 5));
		System.out.println("X = " + newLoc.x + "; Y = " + newLoc.y);
	}
}