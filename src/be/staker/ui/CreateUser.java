package be.staker.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateUser extends JFrame {
	private JTextField textField;

	public CreateUser() {
		super("Setting up account");

		setSize(300, 200);
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(11, 59, 70, 26);
		getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(89, 62, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		
		setVisible(true);

	}
}
