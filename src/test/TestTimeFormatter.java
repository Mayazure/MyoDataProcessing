package test;

import emgData.TimestampFormatter;
import experiment.DataInfo;

public class TestTimeFormatter {

	public static void main(String[] args) {
		DataInfo dataInfo = DataInfo.getDataInfoInstance();
		dataInfo.setDataFilePath("D:\\OneDrive - Australian National University\\MyoProject\\Format Data\\Exp9\\");
		dataInfo.setEmgFileName("emg-20170725155545.csv");
		TimestampFormatter timestampFormatter = new TimestampFormatter();
		timestampFormatter.formatAllTimestamp();
	}
}
