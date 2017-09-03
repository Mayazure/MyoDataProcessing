package emgData;

import java.util.ArrayList;

import fileOperator.FileOperator;

public class ActivitySplitter {
	
	private String filePath;
	private FileOperator fileOperator;
	private ArrayList<SplitterIndex> splitterIndexes;
	
	public ActivitySplitter(String filePath){
		this.filePath = filePath;
	}
	
	public ArrayList<SplitterIndex> generateSplitterIndexes(){
		splitterIndexes = new ArrayList<SplitterIndex>();
		fileOperator = new FileOperator();
		fileOperator.loadReadFile(filePath);

		String line = null;
		fileOperator.nextLine();
		line = fileOperator.nextLine();
		int oristart = line.indexOf(",");
		int oriend = line.indexOf(",", oristart+1);
		String activityLabel = line.substring(oristart+1, oriend);
		String activityFilter = ","+activityLabel+",";
		
		int indexStart = 1;
		int indexEnd = 1;
		
		while ((line = fileOperator.nextLine())!=null) {

			if(line.contains(activityFilter)){
				indexEnd++;
			}
			else{
				SplitterIndex splitterIndex = new SplitterIndex(indexStart,indexEnd,activityLabel);
				splitterIndexes.add(splitterIndex);
				
				indexStart = indexEnd+1;
				indexEnd = indexStart;
				int start = line.indexOf(",");
				int end = line.indexOf(",", start+1);
				activityLabel = line.substring(start+1, end);
				activityFilter = ","+activityLabel+",";
			}
		}
		
		SplitterIndex splitterIndex = new SplitterIndex(indexStart,indexEnd,activityLabel);
		splitterIndexes.add(splitterIndex);
		
		return splitterIndexes;
	}
}
