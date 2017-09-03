package test;

import java.util.ArrayList;
import java.util.Iterator;

import rangeData.RangeInfo;
import rangeData.RangeList;
import rangeData.RangeParser;

public class TestRangeParser {
	
	public static void main(String[] args) {
		RangeParser rangeParser = new RangeParser();
		rangeParser.ParseRange("2017-07-24 12:05:31> $T1=1500861927213$T2=1500861931038$R1=26$R2=24");
		
		RangeList rangeList = new RangeList("D:\\OneDrive\\MyoProject\\Data\\MyoDriving\\201707241005.txt");
		ArrayList<RangeInfo> infos = rangeList.getRangeList();
		
		Iterator<RangeInfo> iterator = infos.iterator();
		while(iterator.hasNext()){
			RangeInfo rangeInfo = iterator.next();
			System.out.println(rangeInfo.getTimestamp1()+";"+rangeInfo.getTimestamp2()+";"+rangeInfo.getRange1()+";"+rangeInfo.getRange2());
		}
		System.out.println(infos.size());
	}

}
