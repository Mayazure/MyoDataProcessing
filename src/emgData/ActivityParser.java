package emgData;

import fileOperator.FileOperator;

public class ActivityParser extends Thread{

	private int start = 0;
	private int end = 0;
	private int index = 0;
	private String activityName;
	private String filePath;
	private String fileName;
	private LineFormatter lineFormatter;
	private FileOperator inFileOperator;
	private FileOperator outFileOperator;
	private FileParser fileParser;
	
	public ActivityParser(SplitterIndex splitterIndex, String filePath, String fileName,FileParser fileParser) {
		super();
		this.fileParser = fileParser;
		this.start = splitterIndex.getStart();
		this.end = splitterIndex.getEnd();
		this.activityName = splitterIndex.getName();
		this.filePath = filePath;
		this.fileName = fileName;
		lineFormatter = new LineFormatter(activityName);
		inFileOperator = new FileOperator();
		inFileOperator.loadReadFile(filePath+fileName);
		outFileOperator = new FileOperator();
		String outFilePath = filePath+"Parsed\\";
		outFileOperator.createFileDir(outFilePath);
		outFileOperator.loadWriteFile(outFilePath+activityName+".csv");
	}
	
	@Override
	public void run(){
		parse();
		if(fileParser!=null){
			fileParser.updateCount();
		}
	}
	
	private void parse(){
		
		for(int i=0;i<=end;i++){
			String str = inFileOperator.nextLine();
			if(i<start){
				continue;
			}
			String result = lineFormatter.ruleFormat(str);
			outFileOperator.writeToFile(result);
		}
		inFileOperator.closeIn();
		outFileOperator.closeOut();
	}				
}
