package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.JButton;

//TODO javadoc
@SuppressWarnings("serial")
public class Botao extends JButton {

	private BufferedImage image, imageRollOver;
	private boolean hasRollOver = false;

	public Botao(String botao) {
		try {
			image = ImageIO.read(new File(botao));
		} catch (IOException e) {
		}
	}

	public Botao(String botao, String btnRoll) {
		try {
			image = ImageIO.read(new File(botao));
			imageRollOver = ImageIO.read(new File(btnRoll));
			hasRollOver = true;
		} catch (IOException e) {

		}
	}

	public Botao(URL url) {
		try {
			String temp = url.getPath();
			String[] temparray = temp.split("/");
			temp = temparray[temparray.length - 2] + "/" + temparray[temparray.length - 1];
			image = ImageIO.read(new File(temp));
		} catch (IOException e) {
		}
	}

	public Botao(URL url, URL urlRollOver) {
		try {
			String temp = url.getPath();
			String[] temparray = temp.split("/");
			temp = temparray[temparray.length - 2] + "/" + temparray[temparray.length - 1];
			image = ImageIO.read(new File(temp));
			temp = urlRollOver.getPath();
			temparray = temp.split("/");
			temp = temparray[temparray.length - 2] + "/" + temparray[temparray.length - 1];
			imageRollOver = ImageIO.read(new File(temp));
			hasRollOver = true;
		} catch (IOException e) {
		}
	}

	public void setBotaoRollOver(URL urlRollOver) {
		try {
			String temp = urlRollOver.getPath();
			String[] temparray = temp.split("/");
			temp = temparray[temparray.length - 3] + "/" + temparray[temparray.length - 2] + "/" + temparray[temparray.length - 1];
			imageRollOver = ImageIO.read(new File(temp));
			hasRollOver = true;
		} catch (IOException e) {
		}
	}

	public void setBotaoRollOver(String uRollOver) {
		try {
			imageRollOver = ImageIO.read(new File(uRollOver));
			hasRollOver = true;
		} catch (IOException e) {
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		ButtonModel model = getModel();
		if (hasRollOver) {
			if (model.isRollover()) {
				g.drawImage(imageRollOver, 0, 0, null);
			}
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(image.getWidth(), image.getHeight());
	}

}
