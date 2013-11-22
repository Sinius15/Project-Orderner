package com.sinius.ordener.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.sinius.ordener.Game;
import com.sinius.ordener.Util;
import com.sinius.ordener.sorters.BasicSort;
import com.sinius.ordener.sorters.BubbleSort;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public StartFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
			e2.printStackTrace();
		}
		setResizable(false);
		setTitle("Sorter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSortTypeOne = new JButton("Basic Sort");
		btnSortTypeOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Game(new BasicSort(), Util.toIntArr(getTextField().getText().split(",")), Integer.parseInt(getTextField_1().getText()));
			}
		});
		btnSortTypeOne.setBounds(10, 60, 140, 23);
		contentPane.add(btnSortTypeOne);
		
		textField = new JTextField();
		textField.setBounds(138, 11, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblToSort = new JLabel("To Sort:  (devided by ,)");
		lblToSort.setBounds(10, 14, 140, 14);
		contentPane.add(lblToSort);
		
		JButton btnRandom = new JButton("?");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String out = "";
				for(int i = 0; i<100; i++)
					out = out + String.valueOf(randomNumber(1, 100)) + ",";
				out = out.substring(0, out.length()-1);
				getTextField().setText(out);
			}
		});
		btnRandom.setBounds(288, 10, 38, 23);
		contentPane.add(btnRandom);
		
		JLabel lblSortAlgorithem = new JLabel("Sort Algorithem:");
		lblSortAlgorithem.setBounds(10, 39, 120, 14);
		contentPane.add(lblSortAlgorithem);
		
		JButton btnBubbleSort = new JButton("Bubble Sort");
		btnBubbleSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Game(new BubbleSort(), Util.toIntArr(getTextField().getText().split(",")),Integer.parseInt(getTextField_1().getText()));
			}
		});
		btnBubbleSort.setBounds(160, 60, 166, 23);
		contentPane.add(btnBubbleSort);
		
		JLabel lblRuns = new JLabel("runs:");
		lblRuns.setBounds(197, 39, 46, 14);
		contentPane.add(lblRuns);
		
		textField_1 = new JTextField();
		textField_1.setText("1");
		textField_1.setBounds(239, 36, 39, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
	
	public static int randomNumber(int min, int max){
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	public JTextField getTextField() {
		return textField;
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
}
