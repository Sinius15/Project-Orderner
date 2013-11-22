package com.sinius.ordener.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.sinius.ordener.Game;
import com.sinius.ordener.sorters.BasicSort;
import com.sinius.ordener.sorters.BubbleSort;

public class StartFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	public StartFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
			e2.printStackTrace();
		}
		setResizable(false);
		setTitle("Sorter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 88);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSortTypeOne = new JButton("Basic Sort");
		btnSortTypeOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Game(new BasicSort(), Integer.parseInt(getTextField().getText()), Integer.parseInt(getTextField_1().getText()));
			}
		});
		btnSortTypeOne.setBounds(205, 31, 100, 23);
		contentPane.add(btnSortTypeOne);
		
		JLabel lblSortAlgorithem = new JLabel("Sort Algorithem:");
		lblSortAlgorithem.setBounds(10, 35, 100, 14);
		contentPane.add(lblSortAlgorithem);
		
		JButton btnBubbleSort = new JButton("Bubble Sort");
		btnBubbleSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Game(new BubbleSort(), Integer.parseInt(getTextField().getText()),Integer.parseInt(getTextField_1().getText()));
			}
		});
		btnBubbleSort.setBounds(95, 31, 100, 23);
		contentPane.add(btnBubbleSort);
		
		JLabel lblRuns = new JLabel("runs:");
		lblRuns.setBounds(10, 10, 46, 14);
		contentPane.add(lblRuns);
		
		textField_1 = new JTextField();
		textField_1.setText("1");
		textField_1.setBounds(44, 7, 39, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblToSortLengt = new JLabel("to sort length:");
		lblToSortLengt.setBounds(127, 10, 94, 14);
		contentPane.add(lblToSortLengt);
		
		textField = new JTextField();
		textField.setText("100");
		textField.setBounds(205, 7, 39, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	
	public JTextField getTextField_1() {
		return textField_1;
	}
	public JTextField getTextField() {
		return textField;
	}
}
