package gui;

import java.net.*;

public class Imagens {
	ClassLoader classLoader = getClass().getClassLoader();

	URL constrution = classLoader.getResource("Imagens/under_constrution.jpg");
	URL bg = classLoader.getResource("images/bg/background.png");

	// buttons
	URL appconfig = classLoader.getResource("images/buttons/appconfig.png");
	URL gamesconfig = classLoader.getResource("images/buttons/gamesconfig.png");
	URL exitapp = classLoader.getResource("images/buttons/exitapp.png");

}
