package test;

import java.util.Scanner;

import emgData.LineFormatter;

public class TestLineFormatter {

	public static void main(String[] args) {
		LineFormatter lf = new LineFormatter("test");

		Scanner scanner = new Scanner(System.in);

		while(true){
			String data = scanner.nextLine();
			if(data.equals("end")){
				break;
			}
			else{
				String out = lf.ruleFormat(data);
				System.out.println(out + "    " + lf.getActivity());
			}
		}
		scanner.close();
	}
}
