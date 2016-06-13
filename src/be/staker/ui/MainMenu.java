package be.staker.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.ListSelectionModel;

public class MainMenu extends JFrame{
	
	
	
	
	
	
	
	
	public MainMenu() {
		
		super("Main Menu");

		setSize(500, 650);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(18, 134, 242, 305);
		panel.add(list);
		
		JLabel lblNewLabel = new JLabel("StakeScape");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(165, 11, 161, 118);
		panel.add(lblNewLabel);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(190, 485, 89, 23);
		panel.add(btnStart);
		
		setVisible(true);
		
	
		
		
	}
}
