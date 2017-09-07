package rangeData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import fileOperator.DirTool;
import fileOperator.FileOperator;

public class Statistic {
	
	private String path;
	private ArrayList<RangeInfo> rangeLevel;
	
	public Statistic(String path){
		this.path = path;
		rangeLevel = new ArrayList<RangeInfo>();
	}
	
	public ArrayList<RangeInfo> getRangeLevelList(){
		File files[] = DirTool.getFiles(path);
		for(File tempfile : files){
			String tempfilePath = tempfile.getAbsolutePath();
			rangeLevel.addAll(new RangeList(tempfilePath).getRangeList());
		}
		return rangeLevel;
	}
	
	public void saveToFile(String path){
		FileOperator fileOperator = new FileOperator();
		fileOperator.loadWriteFile(path+"range.csv");
		
		Iterator<RangeInfo> iterator = rangeLevel.iterator();
		while(iterator.hasNext()){
			RangeInfo rf = iterator.next();
			fileOperator.writeToFile(rf.getRange1() + "," + rf.getRange2());
		}
	}

}
