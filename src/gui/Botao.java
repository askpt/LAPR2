package gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

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
