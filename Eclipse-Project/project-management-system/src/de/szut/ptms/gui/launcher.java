/**
 * 
 */
package de.szut.ptms.gui;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import de.szut.ptms.authentication.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import de.szut.ptms.authentication.Authentication;


/**
 * @author Robin Remmers
 *
 */
public class launcher extends JFrame {

	//JLabels
	JLabel authname;
	JLabel password;

	
	//Buttons
	JButton btnLogIn = new JButton("LogIn");
	
	//JTextField
	JTextField LogInNameText = new JTextField(30);
	JPasswordField LogInPWText = new JPasswordField(30);
	Authentication authentication = new Authentication();

	private BufferedImage image;
	public launcher() {
		
		//BackGround Picture
		
		try {
			image = ImageIO.read(new File("D:/EclipseWorkspace/project-management-system/src/de/szut/ptms/gui/red.jpg"));
			// Set your Image Here.
			this.setContentPane(new JLabel(new ImageIcon(image)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//JFrame Settings
		setLayout(null);
		setSize(1280,720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Projekt- und Ticketmanagementsystem - Authentication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//LogIn-Button Settings
	    btnLogIn.setBounds(720, 270, 80, 25);
	    add(btnLogIn);
	    
	    btnLogIn.addActionListener(new ActionListener() { 
	    	public void actionPerformed(ActionEvent e) { 
	    		String inputAuthName = LogInNameText.getText();
	    		String inputPWName = LogInPWText.getText();

				authentication.AuthUser(inputAuthName, inputPWName);
		
		
	    		} 
	    	});
	    
	    //JTextField
	    LogInNameText.setBounds(550, 220, 150, 25);
	    LogInPWText.setBounds(550, 270, 150, 25);
	    add(LogInNameText);
	    add(LogInPWText);

	    
	    // JLabel Settings
		authname = new JLabel("Anmeldename: ");
		authname.setForeground(Color.WHITE); 
		authname.setBounds(450, 130, 100, 200);
		add(authname);
		
		password = new JLabel("Passwort: ");
		password.setForeground(Color.WHITE); 
		password.setBounds(450, 180, 200, 200);
		add(password);
		
		setVisible(true);
		
		
		
	}
}
