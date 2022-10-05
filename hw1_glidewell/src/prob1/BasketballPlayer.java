package prob1;

public class BasketballPlayer {
	private int freeThrowsAttempted;
	private int freeThrowsMade;
	private String name;
	private int threePointersAttempted;
	private int threePointersMade;
	private int twoPointersAttempted;
	private int twoPointersMade;

	//Name operations
	public BasketballPlayer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	//Free throw operations
	public int getFreeThrowsAttempted() {
		return freeThrowsAttempted;
	}
	
	public int getFreeThrowsMade() {
		return freeThrowsMade;
	}
	
	public void shootFreeThrow(boolean isMade) {
		freeThrowsAttempted++;
		if (isMade) {
			freeThrowsMade++;
		}		
	}
	
	public double getFreeThrowPercent() {
		if (freeThrowsAttempted == 0) {
			return 0.0;
		}
		double percent = 100.0*freeThrowsMade/freeThrowsAttempted;
		return percent;
	}
	
	//Two pointer operations
	public int getTwoPointersMade() {
		return twoPointersMade;
	}
	
	public int getTwoPointersAttempted() {
		return twoPointersAttempted;
	}
	
	public void shootTwoPointer(boolean isMade) {
		twoPointersAttempted++;
		if (isMade) {
			twoPointersMade++;
		}
	}
	
	public double getTwoPointerPercent() {
		if (twoPointersAttempted == 0) {
			return 0.0;
		}
		double percent = 100.0*twoPointersMade/twoPointersAttempted;
		return percent;
	}
	
	//Three pointer operations
	public int getThreePointersMade() {
		return threePointersMade;
	}
	
	public int getThreePointersAttempted() {
		return threePointersAttempted;
	}
	
	public void shootThreePointer(boolean isMade) {
		threePointersAttempted++;
		if(isMade) {
			threePointersMade++;
		}
	}
	
	public double getThreePointerPercent() {
		if (threePointersAttempted == 0) {
			return 0.0;
		}
		double percent = 100.0*threePointersMade/threePointersAttempted;
		return percent;
	}
	
	//Total points made 
	public int getTotalPoints() {
		return freeThrowsMade + (twoPointersMade*2) + (threePointersMade*3);
	}
	
	//Player spreadsheet summary
	@Override
	public String toString() {
		int total = getTotalPoints();
		double onePercent = getFreeThrowPercent();
		double twoPercent = getTwoPointerPercent();
		double threePercent = getThreePointerPercent();
		String summary = String.format("Player:%s, points:%d\n"
				+ "   Free Throws: made:%d, attempted:%d, percent:%.1f\n"
				+ "    2 Pointers: made:%d, attempted:%d, percent:%.1f\n"
				+ "Three Pointers: made:%d, attempted:%d, percent:%.1f",
				name, total, freeThrowsMade, freeThrowsAttempted, onePercent,
				twoPointersMade, twoPointersAttempted, twoPercent, 
				threePointersMade, threePointersAttempted, threePercent);
		return summary;
	}
		
}
