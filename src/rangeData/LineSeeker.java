package rangeData;

import experiment.DataInfo;
import fileOperator.FileOperator;

public class LineSeeker {
	
	private FileOperator fileOperator;
	private DataInfo dataInfo = DataInfo.getDataInfoInstance();
	private int start = 0;
	
	public LineSeeker(){
		this(0);
	}
	
	public LineSeeker(int start){
		this.start = start;
		fileOperator = new FileOperator();
	}
	
	public int seekLine(String timestamp){
		fileOperator.loadReadFile(dataInfo.getDataFilePath()+dataInfo.getEmgFileName());
		
		String str = null;
		int count = 0;
		int result = 0;
		long timestampBase = Long.parseLong(timestamp);
		while((str=fileOperator.nextLine())!=null){
			if(count==0||count<start){
				count++;
				continue;
			}
			else{
				String timestampString = str.substring(0,13);
				long timestampLong = Long.parseLong(timestampString);
				if(timestampLong<=timestampBase){
					result = count;
					count++;
				}
				else{
					break;
				}
			}
		}
		return result;
	}
}
