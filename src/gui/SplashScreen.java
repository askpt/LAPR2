package gui;

import java.awt.*;
import java.net.*;

import javax.swing.*;

public class SplashScreen extends JWindow {

	Imagens img = new Imagens();
	private int duration;

	public SplashScreen(int d) {
		duration = d;
	}

	public void showSplash() {

		JPanel content = (JPanel) getContentPane();
		content.setBackground(Color.white);

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

	public void showSplashAndAPP() {
		JanelaPrincipal maingui;
		showSplash();
		try {
			maingui = new JanelaPrincipal();
		} catch (URISyntaxException e) {

		}
	}

}