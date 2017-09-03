package test;

import experiment.DataInfo;
import rangeData.LineSeeker;

public class TestLineSeeker {
	
	public static void main(String[] args) {
		
//		testSub();
		
		DataInfo dataInfo = DataInfo.getDataInfoInstance();
		dataInfo.setDataFilePath("C:\\Users\\Mayazure\\Desktop\\MyoRecording0000\\");
		dataInfo.setEmgFileName("emg-20170722104438_test.csv");
		
		LineSeeker lineSeeker = new LineSeeker();
		int line = lineSeeker.seekLine("1500684284891");
		System.out.println(line);
		System.out.println(System.currentTimeMillis());
	}
	
//	private static void testSub(){
//		String str = "1500684284891275";
//		String timestampString = str.substring(0,12);
//		System.out.println(timestampString);
//	}

}
