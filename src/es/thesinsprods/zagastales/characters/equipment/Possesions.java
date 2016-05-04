package es.thesinsprods.zagastales.characters.equipment;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.AtributosNPC;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.CombateNPC;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.ConocimientosNPC;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.DestrezasNPC;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.MagiaNPC;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.PosesionesNPC;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Atributos;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Combate;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Conocimientos;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Destrezas;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Magia;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Posesiones;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Start;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

public class Possesions {

	private ArrayList<String> pos;

	public Possesions(ArrayList<String> pos) {
		this.pos = pos;

	}

	public void setPos(ArrayList<String> pos) {
		this.pos = pos;
	}

	public ArrayList<String> getPos() {
		return this.pos;
	}

	public boolean Search(String poss) {
		int cont = 0;
		for (int i = 0; i < this.pos.size(); i++) {
			if (pos.get(i).equals(poss)) {
				cont = 1;

			}

		}
		if (cont == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void CalculoPosesion(Characters character)
			throws AtributeOutOfBoundsException, SkillOutOfBoundsException {

		if (Inicio.crear.equals("pj")) {
			int contfpriv = 0;
			boolean exp = character.getPrivileges().Search("Experto");
			boolean mas = character.getPrivileges().Search("Maestro");
			boolean ap = character.getSetbacks().Search("Aprendiz");
			for (int i = 0; i < this.pos.size(); i++) {
				if (this.pos.get(i).equals("+1 Fuerza")) {
					character.getAtributes().setStrength(
							character.getAtributes().getStrength() + 1);
					Atributos.minFuerza += 1;
				}

				if (this.pos.get(i).equals("+1 Destreza")) {
					character.getAtributes().setDexterity(
							character.getAtributes().getDexterity() + 1);
					Atributos.minDestreza += 1;
				}

				if (this.pos.get(i).equals("+1 Resistencia")) {
					character.getAtributes().setResistance(
							character.getAtributes().getResistance() + 1);
					Atributos.minResistencia += 1;
				}

				if (this.pos.get(i).equals("+1 Resistencia Mágica")) {
					character.getAtributes().setMagicres(
							character.getAtributes().getMagicres() + 1);
					Atributos.minResistenciaM += 1;
				}

				if (this.pos.get(i).equals("+1 Inteligencia")) {
					character.getAtributes().setIntelligence(
							character.getAtributes().getIntelligence() + 1);
					Atributos.minInteligencia += 1;
				}

				if (this.pos.get(i).equals("+1 Percepción")) {
					character.getAtributes().setPerception(
							character.getAtributes().getPerception() + 1);
					Atributos.minPercepcion += 1;
				}

				if (this.pos.get(i).equals("+1 Carisma")) {
					character.getAtributes().setCharisma(
							character.getAtributes().getCharisma() + 1);
					Atributos.minCarisma += 1;
				}

				if (this.pos.get(i).equals("+1 Armas de Una Mano")) {
					if ((character.getCombatSkills().getOneHanded() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getCombatSkills().getOneHanded() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getCombatSkills().getOneHanded() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getCombatSkills().setOneHanded(
										character.getCombatSkills()
												.getOneHanded() + 1);
								Combate.minUna += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Armas de Dos Manos")) {

					if ((character.getCombatSkills().getTwoHanded() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getCombatSkills().getTwoHanded() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getCombatSkills().getTwoHanded() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getCombatSkills().setTwoHanded(
										character.getCombatSkills()
												.getTwoHanded() + 1);
								Combate.minDos += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Armas de Asta")) {

					if ((character.getCombatSkills().getPole() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getCombatSkills().getPole() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getCombatSkills().getPole() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getCombatSkills()
										.setPole(
												character.getCombatSkills()
														.getPole() + 1);
								Combate.minAsta += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Armas a Distancia")) {

					if ((character.getCombatSkills().getRanged() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getCombatSkills().getRanged() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getCombatSkills().getRanged() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getCombatSkills()
										.setRanged(
												character.getCombatSkills()
														.getRanged() + 1);
								Combate.minDist += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Esquivar")) {

					if ((character.getCombatSkills().getDodge() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getCombatSkills().getDodge() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getCombatSkills().getDodge() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getCombatSkills()
										.setDodge(
												character.getCombatSkills()
														.getDodge() + 1);
								Combate.minEsq += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Bloquear")) {

					if ((character.getCombatSkills().getBlock() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getCombatSkills().getBlock() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getCombatSkills().getBlock() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getCombatSkills()
										.setBlock(
												character.getCombatSkills()
														.getBlock() + 1);
								Combate.minBloq += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Arte de la Guerra")) {
					if ((character.getKnowledgeSkills().getArtofWar() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getArtofWar() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getArtofWar() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowledgeSkills().setArtofWar(
										character.getKnowledgeSkills()
												.getArtofWar() + 1);
								Conocimientos.minAG += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Diplomacia")) {
					if ((character.getKnowledgeSkills().getDiplomacy() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getDiplomacy() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getDiplomacy() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowledgeSkills().setDiplomacy(
										character.getKnowledgeSkills()
												.getDiplomacy() + 1);
								Conocimientos.minDip += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Etiqueta")) {
					if ((character.getKnowledgeSkills().getEtiquette() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getEtiquette() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getEtiquette() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowledgeSkills().setEtiquette(
										character.getKnowledgeSkills()
												.getEtiquette() + 1);
								Conocimientos.minEt += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Medicina")) {
					if ((character.getKnowledgeSkills().getMedicine() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getMedicine() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getMedicine() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowledgeSkills().setMedicine(
										character.getKnowledgeSkills()
												.getMedicine() + 1);
								Conocimientos.minMed += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Ocultismo")) {
					if ((character.getKnowledgeSkills().getOccultism() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getOccultism() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getOccultism() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowledgeSkills().setOccultism(
										character.getKnowledgeSkills()
												.getOccultism() + 1);
								Conocimientos.minOc += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Investigacion")) {
					if ((character.getKnowledgeSkills().getResearch() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getResearch() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getResearch() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowledgeSkills().setResearch(
										character.getKnowledgeSkills()
												.getResearch() + 1);
								Conocimientos.minInv += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Negociación")) {
					if ((character.getKnowledgeSkills().getNegotiation() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getNegotiation() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getNegotiation() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowledgeSkills().setNegotiation(
										character.getKnowledgeSkills()
												.getNegotiation() + 1);
								Conocimientos.minNeg += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Conocimientos Secretos")) {
					if ((character.getKnowledgeSkills().getSecretKnowledge() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getSecretKnowledge() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowledgeSkills()
									.getSecretKnowledge() == 2 && ap == true) {
								Posesiones.app = 1;
							} else {
								character
										.getKnowledgeSkills()
										.setSecretKnowledge(
												character.getKnowledgeSkills()
														.getSecretKnowledge() + 1);
								Conocimientos.minCS += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Fuego")) {
					if ((character.getMagicSkills().getFire() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getMagicSkills().getFire() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getMagicSkills().getFire() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getMagicSkills()
										.setFire(
												character.getMagicSkills()
														.getFire() + 1);
								Magia.minFuego += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Agua")) {
					if ((character.getMagicSkills().getWater() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getMagicSkills().getWater() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getMagicSkills().getWater() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getMagicSkills()
										.setWater(
												character.getMagicSkills()
														.getWater() + 1);
								Magia.minAgua += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Tierra")) {
					if ((character.getMagicSkills().getEarth() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getMagicSkills().getEarth() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getMagicSkills().getEarth() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getMagicSkills()
										.setEarth(
												character.getMagicSkills()
														.getEarth() + 1);
								Magia.minTierra += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Viento")) {
					if ((character.getMagicSkills().getWind() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getMagicSkills().getWind() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getMagicSkills().getWind() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getMagicSkills()
										.setWind(
												character.getMagicSkills()
														.getWind() + 1);
								Magia.minViento += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Blanca")) {
					if ((character.getMagicSkills().getWhite() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getMagicSkills().getWhite() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getMagicSkills().getWhite() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getMagicSkills()
										.setWhite(
												character.getMagicSkills()
														.getWhite() + 1);
								Magia.minBlanca += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Negra")) {
					if ((character.getMagicSkills().getBlack() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getMagicSkills().getBlack() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getMagicSkills().getBlack() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getMagicSkills()
										.setBlack(
												character.getMagicSkills()
														.getBlack() + 1);
								Magia.minNegra += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Druidica")) {
					if ((character.getMagicSkills().getDruidic() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getMagicSkills().getDruidic() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getMagicSkills().getDruidic() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getMagicSkills()
										.setDruidic(
												character.getMagicSkills()
														.getDruidic() + 1);
								Magia.minDruidica += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Arcana")) {
					if ((character.getMagicSkills().getArcane() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getMagicSkills().getArcane() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getMagicSkills().getArcane() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getMagicSkills()
										.setArcane(
												character.getMagicSkills()
														.getArcane() + 1);
								Magia.minArcana += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Atletismo")) {
					if ((character.getKnowhowSkills().getAthletics() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowhowSkills().getAthletics() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowhowSkills().getAthletics() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowhowSkills().setAthletics(
										character.getKnowhowSkills()
												.getAthletics() + 1);
								Destrezas.minAtl += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Supervivencia")) {
					if ((character.getKnowhowSkills().getSurvival() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowhowSkills().getSurvival() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowhowSkills().getSurvival() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowhowSkills().setSurvival(
										character.getKnowhowSkills()
												.getSurvival() + 1);
								Destrezas.minSup += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Equitación")) {
					if ((character.getKnowhowSkills().getEquitation() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowhowSkills().getEquitation() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowhowSkills().getEquitation() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowhowSkills().setEquitation(
										character.getKnowhowSkills()
												.getEquitation() + 1);
								Destrezas.minEq += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Trampas")) {
					if ((character.getKnowhowSkills().getTraps() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowhowSkills().getTraps() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowhowSkills().getTraps() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowhowSkills()
										.setTraps(
												character.getKnowhowSkills()
														.getTraps() + 1);
								Destrezas.minTra += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Sigilo")) {
					if ((character.getKnowhowSkills().getStealth() == 3 && exp == false)) {
						Posesiones.exp = 1;
					} else {
						if (character.getKnowhowSkills().getStealth() == 4
								&& mas == false) {
							Posesiones.masp = 1;
						} else {
							if (character.getKnowhowSkills().getStealth() == 2
									&& ap == true) {
								Posesiones.app = 1;
							} else {
								character.getKnowhowSkills().setStealth(
										character.getKnowhowSkills()
												.getStealth() + 1);
								Destrezas.minSig += 1;
							}
						}
					}
				}
				if(this.pos.get(i).equals("+3 Salud")){
					
					character.setLife(character.getLife()+3);
				}
				if(this.pos.get(i).equals("+5 Energía")){
					character.setEndurance(character.getEndurance()+5);
				}
				if(this.pos.get(i).equals("+5 Maná")){
					character.setMana(character.getMana()+5);
				}
			}

		}

		else {
			int contfpriv = 0;
			boolean exp = character.getPrivileges().Search("Experto");
			boolean mas = character.getPrivileges().Search("Maestro");
			boolean ap = character.getSetbacks().Search("Aprendiz");
			for (int i = 0; i < this.pos.size(); i++) {
				if (this.pos.get(i).equals("+1 Fuerza")) {
					character.getAtributes().setStrength(
							character.getAtributes().getStrength() + 1);
					AtributosNPC.minFuerza += 1;
				}

				if (this.pos.get(i).equals("+1 Destreza")) {
					character.getAtributes().setDexterity(
							character.getAtributes().getDexterity() + 1);
					AtributosNPC.minDestreza += 1;
				}

				if (this.pos.get(i).equals("+1 Resistencia")) {
					character.getAtributes().setResistance(
							character.getAtributes().getResistance() + 1);
					AtributosNPC.minResistencia += 1;
				}

				if (this.pos.get(i).equals("+1 Resistencia Mágica")) {
					character.getAtributes().setMagicres(
							character.getAtributes().getMagicres() + 1);
					AtributosNPC.minResistenciaM += 1;
				}

				if (this.pos.get(i).equals("+1 Inteligencia")) {
					character.getAtributes().setIntelligence(
							character.getAtributes().getIntelligence() + 1);
					AtributosNPC.minInteligencia += 1;
				}

				if (this.pos.get(i).equals("+1 Percepción")) {
					character.getAtributes().setPerception(
							character.getAtributes().getPerception() + 1);
					AtributosNPC.minPercepcion += 1;
				}

				if (this.pos.get(i).equals("+1 Carisma")) {
					character.getAtributes().setCharisma(
							character.getAtributes().getCharisma() + 1);
					AtributosNPC.minCarisma += 1;
				}

				if (this.pos.get(i).equals("+1 Armas de Una Mano")) {
					if ((character.getCombatSkills().getOneHanded() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getCombatSkills().getOneHanded() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getCombatSkills().getOneHanded() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getCombatSkills().setOneHanded(
										character.getCombatSkills()
												.getOneHanded() + 1);
								CombateNPC.minUna += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Armas de Dos Manos")) {

					if ((character.getCombatSkills().getTwoHanded() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getCombatSkills().getTwoHanded() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getCombatSkills().getTwoHanded() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getCombatSkills().setTwoHanded(
										character.getCombatSkills()
												.getTwoHanded() + 1);
								CombateNPC.minDos += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Armas de Asta")) {

					if ((character.getCombatSkills().getPole() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getCombatSkills().getPole() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getCombatSkills().getPole() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getCombatSkills()
										.setPole(
												character.getCombatSkills()
														.getPole() + 1);
								CombateNPC.minAsta += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Armas a Distancia")) {

					if ((character.getCombatSkills().getRanged() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getCombatSkills().getRanged() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getCombatSkills().getRanged() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getCombatSkills()
										.setRanged(
												character.getCombatSkills()
														.getRanged() + 1);
								CombateNPC.minDist += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Esquivar")) {

					if ((character.getCombatSkills().getDodge() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getCombatSkills().getDodge() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getCombatSkills().getDodge() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getCombatSkills()
										.setDodge(
												character.getCombatSkills()
														.getDodge() + 1);
								CombateNPC.minEsq += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Bloquear")) {

					if ((character.getCombatSkills().getBlock() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getCombatSkills().getBlock() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getCombatSkills().getBlock() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getCombatSkills()
										.setBlock(
												character.getCombatSkills()
														.getBlock() + 1);
								CombateNPC.minBloq += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Arte de la Guerra")) {
					if ((character.getKnowledgeSkills().getArtofWar() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getArtofWar() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getArtofWar() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowledgeSkills().setArtofWar(
										character.getKnowledgeSkills()
												.getArtofWar() + 1);
								ConocimientosNPC.minAG += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Diplomacia")) {
					if ((character.getKnowledgeSkills().getDiplomacy() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getDiplomacy() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getDiplomacy() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowledgeSkills().setDiplomacy(
										character.getKnowledgeSkills()
												.getDiplomacy() + 1);
								ConocimientosNPC.minDip += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Etiqueta")) {
					if ((character.getKnowledgeSkills().getEtiquette() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getEtiquette() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getEtiquette() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowledgeSkills().setEtiquette(
										character.getKnowledgeSkills()
												.getEtiquette() + 1);
								ConocimientosNPC.minEt += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Medicina")) {
					if ((character.getKnowledgeSkills().getMedicine() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getMedicine() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getMedicine() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowledgeSkills().setMedicine(
										character.getKnowledgeSkills()
												.getMedicine() + 1);
								ConocimientosNPC.minMed += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Ocultismo")) {
					if ((character.getKnowledgeSkills().getOccultism() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getOccultism() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getOccultism() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowledgeSkills().setOccultism(
										character.getKnowledgeSkills()
												.getOccultism() + 1);
								ConocimientosNPC.minOc += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Investigacion")) {
					if ((character.getKnowledgeSkills().getResearch() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getResearch() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getResearch() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowledgeSkills().setResearch(
										character.getKnowledgeSkills()
												.getResearch() + 1);
								ConocimientosNPC.minInv += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Negociación")) {
					if ((character.getKnowledgeSkills().getNegotiation() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getNegotiation() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowledgeSkills().getNegotiation() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowledgeSkills().setNegotiation(
										character.getKnowledgeSkills()
												.getNegotiation() + 1);
								ConocimientosNPC.minNeg += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Conocimientos Secretos")) {
					if ((character.getKnowledgeSkills().getSecretKnowledge() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowledgeSkills().getSecretKnowledge() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowledgeSkills()
									.getSecretKnowledge() == 2 && ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character
										.getKnowledgeSkills()
										.setSecretKnowledge(
												character.getKnowledgeSkills()
														.getSecretKnowledge() + 1);
								ConocimientosNPC.minCS += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Fuego")) {
					if ((character.getMagicSkills().getFire() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getMagicSkills().getFire() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getMagicSkills().getFire() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getMagicSkills()
										.setFire(
												character.getMagicSkills()
														.getFire() + 1);
								MagiaNPC.minFuego += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Agua")) {
					if ((character.getMagicSkills().getWater() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getMagicSkills().getWater() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getMagicSkills().getWater() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getMagicSkills()
										.setWater(
												character.getMagicSkills()
														.getWater() + 1);
								MagiaNPC.minAgua += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Tierra")) {
					if ((character.getMagicSkills().getEarth() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getMagicSkills().getEarth() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getMagicSkills().getEarth() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getMagicSkills()
										.setEarth(
												character.getMagicSkills()
														.getEarth() + 1);
								MagiaNPC.minTierra += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Viento")) {
					if ((character.getMagicSkills().getWind() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getMagicSkills().getWind() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getMagicSkills().getWind() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getMagicSkills()
										.setWind(
												character.getMagicSkills()
														.getWind() + 1);
								MagiaNPC.minViento += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Blanca")) {
					if ((character.getMagicSkills().getWhite() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getMagicSkills().getWhite() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getMagicSkills().getWhite() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getMagicSkills()
										.setWhite(
												character.getMagicSkills()
														.getWhite() + 1);
								MagiaNPC.minBlanca += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Negra")) {
					if ((character.getMagicSkills().getBlack() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getMagicSkills().getBlack() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getMagicSkills().getBlack() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getMagicSkills()
										.setBlack(
												character.getMagicSkills()
														.getBlack() + 1);
								MagiaNPC.minNegra += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Druidica")) {
					if ((character.getMagicSkills().getDruidic() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getMagicSkills().getDruidic() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getMagicSkills().getDruidic() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getMagicSkills()
										.setDruidic(
												character.getMagicSkills()
														.getDruidic() + 1);
								MagiaNPC.minDruidica += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Magia Arcana")) {
					if ((character.getMagicSkills().getArcane() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getMagicSkills().getArcane() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getMagicSkills().getArcane() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getMagicSkills()
										.setArcane(
												character.getMagicSkills()
														.getArcane() + 1);
								MagiaNPC.minArcana += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Atletismo")) {
					if ((character.getKnowhowSkills().getAthletics() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowhowSkills().getAthletics() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowhowSkills().getAthletics() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowhowSkills().setAthletics(
										character.getKnowhowSkills()
												.getAthletics() + 1);
								DestrezasNPC.minAtl += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Supervivencia")) {
					if ((character.getKnowhowSkills().getSurvival() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowhowSkills().getSurvival() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowhowSkills().getSurvival() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowhowSkills().setSurvival(
										character.getKnowhowSkills()
												.getSurvival() + 1);
								DestrezasNPC.minSup += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Equitación")) {
					if ((character.getKnowhowSkills().getEquitation() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowhowSkills().getEquitation() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowhowSkills().getEquitation() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowhowSkills().setEquitation(
										character.getKnowhowSkills()
												.getEquitation() + 1);
								DestrezasNPC.minEq += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Trampas")) {
					if ((character.getKnowhowSkills().getTraps() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowhowSkills().getTraps() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowhowSkills().getTraps() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowhowSkills()
										.setTraps(
												character.getKnowhowSkills()
														.getTraps() + 1);
								DestrezasNPC.minTra += 1;
							}
						}
					}
				}
				if (this.pos.get(i).equals("+1 Sigilo")) {
					if ((character.getKnowhowSkills().getStealth() == 3 && exp == false)) {
						PosesionesNPC.exp = 1;
					} else {
						if (character.getKnowhowSkills().getStealth() == 4
								&& mas == false) {
							PosesionesNPC.masp = 1;
						} else {
							if (character.getKnowhowSkills().getStealth() == 2
									&& ap == true) {
								PosesionesNPC.app = 1;
							} else {
								character.getKnowhowSkills().setStealth(
										character.getKnowhowSkills()
												.getStealth() + 1);
								DestrezasNPC.minSig += 1;
							}
						}
					}
					if(this.pos.get(i).equals("+3 Salud")){
						
						character.setLife(character.getLife()+3);
					}
					if(this.pos.get(i).equals("+5 Energía")){
						character.setEndurance(character.getEndurance()+5);
					}
					if(this.pos.get(i).equals("+5 Maná")){
						character.setMana(character.getMana()+5);
					}
				}
			}
		}

	}

	public void CalculoPosesionInv(Characters character)
			throws AtributeOutOfBoundsException, SkillOutOfBoundsException {
		if (Inicio.crear.equals("pj")) {
			for (int i = 0; i < this.pos.size(); i++) {
				if (this.pos.get(i).equals("+1 Fuerza")) {
					character.getAtributes().setStrength(
							character.getAtributes().getStrength() - 1);
					Atributos.minFuerza -= 1;
				}

				if (this.pos.get(i).equals("+1 Destreza")) {
					character.getAtributes().setDexterity(
							character.getAtributes().getDexterity() - 1);
					Atributos.minDestreza -= 1;
				}

				if (this.pos.get(i).equals("+1 Resistencia")) {
					character.getAtributes().setResistance(
							character.getAtributes().getResistance() - 1);
					Atributos.minResistencia -= 1;
				}

				if (this.pos.get(i).equals("+1 Resistencia Mágica")) {
					character.getAtributes().setMagicres(
							character.getAtributes().getMagicres() - 1);
					Atributos.minResistenciaM -= 1;
				}

				if (this.pos.get(i).equals("+1 Inteligencia")) {
					character.getAtributes().setIntelligence(
							character.getAtributes().getIntelligence() - 1);
					Atributos.minInteligencia -= 1;
				}

				if (this.pos.get(i).equals("+1 Percepción")) {
					character.getAtributes().setPerception(
							character.getAtributes().getPerception() - 1);
					Atributos.minPercepcion -= 1;
				}

				if (this.pos.get(i).equals("+1 Carisma")) {
					character.getAtributes().setCharisma(
							character.getAtributes().getCharisma() - 1);
					Atributos.minCarisma -= 1;
				}

				if (this.pos.get(i).equals("+1 Armas de Una Mano")) {

					character.getCombatSkills().setOneHanded(
							character.getCombatSkills().getOneHanded() - 1);
					Combate.minUna -= 1;
				}
				if (this.pos.get(i).equals("+1 Armas de Dos Manos")) {
					character.getCombatSkills().setTwoHanded(
							character.getCombatSkills().getTwoHanded() - 1);
					Combate.minDos -= 1;
				}
				if (this.pos.get(i).equals("+1 Armas de Asta")) {
					character.getCombatSkills().setPole(
							character.getCombatSkills().getPole() - 1);
					Combate.minAsta -= 1;
				}
				if (this.pos.get(i).equals("+1 Armas a Distancia")) {
					character.getCombatSkills().setRanged(
							character.getCombatSkills().getRanged() - 1);
					Combate.minDist -= 1;
				}
				if (this.pos.get(i).equals("+1 Esquivar")) {
					character.getCombatSkills().setDodge(
							character.getCombatSkills().getDodge() - 1);
					Combate.minEsq -= 1;
				}
				if (this.pos.get(i).equals("+1 Bloquear")) {
					character.getCombatSkills().setBlock(
							character.getCombatSkills().getBlock() - 1);
					Combate.minBloq -= 1;
				}
				if (this.pos.get(i).equals("+1 Arte de la Guerra")) {
					character.getKnowledgeSkills().setArtofWar(
							character.getKnowledgeSkills().getArtofWar() - 1);
					Conocimientos.minAG -= 1;
				}
				if (this.pos.get(i).equals("+1 Diplomacia")) {
					character.getKnowledgeSkills().setDiplomacy(
							character.getKnowledgeSkills().getDiplomacy() - 1);
					Conocimientos.minDip -= 1;
				}
				if (this.pos.get(i).equals("+1 Etiqueta")) {
					character.getKnowledgeSkills().setEtiquette(
							character.getKnowledgeSkills().getEtiquette() - 1);
					Conocimientos.minEt -= 1;
				}
				if (this.pos.get(i).equals("+1 Medicina")) {
					character.getKnowledgeSkills().setMedicine(
							character.getKnowledgeSkills().getMedicine() - 1);
					Conocimientos.minMed -= 1;
				}
				if (this.pos.get(i).equals("+1 Ocultismo")) {
					character.getKnowledgeSkills().setOccultism(
							character.getKnowledgeSkills().getOccultism() - 1);
					Conocimientos.minOc -= 1;
				}
				if (this.pos.get(i).equals("+1 Investigacion")) {
					character.getKnowledgeSkills().setResearch(
							character.getKnowledgeSkills().getResearch() - 1);
					Conocimientos.minInv -= 1;
				}
				if (this.pos.get(i).equals("+1 Negociación")) {
					character.getKnowledgeSkills()
							.setNegotiation(
									character.getKnowledgeSkills()
											.getNegotiation() - 1);
					Conocimientos.minNeg -= 1;
				}
				if (this.pos.get(i).equals("+1 Conocimientos Secretos")) {
					character.getKnowledgeSkills()
							.setSecretKnowledge(
									character.getKnowledgeSkills()
											.getSecretKnowledge() - 1);
					Conocimientos.minCS -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Fuego")) {
					character.getMagicSkills().setFire(
							character.getMagicSkills().getFire() - 1);
					Magia.minFuego -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Agua")) {
					character.getMagicSkills().setWater(
							character.getMagicSkills().getWater() - 1);
					Magia.minAgua -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Tierra")) {
					character.getMagicSkills().setEarth(
							character.getMagicSkills().getEarth() - 1);
					Magia.minTierra -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Viento")) {
					character.getMagicSkills().setWind(
							character.getMagicSkills().getWind() - 1);
					Magia.minViento -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Blanca")) {
					character.getMagicSkills().setWhite(
							character.getMagicSkills().getWhite() - 1);
					Magia.minBlanca -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Negra")) {
					character.getMagicSkills().setBlack(
							character.getMagicSkills().getBlack() - 1);
					Magia.minNegra -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Druidica")) {
					character.getMagicSkills().setDruidic(
							character.getMagicSkills().getDruidic() - 1);
					Magia.minDruidica -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Arcana")) {
					character.getMagicSkills().setArcane(
							character.getMagicSkills().getArcane() - 1);
					Magia.minArcana -= 1;
				}
				if (this.pos.get(i).equals("+1 Atletismo")) {
					character.getKnowhowSkills().setAthletics(
							character.getKnowhowSkills().getAthletics() - 1);
					Destrezas.minAtl -= 1;
				}
				if (this.pos.get(i).equals("+1 Supervivencia")) {
					character.getKnowhowSkills().setSurvival(
							character.getKnowhowSkills().getSurvival() - 1);
					Destrezas.minSup -= 1;
				}
				if (this.pos.get(i).equals("+1 Equitación")) {
					character.getKnowhowSkills().setEquitation(
							character.getKnowhowSkills().getEquitation() - 1);
					Destrezas.minEq -= 1;
				}
				if (this.pos.get(i).equals("+1 Trampas")) {
					character.getKnowhowSkills().setTraps(
							character.getKnowhowSkills().getTraps() - 1);
					Destrezas.minTra -= 1;
				}
				if (this.pos.get(i).equals("+1 Sigilo")) {
					character.getKnowhowSkills().setStealth(
							character.getKnowhowSkills().getStealth() - 1);
					Destrezas.minSig -= 1;
				}
				if(this.pos.get(i).equals("+3 Salud")){
					
					character.setLife(character.getLife()-3);
				}
				if(this.pos.get(i).equals("+5 Energía")){
					character.setEndurance(character.getEndurance()-5);
				}
				if(this.pos.get(i).equals("+5 Maná")){
					character.setMana(character.getMana()-5);
				}
			}

		} else {

			for (int i = 0; i < this.pos.size(); i++) {
				if (this.pos.get(i).equals("+1 Fuerza")) {
					character.getAtributes().setStrength(
							character.getAtributes().getStrength() - 1);
					AtributosNPC.minFuerza -= 1;
				}

				if (this.pos.get(i).equals("+1 Destreza")) {
					character.getAtributes().setDexterity(
							character.getAtributes().getDexterity() - 1);
					AtributosNPC.minDestreza -= 1;
				}

				if (this.pos.get(i).equals("+1 Resistencia")) {
					character.getAtributes().setResistance(
							character.getAtributes().getResistance() - 1);
					AtributosNPC.minResistencia -= 1;
				}

				if (this.pos.get(i).equals("+1 Resistencia Mágica")) {
					character.getAtributes().setMagicres(
							character.getAtributes().getMagicres() - 1);
					AtributosNPC.minResistenciaM -= 1;
				}

				if (this.pos.get(i).equals("+1 Inteligencia")) {
					character.getAtributes().setIntelligence(
							character.getAtributes().getIntelligence() - 1);
					AtributosNPC.minInteligencia -= 1;
				}

				if (this.pos.get(i).equals("+1 Percepción")) {
					character.getAtributes().setPerception(
							character.getAtributes().getPerception() - 1);
					AtributosNPC.minPercepcion -= 1;
				}

				if (this.pos.get(i).equals("+1 Carisma")) {
					character.getAtributes().setCharisma(
							character.getAtributes().getCharisma() - 1);
					AtributosNPC.minCarisma -= 1;
				}

				if (this.pos.get(i).equals("+1 Armas de Una Mano")) {

					character.getCombatSkills().setOneHanded(
							character.getCombatSkills().getOneHanded() - 1);
					CombateNPC.minUna -= 1;
				}
				if (this.pos.get(i).equals("+1 Armas de Dos Manos")) {
					character.getCombatSkills().setTwoHanded(
							character.getCombatSkills().getTwoHanded() - 1);
					CombateNPC.minDos -= 1;
				}
				if (this.pos.get(i).equals("+1 Armas de Asta")) {
					character.getCombatSkills().setPole(
							character.getCombatSkills().getPole() - 1);
					CombateNPC.minAsta -= 1;
				}
				if (this.pos.get(i).equals("+1 Armas a Distancia")) {
					character.getCombatSkills().setRanged(
							character.getCombatSkills().getRanged() - 1);
					CombateNPC.minDist -= 1;
				}
				if (this.pos.get(i).equals("+1 Esquivar")) {
					character.getCombatSkills().setDodge(
							character.getCombatSkills().getDodge() - 1);
					CombateNPC.minEsq -= 1;
				}
				if (this.pos.get(i).equals("+1 Bloquear")) {
					character.getCombatSkills().setBlock(
							character.getCombatSkills().getBlock() - 1);
					CombateNPC.minBloq -= 1;
				}
				if (this.pos.get(i).equals("+1 Arte de la Guerra")) {
					character.getKnowledgeSkills().setArtofWar(
							character.getKnowledgeSkills().getArtofWar() - 1);
					ConocimientosNPC.minAG -= 1;
				}
				if (this.pos.get(i).equals("+1 Diplomacia")) {
					character.getKnowledgeSkills().setDiplomacy(
							character.getKnowledgeSkills().getDiplomacy() - 1);
					ConocimientosNPC.minDip -= 1;
				}
				if (this.pos.get(i).equals("+1 Etiqueta")) {
					character.getKnowledgeSkills().setEtiquette(
							character.getKnowledgeSkills().getEtiquette() - 1);
					ConocimientosNPC.minEt -= 1;
				}
				if (this.pos.get(i).equals("+1 Medicina")) {
					character.getKnowledgeSkills().setMedicine(
							character.getKnowledgeSkills().getMedicine() - 1);
					ConocimientosNPC.minMed -= 1;
				}
				if (this.pos.get(i).equals("+1 Ocultismo")) {
					character.getKnowledgeSkills().setOccultism(
							character.getKnowledgeSkills().getOccultism() - 1);
					ConocimientosNPC.minOc -= 1;
				}
				if (this.pos.get(i).equals("+1 Investigacion")) {
					character.getKnowledgeSkills().setResearch(
							character.getKnowledgeSkills().getResearch() - 1);
					ConocimientosNPC.minInv -= 1;
				}
				if (this.pos.get(i).equals("+1 Negociación")) {
					character.getKnowledgeSkills()
							.setNegotiation(
									character.getKnowledgeSkills()
											.getNegotiation() - 1);
					ConocimientosNPC.minNeg -= 1;
				}
				if (this.pos.get(i).equals("+1 Conocimientos Secretos")) {
					character.getKnowledgeSkills()
							.setSecretKnowledge(
									character.getKnowledgeSkills()
											.getSecretKnowledge() - 1);
					ConocimientosNPC.minCS -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Fuego")) {
					character.getMagicSkills().setFire(
							character.getMagicSkills().getFire() - 1);
					MagiaNPC.minFuego -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Agua")) {
					character.getMagicSkills().setWater(
							character.getMagicSkills().getWater() - 1);
					MagiaNPC.minAgua -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Tierra")) {
					character.getMagicSkills().setEarth(
							character.getMagicSkills().getEarth() - 1);
					MagiaNPC.minTierra -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Viento")) {
					character.getMagicSkills().setWind(
							character.getMagicSkills().getWind() - 1);
					MagiaNPC.minViento -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Blanca")) {
					character.getMagicSkills().setWhite(
							character.getMagicSkills().getWhite() - 1);
					MagiaNPC.minBlanca -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Negra")) {
					character.getMagicSkills().setBlack(
							character.getMagicSkills().getBlack() - 1);
					MagiaNPC.minNegra -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Druidica")) {
					character.getMagicSkills().setDruidic(
							character.getMagicSkills().getDruidic() - 1);
					MagiaNPC.minDruidica -= 1;
				}
				if (this.pos.get(i).equals("+1 Magia Arcana")) {
					character.getMagicSkills().setArcane(
							character.getMagicSkills().getArcane() - 1);
					MagiaNPC.minArcana -= 1;
				}
				if (this.pos.get(i).equals("+1 Atletismo")) {
					character.getKnowhowSkills().setAthletics(
							character.getKnowhowSkills().getAthletics() - 1);
					DestrezasNPC.minAtl -= 1;
				}
				if (this.pos.get(i).equals("+1 Supervivencia")) {
					character.getKnowhowSkills().setSurvival(
							character.getKnowhowSkills().getSurvival() - 1);
					DestrezasNPC.minSup -= 1;
				}
				if (this.pos.get(i).equals("+1 Equitación")) {
					character.getKnowhowSkills().setEquitation(
							character.getKnowhowSkills().getEquitation() - 1);
					DestrezasNPC.minEq -= 1;
				}
				if (this.pos.get(i).equals("+1 Trampas")) {
					character.getKnowhowSkills().setTraps(
							character.getKnowhowSkills().getTraps() - 1);
					DestrezasNPC.minTra -= 1;
				}
				if (this.pos.get(i).equals("+1 Sigilo")) {
					character.getKnowhowSkills().setStealth(
							character.getKnowhowSkills().getStealth() - 1);
					DestrezasNPC.minSig -= 1;
				}
				if(this.pos.get(i).equals("+3 Salud")){
					
					character.setLife(character.getLife()-3);
				}
				if(this.pos.get(i).equals("+5 Energía")){
					character.setEndurance(character.getEndurance()-5);
				}
				if(this.pos.get(i).equals("+5 Maná")){
					character.setMana(character.getMana()-5);
				}
			}

		}
	}

}
