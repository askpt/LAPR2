package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import dados.Csv;

public class Teste extends JFrame {

	public Teste(String titulo) {

		super(titulo);
		setLayout(new BorderLayout());

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		final Csv csv = new Csv();

		menuBar = new JMenuBar();

		menu = new JMenu("File");
		menu.setMnemonic('F');
		menuBar.add(menu);

		menuItem = new JMenuItem("Import Country", 'I');
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				csv.importPais(Teste.this);
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Export Country", 'E');
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				csv.exportPais(Teste.this);
			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("List Country", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Main.getPaises().size(); i++) {
					System.out.println(Main.getPaises().get(i));
				}

			}
		});

		menu.add(menuItem);

		setJMenuBar(menuBar);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		pack();
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
