package test;

import time.TimeParser;

public class TestTime {
	
	public static void main(String[] args) {
		TimeParser tp = new TimeParser();
		
		System.out.println(tp.getTimestamp("2016-07-20 22:06:100"));
		System.out.println();
		System.out.println(tp.getTimestamp("2017-07-20 22:06:100"));
		System.out.println(tp.getTimestamp("2017-07-21 22:06:100"));
		System.out.println();
		System.out.println(tp.getTimestamp("2017-07-22 09:06:100"));
		System.out.println(tp.getTimestamp("2017-07-22 12:06:100"));
		System.out.println(tp.getTimestamp("2017-07-22 22:06:100"));
		System.out.println();
		System.out.println(tp.getTimestamp("2017-08-22 22:06:100"));
	}

}
