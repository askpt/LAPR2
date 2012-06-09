package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardLayoutExp extends JFrame {

	private int currentCard = 1;
	private Painel cardPanel;
	private CardLayout cl;
	private Imagens img = new Imagens();

	public CardLayoutExp() {

		setTitle("Card Layout Example");
		setSize(600, 440);
		cardPanel = new Painel(img.bg3);

		// getContentPane().add(cardPanel);
		cl = new CardLayout();
		cardPanel.setLayout(cl);
		Painel jp1 = new Painel(img.bg3);
		Painel jp2 = new Painel(img.bg3);

		JLabel lblCountry = new JLabel("Choose the countries you wish:");
		JComboBox cmbCountry1 = new JComboBox();
		JComboBox cmbCountry2 = new JComboBox();

		JLabel lblCountry_1 = new JLabel("Choose the countries you wish:");
		JComboBox cmbCountry1_1 = new JComboBox();
		JComboBox cmbCountry2_1 = new JComboBox();
		JComboBox cmbCountry3_1 = new JComboBox();

		jp1.add(lblCountry);
		jp1.add(cmbCountry1);
		jp1.add(cmbCountry2);

		jp2.add(lblCountry_1);
		jp2.add(cmbCountry1_1);
		jp2.add(cmbCountry2_1);
		jp2.add(cmbCountry3_1);

		cardPanel.add(jp1, "1");
		cardPanel.add(jp2, "2");
		Painel buttonPanel = new Painel(img.bg3);
		JButton firstBtn = new JButton("add");
		JButton nextBtn = new JButton("remove");
		buttonPanel.add(firstBtn);
		buttonPanel.add(nextBtn);

		firstBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.first(cardPanel);
				currentCard = 1;
			}
		});

		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentCard < 4) {
					currentCard += 1;
					cl.show(cardPanel, "" + (currentCard));
				}
			}
		});

		getContentPane().add(cardPanel, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void addPanel2() {
	}

	private void addPanel3() {
	}

	private void addPanel4() {
	}

	private void addPanel5() {
	}

}
