package gui;

import java.net.*;

public class Imagens {
	ClassLoader classLoader = getClass().getClassLoader();

	URL constrution = classLoader.getResource("Imagens/under_constrution.jpg");
	URL bg = classLoader.getResource("Imagens/background.png");
	URL bg2 = classLoader.getResource("Imagens/bg2.png");
	URL bg3 = classLoader.getResource("Imagens/bg3.png");
	URL bg4 = classLoader.getResource("Imagens/bg4.png");
	URL exit = classLoader.getResource("Imagens/exit.png");
	
	// buttons
	URL appconfig = classLoader.getResource("Imagens/appconfig.png");
	URL gamesconfig = classLoader.getResource("Imagens/gamesconfig.png");
	URL exitapp = classLoader.getResource("Imagens/exitapp.png");

	// exports
	URL expCountry = classLoader.getResource("Imagens/exportCo.png");
	URL expCountryHtml = classLoader.getResource("Imagens/exportCoH.png");

	URL expDisc = classLoader.getResource("Imagens/exportDi.png");
	URL expDiscHtml = classLoader.getResource("Imagens/exportDiH.png");

	URL expResu = classLoader.getResource("Imagens/exportRe.png");
	URL expResuHtml = classLoader.getResource("Imagens/exportReH.png");

	// imports
	URL impCountry = classLoader.getResource("Imagens/importCo.png");

	URL impDisc = classLoader.getResource("Imagens/importDi.png");

	URL impResu = classLoader.getResource("Imagens/importRe.png");

	// add

	URL addAth = classLoader.getResource("Imagens/addAT.png");
	URL addCo = classLoader.getResource("Imagens/addCO.png");
	URL addJO = classLoader.getResource("Imagens/addGE.png");
	URL addDis = classLoader.getResource("Imagens/addDI.png");
	URL addSpo = classLoader.getResource("Imagens/addSP.png");
	URL addEv = classLoader.getResource("Imagens/addEV.png");

	// edit

	URL editAth = classLoader.getResource("Imagens/editAT.png");
	URL editCo = classLoader.getResource("Imagens/editCO.png");
	URL editJO = classLoader.getResource("Imagens/editGE.png");
	URL editDis = classLoader.getResource("Imagens/editDI.png");
	URL editSpo = classLoader.getResource("Imagens/editSP.png");
	URL editEv = classLoader.getResource("Imagens/editEV.png");

	// remove

	URL removeAth = classLoader.getResource("Imagens/removeAT.png");
	URL removeCo = classLoader.getResource("Imagens/removeCO.png");
	URL removeJO = classLoader.getResource("Imagens/removeGE.png");
	URL removeDis = classLoader.getResource("Imagens/removeDI.png");
	URL removeSpo = classLoader.getResource("Imagens/removeSP.png");
	URL removeEv = classLoader.getResource("Imagens/removeEV.png");

	// register

	URL regAt = classLoader.getResource("Imagens/aatt.png");
	URL regRe = classLoader.getResource("Imagens/rar.png");
	URL regReTeam = classLoader.getResource("Imagens/rtr.png");

	// ok,clear, +

	URL ok = classLoader.getResource("Imagens/btn25.png");
	URL clear = classLoader.getResource("Imagens/btn26.png");
	URL mais = classLoader.getResource("Imagens/+.png");
	URL menos = classLoader.getResource("Imagens/no.png");

	// panels
	URL imp = classLoader.getResource("Imagens/import.png");
	URL exp = classLoader.getResource("Imagens/export.png");
	URL add = classLoader.getResource("Imagens/add.png");
	URL edit = classLoader.getResource("Imagens/edit.png");
	URL remove = classLoader.getResource("Imagens/remove.png");
	URL reg = classLoader.getResource("Imagens/reg.png");

}
