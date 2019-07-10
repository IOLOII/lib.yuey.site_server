package cla;

import java.util.Scanner;

public class symbol_split{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		isStr(s,",");
	}
	public static	String isStr(String s,String regex) {
		String ssss = "";
//		while (s.contains(";")) {
			String [] sss = s.split(regex);
			for (String ss : sss) {
				ssss+=ss;
			}
			return ssss;
//			System.out.println(ssss);
//		}
	}
	static void hello() {
		System.out.println("hello");
	}
}
