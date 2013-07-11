package com.control.Action;

public class StringTest {
	
	public static void main(String[] args) {
		String o = "4@0011#s@0022#a@0011#e@0022#r";
		String s[] = new String[20];
		s = o.split("@");
		
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
	}
}
