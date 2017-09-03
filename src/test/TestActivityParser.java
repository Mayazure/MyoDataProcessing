package test;

import emgData.ActivityParser;
import emgData.SplitterIndex;

public class TestActivityParser {
	
	public static void main(String[] args) {
		
		SplitterIndex splitterIndex = new SplitterIndex(215, 1000, "free-non");
		ActivityParser activityParser = new ActivityParser(splitterIndex, "C:\\Users\\Mayazure\\Desktop\\MyoRecording0000\\","emg-20170722104438_test.csv",null);
		activityParser.start();
	}

}
