package rangeData;

import com.sun.glass.ui.Window.Level;

import time.TimeParser;

public class RangeParser {
	
	private TimeParser timeParser = new TimeParser();

	public RangeInfo ParseRange(String line){
		int start = line.indexOf(">");
		line = line.substring(start+1).trim();
		
		String[] datas = line.split("\\$..=");
		
//		int len = datas.length;
//		System.out.println(">>> "+line);
//		System.out.println(len);
//		for(int i=0;i<len;i++){
//			System.out.println(datas[i]);
//		}
		
		return new RangeInfo(datas[1], datas[2], datas[3],datas[4]);
	}
	
	//New Analysis Parse
	public NRangeInfo NParseRange(String line){
		
		line = line.trim();
		int len = line.length();
		
		//Get EMG data level must be one of {0,1}.
		int level = 0;
		if(line.charAt(len-1)=='>'){
			level = 1;
		}
		else{
			level = 0;
		}
		
		//Get time and convert to timestamp
		int s1 = line.indexOf(">");
		String dateTime = line.substring(0, s1);
		String timestamp = String.valueOf(timeParser.getTimestamp(dateTime));
		
		//Get emotion range data
		line = line.substring(s1+1,len);
		String[] datas = line.split("\\$..=");
		
		NRangeInfo nRangeInfo = new NRangeInfo(timestamp, datas[1], datas[2], level);
		return nRangeInfo;
	}
}
