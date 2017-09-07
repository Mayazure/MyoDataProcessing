package rangeData;

public class RangeParser {

	public RangeInfo ParseRange(String line){
		int start = line.indexOf(">");
		line = line.substring(start+1).trim();
		
		String[] datas = line.split("\\$..=");
		
//		int len = datas.length;
//		System.out.println(">>> "+line);
//		System.out.println(len);
//		for(int i=0;i<len;i++){
//			System.out.println(datas[i]);
//		}
		
		return new RangeInfo(datas[1], datas[2], datas[3],datas[4]);
	}
}
