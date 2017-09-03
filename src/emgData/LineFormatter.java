package emgData;

public class LineFormatter {
	
	private StringBuilder rawString;
	private String parsedString;
	private String activityString;
	
	public LineFormatter(String activity){
		activityString = activity.trim()+",";
	}
	
	public LineFormatter(){
		activityString = "";
	}
	
	public String ruleFormat(String raw){
		rawString = new StringBuilder(raw.trim());
		ruleFormatTime();
		parseActivity();
//		formatTime();
		return parsedString;
	}
	
	public void parseActivity(){
//		int start = rawString.indexOf(",", 0);
//		int end = rawString.indexOf(",", start+1);
//		this.activityString = rawString.substring(start+1, end);
//		rawString.delete(start, end);
		parsedString.replace(activityString, "");
	}
	
	private void ruleFormatTime(){
		int end = rawString.indexOf(",");
		rawString = rawString.delete(end-3, end);
		rawString = rawString.delete(0, 6);
		parsedString = rawString.toString();
	}
	
	public String formatTime(String line){
		StringBuilder raw = new StringBuilder(line);
		int end = raw.indexOf(",");
		raw = raw.delete(end-3, end);
//		raw= raw.delete(0, 5);
		parsedString = raw.toString();
		return parsedString;
	}
	
	public String getActivity(){
		return this.activityString;
	}
}
