package gui;

import java.net.*;

public class Imagens {
	ClassLoader classLoader = getClass().getClassLoader();

	URL constrution = classLoader.getResource("Imagens/under_constrution.jpg");
	URL bg = classLoader.getResource("Imagens/background.png");
	URL exit = classLoader.getResource("Imagens/exit.png");

	// buttons
	URL appconfig = classLoader.getResource("Imagens/appconfig.png");
	URL gamesconfig = classLoader.getResource("Imagens/gamesconfig.png");
	URL exitapp = classLoader.getResource("Imagens/exitapp.png");

	// exports
	URL expCountry = classLoader.getResource("Imagens/exportbtn.png");
	URL expCountryHtml = classLoader.getResource("Imagens/exportCounHtml.png");

	URL expDisc = classLoader.getResource("Imagens/exportDisci.png");
	URL expDiscHtml = classLoader.getResource("Imagens/expDisciHtml.png");

	URL expResu = classLoader.getResource("Imagens/expResu.png");
	URL expResuHtml = classLoader.getResource("Imagens/expResuHtml.png");

	// imports
	URL impCountry = classLoader.getResource("Imagens/importbtn.png");
	URL impCountryHtml = classLoader.getResource("Imagens/importbtnhtml.png");

	URL impDisc = classLoader.getResource("Imagens/importDisci.png");
	URL impDiscHtml = classLoader.getResource("Imagens/importDisciHtml.png");

	URL impResu = classLoader.getResource("Imagens/importresu.png");
	URL impResuHtml = classLoader.getResource("Imagens/importresuHtml.png");

	// add

	URL addAth = classLoader.getResource("Imagens/addAth.png");
	URL addCo = classLoader.getResource("Imagens/addCo.png");
	URL addJO = classLoader.getResource("Imagens/addJO.png");
	URL addDis = classLoader.getResource("Imagens/addDisc.png");
	URL addSpo = classLoader.getResource("Imagens/addSpo.png");

	// panels
	URL imp = classLoader.getResource("Imagens/import.png");
	URL exp = classLoader.getResource("Imagens/export.png");
	URL add = classLoader.getResource("Imagens/add.png");
	URL edit = classLoader.getResource("Imagens/edit.png");
	URL remove = classLoader.getResource("Imagens/remove.png");

}
