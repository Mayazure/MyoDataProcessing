package test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import emgData.ActivitySplitter;
import emgData.SplitterIndex;

public class TestActivitySplitter {

	public static void main(String[] args) {
//		String filePath = "C:\\Users\\Mayazure\\Desktop\\MyoRecording\\20170719000426\\emg-20170719000426.csv";
		String filePath = "C:\\Users\\Mayazure\\Desktop\\MyoRecording0000\\emg-20170722104438_test.csv";
		ActivitySplitter activitySplitter = new ActivitySplitter(filePath);
		
		long begin = System.currentTimeMillis();
		ArrayList<SplitterIndex> splitterIndexes = activitySplitter.generateSplitterIndexes();
		long finish = System.currentTimeMillis();
		
		Iterator<SplitterIndex> iterator = splitterIndexes.iterator();
		
		while(iterator.hasNext()){
			
			
			SplitterIndex splitterIndex = iterator.next();
			String name = splitterIndex.getName();
			int start = splitterIndex.getStart()+1;
			int end = splitterIndex.getEnd()+1;
			System.out.println(name+":"+start+"-"+end);
		}
		
		double duration = (double)(finish-begin);
		System.out.println(duration/1000.0);
	}
}
