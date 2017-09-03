package rangeData;

public class RangeInfo {

	private String timestamp1;
	private String timestamp2;
	private String range1;
	private String range2;
	
	public RangeInfo(String timestamp1, String timestamp2, String range1, String range2) {
		super();
		this.timestamp1 = timestamp1;
		this.timestamp2 = timestamp2;
		this.range1 = range1;
		this.range2 = range2;
	}

	public String getTimestamp1() {
		return timestamp1;
	}

	public void setTimestamp1(String timestamp1) {
		this.timestamp1 = timestamp1;
	}

	public String getTimestamp2() {
		return timestamp2;
	}

	public void setTimestamp2(String timestamp2) {
		this.timestamp2 = timestamp2;
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
