package com.sinius.ordener;

import java.util.ArrayList;
import java.util.List;

public class Util {

	public static int[] toIntArr(String[] in){
		int[] out = new int[in.length];
		for(int i = 0; i<in.length ;i++)
			out[i] = Integer.parseInt(in[i]);
		return out;
	}
	
	public static int getHighest(int[] in){
		int out = -1;
		for(int i : in)
			if(i > out)
				out = i;
		return out;
	}
	
	public static int[] toArray(List<Integer> integers){
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++){
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
	
	public static List<Integer> toList(int[] in){
		List<Integer> intList = new ArrayList<Integer>();
		for (int index = 0; index < in.length; index++)
			intList.add(in[index]);
		return intList;
	}
	
	public static int getAverage(int[] in){
		int tot = 0;
		for(int i : in)
			tot += i;
		return tot/in.length;
	}
	
}
