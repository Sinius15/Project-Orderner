package com.sinius.ordener.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sinius.ordener.Game;

public class Display{

	private JFrame frame;
	private DrawPane pane;
	private BufferedImage img;
	private BufferedImage output;
	private Color bgColor;
	public Dimension contentSize ;
	
	//copedy from other project
	
	public Display(int width, int height, String title, Color backGround){
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
			e2.printStackTrace();
		}
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		contentSize = new Dimension(width, height);
		bgColor = backGround;
		
		frame = new JFrame();
		pane = new DrawPane();
		frame.setResizable(true);
		pane.setPreferredSize(new Dimension(width, height));
		frame.setContentPane(pane);
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public class DrawPane extends JPanel{
		private static final long serialVersionUID = -6825107813851526680L;
		public void paintComponent(Graphics gg){
			final Graphics graphics = output.getGraphics();
			
			graphics.drawImage(img, 0, 0, null);

			gg.drawImage(output, 0, 0, frame.getWidth()-frame.getInsets().left-frame.getInsets().right, frame.getHeight()-frame.getInsets().top-frame.getInsets().bottom, null);
		}
	}
	
	public void reDraw(){
		output.getGraphics().setColor(bgColor);
		output.getGraphics().fillRect(0, 0, contentSize.width, contentSize.height);
		img.getGraphics().setColor(bgColor);
		img.getGraphics().fillRect(0, 0, contentSize.width, contentSize.height);
		Game.get().reDraw(img.createGraphics());
		
		frame.repaint();
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public DrawPane getPanel(){
		return pane;
	}
	
	public void resetSize(){
		frame.setSize(new Dimension(contentSize.width+frame.getInsets().left+frame.getInsets().right, contentSize.height+frame.getInsets().top+frame.getInsets().bottom));
		frame.revalidate();
	}
}
