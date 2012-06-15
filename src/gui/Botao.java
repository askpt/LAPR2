package gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

import javax.imageio.*;
import javax.swing.*;

/**
 * 
 * A custom Button that extends JButton and loads an image to the button
 * 
 */
@SuppressWarnings("serial")
public class Botao extends JButton {

	/**
	 * the image to the button
	 */
	private BufferedImage image;

	/**
	 * the image to the button when the mouse is over the button
	 */
	private BufferedImage imageRollOver;

	/**
	 * Whether or not we've set the RollOver image.
	 */
	private boolean hasRollOver = false;

	/**
	 * Constructor of this class, loads an image
	 * 
	 * @param botao
	 *            the path of the image
	 */
	public Botao(String botao) {
		try {
			image = ImageIO.read(new File(botao));
		} catch (IOException e) {
		}
	}

	/**
	 * Constructor of this class, loads an image to the button and other to the
	 * roll over option
	 * 
	 * @param botao
	 *            the path of the image
	 * @param btnRoll
	 *            the path of the roll over image
	 */
	public Botao(String botao, String btnRoll) {
		try {
			image = ImageIO.read(new File(botao));
			imageRollOver = ImageIO.read(new File(btnRoll));
			hasRollOver = true;
		} catch (IOException e) {

		}
	}

	/**
	 * Constructor of this class, loads an image from the url
	 * 
	 * @param url
	 *            the url of the image
	 */
	public Botao(URL url) {
		try {
			String temp = url.getPath();
			String[] temparray = temp.split("/");
			temp = temparray[temparray.length - 2] + "/" + temparray[temparray.length - 1];
			image = ImageIO.read(new File(temp));
		} catch (IOException e) {
		}
	}

	/**
	 * Constructor of this class, loads an image to the button and other to the
	 * roll over option from the url
	 * 
	 * @param url
	 *            the url of the image
	 * @param urlRollOver
	 *            the url of the roll over image
	 */
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

	/**
	 * Adds the rollover option to the button
	 * 
	 * @param urlRollOver
	 *            image url
	 */
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

	/**
	 * Adds the rollover option to the button
	 * 
	 * @param uRollOver
	 *            image path
	 */
	public void setBotaoRollOver(String uRollOver) {
		try {
			imageRollOver = ImageIO.read(new File(uRollOver));
			hasRollOver = true;
		} catch (IOException e) {
		}
	}

	/**
	 * Draws the image into the button
	 * 
	 * @see JComponent
	 */
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

	/**
	 * If the <code>preferredSize</code> has been set to a non-<code>null</code>
	 * value just returns it. If the UI delegate's <code>getPreferredSize</code>
	 * method returns a non <code>null</code> value then return that; otherwise
	 * defer to the component's layout manager.
	 * 
	 * @return the value of the <code>preferredSize</code> property
	 * @see JComponent
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(image.getWidth(), image.getHeight());
	}

}
