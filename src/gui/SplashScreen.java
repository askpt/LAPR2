package gui;

import java.awt.*;

import javax.swing.*;

/*
 * Class that loads first, this class creates a simple splashscreen
 */
@SuppressWarnings("serial")
public class SplashScreen extends JWindow {

	/*
	 * Instance of the class Imagens, used to give the label an ImageIcon
	 */
	Imagens img = new Imagens();

	/*
	 * value of the time that the thread will sleep
	 */
	private int duration;

	/*
	 * Constructor of this class
	 * 
	 * @param d the value of the time that the thread will sleep
	 */
	public SplashScreen(int d) {
		duration = d;
	}

	/*
	 * This method shows the splashscreen in the middle of the screen, uses a
	 * label to show an image and the duration of the thread is set in the class
	 * constructor
	 */
	public void showSplash() {

		JPanel content = (JPanel) getContentPane();

		int width = 450;
		int height = 300;

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		JLabel label = new JLabel(new ImageIcon(img.splash));
		content.add(label, BorderLayout.CENTER);
		setVisible(true);

		try {
			Thread.sleep(duration);
		} catch (Exception e) {
		}

		setVisible(false);

	}

}