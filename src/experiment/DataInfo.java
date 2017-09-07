package experiment;

import rangeData.Table;

public class DataInfo {

	private static DataInfo dataInfoInstance = new DataInfo();
	
	public static DataInfo getDataInfoInstance(){
		return dataInfoInstance;
	}
	
	private DataInfo(){
		
	}
	
	private String dataFilePath;
	private String parsedFilePath;
	private String emgFileName;
	private String rangeFileName;
	
	/*
	private String gyrFileName;
	private String accFileName;
	private String oriFileName;
	private String oreFileName;
	*/

	public String getDataFilePath() {
		return dataFilePath;
	}

	public void setDataFilePath(String dataFilePath) {
		this.dataFilePath = dataFilePath;
		this.parsedFilePath = dataFilePath+"\\ParsedData_"+Table.density+"\\";
	}

	public String getEmgFileName() {
		return emgFileName;
	}

	public void setEmgFileName(String emgFileName) {
		this.emgFileName = emgFileName;
	}

	public String getRangeFileName() {
		return rangeFileName;
	}

	public void setRangeFileName(String rangeFileName) {
		this.rangeFileName = rangeFileName;
	}

	public String getParsedFilePath() {
		return parsedFilePath;
	}

	
	/*
	public String getGyrFileName() {
		return gyrFileName;
	}

	public void setGyrFileName(String gyrFileName) {
		this.gyrFileName = gyrFileName;
	}

	public String getAccFileName() {
		return accFileName;
	}

	public void setAccFileName(String accFileName) {
		this.accFileName = accFileName;
	}

	public String getOriFileName() {
		return oriFileName;
	}

	public void setOriFileName(String oriFileName) {
		this.oriFileName = oriFileName;
	}

	public String getOreFileName() {
		return oreFileName;
	}

	public void setOreFileName(String oreFileName) {
		this.oreFileName = oreFileName;
	}
	
	*/
}
