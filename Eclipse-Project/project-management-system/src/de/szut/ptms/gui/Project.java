package de.szut.ptms.gui;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextArea;


public class Project extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2945227968188389999L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project frame = new Project();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	public void createProject(){
//		JPanel contentPane1;
//		JTextField textField;
//		JTextField textField_1;
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 600, 500);
//		contentPane1 = new JPanel();
//		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane1);
//		contentPane1.setLayout(null);
//		
//		JLabel lblProjectName = new JLabel("Project Name:");
//		lblProjectName.setBounds(10, 11, 87, 14);
//		contentPane1.add(lblProjectName);
//		
//		textField = new JTextField();
//		textField.setBounds(10, 31, 161, 20);
//		contentPane1.add(textField);
//		textField.setColumns(10);
//		
//		JLabel lblKeyword = new JLabel("Keyword:");
//		lblKeyword.setBounds(194, 11, 86, 14);
//		contentPane1.add(lblKeyword);
//		
//		textField_1 = new JTextField();
//		textField_1.setBounds(194, 31, 86, 20);
//		contentPane1.add(textField_1);
//		textField_1.setColumns(10);
//		
//		JLabel lblProjectLeader = new JLabel("Project Leader:");
//		lblProjectLeader.setBounds(10, 62, 87, 14);
//		contentPane1.add(lblProjectLeader);
//		
//		JButton btnBack = new JButton("Back");
//		btnBack.setBounds(485, 427, 89, 23);
//		btnBack.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
////				TODO
//				System.out.println("Back");
//			}
//		});
//		contentPane1.add(btnBack);
//		
//		JLabel lblProjectMember = new JLabel("Project Member:");
//		lblProjectMember.setBounds(10, 135, 115, 14);
//		contentPane1.add(lblProjectMember);
//		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(10, 156, 247, 93);
//		contentPane1.add(scrollPane_1);
//		
//		String[] member = {"hi", "ho", "he", "ha", "hu", "chip", "golem", "heise"};
//		
//		final JList<?> list_1 = new JList<Object>(member);
//		scrollPane_1.setViewportView(list_1);
//		
//		JButton btnAdd = new JButton("Add");
//		btnAdd.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				TODO
//				System.out.println("Add " + list_1.getSelectedValue());
//			}
//		});
//		btnAdd.setBounds(267, 226, 89, 23);
//		contentPane1.add(btnAdd);
//		
//		String[] leader = {"hi", "ho", "he", "ha", "hu", "chip", "golem", "heise"};
//		
//		JComboBox<?> comboBox = new JComboBox<Object>(leader);
//		comboBox.setBounds(10, 87, 247, 30);
//		contentPane1.add(comboBox);
//		
//		SpinnerDateModel sdm = new SpinnerDateModel();
//		JSpinner spinner = new JSpinner(sdm);
//		spinner.setEditor(new DateEditor(spinner,"dd.MM.yyyy"));
//		spinner.setBounds(10, 285, 247, 20);
//		contentPane1.add(spinner);
//		
//		JLabel lblStartDate = new JLabel("Start Date:");
//		lblStartDate.setBounds(10, 260, 76, 14);
//		contentPane1.add(lblStartDate);
//		
//		JLabel lblEndDate = new JLabel("End Date:");
//		lblEndDate.setBounds(10, 316, 87, 14);
//		contentPane1.add(lblEndDate);
//		
//		SpinnerDateModel sdm_1 = new SpinnerDateModel();
//		JSpinner spinner_1 = new JSpinner(sdm_1);
//		spinner_1.setEditor(new DateEditor(spinner_1,"dd.MM.yyyy"));
//		spinner_1.setBounds(10, 341, 247, 20);
//		contentPane1.add(spinner_1);
//		
//		JLabel lblProjectDescription = new JLabel("Project Description:");
//		lblProjectDescription.setBounds(317, 11, 125, 14);
//		contentPane1.add(lblProjectDescription);
//		
//		final JTextArea textArea = new JTextArea();
//		textArea.setWrapStyleWord(true);
//		textArea.setLineWrap(true); 
//		textArea.setBounds(317, 29, 257, 163);
//		Border border = BorderFactory.createLineBorder(Color.BLACK);
//		textArea.setBorder(border);
//		contentPane1.add(textArea);
//		
//		JButton btnCreate = new JButton("Create");
//		btnCreate.setBounds(382, 427, 89, 23);
//		btnCreate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
////				TODO
//				System.out.println("create");
//				System.out.println(textArea.getText());
//				
//			}
//		});
//		contentPane1.add(btnCreate);
//
//	}
	

	/**
	 * Create the frame.
	 */
	public Project() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseYourProject = new JLabel("Choose your project:");
		lblChooseYourProject.setBounds(10, 11, 126, 14);
		contentPane.add(lblChooseYourProject);
		
		String[] projects = {"hi", "ho", "he", "ha", "hu", "chip", "golem", "heise"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 247, 122);
		contentPane.add(scrollPane);
		JList<?> list = new JList<Object>(projects);
		scrollPane.setViewportView(list);
		
		JButton btnCreateProject = new JButton("Create Project");
		btnCreateProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				TODO
				System.out.println("Create");
//				createProject.main(null);
//				dispose();
//				createProject();
				dispose();
				CreateProjectFrame.main(null);
				
			}
		});
		btnCreateProject.setBounds(263, 414, 139, 23);
		contentPane.add(btnCreateProject);
	}
}
