package rangeData;

public class NRangeInfo {

	private String timestamp1;
	private String range1;
	private String range2;
	private int level;
	
	public NRangeInfo(String timestamp1, String range1, String range2, int level) {
		super();
		this.timestamp1 = timestamp1;
		this.range1 = range1;
		this.range2 = range2;
		this.level = level;
	}

	public String getTimestamp1() {
		return timestamp1;
	}

	public void setTimestamp1(String timestamp1) {
		this.timestamp1 = timestamp1;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getRange1() {
		return range1;
	}

	public void setRange1(String range1) {
		this.range1 = range1;
	}

	public String getRange2() {
		return range2;
	}

	public void setRange2(String range2) {
		this.range2 = range2;
	}
}
