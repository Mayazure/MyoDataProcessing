package emgData;

public class SplitterIndex {

	private String name; 
	private int start;
	private int end;
	
	public SplitterIndex(int start, int end, String name) {
		super();
		this.start = start;
		this.end = end;
		this.name = name;
	}
	public SplitterIndex(){
		
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
