package emgData;

import java.io.File;

import experiment.DataInfo;
import fileOperator.FileOperator;

public class TimestampFormatter {

	private DataInfo dataInfo = DataInfo.getDataInfoInstance();
	private FileOperator fileOperator;
	private LineFormatter lineFormatter;
	private String parsedPath;
	
	public TimestampFormatter(){
		fileOperator = new FileOperator();
		lineFormatter = new LineFormatter();
		
		parsedPath = dataInfo.getParsedFilePath();
		File file = new File(parsedPath);
		if(!file.exists()||!file.isDirectory()){
			fileOperator.createFileDir(parsedPath);
		}
	}
	
	public void formatAllTimestamp(){
		fileOperator.loadReadFile(dataInfo.getDataFilePath()+dataInfo.getEmgFileName());
		fileOperator.loadWriteFile(parsedPath+"parsed_"+dataInfo.getEmgFileName());
		String line;
		line = fileOperator.nextLine();
		while((line=fileOperator.nextLine())!=null){
			fileOperator.writeToFile(lineFormatter.formatTime(line));
		}
	}
	
}
