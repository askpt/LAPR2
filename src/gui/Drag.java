package gui;

import java.io.*;

import javax.swing.*;

import dados.*;

public class Drag extends JDialog {

	public Drag(JFrame parent) {
		super(parent, "Drag & Drop Files here", true);
		Imagens img = new Imagens();
		Painel principal = new Painel(img.dragndrop);
		principal.setOpaque(false);
		getContentPane().add(principal);
		new FileDrop(principal, new FileDrop.Listener() {

			@Override
			public void filesDropped(File[] files) {
				Csv csv = new Csv();
				csv.intelImport(files, Drag.this, Main.getPaises(), Main.getDisciplinas(), Main.getModalidades(), Main.getJogos(), Main.getProvas(), Main.getEquipas(), Main.getAtleta());

			}
		});
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setSize(200, 185);
		setVisible(true);

	}
}
