package jogosolimpicos;

import listaligada.ListaLigada;

public class Listagem {

	public static ListaLigada<Pais> listarMedalhasPais(ListaLigada<Pais> paises, ListaLigada<Prova> provas, int anoInicio, int anoFim, String modalidade, Disciplina disciplina) {
		ListaLigada<Prova> provaTemp = new ListaLigada<Prova>();
		for (int i = 0; i < provas.size(); i++) {
			provaTemp.add(provas.get(i));
		}

		ListaLigada<Pais> paisesTemp = new ListaLigada<Pais>();
		for (int i = 0; i < paises.size(); i++) {
			paises.get(i).getMedalha().resetMedalhas();
			paisesTemp.add(paises.get(i));
		}

		for (int i = 0; i < provaTemp.size(); i++) {
			if (!(disciplina == null) && !provaTemp.get(i).getDisciplina().equals(disciplina)) {
				provaTemp.remove(i);
				i--;
			}
		}

		for (int i = 0; i < provaTemp.size(); i++) {
			if (!(modalidade == null) && !provaTemp.get(i).getDisciplina().getModalidade().getNome().equalsIgnoreCase(modalidade)) {
				provaTemp.remove(i);
				i--;
			}
		}

		for (int i = anoInicio; i <= anoFim; i += 4) {
			for (int j = 0; j < provaTemp.size(); j++) {
				if (provaTemp.get(j).getJogosOlimpicos().getAno() < anoInicio || provaTemp.get(j).getJogosOlimpicos().getAno() > anoFim) {
					provaTemp.remove(j);
					j--;
				} else if (provaTemp.get(j).getJogosOlimpicos().getAno() == i && provaTemp.get(j) instanceof ProvaInd && !((ProvaInd) provaTemp.get(j)).getResultados().isEmpty()) {
					provaTemp.get(j).ordenar();

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
					int itFimBronze = itInicioBronze;
					for (int l = itInicioBronze + 1; l < ((ProvaInd) provaTemp.get(j)).getResultados().size(); l++) {
						temp = ((ProvaInd) provaTemp.get(j)).getResultados().get(itInicioBronze).getResultado();
						if (temp != ((ProvaInd) provaTemp.get(j)).getResultados().get(l).getResultado()) {
							itFimBronze = l - 1;
							break;
						}
					}

					for (int l = itInicioOuro; itFimOuro < ((ProvaInd) provaTemp.get(j)).getResultados().size() && l <= itFimOuro; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addOuro();
							}
						}
					}
					for (int l = itInicioPrata; itFimPrata < ((ProvaInd) provaTemp.get(j)).getResultados().size() && l <= itFimPrata; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addPrata();
							}
						}
					}
					for (int l = itInicioBronze; itFimBronze < ((ProvaInd) provaTemp.get(j)).getResultados().size() && l <= itFimBronze; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addBronze();
							}
						}
					}
					provaTemp.remove(j);
					j--;

				} else if (provaTemp.get(j).getJogosOlimpicos().getAno() == i && provaTemp.get(j) instanceof ProvaCol && !((ProvaCol) provaTemp.get(j)).getResultados().isEmpty()) {
					provaTemp.get(j).ordenar();

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
					int itFimBronze = itInicioBronze;
					for (int l = itInicioBronze + 1; l < ((ProvaCol) provaTemp.get(j)).getResultados().size(); l++) {
						temp = ((ProvaCol) provaTemp.get(j)).getResultados().get(itInicioBronze).getResultado();
						if (temp != ((ProvaCol) provaTemp.get(j)).getResultados().get(l).getResultado()) {
							itFimBronze = l - 1;
							break;
						}
					}

					for (int l = itInicioOuro; itFimOuro < ((ProvaCol) provaTemp.get(j)).getResultados().size() && l <= itFimOuro; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addOuro();
							}
						}
					}
					for (int l = itInicioPrata; itFimPrata < ((ProvaCol) provaTemp.get(j)).getResultados().size() && l <= itFimPrata; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addPrata();
							}
						}
					}
					for (int l = itInicioBronze; itFimBronze < ((ProvaCol) provaTemp.get(j)).getResultados().size() && l <= itFimBronze; l++) {
						for (int m = 0; m < paisesTemp.size(); m++) {
							if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getPais().getCodigoPais(i).equalsIgnoreCase(paisesTemp.get(m).getCodigoPais(i))) {
								paisesTemp.get(m).getMedalha().addBronze();
							}
						}
					}
					provaTemp.remove(j);
					j--;

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

		return paisesTemp;
	}

	public static ListaLigada<Atleta> listarMedalhasAtleta(ListaLigada<Atleta> atletas, ListaLigada<Equipa> equipas, ListaLigada<Prova> provas, int anoInicio, int anoFim, String modalidade, Disciplina disciplina) {
		ListaLigada<Prova> provaTemp = new ListaLigada<Prova>();
		for (int i = 0; i < provas.size(); i++) {
			provaTemp.add(provas.get(i));
		}

		ListaLigada<Atleta> atletasTemp = new ListaLigada<Atleta>();
		for (int i = 0; i < atletas.size(); i++) {
			atletas.get(i).getMedalha().resetMedalhas();
			atletasTemp.add(atletas.get(i));
		}
		ListaLigada<Equipa> equipasTemp = new ListaLigada<Equipa>();
		for (int i = 0; i < equipas.size(); i++) {
			equipasTemp.add(equipas.get(i));
		}

		for (int i = 0; i < provaTemp.size(); i++) {
			if (!(disciplina == null) && !provaTemp.get(i).getDisciplina().equals(disciplina)) {
				provaTemp.remove(i);
				i--;
			}
		}

		for (int i = 0; i < provaTemp.size(); i++) {
			if (!(modalidade == null) && !provaTemp.get(i).getDisciplina().getModalidade().getNome().equalsIgnoreCase(modalidade)) {
				provaTemp.remove(i);
				i--;
			}
		}

		for (int i = anoInicio; i <= anoFim; i += 4) {
			for (int j = 0; j < provaTemp.size(); j++) {
				if (provaTemp.get(j).getJogosOlimpicos().getAno() < anoInicio || provaTemp.get(j).getJogosOlimpicos().getAno() > anoFim) {
					provaTemp.remove(j);
					j--;
				} else if (provaTemp.get(j).getJogosOlimpicos().getAno() == i && provaTemp.get(j) instanceof ProvaInd && !((ProvaInd) provaTemp.get(j)).getResultados().isEmpty()) {
					provaTemp.get(j).ordenar();

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
					int itFimBronze = itInicioBronze;
					for (int l = itInicioBronze + 1; l < ((ProvaInd) provaTemp.get(j)).getResultados().size(); l++) {
						temp = ((ProvaInd) provaTemp.get(j)).getResultados().get(itInicioBronze).getResultado();
						if (temp != ((ProvaInd) provaTemp.get(j)).getResultados().get(l).getResultado()) {
							itFimBronze = l - 1;
							break;
						}
					}

					for (int l = itInicioOuro; itFimOuro < ((ProvaInd) provaTemp.get(j)).getResultados().size() && l <= itFimOuro; l++) {
						for (int m = 0; m < atletasTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getID() == atletasTemp.get(m).getID()) {
								atletasTemp.get(m).getMedalha().addOuro();
							}
						}
					}
					for (int l = itInicioPrata; itFimPrata < ((ProvaInd) provaTemp.get(j)).getResultados().size() && l <= itFimPrata; l++) {
						for (int m = 0; m < atletasTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getID() == atletasTemp.get(m).getID()) {
								atletasTemp.get(m).getMedalha().addPrata();
							}
						}
					}
					for (int l = itInicioBronze; itFimBronze < ((ProvaInd) provaTemp.get(j)).getResultados().size() && l <= itFimBronze; l++) {
						for (int m = 0; m < atletasTemp.size(); m++) {
							if (((ProvaInd) provaTemp.get(j)).getResultados().get(l).getAtleta().getID() == atletasTemp.get(m).getID()) {
								atletasTemp.get(m).getMedalha().addBronze();
							}
						}
					}
					provaTemp.remove(j);
					j--;

				} else if (provaTemp.get(j).getJogosOlimpicos().getAno() == i && provaTemp.get(j) instanceof ProvaCol && !((ProvaCol) provaTemp.get(j)).getResultados().isEmpty()) {
					provaTemp.get(j).ordenar();

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
					int itFimBronze = itInicioBronze;
					for (int l = itInicioBronze + 1; l < ((ProvaCol) provaTemp.get(j)).getResultados().size(); l++) {
						temp = ((ProvaCol) provaTemp.get(j)).getResultados().get(itInicioBronze).getResultado();
						if (temp != ((ProvaCol) provaTemp.get(j)).getResultados().get(l).getResultado()) {
							itFimBronze = l - 1;
							break;
						}
					}

					for (int l = itInicioOuro; itFimOuro < ((ProvaCol) provaTemp.get(j)).getResultados().size() && l <= itFimOuro; l++) {
						for (int m = 0; m < equipasTemp.size(); m++) {
							if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getID() == equipasTemp.get(m).getID()) {
								for (int n = 0; n < ((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getAtleta().size(); n++) {
									for (int o = 0; o < atletasTemp.size(); o++) {
										if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getAtleta().get(n).getID() == atletasTemp.get(o).getID()) {
											atletasTemp.get(o).getMedalha().addOuro();
										}
									}
								}
							}
						}
					}
					for (int l = itInicioPrata; itFimPrata < ((ProvaCol) provaTemp.get(j)).getResultados().size() && l <= itFimPrata; l++) {
						for (int m = 0; m < equipasTemp.size(); m++) {
							if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getID() == equipasTemp.get(m).getID()) {
								for (int n = 0; n < ((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getAtleta().size(); n++) {
									for (int o = 0; o < atletasTemp.size(); o++) {
										if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getAtleta().get(n).getID() == atletasTemp.get(o).getID()) {
											atletasTemp.get(o).getMedalha().addPrata();
										}
									}
								}
							}
						}
					}
					for (int l = itInicioBronze; itFimBronze < ((ProvaCol) provaTemp.get(j)).getResultados().size() && l <= itFimBronze; l++) {
						for (int m = 0; m < equipasTemp.size(); m++) {
							if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getID() == equipasTemp.get(m).getID()) {
								for (int n = 0; n < ((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getAtleta().size(); n++) {
									for (int o = 0; o < atletasTemp.size(); o++) {
										if (((ProvaCol) provaTemp.get(j)).getResultados().get(l).getEquipa().getAtleta().get(n).getID() == atletasTemp.get(o).getID()) {
											atletasTemp.get(o).getMedalha().addBronze();
										}
									}
								}
							}
						}
					}
					provaTemp.remove(j);
					j--;

				}
			}
		}

		for (int i = 0; i < atletasTemp.size() - 1; i++) {
			for (int j = i; j < atletasTemp.size(); j++) {
				if (atletasTemp.get(i).compareTo(atletasTemp.get(j)) < 0) {
					Object obj = atletasTemp.get(j);
					atletasTemp.set(j, atletasTemp.get(i));
					atletasTemp.set(i, (Atleta) obj);
				}
			}
		}

		return atletasTemp;
	}

	public static Object[] estatisticaPais(Pais pais, ListaLigada<Prova> provas, ListaLigada<Pais> paises) {
		Object valores[] = new Object[7];
		int valTemp[] = new int[4];

		valores[0] = jogosParticipou(pais, provas);
		valores[1] = disciplinasParticipou(pais, provas);
		valTemp = medalhasGanhasRank(pais, paises, provas, 0, 9999, null, null);
		valores[2] = (valTemp[0]);
		valores[3] = (valTemp[1]);
		valores[4] = (valTemp[2]);
		valores[5] = (valTemp[3]);
		valores[6] = (int) valores[0] != 0 ? ((int) valores[2] + (int) valores[3] + (int) valores[4]) / (int) valores[0] : 0;

		return valores;
	}

	private static int[] medalhasGanhasRank(Pais pais, ListaLigada<Pais> paises, ListaLigada<Prova> provas, int anoInicio, int anoFim, String modalidade, Disciplina disciplina) {
		ListaLigada<Pais> paisesTemp = listarMedalhasPais(paises, provas, anoInicio, anoFim, modalidade, disciplina);
		int valTemp[] = new int[4];

		int itPais = 0;
		for (; itPais < paisesTemp.size(); itPais++) {
			if (pais.getCodigoPais(0).equalsIgnoreCase(paisesTemp.get(itPais).getCodigoPais(0))) {
				break;
			}
		}

		valTemp[0] = paisesTemp.get(itPais).getMedalha().getOuro();
		valTemp[1] = paisesTemp.get(itPais).getMedalha().getPrata();
		valTemp[2] = paisesTemp.get(itPais).getMedalha().getBronze();
		valTemp[3] = itPais + 1;

		return valTemp;
	}

	private static int disciplinasParticipou(Pais pais, ListaLigada<Prova> provas) {
		ListaLigada<Disciplina> discTemp = new ListaLigada<Disciplina>();

		for (int i = 0; i < provas.size(); i++) {
			if (provas.get(i) instanceof ProvaInd) {
				for (int j = 0; j < ((ProvaInd) provas.get(i)).getResultados().size(); j++) {
					if (((ProvaInd) provas.get(i)).getResultados().get(j).getAtleta().getPais().getCodigoPais(provas.get(i).getJogosOlimpicos().getAno()).equalsIgnoreCase(pais.getCodigoPais(provas.get(i).getJogosOlimpicos().getAno()))) {
						if (!discTemp.contains(provas.get(i).getDisciplina())) {
							discTemp.add(provas.get(i).getDisciplina());
						}
					}
				}
			} else if (provas.get(i) instanceof ProvaCol) {
				for (int j = 0; j < ((ProvaCol) provas.get(i)).getResultados().size(); j++) {
					if (((ProvaCol) provas.get(i)).getResultados().get(j).getEquipa().getPais().getCodigoPais(provas.get(i).getJogosOlimpicos().getAno()).equalsIgnoreCase(pais.getCodigoPais(provas.get(i).getJogosOlimpicos().getAno()))) {
						if (!discTemp.contains(provas.get(i).getDisciplina())) {
							discTemp.add(provas.get(i).getDisciplina());
						}
					}
				}
			}

		}

		return discTemp.size();
	}

	private static int jogosParticipou(Pais pais, ListaLigada<Prova> provas) {

		ListaLigada<JogosOlimpicos> jogosTemp = new ListaLigada<JogosOlimpicos>();

		for (int i = 0; i < provas.size(); i++) {
			if (provas.get(i) instanceof ProvaInd) {
				for (int j = 0; j < ((ProvaInd) provas.get(i)).getResultados().size(); j++) {
					if (((ProvaInd) provas.get(i)).getResultados().get(j).getAtleta().getPais().getCodigoPais(provas.get(i).getJogosOlimpicos().getAno()).equalsIgnoreCase(pais.getCodigoPais(provas.get(i).getJogosOlimpicos().getAno()))) {
						if (!jogosTemp.contains(provas.get(i).getJogosOlimpicos())) {
							jogosTemp.add(provas.get(i).getJogosOlimpicos());
						}
					}
				}
			} else if (provas.get(i) instanceof ProvaCol) {
				for (int j = 0; j < ((ProvaCol) provas.get(i)).getResultados().size(); j++) {
					if (((ProvaCol) provas.get(i)).getResultados().get(j).getEquipa().getPais().getCodigoPais(provas.get(i).getJogosOlimpicos().getAno()).equalsIgnoreCase(pais.getCodigoPais(provas.get(i).getJogosOlimpicos().getAno()))) {
						if (!jogosTemp.contains(provas.get(i).getJogosOlimpicos())) {
							jogosTemp.add(provas.get(i).getJogosOlimpicos());
						}
					}
				}
			}

		}

		return jogosTemp.size();
	}

}
