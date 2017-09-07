package rangeData;

import java.util.ArrayList;

import fileOperator.FileOperator;

public class RangeList {
	
	private FileOperator fileOperator;
	private ArrayList<RangeInfo> rangeInfos;
	private String filePath;
	private RangeParser rangeParser;
	
	public RangeList(String filePath){
		this.filePath = filePath;
		fileOperator = new FileOperator();
		rangeParser = new RangeParser();
		generateRangeList();
	}
	
	private void generateRangeList(){
		rangeInfos = new ArrayList<RangeInfo>();
		fileOperator.loadReadFile(filePath);
		String line;
		
		while((line=fileOperator.nextLine())!=null){
			if(line.equals("")||line.contains("TEST")||line.contains("start")||line.contains("Total")){
				continue;
			}
			else{
				rangeInfos.add(rangeParser.ParseRange(line));
			}
		}
	}
	
	public ArrayList<RangeInfo> getRangeList(){
		return rangeInfos;
	}

}
