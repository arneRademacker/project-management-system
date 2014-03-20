/**
 * 
 */
package de.szut.ptms.gui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;

import de.szut.ptms.authentication.Authenticator;

/**
 * @author Robin Remmers
 * @author Arne Rademacker
 * 
 */
public class Launcher extends JFrame {

	private static final long serialVersionUID = -4738430971086961083L;

	// JLabels
	JLabel authnameLabel;
	JLabel passwordLabel;

	// Buttons
	JButton loginButton = new JButton("LogIn");

	// JTextField
	JTextField loginNameText = new JTextField(30);
	JPasswordField loginPWText = new JPasswordField(30);
	Authenticator authenticator = new Authenticator();

	private BufferedImage backgroundImage;

	public Launcher() {

		try {
			backgroundImage = ImageIO.read(new File("assets/red.jpg"));
			this.setContentPane(new JLabel(new ImageIcon(backgroundImage)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// JFrame Settings
		setLayout(null);
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Projekt- und Ticketmanagementsystem - Authentication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// LogIn-Button Settings
		loginButton.setBounds(720, 270, 80, 25);
		add(loginButton);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputAuthName = loginNameText.getText();
				String inputPWName = loginPWText.getText();

				authenticator.authenticateUser(inputAuthName, inputPWName);

			}
		});

		// JTextField
		loginNameText.setBounds(550, 220, 150, 25);
		loginPWText.setBounds(550, 270, 150, 25);
		add(loginNameText);
		add(loginPWText);

		// JLabel Settings
		authnameLabel = new JLabel("Anmeldename: ");
		authnameLabel.setForeground(Color.WHITE);
		authnameLabel.setBounds(450, 130, 100, 200);
		add(authnameLabel);

		passwordLabel = new JLabel("Passwort: ");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(450, 180, 200, 200);
		add(passwordLabel);

		setVisible(true);

	}
}
