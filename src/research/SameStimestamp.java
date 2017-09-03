package research;

import java.util.ArrayList;
import java.util.Iterator;

import fileOperator.FileOperator;

public class SameStimestamp {
	
	private FileOperator fileOperator;
	private int count = 0;
	private String timestamp;
	
	public SameStimestamp(String filePath){
		fileOperator = new FileOperator();
		fileOperator.loadReadFile(filePath);
	}
	
	public ArrayList<Integer> find(){
		ArrayList<Integer> lineIndex = new ArrayList<Integer>();
		int lineNo = 1;
		String line;
		fileOperator.nextLine();
		while(true){
			line = fileOperator.nextLine();
			lineNo++;
			String timestampString="";
			if(line!=null){
				timestampString = formatTime(line);
			}			
			if(timestampString.equals(timestamp)){
				count++;
			}
			else{
				if(count>2){
					lineIndex.add(lineNo-1);
				}
				timestamp = timestampString;
				count = 0;
			}
			if(line==null){
				break;
			}
		}
		return lineIndex;
	}
	
	private String formatTime(String line){
		int end = line.indexOf(",");
		String raw = line.substring(0,end);
		return  raw;
	}
	
	public static void main(String[] args) {
		String filePath = "D:\\OneDrive - Australian National University\\MyoProject\\Format Data\\Exp2\\";
		String fileName = "emg-20170718114247.csv";
		SameStimestamp st = new SameStimestamp(filePath+fileName);
		ArrayList<Integer> set = st.find();
		System.out.println("Find done.");
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext()){
			int a = iterator.next();
			System.out.println(a);
		}
	}
}
