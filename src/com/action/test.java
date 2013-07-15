package com.action;

import util.CDQR;

import com.opensymphony.xwork2.ActionSupport;

public class test extends ActionSupport{
	
	public String action1(){
		System.out.println("fuck");
		return SUCCESS;
	}
	
	public String action2(){
		System.out.println("fuck2");
		return SUCCESS;
	}
	
	public static void main(String[] args) {
		new CDQR().encode("100@aaa");
	}
}
