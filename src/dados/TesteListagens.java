package dados;

import jogosolimpicos.*;
import listaligada.*;

public class TesteListagens {

	public static void listarMedalhas(ListaLigada<Pais> paises, ListaLigada<Prova> provas, int anoInicio, int anoFim) {
		ListaLigada<Prova> provaTemp = new ListaLigada<Prova>();
		for (int i = 0; i < provas.size(); i++) {
			provaTemp.add(provas.get(i));
		}

		ListaLigada<Pais> paisesTemp = new ListaLigada<Pais>();
		for (int i = 0; i < paises.size(); i++) {
			paisesTemp.add(paises.get(i));
		}

		for (int i = anoInicio; i <= anoFim; i += 4) {
			for (int j = 0; j < provaTemp.size(); j++) {
				if (provaTemp.get(j).getJogosOlimpicos().getAno() != i) {
					provaTemp.remove(j);
					j--;
				} else if (provaTemp.get(j) instanceof ProvaInd && !((ProvaInd) provaTemp.get(j)).getResultados().isEmpty()) {
					provaTemp.get(j).ordenar();

					// for (int m = 0; m < paisesTemp.size(); m++) {
					// if (((ProvaInd)
					// provaTemp.get(j)).getResultados().get(0).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i)))
					// {
					// paisesTemp.get(m).getMedalha().addOuro();
					// }
					// }
					// for (int m = 0; m < paisesTemp.size(); m++) {
					// if (((ProvaInd)
					// provaTemp.get(j)).getResultados().get(1).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i)))
					// {
					// paisesTemp.get(m).getMedalha().addPrata();
					// }
					// }
					// for (int m = 0; m < paisesTemp.size(); m++) {
					// if (((ProvaInd)
					// provaTemp.get(j)).getResultados().get(2).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i)))
					// {
					// paisesTemp.get(m).getMedalha().addBronze();
					// }
					// }

					int itInicioOuro = 0;
					int itFimOuro = 0;
					float temp;
					for (int l = 1; l < ((ProvaInd) provaTemp.get(j)).getResultados().size(); l++) {
						temp = ((ProvaInd) provaTemp.get(j)).getResultados().get(itInicioOuro).getResultado();
						if ((temp != ((ProvaInd) provaTemp.get(j)).getResultados().get(l).getResultado())) {
							itFimOuro = l - 1;
							break;
						}
					}
					int itInicioPrata = itFimOuro + 1;
					int itFimPrata = itInicioPrata;
					for (int l = itInicioPrata + 1; l < ((ProvaInd) provaTemp.get(j)).getResultados().size(); l++) {
						temp = ((ProvaInd) provaTemp.get(j)).getResultados().get(itInicioPrata).getResultado();
						if (temp != ((ProvaInd) provaTemp.get(j)).getResultados().get(l).getResultado()) {
							itFimPrata = l - 1;
							break;
						}
					}
					int itInicioBronze = itFimPrata + 1;
					int itFimBronze = 0;
					for (int l = itInicioBronze + 1; l < ((ProvaInd) provaTemp.get(j)).getResultados().size(); l++) {
						temp = ((ProvaInd) provaTemp.get(j)).getResultados().get(itInicioBronze).getResultado();
						if (temp != ((ProvaInd) provaTemp.get(j)).getResultados().get(l).getResultado()) {
							itFimBronze = l - 1;
							break;
						}
					}

					for (int l = itInicioOuro; l <= itFimOuro; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addOuro();
							}
						}
					}
					for (int l = itInicioPrata; l <= itFimPrata; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addPrata();
							}
						}
					}
					for (int l = itInicioBronze; l <= itFimBronze; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addBronze();
							}
						}
					}

				} else if (provaTemp.get(j) instanceof ProvaCol && !((ProvaCol) provaTemp.get(j)).getResultados().isEmpty()) {
					provaTemp.get(j).ordenar();

					// for (int m = 0; m < paisesTemp.size(); m++) {
					// if (((ProvaCol)
					// provaTemp.get(j)).getResultados().get(0).getEquipa().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i)))
					// {
					// paisesTemp.get(m).getMedalha().addOuro();
					// }
					// }
					// for (int m = 0; m < paisesTemp.size(); m++) {
					// if (((ProvaCol)
					// provaTemp.get(j)).getResultados().get(1).getEquipa().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i)))
					// {
					// paisesTemp.get(m).getMedalha().addPrata();
					// }
					// }
					// for (int m = 0; m < paisesTemp.size(); m++) {
					// if (((ProvaCol)
					// provaTemp.get(j)).getResultados().get(2).getEquipa().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i)))
					// {
					// paisesTemp.get(m).getMedalha().addBronze();
					// }
					// }

					int itInicioOuro = 0;
					int itFimOuro = 0;
					float temp;
					for (int l = 1; l < ((ProvaCol) provaTemp.get(j)).getResultados().size(); l++) {
						temp = ((ProvaCol) provaTemp.get(j)).getResultados().get(itInicioOuro).getResultado();
						if ((temp != ((ProvaCol) provaTemp.get(j)).getResultados().get(l).getResultado())) {
							itFimOuro = l - 1;
							break;
						}
					}
					int itInicioPrata = itFimOuro + 1;
					int itFimPrata = itInicioPrata;
					for (int l = itInicioPrata + 1; l < ((ProvaCol) provaTemp.get(j)).getResultados().size(); l++) {
						temp = ((ProvaCol) provaTemp.get(j)).getResultados().get(itInicioPrata).getResultado();
						if (temp != ((ProvaCol) provaTemp.get(j)).getResultados().get(l).getResultado()) {
							itFimPrata = l - 1;
							break;
						}
					}
					int itInicioBronze = itFimPrata + 1;
					int itFimBronze = 0;
					for (int l = itInicioBronze + 1; l < ((ProvaCol) provaTemp.get(j)).getResultados().size(); l++) {
						temp = ((ProvaCol) provaTemp.get(j)).getResultados().get(itInicioBronze).getResultado();
						if (temp != ((ProvaCol) provaTemp.get(j)).getResultados().get(l).getResultado()) {
							itFimBronze = l - 1;
							break;
						}
					}

					for (int l = itInicioOuro; l <= itFimOuro; l++) {
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
			for (int j = i; j < paisesTemp.size(); j++) {
				if (paisesTemp.get(i).compareTo(paisesTemp.get(j)) < 0) {
					Object obj = paisesTemp.get(j);
					paisesTemp.set(j, paisesTemp.get(i));
					paisesTemp.set(i, (Pais) obj);
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(paisesTemp.get(i).getNomePais() + ":" + paisesTemp.get(i).getMedalha().toString());
		}
	}
}
