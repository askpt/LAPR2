package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class AppConfig extends JFrame {

	public AppConfig() {
		setTitle("Application Configuration");
		JTabbedPane jtp = new JTabbedPane();
		getContentPane().add(jtp);
		Imagens img = new Imagens();

		// Panels
		Painel imp = new Painel(img.imp);
		Painel exp = new Painel(img.exp);
		Painel add = new Painel(img.add);
		Painel edit = new Painel(img.edit);
		Painel remove = new Painel(img.remove);

		// Aux EmptyBorder
		Border emptyBorder = BorderFactory.createEmptyBorder();

		exp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		// Inner Panel
		JPanel p1 = new JPanel(new GridLayout(3, 1, 10, 10));

		// Buttons
		Botao expCountry = new Botao(img.expCountry);
		expCountry.setContentAreaFilled(false);
		expCountry.setBorder(emptyBorder);

		Botao expDisc = new Botao(img.expDisc);
		expDisc.setContentAreaFilled(false);
		expDisc.setBorder(emptyBorder);

		Botao expResu = new Botao(img.expResu);
		expResu.setContentAreaFilled(false);
		expResu.setBorder(emptyBorder);

		p1.add(expCountry);
		p1.add(expDisc);
		p1.add(expResu);
		exp.add(p1);

		jtp.addTab("Import", imp);
		jtp.addTab("Export", exp);
		jtp.addTab("Add", add);
		jtp.addTab("Edit", edit);
		jtp.addTab("Remove", remove);

		setSize(400, 400);
		setVisible(true);

	}
}
