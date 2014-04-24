package de.szut.ptms.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;

import java.awt.Dimension;

import javax.swing.JToolBar;

import java.awt.ComponentOrientation;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextArea;

import java.awt.SystemColor;

import de.szut.dataLayer.sqlite.*;
import de.szut.ptms.CurrentProject.*;
import de.szut.ptms.authentication.Authenticator;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



class BoxMainGui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final BoxMainGui MAIN = null;

	private CardLayout cardLayout = new CardLayout();
	private JPasswordField pwdBioBrause;
	private JTextField txtLoginName, txtProjectname, txtKeyword;
	private JLabel lblProjectLeader, lblChooseprojectmember,
			lblProjectDescribtion;
	private JTextField txtErstellerAusDatenbank, txtEmail, txtNachname, txtCall,
			txtVorname, txtBetreff, txtTelefonnummerEingeben, txtUsername;
	private JPanel pMain, pLogin, pChooseProject, pCreateProject,
			pCreateMember, pCreateTicket, pProjectOverview;
	private JPasswordField pwdPfpassword;
	private JTextField txtTicketBetreff;
	private JTextField txtTicketErsteller;
	private JTextField txtTicketTeleNr;
	private JTextField txtTicketEmail;
	private JTextField txtTxtemailshow;
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private JTextField txtlblMessage;
	private Statement statement;
	ArrayList<ArrayList<String>> arrayChooseProject = new ArrayList<>();
	ConnectionSqlite connection = new ConnectionSqlite();
	@SuppressWarnings("rawtypes")
	private JList liChooseProjectMember, liChoosenMember;
	@SuppressWarnings("rawtypes")
	private DefaultListModel lmChooseProjectMember = new DefaultListModel();
	@SuppressWarnings("rawtypes")
	private DefaultListModel lmChoosenProjectMember = new DefaultListModel();
	final Authenticator authenticator = new Authenticator();
	final CurrentProject currentproject = new CurrentProject();
	public static void main(String[] args) {
		// Hier wird das Hauptfenster sichtbar gemacht
		BoxMainGui main = new BoxMainGui();
		main.pack();
		main.setLocationByPlatform(true);
		main.setVisible(true);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BoxMainGui() {

		setMinimumSize(new Dimension(1280, 720));
		// --------------------------------------------------------------------------//
		// Rahmenframe wird definiert
		// --------------------------------------------------------------------------//
		setSize(new Dimension(1280, 720));
		setResizable(false);
		setTitle("Skayo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		// --------------------------------------------------------------------------//
		// Toolbar
		// --------------------------------------------------------------------------//
		JToolBar toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		toolBar.setBorder(new MatteBorder(1, 1, 1, 1,
				(Color) new Color(0, 0, 0)));
		toolBar.setMinimumSize(new Dimension(1280, 50));
		toolBar.setMaximumSize(new Dimension(1280, 50));
		toolBar.setPreferredSize(new Dimension(1280, 50));
		toolBar.setName("");
		getContentPane().add(toolBar, BorderLayout.NORTH);

		// Login Button soll aus PanelLogin aktualisiert werden

		// --------------------------------------------------------------------------//
		// LoginButton
		// --------------------------------------------------------------------------//
		final JLabel btnLogin = new JLabel("Authentification");
		btnLogin.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.setInheritsPopupMenu(true);
		btnLogin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnLogin.setMaximumSize(new Dimension(100, 120));
		btnLogin.setMinimumSize(new Dimension(100, 120));
		btnLogin.setPreferredSize(new Dimension(100, 120));
		btnLogin.setSize(new Dimension(100, 120));
		toolBar.add(btnLogin);

		// "Project Name" muss durch dann ausgewählten Projectnamen ausgetauscht
		// werden, bis Project noch nichts ausgewählt auf unsichtbar
		final JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lblProjectName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjectName.setMaximumSize(new Dimension(200, 120));
		lblProjectName.setVisible(false);
		
		
		// --------------------------------------------------------------------------//
		// Label Username
		// muss aktualisiert werden
		// --------------------------------------------------------------------------//
				
		final JLabel lblUserName = new JLabel("User Name");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserName
		.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lblUserName.setMaximumSize(new Dimension(200, 120));
		toolBar.add(lblUserName);
		lblUserName.setVisible(false);
		toolBar.add(lblProjectName);
		

		// --------------------------------------------------------------------------//
		// ChooseProject
		// --------------------------------------------------------------------------//

		final JButton btnChooseProject = new JButton("Choose Project");
		btnChooseProject.setBackground(Color.CYAN);
		btnChooseProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pMain, "ChooseProject");
			}
		});
		btnChooseProject.setMaximumSize(new Dimension(100, 120));
		btnChooseProject.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnChooseProject.setVisible(false);
		
		// --------------------------------------------------------------------------//
		// lbl Project Keyword
		// --------------------------------------------------------------------------//
		
		final JLabel lblProjectKeyword = new JLabel("Project Keyword");
		lblProjectKeyword.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lblProjectKeyword.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProjectKeyword.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjectKeyword.setMaximumSize(new Dimension(200, 120));
		lblProjectKeyword.setVisible(false);
		toolBar.add(lblProjectKeyword);
		toolBar.add(btnChooseProject);
		

		// --------------------------------------------------------------------------//
		// CreateProject / NewProject
		// --------------------------------------------------------------------------//
		final JButton btnNewProject = new JButton("Create Project");
		btnNewProject.setBackground(Color.CYAN);
		btnNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pMain, "CreateProject");
			}
		});
		btnNewProject.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnNewProject.setMaximumSize(new Dimension(100, 120));
		btnNewProject.setPreferredSize(new Dimension(100, 50));
		btnNewProject.setVisible(false);
		toolBar.add(btnNewProject);
		// --------------------------------------------------------------------------//
		// New Ticket
		// --------------------------------------------------------------------------//
		final JButton btnNewTicket = new JButton("Create Ticket");
		btnNewTicket.setBackground(Color.CYAN);
		btnNewTicket.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnNewTicket.setActionCommand("New Ticket");
		btnNewTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pMain, "CreateTicket");
			}
		});
		btnNewTicket.setPreferredSize(new Dimension(100, 50));
		btnNewTicket.setMaximumSize(new Dimension(100, 120));
		btnNewTicket.setVisible(false);
		toolBar.add(btnNewTicket);
		
		// --------------------------------------------------------------------------//
		// Create User, 
		// wechselt automatisch auf das andere Feld
		// --------------------------------------------------------------------------//
		final JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.setBackground(Color.CYAN);
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pMain, "CreateMember");
			}
		});
		btnCreateUser.setMaximumSize(new Dimension(100, 100));
		btnCreateUser.setMinimumSize(new Dimension(91, 100));
		btnCreateUser.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCreateUser.setVisible(false);
		toolBar.add(btnCreateUser);
		
				// --------------------------------------------------------------------------//
				// LogoutButton
				// wechselt automatisch auf Login Bildschirm Person muss dann nur abgemeldet werden
				//
				// --------------------------------------------------------------------------//
				final JButton btnLogout = new JButton("Logout");
				btnLogout.setVisible(false);
				btnLogout.setBackground(Color.RED);
				btnLogout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cardLayout.show(pMain, "Login");
						txtLoginName.setText("");
						pwdBioBrause.setText("");
						lblUserName.setVisible(false);
						lblProjectName.setVisible(false);
						lblProjectKeyword.setVisible(false);
						txtlblMessage.setVisible(false);
						btnChooseProject.setVisible(false);
						btnCreateUser.setVisible(false);
						btnNewProject.setVisible(false);
						btnNewTicket.setVisible(false);
						btnLogout.setVisible(false);
						btnLogin.setVisible(true);
						
					}
				});
				btnLogout.setPreferredSize(new Dimension(100, 50));
				btnLogout.setMaximumSize(new Dimension(150, 120));
				btnLogout.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
						null, null));
				toolBar.add(btnLogout);

		// --------------------------------------------------------------------------//
		// pMain Hauptfenster mit CardLayout
		// --------------------------------------------------------------------------//

		pMain = new JPanel();
		pMain.setSize(new Dimension(1280, 670));
		getContentPane().add(pMain, BorderLayout.CENTER);
		pMain.setLayout(cardLayout);

		// --------------------------------------------------------------------------//
		// pMain Card: pLogin
		// --------------------------------------------------------------------------//

		pLogin = new JPanel();
		pMain.add(pLogin, "Login");

		JPanel panelLogin = new JPanel();
		panelLogin.setSize(new Dimension(1280, 620));
		pLogin.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(474, 131, 247, 38);
		pLogin.add(lblLogin);

		JLabel lblLoginName = new JLabel("Login Name :");
		lblLoginName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		lblLoginName.setBounds(414, 215, 106, 28);
		pLogin.add(lblLoginName);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		lblPassword.setBounds(414, 284, 116, 28);
		pLogin.add(lblPassword);

		
		// --------------------------------------------------------------------------//
		// PasswordField
		// muss ausgelesen werden, damit es geprüft wird
		// --------------------------------------------------------------------------//
		pwdBioBrause = new JPasswordField();
		pwdBioBrause.setBackground(Color.WHITE);
		pwdBioBrause.setHorizontalAlignment(SwingConstants.LEFT);
		pwdBioBrause.setEchoChar('*');
		pwdBioBrause.setBounds(576, 282, 200, 28);
		pLogin.add(pwdBioBrause);
		
		// --------------------------------------------------------------------------//
		// LoginnameField
		// muss ausgelesen werden, damit es geprüft wird und muss dann Oben in der Toolbar 
		// den Reiter Loginname überschreiben
		// Username wird ausgelesen für Toolbar
		// --------------------------------------------------------------------------//

		txtLoginName = new JTextField();
		
	
		
		txtLoginName.setHorizontalAlignment(SwingConstants.LEFT);
		txtLoginName.setBounds(576, 215, 200, 28);
		pLogin.add(txtLoginName);
		txtLoginName.setColumns(10);
		
		final JButton btnLogin_1 = new JButton("Login");
		btnLogin_1.setBackground(Color.GREEN);
		btnLogin_1.setForeground(Color.BLACK);
		btnLogin_1.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				
				authenticator.authenticateUser( txtLoginName.getText(), pwdBioBrause.getText());
				
				if (authenticator.logInOk == true)
				{
		
				lblUserName.setVisible(true);
				lblUserName.setText("Username: "+txtLoginName.getText());
				btnChooseProject.setVisible(true);
				btnCreateUser.setVisible(true);
				btnNewProject.setVisible(true);
				btnNewTicket.setVisible(true);
				btnLogout.setVisible(true);
				btnLogin.setVisible(false);
				cardLayout.show(pMain, "ChooseProject");
				}
					
			}
		}
		);
		btnLogin_1.setBounds(884, 412, 170, 69);
		pLogin.add(btnLogin_1);
		
		txtlblMessage = new JTextField();
		txtlblMessage.setFocusable(false);
		txtlblMessage.setVisible(false);
		txtlblMessage.setBorder(null);
		txtlblMessage.setBackground(new Color(255, 69, 0));
		txtlblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		txtlblMessage.setText("Your username or password is invalid, please try again.");
		txtlblMessage.setEditable(false);
		txtlblMessage.setBounds(405, 356, 387, 20);
		pLogin.add(txtlblMessage);
		txtlblMessage.setColumns(10);


		// --------------------------------------------------------------------------//
		// pMain Card: pChooseProject
		// --------------------------------------------------------------------------//

		pChooseProject = new JPanel();
		pMain.add(pChooseProject, "ChooseProject");
		

		pChooseProject.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		pChooseProject.setSize(new Dimension(1280, 620));
		pChooseProject.setLayout(new BorderLayout(0, 0));

		JLabel lblChooseproject = new JLabel("Please Choose a Project:");
		lblChooseproject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChooseproject.setHorizontalAlignment(SwingConstants.CENTER);
		pChooseProject.add(lblChooseproject, BorderLayout.NORTH);

		JScrollPane spChooseProject = new JScrollPane();
		pChooseProject.add(spChooseProject, BorderLayout.CENTER);

		connection.ConnectionSqliteIni();
		String queryProjectList = "SELECT projectname FROM project"; 
		ResultSet queryResults2 = null;
		try {
			queryResults2 = connection.statement.executeQuery(queryProjectList);
			ResultSetMetaData metadata = queryResults2.getMetaData();
			int numcols = metadata.getColumnCount();
			
			while (queryResults2.next()) {
				
				ArrayList<String> row = new ArrayList<>(numcols);
			    int i = 1;
			    while (i <= numcols) {
			    	row.add(queryResults2.getString(i++));
			    }
			    arrayChooseProject.add(row);
			    
			}
			
			//System.out.println(arrayChooseProject);
			
		}
		catch (SQLException e1) 
				{
					e1.printStackTrace();	
				}
	


		final JList liChooseProject = new JList(arrayChooseProject.toArray());
		liChooseProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2){
					
					int index = liChooseProject.getSelectedIndex();
					//System.out.println(index);
					
					currentproject.selectCurrentProject(index + 1);
					
//					System.out.println(liChooseProject.getSelectedValue());
					lblProjectName.setText("Project Name: "+liChooseProject.getSelectedValue());
					lblProjectName.setVisible(true);
					lblProjectKeyword.setText("Project Keyword: " /* TODO get DB */);
					lblProjectKeyword.setVisible(true);
					cardLayout.show(pMain, "ProjectOverview");
				}
			}
		});
		
		pChooseProject.add(liChooseProject);
		

		// --------------------------------------------------------------------------//
		// pMain Card: pCreateProject
		// --------------------------------------------------------------------------//

		pCreateProject = new JPanel();
		pMain.add(pCreateProject, "CreateProject");

		pCreateProject.setSize(new Dimension(1280, 620));
		pCreateProject.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		pCreateProject.setLayout(null);

		JLabel lblProjectname = new JLabel("Projectname : ");
		lblProjectname.setBounds(33, 29, 132, 46);
		pCreateProject.add(lblProjectname);

		txtProjectname = new JTextField();
		txtProjectname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (txtProjectname.getText().equals(
						"Please enter a projectname"))
					txtProjectname.setText("");
			}
		});
		txtProjectname.setText("Please enter a projectname");
		txtProjectname.setBounds(204, 42, 188, 20);
		pCreateProject.add(txtProjectname);
		txtProjectname.setColumns(10);

		JLabel lblKeyword = new JLabel("Keyword:");
		lblKeyword.setBounds(516, 45, 72, 17);
		pCreateProject.add(lblKeyword);

		txtKeyword = new JTextField();
		txtKeyword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (txtKeyword.getText().equals("Please enter a keyword"))
					txtKeyword.setText("");
			}
		});
		txtKeyword.setText("Please enter a keyword");
		txtKeyword.setBounds(614, 42, 139, 20);
		pCreateProject.add(txtKeyword);
		txtKeyword.setColumns(10);

		lblProjectDescribtion = new JLabel("Project Describtion:");
		lblProjectDescribtion.setBounds(796, 45, 121, 14);
		pCreateProject.add(lblProjectDescribtion);

		lblProjectLeader = new JLabel("Project Leader:");
		lblProjectLeader.setBounds(33, 161, 132, 14);
		pCreateProject.add(lblProjectLeader);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"ProjectLeader einf\u00FCgen", "ProjectLeader einf\u00FCgen2" }));
		comboBox.setBounds(204, 158, 188, 20);
		pCreateProject.add(comboBox);

		lblChooseprojectmember = new JLabel("ChooseProjectMember");
		lblChooseprojectmember.setBounds(33, 248, 216, 14);
		pCreateProject.add(lblChooseprojectmember);

		JScrollPane spChooseProjectMember = new JScrollPane();
		spChooseProjectMember.setBounds(33, 273, 369, 162);
		pCreateProject.add(spChooseProjectMember);

		lmChooseProjectMember.addElement("test1");

		liChooseProjectMember = new JList(lmChooseProjectMember);
		liChooseProjectMember
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liChooseProjectMember.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					lmChoosenProjectMember.addElement(liChooseProjectMember
							.getSelectedValue());
					lmChooseProjectMember.removeElement(liChooseProjectMember
							.getSelectedValue());
				}
			}
		});

		spChooseProjectMember.setViewportView(liChooseProjectMember);

		JScrollPane spChoosenMember = new JScrollPane();
		spChoosenMember.setBounds(516, 273, 369, 162);
		pCreateProject.add(spChoosenMember);

		lmChoosenProjectMember.addElement("test2");
		liChoosenMember = new JList(lmChoosenProjectMember);

		liChoosenMember.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liChoosenMember.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					lmChooseProjectMember.addElement(liChoosenMember
							.getSelectedValue());
					lmChoosenProjectMember.removeElement(liChoosenMember
							.getSelectedValue());
				}
			}
		});

		spChoosenMember.setViewportView(liChoosenMember);

		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(33, 466, 83, 14);
		pCreateProject.add(lblStartDate);

		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(33, 540, 83, 14);
		pCreateProject.add(lblEndDate);

		JSpinner spStartDate = new JSpinner(new SpinnerDateModel(new Date(),
				null, null, Calendar.MONTH));
		spStartDate
				.setEditor(new JSpinner.DateEditor(spStartDate, "dd.MM.yyyy"));
		spStartDate.setBounds(33, 488, 206, 20);
		pCreateProject.add(spStartDate);

		JSpinner spEndDate = new JSpinner(new SpinnerDateModel(new Date(),
				null, null, Calendar.MONTH));
		spEndDate.setEditor(new JSpinner.DateEditor(spEndDate, "dd.MM.yyyy"));
		spEndDate.setBounds(33, 565, 206, 20);
		pCreateProject.add(spEndDate);

		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Create project
			}
		});
		button.setBounds(1113, 569, 121, 40);
		pCreateProject.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(927, 40, 307, 235);
		pCreateProject.add(scrollPane);
		JTextArea txtAreaDescript = new JTextArea();
		scrollPane.setViewportView(txtAreaDescript);
		txtAreaDescript.setLineWrap(true);
		txtAreaDescript.setWrapStyleWord(true);

		JLabel lblAdd = new JLabel("Add ->");
		lblAdd.setBounds(432, 342, 46, 14);
		pCreateProject.add(lblAdd);



		// --------------------------------------------------------------------------//
		// pMain Card: pCreateTicket
		// --------------------------------------------------------------------------//

		pCreateTicket = new JPanel();
		pMain.add(pCreateTicket, "CreateTicket");

		pCreateTicket.setSize(new Dimension(1280, 620));
		pCreateTicket.setLayout(null);

		JLabel lblErsteller = new JLabel("Creator :");
		lblErsteller.setBounds(10, 27, 86, 14);
		pCreateTicket.add(lblErsteller);

		txtErstellerAusDatenbank = new JTextField();
		txtErstellerAusDatenbank.setEditable(false);
		txtErstellerAusDatenbank.setBounds(123, 24, 214, 20);
		pCreateTicket.add(txtErstellerAusDatenbank);
		txtErstellerAusDatenbank.setColumns(10);
		txtErstellerAusDatenbank.setText(txtLoginName.getText());

		JLabel lblTelefon = new JLabel("Mobile :");
		lblTelefon.setBounds(10, 62, 86, 14);
		pCreateTicket.add(lblTelefon);

		txtTelefonnummerEingeben = new JTextField();
		txtTelefonnummerEingeben.setEditable(false);
		txtTelefonnummerEingeben.setBounds(123, 59, 214, 20);
		pCreateTicket.add(txtTelefonnummerEingeben);
		txtTelefonnummerEingeben.setColumns(10);

		JLabel lblBetreff = new JLabel("Head :");
		lblBetreff.setBounds(537, 27, 86, 14);
		pCreateTicket.add(lblBetreff);

		txtBetreff = new JTextField();
		txtBetreff.setBounds(682, 24, 500, 20);
		pCreateTicket.add(txtBetreff);
		txtBetreff.setColumns(10);

		JLabel lblBeschreibung = new JLabel("Description :");
		lblBeschreibung.setBounds(537, 62, 98, 14);
		pCreateTicket.add(lblBeschreibung);

		JLabel lblProject = new JLabel("Project :");
		lblProject.setBounds(10, 143, 86, 14);
		pCreateTicket.add(lblProject);

		JComboBox<?> cbChooseProject = new JComboBox();
		cbChooseProject.setBounds(123, 140, 214, 20);
		pCreateTicket.add(cbChooseProject);
		
		JButton btnSave_2 = new JButton("Save");
		btnSave_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TODO Save Create Ticket
			}
		});
		btnSave_2.setBounds(1113, 569, 121, 40);
		pCreateTicket.add(btnSave_2);
		
		JScrollPane scrollCreateTciketDescript = new JScrollPane();
		scrollCreateTciketDescript.setBounds(682, 57, 500, 419);
		pCreateTicket.add(scrollCreateTciketDescript);
		
		JTextArea textAreaCreateTicketDescript = new JTextArea();
		textAreaCreateTicketDescript.setLineWrap(true);
		textAreaCreateTicketDescript.setWrapStyleWord(true);
		scrollCreateTciketDescript.setViewportView(textAreaCreateTicketDescript);
		
		JLabel lblLblmailschow = new JLabel("E-Mail :");
		lblLblmailschow.setBounds(10, 101, 86, 14);
		pCreateTicket.add(lblLblmailschow);
		
		txtTxtemailshow = new JTextField();
		txtTxtemailshow.setEditable(false);
		txtTxtemailshow.setBounds(123, 98, 214, 20);
		pCreateTicket.add(txtTxtemailshow);
		txtTxtemailshow.setColumns(10);


		// --------------------------------------------------------------------------//
		// pMain CardLayout pProjectOverview
		// --------------------------------------------------------------------------//

		pProjectOverview = new JPanel();
		pMain.add(pProjectOverview, "ProjectOverview");
		
		pProjectOverview.setSize(new Dimension(1280, 620));
		pProjectOverview.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(26, 325, 309, 207);
		pProjectOverview.add(scrollPane_2);
		
		final JList liTickets = new JList();
		scrollPane_2.setViewportView(liTickets);
		liTickets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2){
//					TODO getSelectedValue();
//					System.out.println(liTickets.getSelectedValue());
//					lblProjectName.setText("Project Name: "+liChooseProject.getSelectedValue());
//					lblProjectName.setVisible(true);
					cardLayout.show(pMain, "ShowTicket");
				}
			}
			
		});
		
		liTickets.setModel(new AbstractListModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 2232864372444372607L;
			String[] values = new String[] {
					"Insert ProjectlistInsert Projectlist",
					"Insert Projectlist", "Insert Projectlist",
					"Insert Projectlist", "TestProject",
					"Insert Projectlist", "Insert Projectlist",
					"Insert Projectlist", "ChooseProject",
					"Insert Projectlist" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		
		
		JLabel lblProjektBeschreibung = new JLabel("Project Description : ");
		lblProjektBeschreibung.setBounds(26, 11, 134, 22);
		pProjectOverview.add(lblProjektBeschreibung);
		
		JLabel lblTickets = new JLabel("Tickets :");
		lblTickets.setBounds(26, 300, 90, 14);
		pProjectOverview.add(lblTickets);
		
		JLabel lblMitglieder = new JLabel("Member : ");
		lblMitglieder.setBounds(441, 13, 63, 18);
		pProjectOverview.add(lblMitglieder);
		
		JLabel lblProjektLeiter = new JLabel("Project Leader :");
		lblProjektLeiter.setBounds(792, 13, 97, 18);
		pProjectOverview.add(lblProjektLeiter);
		
		JTextField txtProjektLeiter = new JTextField();
		txtProjektLeiter.setEditable(false);
		txtProjektLeiter.setText("Projekt Leiter");
		txtProjektLeiter.setBounds(792, 41, 267, 22);
		pProjectOverview.add(txtProjektLeiter);
		txtProjektLeiter.setColumns(10);
		
		JLabel lblStart = new JLabel("Project Start :");
		lblStart.setBounds(782, 102, 107, 22);
		pProjectOverview.add(lblStart);
		
		JLabel lblEnd = new JLabel("Project End :");
		lblEnd.setBounds(952, 102, 107, 22);
		pProjectOverview.add(lblEnd);
		
		txtStartTime = new JTextField();
		txtStartTime.setEditable(false);
		txtStartTime.setBounds(782, 135, 160, 20);
		pProjectOverview.add(txtStartTime);
		txtStartTime.setColumns(10);
		
		txtEndTime = new JTextField();
		txtEndTime.setEditable(false);
		txtEndTime.setColumns(10);
		txtEndTime.setBounds(952, 135, 160, 20);
		pProjectOverview.add(txtEndTime);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(26, 40, 369, 249);
		pProjectOverview.add(scrollPane_4);
		
		JTextArea textAreaProDescript = new JTextArea();
		textAreaProDescript.setBackground(SystemColor.control);
		textAreaProDescript.setEditable(false);
		textAreaProDescript.setWrapStyleWord(true);
		textAreaProDescript.setLineWrap(true);
		scrollPane_4.setViewportView(textAreaProDescript);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(441, 42, 292, 247);
		pProjectOverview.add(scrollPane_3);
		
		JList list = new JList();
		list.setBackground(SystemColor.control);
		scrollPane_3.setViewportView(list);
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (arg0.getClickCount() == 2){
//				System.out.println(liChooseProject.getSelectedValue());
//				lblProjectName.setText("Project Name: "+liChooseProject.getSelectedValue());
//				lblProjectName.setVisible(true);
//				cardLayout.show(pMain, "ProjectOverview");
//			}
//		}


		// --------------------------------------------------------------------------//
		// pMain CardLayout pCreateMember
		// --------------------------------------------------------------------------//

		pCreateMember = new JPanel();
		pMain.add(pCreateMember, "CreateMember");
		pCreateMember.setLayout(null);

		JLabel lblCreateMember = new JLabel("Create User");
		lblCreateMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateMember.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreateMember.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		lblCreateMember.setBounds(523, 37, 162, 21);
		pCreateMember.add(lblCreateMember);

		JLabel lblVorname = new JLabel("First Name :");
		lblVorname.setHorizontalAlignment(SwingConstants.CENTER);
		lblVorname.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		lblVorname.setBounds(355, 146, 139, 21);
		pCreateMember.add(lblVorname);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		lblUsername.setBounds(355, 93, 139, 21);
		pCreateMember.add(lblUsername);

		JLabel lblNachname = new JLabel("Second Name :");
		lblNachname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNachname.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		lblNachname.setBounds(355, 202, 139, 21);
		pCreateMember.add(lblNachname);

		JLabel lblEmail = new JLabel("E-Mail :");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		lblEmail.setBounds(355, 258, 139, 21);
		pCreateMember.add(lblEmail);
		
		JLabel lblCall = new JLabel("Mobile :");
		lblCall.setHorizontalAlignment(SwingConstants.CENTER);
		lblCall.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		lblCall.setBounds(355, 308, 139, 21);
		pCreateMember.add(lblCall);

		JLabel lblBerechtigungsgruppe = new JLabel("Authorization Group :");
		lblBerechtigungsgruppe.setHorizontalAlignment(SwingConstants.CENTER);
		lblBerechtigungsgruppe.setBorder(new BevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		lblBerechtigungsgruppe.setBounds(355, 407, 139, 21);
		pCreateMember.add(lblBerechtigungsgruppe);

		txtVorname = new JTextField();
		txtVorname.setBounds(571, 146, 231, 20);
		pCreateMember.add(txtVorname);
		txtVorname.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(571, 93, 231, 20);
		pCreateMember.add(txtUsername);
		txtUsername.setColumns(10);

		txtNachname = new JTextField();
		txtNachname.setBounds(571, 202, 231, 20);
		pCreateMember.add(txtNachname);
		txtNachname.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(571, 258, 231, 20);
		pCreateMember.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCall = new JTextField();
		txtCall.setBounds(571, 308, 231, 20);
		pCreateMember.add(txtCall);
		txtCall.setColumns(10);

		JComboBox cbBerechtigungsgruppe = new JComboBox();
		cbBerechtigungsgruppe.setModel(new DefaultComboBoxModel(new String[] {
				"Member", "Admin" }));
		cbBerechtigungsgruppe.setBounds(571, 407, 231, 21);
		pCreateMember.add(cbBerechtigungsgruppe);
		
		JButton btnSave_3 = new JButton("Save");
		btnSave_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				TODO Save create User
			}
		});
		btnSave_3.setBounds(1113, 569, 121, 40);
		pCreateMember.add(btnSave_3);
		
		JLabel lblPasswort = new JLabel("Password :");
		lblPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswort.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblPasswort.setBounds(355, 360, 139, 21);
		pCreateMember.add(lblPasswort);
		
		pwdPfpassword = new JPasswordField();
		pwdPfpassword.setHorizontalAlignment(SwingConstants.LEFT);
		pwdPfpassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pwdPfpassword.setEchoChar('*');
		pwdPfpassword.setText("BIO BRAUSE");
		pwdPfpassword.setBounds(571, 359, 231, 21);
		pCreateMember.add(pwdPfpassword);
		
		JPanel pShowTickets = new JPanel();
		pShowTickets.setSize(new Dimension(1280, 720));
		pShowTickets.setMinimumSize(new Dimension(1280, 720));
		pShowTickets.setMaximumSize(new Dimension(1280, 720));
		pMain.add(pShowTickets, "ShowTicket");
		pShowTickets.setLayout(null);
		
		JLabel lblTicketbetreff = new JLabel("Ticket Head :");
		lblTicketbetreff.setBounds(10, 28, 147, 24);
		pShowTickets.add(lblTicketbetreff);
		
		txtTicketBetreff = new JTextField();
		txtTicketBetreff.setEditable(false);
		txtTicketBetreff.setBounds(106, 30, 404, 20);
		pShowTickets.add(txtTicketBetreff);
		txtTicketBetreff.setColumns(10);
		
		JLabel lblTicketBeschreibung = new JLabel("Ticket Description :");
		lblTicketBeschreibung.setBounds(10, 83, 127, 24);
		pShowTickets.add(lblTicketBeschreibung);
		
		JLabel lblErstellername = new JLabel("Creator : ");
		lblErstellername.setBounds(604, 33, 97, 19);
		pShowTickets.add(lblErstellername);
		
		JLabel lblTelefonnummer = new JLabel("Mobile :");
		lblTelefonnummer.setBounds(604, 88, 78, 19);
		pShowTickets.add(lblTelefonnummer);
		
		txtTicketErsteller = new JTextField();
		txtTicketErsteller.setEditable(false);
		txtTicketErsteller.setBounds(692, 30, 300, 20);
		pShowTickets.add(txtTicketErsteller);
		txtTicketErsteller.setColumns(10);
		
		txtTicketTeleNr = new JTextField();
		txtTicketTeleNr.setEditable(false);
		txtTicketTeleNr.setBounds(692, 85, 300, 20);
		pShowTickets.add(txtTicketTeleNr);
		txtTicketTeleNr.setColumns(10);
		
		JLabel lblEmail_1 = new JLabel("E-Mail:");
		lblEmail_1.setBounds(604, 134, 78, 14);
		pShowTickets.add(lblEmail_1);
		
		txtTicketEmail = new JTextField();
		txtTicketEmail.setEditable(false);
		txtTicketEmail.setBounds(692, 131, 300, 20);
		pShowTickets.add(txtTicketEmail);
		txtTicketEmail.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(604, 181, 78, 14);
		pShowTickets.add(lblStatus);
		
		final JComboBox cbTicketStatus = new JComboBox();
		cbTicketStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(cbTicketStatus.getSelectedItem());
//				TODO Status Ticket Changed (SAVE)
			}
		});
		cbTicketStatus.setModel(new DefaultComboBoxModel(new String[] {"Open", "Focused", "Closed"}));
		cbTicketStatus.setBounds(692, 179, 300, 24);
		pShowTickets.add(cbTicketStatus);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 118, 500, 350);
		pShowTickets.add(scrollPane_1);
		
		JTextArea textAreaTicketDescriptShow = new JTextArea();
		textAreaTicketDescriptShow.setWrapStyleWord(true);
		textAreaTicketDescriptShow.setEditable(false);
		textAreaTicketDescriptShow.setBackground(SystemColor.control);
		textAreaTicketDescriptShow.setLineWrap(true);
		scrollPane_1.setViewportView(textAreaTicketDescriptShow);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
