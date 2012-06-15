package gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

import javax.imageio.*;
import javax.swing.*;

/**
 * 
 * Custom panel with a background image
 * 
 */
@SuppressWarnings("serial")
public class Painel extends JPanel {

	/**
	 * Default image
	 */
	private String imagem = "Imagens/background.png";

	/**
	 * Constructor of this class
	 */
	public Painel() {
		super();
	}

	/**
	 * Constructor of this class, creates an image from the String in param
	 * 
	 * @param image
	 *            image's path
	 */
	public Painel(String image) {
		super();
		this.imagem = image;
	}

	/**
	 * Constructor of this class, creates an image from the url in param
	 * 
	 * @param url
	 *            image's path
	 */
	public Painel(URL url) {
		String temp = url.getPath();
		String[] temparray = temp.split("/");
		imagem = temparray[temparray.length - 3] + "/" + temparray[temparray.length - 2] + "/" + temparray[temparray.length - 1];
	}

	/**
	 * Constructor of this class, sets the manager layout
	 * 
	 * @param layout
	 *            manager layout
	 */
	public Painel(LayoutManager layout) {
		super(layout);
	}

	/**
	 * Sets the image
	 * 
	 * @param image
	 *            image path
	 */
	public void setImage(String image) {
		this.imagem = image;
	}

	/**
	 * Sets the image
	 * 
	 * @param imageURL
	 *            image url
	 */
	public void setImage(URL imageURL) {
		String temp = imageURL.getPath();
		String[] temparray = temp.split("/");
		this.imagem = temparray[temparray.length - 3] + "/" + temparray[temparray.length - 2] + "/" + temparray[temparray.length - 1];
	}

	/**
	 * Loads the image into the panel
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		BufferedImage image;
		try {
			image = ImageIO.read(new File(imagem));

			super.paintComponent(g);

			if (image != null)
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

		} catch (IOException e) {
		}

	}

}
