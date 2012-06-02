package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dados.*;

@SuppressWarnings("serial")
public class Teste extends JFrame {

	public Teste(String titulo) {

		super(titulo);
		setLayout(new BorderLayout());

		Imagens img = new Imagens();

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

				csv.importPais(Teste.this, Main.getPaises());
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Export Country", 'E');
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				csv.exportPais(Teste.this, Main.getPaises());
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

		menuItem = new JMenuItem("Import Disciplines", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				csv.importDisc(Teste.this, Main.getDisciplinas(), Main.getModalidades());
			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Export Disciplines", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				csv.exportDisciplina(Teste.this, Main.getModalidades());

			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("List Disciplines", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < Main.getDisciplinas().size(); i++) {
					System.out.println(Main.getDisciplinas().get(i).toStringTest());
				}

				for (int i = 0; i < Main.getModalidades().size(); i++) {
					System.out.println(Main.getModalidades().get(i).toStringTest());
				}

			}
		});

		menu.add(menuItem);

		setJMenuBar(menuBar);

		JLabel label = new JLabel(new ImageIcon(img.constrution));
		label.setEnabled(false);
		label.setDisabledIcon(new ImageIcon(img.constrution));
		add(label);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		pack();
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
