package gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

public class Painel extends JPanel {

	// imagem que carrega por defeito
	String imagem = "images/bg/background.png";

	public Painel() {
		super();
	}

	public Painel(String image) {
		super();
		this.imagem = image;
	}

	public Painel(LayoutManager layout) {
		super(layout);
	}

	public void paintComponent(Graphics g) {
		BufferedImage image;
		try {
			image = ImageIO.read(new File(imagem));

			super.paintComponent(g);

			if (image != null)
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
