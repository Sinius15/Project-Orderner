package com.sinius.ordener.sorters;

public class BubbleSort implements Sorter {

	@Override
	public int[] sort(int[] input) {
		
		while(true){
			boolean swamped = false;
			for(int i = 0 ; i<input.length-1 ; i++){
				int left = input[i];
				int right= input[i+1];
				if(left > right){
					input[i] = right;
					input[i+1] = left;
					swamped = true;
				}
			}
			if(!swamped)
				break;
		}
		
		return input;
	}

}
