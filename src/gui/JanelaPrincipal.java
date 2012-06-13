package gui;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	private Imagens img = new Imagens();

	public JanelaPrincipal() throws URISyntaxException {

		super("Olympic Games Application");
		addButtons();
		setProperties(640, 480, 0, true);

	}

	private void close() {
		String[] opt = { "Yes", "No" };
		if (JOptionPane.showOptionDialog(this, "Do you really want to exit?", "Olympic Games", 0, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(img.exit), opt, opt[0]) == 0) {
			Main.gravarEstado();
			dispose();
			System.exit(0);
		}
	}

	private void setProperties(int w, int h, int opcao, boolean v) {
		setSize(w, h);
		setDefaultCloseOperation(opcao);
		setUndecorated(true);
		setVisible(v);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
	}

	private void addButtons() {
		// Buttons
		Botao btn1 = new Botao(img.appconfig);
		btn1.setBotaoRollOver(img.appconfig_o);
		Botao btn2 = new Botao(img.about);
		btn2.setBotaoRollOver(img.about_o);
		Botao btn3 = new Botao(img.exitapp);
		btn3.setBotaoRollOver(img.exitapp_o);

		// Panels
		Painel panel = new Painel(new FlowLayout(FlowLayout.RIGHT, 55, 120));
		Painel panelbtn = new Painel(img.bg4);
		panelbtn.setLayout(new GridLayout(4, 1, 10, 10));
		panelbtn.setBorder(new EmptyBorder(20, 20, 30, 20));
		panelbtn.setOpaque(false);
		panel.add(panelbtn);
		Border emptyBorder = BorderFactory.createEmptyBorder();

		JLabel lb = new JLabel("Menu");
		lb.setFont(new Font("Arial", Font.BOLD, 14));
		lb.setForeground(Color.white);

		// appconfig
		btn1.setContentAreaFilled(false);
		btn1.setBorder(emptyBorder);
		btn1.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				AppConfig appconfig = new AppConfig();
			}
		});

		// about
		btn2.setContentAreaFilled(false);
		btn2.setBorder(emptyBorder);
		btn2.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				try {
					About about = new About(JanelaPrincipal.this);
				} catch (URISyntaxException e1) {
				}
			}
		});

		// exitapp
		btn3.setContentAreaFilled(false);
		btn3.setBorder(emptyBorder);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});

		panelbtn.add(lb);
		panelbtn.add(btn1);
		panelbtn.add(btn2);
		panelbtn.add(btn3);
		add(panel, BorderLayout.CENTER);
	}

}
