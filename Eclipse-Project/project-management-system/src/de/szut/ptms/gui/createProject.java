package de.szut.ptms.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SpinnerDateModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextArea;

public class createProject extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2443995693734521293L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createProject frame = new createProject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public createProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProjectName = new JLabel("Project Name:");
		lblProjectName.setBounds(10, 11, 87, 14);
		contentPane.add(lblProjectName);
		
		textField = new JTextField();
		textField.setBounds(10, 31, 161, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblKeyword = new JLabel("Keyword:");
		lblKeyword.setBounds(194, 11, 86, 14);
		contentPane.add(lblKeyword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 31, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblProjectLeader = new JLabel("Project Leader:");
		lblProjectLeader.setBounds(10, 62, 87, 14);
		contentPane.add(lblProjectLeader);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(485, 427, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				TODO
				System.out.println("Back");
			}
		});
		contentPane.add(btnBack);
		
		JLabel lblProjectMember = new JLabel("Choose Project Member:");
		lblProjectMember.setBounds(10, 135, 224, 14);
		contentPane.add(lblProjectMember);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 156, 247, 93);
		contentPane.add(scrollPane_1);
		
		String[] member = {"hi", "ho", "he", "ha", "hu", "chip", "golem", "heise"};
		
		final JList<?> list_1 = new JList<Object>(member);
		scrollPane_1.setViewportView(list_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TODO
				System.out.println("Add " + list_1.getSelectedValue());
				String listMember = (String) list_1.getSelectedValue();
//				memberList.add(listMember);
			}
		});
		btnAdd.setBounds(267, 226, 89, 23);
		contentPane.add(btnAdd);
		
		String[] leader = {"hi", "ho", "he", "ha", "hu", "chip", "golem", "heise"};
		
		JComboBox<?> comboBox = new JComboBox<Object>(leader);
		comboBox.setBounds(10, 87, 247, 30);
		contentPane.add(comboBox);
		
		SpinnerDateModel sdm = new SpinnerDateModel();
		JSpinner spinner = new JSpinner(sdm);
		spinner.setEditor(new DateEditor(spinner,"dd.MM.yyyy"));
		spinner.setBounds(10, 285, 247, 20);
		contentPane.add(spinner);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(10, 260, 76, 14);
		contentPane.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(10, 316, 87, 14);
		contentPane.add(lblEndDate);
		
		SpinnerDateModel sdm_1 = new SpinnerDateModel();
		JSpinner spinner_1 = new JSpinner(sdm_1);
		spinner_1.setEditor(new DateEditor(spinner_1,"dd.MM.yyyy"));
		spinner_1.setBounds(10, 341, 247, 20);
		contentPane.add(spinner_1);
		
		JLabel lblProjectDescription = new JLabel("Project Description:");
		lblProjectDescription.setBounds(317, 11, 125, 14);
		contentPane.add(lblProjectDescription);
//		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(317, 29, 257, 163);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
//		textArea.setBorder(border);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(382, 427, 89, 23);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				TODO
				System.out.println("create");
//				System.out.println(textArea.getText());
				System.out.println(textField.getText() + " with Keyword: " + textField_1.getText());
				
			}
		});
		contentPane.add(btnCreate);
		
		String[] memberList = {"hi", "ho", "he", "ha", "hu", "chip", "golem", "heise"};
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setBounds(366, 225, 208, 184);
//		textArea_1.setText();
//		textArea_1.setFont(memberList);
		contentPane.add(textArea_1);
		
		
	

	}
}
