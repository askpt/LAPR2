package gui;

import java.net.*;

public class Imagens {
	ClassLoader classLoader = getClass().getClassLoader();

	URL constrution = classLoader.getResource("Imagens/under_constrution.jpg");
	URL bg = classLoader.getResource("Imagens/background.png");

	// buttons
	URL appconfig = classLoader.getResource("Imagens/appconfig.png");
	URL gamesconfig = classLoader.getResource("Imagens/gamesconfig.png");
	URL exitapp = classLoader.getResource("Imagens/exitapp.png");

}
