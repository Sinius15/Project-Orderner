package com.sinius.ordener;

public class TimeTimer{

	private long start, end;
	
	public void Start(){
		start = System.nanoTime();
	}
	
	public void Stop(){
		end = System.nanoTime();
	}
	
	public String getMils(){
		return String.valueOf(end-start);
	}
}
