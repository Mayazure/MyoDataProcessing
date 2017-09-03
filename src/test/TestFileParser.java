package test;

import emgData.FileParser;
import experiment.DataInfo;

public class TestFileParser {
	
	public static void main(String[] args) {
		
		DataInfo dataInfo = DataInfo.getDataInfoInstance();
		dataInfo.setDataFilePath("C:\\Users\\Mayazure\\Desktop\\MyoRecording0000\\");
		dataInfo.setEmgFileName("emg-20170722104438_test.csv");
		
		FileParser fp = new FileParser(null);
		fp.parseAll();
		
	}

}
