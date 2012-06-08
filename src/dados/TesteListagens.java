package dados;

import jogosolimpicos.*;
import listaligada.*;

public class TesteListagens {

	public static void listarMedalhas(ListaLigada<Pais> paises, ListaLigada<Prova> provas, int anoInicio, int anoFim) {
		ListaLigada<Prova> provaTemp = provas;
		ListaLigada<Pais> paisesTemp = paises;
		for (int i = anoInicio; i <= anoFim; i += 4) {
			for (int j = 0; j < provaTemp.size(); j++) {
				if (provaTemp.get(j).getJogosOlimpicos().getAno() != i) {
					provaTemp.remove(j);
					j--;
				} else if (provaTemp.get(j) instanceof ProvaInd && !((ProvaInd) provaTemp.get(j)).getResultados().isEmpty()) {
					provaTemp.get(j).ordenar();
					int itInicioOuro = 0;
					int itFimOuro = 0;
					int resul = 0;
					for (int l = 1; l < ((ProvaInd) provaTemp.get(j)).getResultados().size(); l++) {
						resul += ((ProvaInd) provaTemp.get(j)).getResultados().get(l).getResultado();
						if ((resul / (l + 1)) != ((ProvaInd) provaTemp.get(j)).getResultados().get(0).getResultado()) {
							itFimOuro = l - 1;
							break;
						}
					}
					int itInicioPrata = itFimOuro + 1;
					int itFimPrata = 0;
					resul = 0;
					for (int l = itInicioPrata + 1; l < ((ProvaInd) provaTemp.get(j)).getResultados().size(); l++) {
						resul += ((ProvaInd) provaTemp.get(j)).getResultados().get(l).getResultado();
						if ((resul / (l + 1)) != ((ProvaInd) provaTemp.get(j)).getResultados().get(0).getResultado()) {
							itFimPrata = l - 1;
							break;
						}
					}
					int itInicioBronze = itFimPrata + 1;
					int itFimBronze = 0;
					resul = 0;
					for (int l = itInicioBronze + 1; l < ((ProvaInd) provaTemp.get(j)).getResultados().size(); l++) {
						resul += ((ProvaInd) provaTemp.get(j)).getResultados().get(l).getResultado();
						if ((resul / (l + 1)) != ((ProvaInd) provaTemp.get(j)).getResultados().get(0).getResultado()) {
							itFimBronze = l - 1;
							break;
						}
					}

					for (int l = itInicioOuro; !((ProvaInd) provaTemp.get(j)).getResultados().isEmpty() && l <= itFimOuro; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addOuro();
							}
						}
					}
					for (int l = itInicioPrata; !((ProvaInd) provaTemp.get(j)).getResultados().isEmpty() && l <= itFimPrata; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addPrata();
							}
						}
					}
					for (int l = itInicioBronze; !((ProvaInd) provaTemp.get(j)).getResultados().isEmpty() && l <= itFimBronze; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addBronze();
							}
						}
					}

				} else if (provaTemp.get(j) instanceof ProvaCol && !((ProvaCol) provaTemp.get(j)).getResultados().isEmpty()) {
					provaTemp.get(j).ordenar();
					int itInicioOuro = 0;
					int itFimOuro = 0;
					int resul = 0;
					for (int l = 1; !((ProvaCol) provaTemp.get(j)).getResultados().isEmpty() && l < ((ProvaCol) provaTemp.get(j)).getResultados().size(); l++) {
						resul += ((ProvaCol) provaTemp.get(j)).getResultados().get(l).getResultado();
						if ((resul / (l + 1)) != ((ProvaCol) provaTemp.get(j)).getResultados().get(0).getResultado()) {
							itFimOuro = l - 1;
							break;
						}
					}
					int itInicioPrata = itFimOuro + 1;
					int itFimPrata = 0;
					resul = 0;
					for (int l = itInicioPrata + 1; !((ProvaCol) provaTemp.get(j)).getResultados().isEmpty() && l < ((ProvaCol) provaTemp.get(j)).getResultados().size(); l++) {
						resul += ((ProvaCol) provaTemp.get(j)).getResultados().get(l).getResultado();
						if ((resul / (l + 1)) != ((ProvaCol) provaTemp.get(j)).getResultados().get(0).getResultado()) {
							itFimPrata = l - 1;
							break;
						}
					}
					int itInicioBronze = itFimPrata + 1;
					int itFimBronze = 0;
					resul = 0;
					for (int l = itInicioBronze + 1; !((ProvaCol) provaTemp.get(j)).getResultados().isEmpty() && l < ((ProvaCol) provaTemp.get(j)).getResultados().size(); l++) {
						resul += ((ProvaCol) provaTemp.get(j)).getResultados().get(l).getResultado();
						if ((resul / (l + 1)) != ((ProvaCol) provaTemp.get(j)).getResultados().get(0).getResultado()) {
							itFimBronze = l - 1;
							break;
						}
					}

					for (int l = itInicioOuro; !((ProvaCol) provaTemp.get(j)).getResultados().isEmpty() && l <= itFimOuro; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addOuro();
							}
						}
					}
					for (int l = itInicioPrata; l <= itFimPrata; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addPrata();
							}
						}
					}
					for (int l = itInicioBronze; l <= itFimBronze; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addBronze();
							}
						}
					}

				}
			}
		}

		for (int i = 0; i < paisesTemp.size() - 1; i++) {
			for (int j = 0; j < paisesTemp.size(); j++) {
				if (paisesTemp.get(i).compareTo(paisesTemp.get(j)) < 0) {
					Object obj = paisesTemp.get(j);
					paisesTemp.set(j, paisesTemp.get(i));
					paisesTemp.set(i, (Pais) obj);
				}
			}
		}

		for (int i = 0; i < paisesTemp.size(); i++) {
			System.out.println(paisesTemp.get(i).getNomePais());
		}
	}

}
