package gui;

import java.awt.*;
import java.net.*;

import javax.swing.*;

/**
 * Class that loads first, this class creates a simple splashscreen
 */
@SuppressWarnings("serial")
public class SplashScreen extends JWindow {

	/**
	 * Instance of the class Imagens, used to give the label an ImageIcon
	 */
	Imagens img = new Imagens();

	/**
	 * value of the time that the thread will sleep
	 */
	private int duration;

	/**
	 * with of the splash screen
	 */
	private int width;

	/**
	 * height of the splash screen
	 */
	private int height;

	/**
	 * Image to show in the splash screen
	 */
	private ImageIcon image;

	/**
	 * visibility fo the splash screen
	 */
	private boolean show;

	/**
	 * Constructor of this class
	 * 
	 * @param d
	 *            the value of the time that the thread will sleep
	 */
	public SplashScreen(int d) {
		setDuration(d);
	}

	/**
	 * Constructor of this class
	 * 
	 * @param d
	 *            the value of the time that the thread will sleep
	 * @param image
	 *            image to show in the splash screen
	 */
	public SplashScreen(int d, URL image) {
		setDuration(d);
		setImage(image);
	}

	/**
	 * Constructor of this class
	 * 
	 * @param d
	 *            the value of the time that the thread will sleep
	 * @param image
	 *            image to show in the splash screen
	 * @param show
	 *            sets whether you want to show the splash the screen or not
	 */
	public SplashScreen(int d, URL image, boolean show) {
		setDuration(d);
		setImage(image);
		setShow(show);

	}

	/**
	 * Constructor of this class
	 * 
	 * @param d
	 *            the value of the time that the thread will sleep
	 * @param image
	 *            image to show in the splash screen
	 * @param show
	 *            sets whether you want to show the splash the screen or not
	 */
	public SplashScreen(int d, String image, boolean show) {
		setDuration(d);
		setImage(image);
		setShow(show);

	}

	/**
	 * This method shows the splashscreen in the middle of the screen, uses a
	 * label to show an image and the duration of the thread is set in the
	 * constructor
	 */
	private void showSplash() {
		if (this.show) {
			setSplashSize(450, 300);
			centerSplash();
			animeSplash();
		}
	}

	/**
	 * Sets duration
	 * 
	 * @param duration
	 *            the duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Sets splash width and height
	 * 
	 * @param w
	 *            the width
	 * @param h
	 *            the height
	 */
	public void setSplashSize(int w, int h) {
		this.width = w;
		this.height = h;
	}

	/**
	 * Sets the width
	 * 
	 * @param w
	 *            the width
	 */
	public void setWidth(int w) {
		this.width = w;
	}

	/**
	 * Sets the height
	 * 
	 * @param h
	 *            the height
	 */
	public void setHeight(int h) {
		this.height = h;
	}

	/**
	 * Sets the image
	 * 
	 * @param urlImage
	 *            the image url
	 */
	public void setImage(URL urlImage) {
		this.image = new ImageIcon(urlImage);
	}

	public void setImage(String path) {
		this.image = new ImageIcon(path);
	}

	/**
	 * Sets the visibility of the splash screen
	 * 
	 * @param show
	 *            show if the param is true
	 */
	public void setShow(boolean show) {
		this.show = show;
		if (show) {
			showSplash();
		}
	}

	/**
	 * Centers the splash screen in the middle of the screen
	 */
	private void centerSplash() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);
	}

	/**
	 * Animes the splash screen, uses a thread with its time set in the
	 * constructor
	 */
	private void animeSplash() {
		JPanel content = (JPanel) getContentPane();
		JLabel label = new JLabel(image);
		content.add(label, BorderLayout.CENTER);
		setVisible(true);

		try {
			Thread.sleep(duration);
		} catch (Exception e) {
		}

		setVisible(false);
	}

	/**
	 * Gets the splash width
	 * 
	 * @return width splash width
	 */
	public int getSplashWidth() {
		return this.width;
	}

	/**
	 * Gets the splash height
	 * 
	 * @return splash height
	 */
	public int getSplasHeight() {
		return this.height;
	}

	/**
	 * Gets the visibility of the splash screen
	 * 
	 * @return show visibility of the splash screen
	 */
	public boolean isShow() {
		return show;
	}

}