package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import jogosolimpicos.*;
import dados.*;

public class AppConfig extends JFrame {

	private Painel imp, exp, add, edit, remove, reg;

	private Imagens img = new Imagens();
	private final Csv csv = new Csv();
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private JTabbedPane jtp = new JTabbedPane();
	private AddDados a;
	private RemDados r;
	private AddRegs re;

	public AppConfig() {

		setTitle("Application Configuration");

		addPaineis();
		addTabs();
		addImports();
		addExports();
		addAdds();
		addEdits();
		addRemoves();
		addRegs();
		setProperties(600, 400, 1, true);

	}

	private void setProperties(int w, int h, int opcao, boolean visible) {
		setSize(w, h);
		setDefaultCloseOperation(opcao);
		setVisible(visible);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			}
		});
	}

	private void addTabs() {

		getContentPane().add(jtp);

		// Tabs
		jtp.addTab("Import", imp);
		jtp.addTab("Export", exp);
		jtp.addTab("Add", add);
		jtp.addTab("Edit", edit);
		jtp.addTab("Remove", remove);
		jtp.addTab("Register", reg);

	}

	private void addPaineis() {

		// Panels
		imp = new Painel(img.bg3);
		exp = new Painel(img.bg3);
		add = new Painel(img.bg3);
		edit = new Painel(img.bg3);
		remove = new Painel(img.bg3);
		reg = new Painel(img.bg3);

		imp.setOpaque(false);
		exp.setOpaque(false);
		add.setOpaque(false);
		edit.setOpaque(false);
		remove.setOpaque(false);
		reg.setOpaque(false);
	}

	private void addImports() {

		JPanel p1 = new JPanel(new GridLayout(3, 2, 10, 10));
		p1.setOpaque(false);
		imp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		// Countries
		Botao impCountry = new Botao(img.impCountry);
		impCountry.setContentAreaFilled(false);
		impCountry.setBorder(emptyBorder);
		impCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importPais(AppConfig.this, Main.getPaises());
			}
		});

		Botao impCountryHtml = new Botao(img.impCountryHtml);
		impCountryHtml.setContentAreaFilled(false);
		impCountryHtml.setBorder(emptyBorder);

		// Disciplines
		Botao impDisc = new Botao(img.impDisc);
		impDisc.setContentAreaFilled(false);
		impDisc.setBorder(emptyBorder);
		impDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importDisc(AppConfig.this, Main.getDisciplinas(), Main.getModalidades());
			}
		});

		Botao impDiscHtml = new Botao(img.impDiscHtml);
		impDiscHtml.setContentAreaFilled(false);
		impDiscHtml.setBorder(emptyBorder);

		// Results
		Botao impResu = new Botao(img.impResu);
		impResu.setContentAreaFilled(false);
		impResu.setBorder(emptyBorder);
		impResu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importResultados(AppConfig.this, Main.getAtleta(), Main.getModalidades(), Main.getPaises(), Main.getProvas(), Main.getEquipas(), Main.getJogos());
			}
		});

		Botao impResuHtml = new Botao(img.impResuHtml);
		impResuHtml.setContentAreaFilled(false);
		impResuHtml.setBorder(emptyBorder);

		p1.add(impCountry);
		p1.add(impCountryHtml);
		p1.add(impDisc);
		p1.add(impDiscHtml);
		p1.add(impResu);
		p1.add(impResuHtml);
		imp.add(p1);
	}

	private void addExports() {

		JPanel p1 = new JPanel(new GridLayout(3, 2, 10, 10));
		p1.setOpaque(false);
		exp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		// Countries
		Botao expCountry = new Botao(img.expCountry);
		expCountry.setContentAreaFilled(false);
		expCountry.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.exportPais(AppConfig.this, Main.getPaises());
			}
		});

		Botao expCountryHtml = new Botao(img.expCountryHtml);
		expCountryHtml.setContentAreaFilled(false);
		expCountryHtml.setBorder(emptyBorder);

		// Disciplines
		Botao expDisc = new Botao(img.expDisc);
		expDisc.setContentAreaFilled(false);
		expDisc.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.exportDisciplina(AppConfig.this, Main.getModalidades());
			}
		});

		Botao expDiscHtml = new Botao(img.expDiscHtml);
		expDiscHtml.setContentAreaFilled(false);
		expDiscHtml.setBorder(emptyBorder);

		// Results
		Botao expResu = new Botao(img.expResu);
		expResu.setContentAreaFilled(false);
		expResu.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.exportResultados(AppConfig.this, Main.getModalidades(), Main.getProvas(), "Gymnastics", 1, 2008);
			}
		});

		Botao expResuHtml = new Botao(img.expResuHtml);
		expResuHtml.setContentAreaFilled(false);
		expResuHtml.setBorder(emptyBorder);

		p1.add(expCountry);
		p1.add(expCountryHtml);
		p1.add(expDisc);
		p1.add(expDiscHtml);
		p1.add(expResu);
		p1.add(expResuHtml);
		exp.add(p1);
	}

	private void addAdds() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new GridLayout(3, 2, 10, 10));
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		add.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		Botao addJO = new Botao(img.addJO);
		addJO.setContentAreaFilled(false);
		addJO.setBorder(emptyBorder);
		addJO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(0);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(0);
				}
				
				
			}
		});

		Botao addCo = new Botao(img.addCo);
		addCo.setContentAreaFilled(false);
		addCo.setBorder(emptyBorder);
		addCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(1);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(1);
				}
			}
			
		});

		Botao addDis = new Botao(img.addDis);
		addDis.setContentAreaFilled(false);
		addDis.setBorder(emptyBorder);
		addDis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(2);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(2);
				}
			}
		});

		Botao addSpo = new Botao(img.addSpo);
		addSpo.setContentAreaFilled(false);
		addSpo.setBorder(emptyBorder);
		addSpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(3);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(3);
				}
			}
		});

		Botao addEv = new Botao(img.addEv);
		addEv.setContentAreaFilled(false);
		addEv.setBorder(emptyBorder);
		addEv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(4);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(4);
				}
			}
		});

		Botao addAth = new Botao(img.addAth);
		addAth.setContentAreaFilled(false);
		addAth.setBorder(emptyBorder);
		addAth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(5);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(5);
				}
			}
		});

		p1.add(addJO);
		p1.add(addCo);
		p1.add(addDis);
		p1.add(addSpo);
		p1.add(addEv);
		p1.add(addAth);
		add.add(p1);

	}

	private void addEdits() {

		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new GridLayout(3, 2, 10, 10));
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		edit.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		Botao editJO = new Botao(img.editJO);
		editJO.setContentAreaFilled(false);
		editJO.setBorder(emptyBorder);
		editJO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(5);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(5);
				}
			}
		});

		Botao editCo = new Botao(img.editCo);
		editCo.setContentAreaFilled(false);
		editCo.setBorder(emptyBorder);
		editCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(5);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(5);
				}
			}
		});

		Botao editDis = new Botao(img.editDis);
		editDis.setContentAreaFilled(false);
		editDis.setBorder(emptyBorder);
		editDis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(5);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(5);
				}
			}
		});

		Botao editSpo = new Botao(img.editSpo);
		editSpo.setContentAreaFilled(false);
		editSpo.setBorder(emptyBorder);
		editSpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(5);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(5);
				}
			}
		});

		Botao editEv = new Botao(img.editEv);
		editEv.setContentAreaFilled(false);
		editEv.setBorder(emptyBorder);
		editEv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(5);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(5);
				}
			}
		});

		Botao editAth = new Botao(img.editAth);
		editAth.setContentAreaFilled(false);
		editAth.setBorder(emptyBorder);
		editAth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a!=null){
					a.setSelectedIndex(5);
					a.setVisible(true);
				}else {
					a = new AddDados();
					a.setSelectedIndex(5);
				}
			}
		});

		p1.add(editJO);
		p1.add(editCo);
		p1.add(editDis);
		p1.add(editSpo);
		p1.add(editEv);
		p1.add(editAth);
		edit.add(p1);
	}

	private void addRemoves() {

		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new GridLayout(3, 2, 10, 10));
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		remove.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		Botao removeJO = new Botao(img.removeJO);
		removeJO.setContentAreaFilled(false);
		removeJO.setBorder(emptyBorder);
		removeJO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r!=null){
					r.setSelectedIndex(0);
					r.setVisible(true);
				}else {
					r = new RemDados();
					r.setSelectedIndex(0);
				}
			}
		});

		Botao removeCo = new Botao(img.removeCo);
		removeCo.setContentAreaFilled(false);
		removeCo.setBorder(emptyBorder);
		removeCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r!=null){
					r.setSelectedIndex(1);
					r.setVisible(true);
				}else {
					r = new RemDados();
					r.setSelectedIndex(1);
				}
			}
		});

		Botao removeDis = new Botao(img.removeDis);
		removeDis.setContentAreaFilled(false);
		removeDis.setBorder(emptyBorder);
		removeDis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r!=null){
					r.setSelectedIndex(2);
					r.setVisible(true);
				}else {
					r = new RemDados();
					r.setSelectedIndex(2);
				}
			}
		});

		Botao removeSpo = new Botao(img.removeSpo);
		removeSpo.setContentAreaFilled(false);
		removeSpo.setBorder(emptyBorder);
		removeSpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r!=null){
					r.setSelectedIndex(3);
					r.setVisible(true);
				}else {
					r = new RemDados();
					r.setSelectedIndex(3);
				}
			}
		});

		Botao removeEv = new Botao(img.removeEv);
		removeEv.setContentAreaFilled(false);
		removeEv.setBorder(emptyBorder);
		removeEv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r!=null){
					r.setSelectedIndex(4);
					r.setVisible(true);
				}else {
					r = new RemDados();
					r.setSelectedIndex(4);
				}
			}
		});

		Botao removeAth = new Botao(img.removeAth);
		removeAth.setContentAreaFilled(false);
		removeAth.setBorder(emptyBorder);
		removeAth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r!=null){
					r.setSelectedIndex(5);
					r.setVisible(true);
				}else {
					r = new RemDados();
					r.setSelectedIndex(5);
				}
			}
		});

		p1.add(removeJO);
		p1.add(removeCo);
		p1.add(removeDis);
		p1.add(removeSpo);
		p1.add(removeEv);
		p1.add(removeAth);
		remove.add(p1);
	}

	private void addRegs() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new GridLayout(3, 2, 10, 10));
		p1.setOpaque(false);
		reg.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));

		Botao regAtToTeam = new Botao(img.regAt);
		regAtToTeam.setContentAreaFilled(false);
		regAtToTeam.setToolTipText("Add athlete to a team.");
		regAtToTeam.setBorder(emptyBorder);
		regAtToTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(re!=null){
					re.setSelectedIndex(0);
					re.setVisible(true);
				}else {
					re = new AddRegs();
					re.setSelectedIndex(0);
				}
			}
		});

		Botao regResult = new Botao(img.regRe);
		regResult.setContentAreaFilled(false);
		regResult.setToolTipText("Register athlete's result.");
		regResult.setBorder(emptyBorder);
		regResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(re!=null){
					re.setSelectedIndex(1);
					re.setVisible(true);
				}else {
					re = new AddRegs();
					re.setSelectedIndex(1);
				}
			}
		});

		Botao regResultTeam = new Botao(img.regReTeam);
		regResultTeam.setContentAreaFilled(false);
		regResultTeam.setToolTipText("Registar team's result.");
		regResultTeam.setBorder(emptyBorder);
		regResultTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(re!=null){
					re.setSelectedIndex(2);
					re.setVisible(true);
				}else {
					re = new AddRegs();
					re.setSelectedIndex(2);
				}
			}
		});


		p1.add(regAtToTeam);
		p1.add(regResult);
		p1.add(regResultTeam);
		reg.add(p1);

	}
}
