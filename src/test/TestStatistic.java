package test;

import rangeData.Statistic;

public class TestStatistic {

	public static void main(String[] args) {
		
		String path = "D:\\Myo\\Organized Data\\range\\";
		
		Statistic statistic = new Statistic(path);
		statistic.getRangeLevelList();
		statistic.saveToFile(path);
	}
}
