package gui;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;

public class JanelaPrincipal extends JFrame {

	private Imagens img = new Imagens();

	public JanelaPrincipal() throws URISyntaxException {

		super("Olympic Games Application");
		Botao btn1 = new Botao(img.appconfig);
		Botao btn2 = new Botao(img.gamesconfig);
		Botao btn3 = new Botao(img.exitapp);

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
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btn3.setContentAreaFilled(false);
		btn3.setBorder(emptyBorder);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fechar();
			}
		});

		panelbtn.add(btn1);
		panelbtn.add(btn2);
		panelbtn.add(btn3);
		add(panel, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				fechar();
			}
		});

		setSize(640, 480);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	private void fechar() {
		String[] opcoes = { "Sim", "Nao" };
		if (JOptionPane.showOptionDialog(this, "Deseja mesmo sair?", "Jogos Olimpicos", 0, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(img.exit), opcoes, opcoes[0]) == 0) {
			dispose();
		}
	}

}
