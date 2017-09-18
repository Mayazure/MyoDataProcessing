package rangeData;

import java.util.ArrayList;
import java.util.Iterator;

import controller.MainWindow;
import experiment.DataInfo;
import fileOperator.FileOperator;

public class DataExtractor {

	private LineSeeker lineSeeker;
	private ArrayList<Line> lines;
	private ArrayList<RangeInfo> rangeInfos;
	private RangeList rangeList;
	private FileOperator fileOperator;
//	private FileOperator readFileOperator;
	private DataInfo dataInfo = DataInfo.getDataInfoInstance();
	private MainWindow mainWindow;
	private int[] count;
	private int density = Table.density;
	
	public DataExtractor(MainWindow mainWindow){
		this.mainWindow = mainWindow;
		lineSeeker = new LineSeeker();
		lines = new ArrayList<Line>();
		rangeList = new RangeList(dataInfo.getDataFilePath()+dataInfo.getRangeFileName());
		rangeInfos = rangeList.getRangeList();
		fileOperator = new FileOperator();
//		readFileOperator = new FileOperator();
		count = new int[density];
		for(int i=0;i<count.length;i++){
			count[i]=0;
		}
	}
	
	public void extractData(){
		for(int i=0;i<density;i++){
			fileOperator.createFileDir(dataInfo.getParsedFilePath()+"\\"+i);
		}
		Iterator<RangeInfo> iterator = rangeInfos.iterator();
		while(iterator.hasNext()){
			RangeInfo rangeInfo = iterator.next();
			Line tempLine = new Line(lineSeeker.seekLine(rangeInfo.getTimestamp1()),rangeInfo.getRange1(),rangeInfo.getRange2());
			lines.add(tempLine);
		}
		
		Iterator<Line> lineIterator = lines.iterator();
//		fileOperator.loadWriteFile(dataInfo.getParsedFilePath()+"parsed.txt");
		int curcount = 0;
		while(lineIterator.hasNext()){
			curcount++;
			Line line = lineIterator.next();
			int angerLevel = Table.level[Integer.parseInt(line.getRange2())];
			fileOperator.loadReadFile(dataInfo.getParsedFilePath()+"parsed_"+dataInfo.getEmgFileName());
			fileOperator.loadWriteFile(dataInfo.getParsedFilePath()+angerLevel+"\\"+count[angerLevel]+".csv");
			count[angerLevel]++;
//			fileOperator.writeToFile(line.getRange1()+";"+line.getRange2()+";");
			
			int end = line.getLine();
			int start = 0;
			if(end<=Table.windowLength){
				start = 0;
			}
			else{
				start = end - Table.windowLength;
			}
			for(int i=0;i<=end;i++){
				if(i<start){
					fileOperator.nextLine();
//					continue;
				}
				else{
					String str = fileOperator.nextLine();
					fileOperator.writeToFile(str);
				}
			}
			mainWindow.updateSimpleConsole("Extract:"+curcount+"/"+lines.size());
			fileOperator.closeIn();
			fileOperator.closeOut();
		}
		mainWindow.updateSimpleConsole("Extract finished.");
	}
	
	private class Line{
		private int line;
		private String range1;
		private String range2;
		public Line(int line, String range1, String range2) {
			super();
			this.line = line;
			this.range1 = range1;
			this.range2 = range2;
		}
		public int getLine() {
			return line;
		}
		public void setLine(int line) {
			this.line = line;
		}
		public String getRange1() {
			return range1;
		}
		public void setRange1(String range1) {
			this.range1 = range1;
		}
		public String getRange2() {
			return range2;
		}
		public void setRange2(String range2) {
			this.range2 = range2;
		}
		
	}
}