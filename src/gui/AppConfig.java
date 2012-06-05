package gui;

import javax.swing.*;

public class AppConfig extends JFrame {

	public AppConfig() {
		setTitle("Application Configuration");

		JTabbedPane jtp = new JTabbedPane();

		getContentPane().add(jtp);

		Painel imp = new Painel("images/import.png");
		Painel exp = new Painel("images/export.png");
		Painel add = new Painel("images/add.png");
		Painel edit = new Painel("images/edit.png");
		Painel remove = new Painel("images/remove.png");

		jtp.addTab("Import", imp);
		jtp.addTab("Export", exp);
		jtp.addTab("Add", add);
		jtp.addTab("Edit", edit);
		jtp.addTab("Remove", remove);

		setSize(400, 400);
		setVisible(true);

	}

}
