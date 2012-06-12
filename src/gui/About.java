package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;

public class About extends JDialog {

	public About(JFrame parent) throws URISyntaxException {
		super(parent, "About M&M", true);

		Imagens img = new Imagens();

		// Painel principal
		Painel panel_principal = new Painel(img.bg3);
		panel_principal.setLayout(new BorderLayout());

		Botao logo = new Botao(img.logo);
		logo.setContentAreaFilled(false);
		logo.setBorderPainted(false);

		panel_principal.add(logo, BorderLayout.CENTER);
		panel_principal.setBorder(new EmptyBorder(30, 20, 0, 0));

		JPanel inner = new JPanel();
		inner.setLayout(new GridLayout(2, 1, 0, 0));
		inner.setOpaque(false);
		Font font = new Font("Arial", Font.PLAIN, 9);
		JLabel name = new JLabel("M&M - Medal Managment");
		name.setForeground(Color.white);
		JLabel version = new JLabel("Version: Medal Managment Realease 1");
		version.setForeground(Color.white);
		inner.setBorder(new EmptyBorder(30, 20, 40, 20));
		inner.add(name);
		inner.add(version);
		final URI visit_url = new URI("https://code.google.com/p/lapr2-projeto/");
		logo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open(visit_url);
			}
		});
		panel_principal.add(inner, BorderLayout.EAST);
		getContentPane().add(panel_principal);
		setSize(400, 200);
		setVisible(true);

	}

	private static void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
			}
		}

	}
}