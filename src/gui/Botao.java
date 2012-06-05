package gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

import javax.imageio.*;
import javax.swing.*;

public class Botao extends JButton {

	BufferedImage image;

	public Botao(String botao) {
		try {
			image = ImageIO.read(new File(botao));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Botao(URL url) {
		try {
			String temp = url.getPath();
			System.out.println(temp);
			String[] temparray = temp.split("/");
			temp = temparray[temparray.length - 3] + "/"
					+ temparray[temparray.length - 2] + "/"
					+ temparray[temparray.length - 1];
			image = ImageIO.read(new File(temp));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(image.getWidth(), image.getHeight());
	}

}
