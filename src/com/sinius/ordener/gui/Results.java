package com.sinius.ordener.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class Results extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<String> list;
	private JLabel average;

	public Results(String[] dat) {
		setResizable(false);
		setTitle("Results");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 223, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 197, 172);
		contentPane.add(scrollPane);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		getList().setListData(dat);
		
		JLabel lblMeanTime = new JLabel("average time:");
		lblMeanTime.setBounds(10, 194, 91, 14);
		contentPane.add(lblMeanTime);
		
		average = new JLabel("");
		average.setBounds(92, 194, 115, 14);
		contentPane.add(average);
	}
	
	public JList<String> getList() {
		return list;
	}
	public JLabel getAverage() {
		return average;
	}
}
