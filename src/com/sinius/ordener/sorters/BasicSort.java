package com.sinius.ordener.sorters;

import java.util.ArrayList;

import com.sinius.ordener.Util;

public class BasicSort implements Sorter{

	@Override
	public int[] sort(int[] qwe) {
		ArrayList<Integer> in = (ArrayList<Integer>) Util.toList(qwe);
		int[] out = new int[qwe.length];
		int outIndx = 0;
		
		while(in.size() > 0){
			int lowestIndex = -1;
			int lowestNumber = Integer.MAX_VALUE;
			int counter = 0;
			for(Integer i : in){
				if(i<lowestNumber){
					lowestNumber = i;
					lowestIndex = counter;
				}
				counter++;
			}
			out[outIndx] = lowestNumber;
			outIndx++;
			in.remove(lowestIndex);
		}
		
		return out;
	}
	
}
