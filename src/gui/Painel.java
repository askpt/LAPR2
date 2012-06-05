package gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

import javax.imageio.*;
import javax.swing.*;

public class Painel extends JPanel {

	// imagem que carrega por defeito
	String imagem = "bin/Imagens/background.png";

	public Painel() {
		super();
	}

	public Painel(String image) {
		super();
		this.imagem = image;
	}

	public Painel(URL url) {
		String temp = url.getPath();
		System.out.println(temp);
		String[] temparray = temp.split("/");
		imagem = temparray[temparray.length - 3] + "/"
				+ temparray[temparray.length - 2] + "/"
				+ temparray[temparray.length - 1];
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
