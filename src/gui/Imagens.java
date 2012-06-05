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
	URL expCountry = classLoader.getResource("Imagens/exportbtn.png");
	URL expDisc = classLoader.getResource("Imagens/exportDisci.png");
	URL expResu = classLoader.getResource("Imagens/expResu.png");

	// panels
	URL imp = classLoader.getResource("Imagens/import.png");
	URL exp = classLoader.getResource("Imagens/export.png");
	URL add = classLoader.getResource("Imagens/add.png");
	URL edit = classLoader.getResource("Imagens/edit.png");
	URL remove = classLoader.getResource("Imagens/remove.png");

}
