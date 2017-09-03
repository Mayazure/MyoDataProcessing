package fileOperator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

public class FileOperator {

	private File file;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private FileOutputStream outStream;

	public void loadReadFile(String filePath){
		file = new File(filePath);
		if(!file.isFile()||!file.exists()){
			System.out.println("File not found:"+filePath);
		}
		else{
			try {
				fileReader = new FileReader(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bufferedReader = new BufferedReader(fileReader);
		}
	}

	public void loadWriteFile(String filePath){
			try {
				outStream = new FileOutputStream(filePath,true);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void createFileDir(String path){
		//		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
		//		String desktopPath = desktopDir.getAbsolutePath();
		//		String recordPath = desktopPath + "\\MyoDriving";
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
	}

	public String nextLine(){
		String result = null;
		try {
			result = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public void writeToFile(String data){
		String outData = data +"\r\n";
		try {
			outStream.write(outData.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public void closeIn(){
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeOut(){
		try {
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}