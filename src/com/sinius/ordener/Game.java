package com.sinius.ordener;

import java.awt.Color;
import java.awt.Graphics2D;

import com.sinius.ordener.gui.Results;
import com.sinius.ordener.sorters.Sorter;

public class Game {
	
	private static Game thiss;
	public int[] toDraw;
	public int highest;
	public boolean running = true;
	public String time;
	public String status = ""; 
	public Results results;
	private String[] rsltS;
	private int[] rsltI;
	
	public Game(final Sorter alg, final int length, final int runs){
		thiss = this;
		
//		frame = new Display(toSort.length*10+toSort.length+2, highest * 5, "sorter", Color.black);
		rsltS = new String[runs];
		rsltI = new int[runs];
		
		new Thread(new Runnable() {@Override public void run() {
			for(int i = 0 ; i < runs; i++){
				int[] toSort = Util.randomIntArr(length);
				toDraw = toSort;
				highest = Util.getHighest(toSort);

				TimeTimer t = new TimeTimer();
				t.Start();
				toDraw = alg.sort(toSort);
				t.Stop();
				rsltS[i] = "Run " + i + " finished in " + t.getMils() + " nanoseconds.";
				rsltI[i] = Integer.parseInt(t.getMils());
			}
			results = new Results(rsltS);
			results.getAverage().setText(String.valueOf(Util.getAverage(rsltI)));
			results.setVisible(true);
			
		}}).start();;
		
//		new Thread(new Runnable() {@Override public void run() {
//			while(running){
//				frame.reDraw();
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {}
//			}
//		}}).start();
	}
	
	public void reDraw(Graphics2D g){
		for(int i = 0 ; i < toDraw.length ; i++){
			g.setColor(Color.gray);
			g.fillRect(i*10+i+1, highest*5-toDraw[i]*5, 8, toDraw[i]*5);
			g.setColor(Color.black);
			g.drawRect(i*10+i+1, highest*5-toDraw[i]*5, 8, toDraw[i]*5);
		}
		g.setColor(Color.black);
		g.drawString(status, 20, 20);
	}
	
	public static Game get(){
		return thiss;
	}
	

}
