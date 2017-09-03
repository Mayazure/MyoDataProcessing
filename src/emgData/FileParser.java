package emgData;

import java.util.ArrayList;
import java.util.Iterator;

import controller.MainWindow;
import experiment.DataInfo;

public class FileParser {
	
	private ArrayList<SplitterIndex> splitterIndexes;
	private DataInfo dataInfo = DataInfo.getDataInfoInstance();
	private volatile Integer count = 0;
	private Integer total = 0;
	private MainWindow mainWindow;
	
	public FileParser(MainWindow mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void parseAll(){
		spliteActivity();
		parseActivity();
	}
	
	private void spliteActivity(){
		ActivitySplitter activitySplitter = new ActivitySplitter(dataInfo.getDataFilePath()+dataInfo.getEmgFileName());
		splitterIndexes = activitySplitter.generateSplitterIndexes();
		total = splitterIndexes.size();
	}
	
	private void parseActivity(){
		
		Iterator<SplitterIndex> iterator = splitterIndexes.iterator();
		
		while(iterator.hasNext()){
			SplitterIndex splitterIndex = iterator.next();
			ActivityParser activityParser = new ActivityParser(splitterIndex,dataInfo.getDataFilePath(), dataInfo.getEmgFileName(),this);
			activityParser.setName(splitterIndex.getName());
			activityParser.start();
		}
		while(count!=total){
			
		}
		mainWindow.updateSimpleConsole("All finished.");
		count = 0;
	}
	
	public synchronized void updateCount(){
		synchronized (count) {
			count++;
			mainWindow.updateSimpleConsole("Finished:"+count+"/"+total+".");
		}
	}
}
