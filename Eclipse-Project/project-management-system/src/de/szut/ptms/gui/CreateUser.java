package de.szut.ptms.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class CreateUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -143516077413362439L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser frame = new CreateUser();
					frame.setVisible(true);
					frame.setTitle("Create User");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				if(passwordField.getPassword() == passwordField_1.getPassword()){
					txtUserName.getText();
					passwordField.getPassword();
//				}else{
//					JOptionPane.showMessageDialog(null, "Passwords not equal",
//							"Error", JOptionPane.ERROR_MESSAGE);
//				}
				
			}
		});
		btnCreateUser.setBounds(346, 328, 112, 29);
		contentPane.add(btnCreateUser);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setBounds(468, 328, 107, 29);
		contentPane.add(btnCancel);
		
		JLabel lblSetUsername = new JLabel("Set Username:");
		lblSetUsername.setBounds(10, 21, 121, 14);
		contentPane.add(lblSetUsername);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(10, 46, 195, 29);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblSetPassword = new JLabel("Set Password:");
		lblSetPassword.setBounds(10, 86, 121, 14);
		contentPane.add(lblSetPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 111, 195, 29);
		contentPane.add(passwordField);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(10, 151, 161, 14);
		contentPane.add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(10, 176, 195, 29);
		contentPane.add(passwordField_1);
	}
}
