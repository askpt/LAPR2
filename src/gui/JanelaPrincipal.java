package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class JanelaPrincipal extends JFrame {

	public JanelaPrincipal() {

		super("Olympic Games Application");

		Botao btn1 = new Botao("images/buttons/appconfig.png");
		Botao btn2 = new Botao("images/buttons/gamesconfig.png");
		Botao btn3 = new Botao("images/buttons/exitapp.png");

		Painel panel = new Painel(new FlowLayout(FlowLayout.RIGHT, 100, 120));

		JPanel panelbtn = new JPanel(new GridLayout(3, 1, 10, 10));
		panelbtn.setBackground(new Color(0, 122, 133));

		panel.add(panelbtn);

		btn1.setContentAreaFilled(false);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		btn1.setBorder(emptyBorder);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppConfig b = new AppConfig();
			}
		});

		btn2.setContentAreaFilled(false);
		btn2.setBorder(emptyBorder);

		btn3.setContentAreaFilled(false);
		btn3.setBorder(emptyBorder);

		panelbtn.add(btn1);
		panelbtn.add(btn2);
		panelbtn.add(btn3);

		add(panel, BorderLayout.CENTER);
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
