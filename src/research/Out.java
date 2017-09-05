package research;

import fileOperator.FileOperator;

public class Out {

	public static void main(String[] args) {
		FileOperator fo = new FileOperator();
		String path = "H:\\Myo\\Organized Data\\";
		for(int i=1;i<=27;i++){
			fo.createFileDir(path+i);
		}
		
	}
}
