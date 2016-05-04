package es.thesinsprods.zagastales.characters.race;

import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.CombatSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;

import es.thesinsprods.zagastales.juegozagas.creadornpcs.AtributosNPC;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.ConocimientosNPC;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.DestrezasNPC;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.MagiaNPC;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Atributos;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Conocimientos;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Destrezas;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Magia;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

public class Race {
	private String race;

	public Race(String race) {

		this.race = race;

	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public void CalculoRaza(Characters character)
			throws AtributeOutOfBoundsException, SkillOutOfBoundsException {
		if (Inicio.crear.equals("pj")) {
			if (this.race.equals("Alto Elfo")) {
				MagicSkills.skill0 = 2;
				MagicSkills.skill1 = 2;
				MagicSkills.skill2 = 6;
				MagicSkills.skill3 = 14;
				MagicSkills.skill4 = 30;
			}
			if (this.race.equals("Addar Meddwl")) {
				CombatSkills.skill0 = 4;
				CombatSkills.skill1 = 4;
				CombatSkills.skill2 = 8;
				CombatSkills.skill3 = 16;
				CombatSkills.skill4 = 32;
				Atributos.minInteligencia += 1;
				Atributos.minCarisma += 1;
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() + 1);
				character.getAtributes().setCharisma(
						character.getAtributes().getCharisma() + 1);

			}
			if (this.race.equals("Naga")) {
				Atributos.minResistencia += 1;

				Magia.minAgua += 1;

				character.getAtributes().setResistance(
						character.getAtributes().getResistance() + 1);
				character.getMagicSkills().setWater(
						character.getMagicSkills().getWater() + 1);
			}
			if (this.race.equals("Elfo Silvano")) {
				Atributos.minDestreza += 1;
				Atributos.minPercepcion += 1;

				character.getAtributes().setPerception(
						character.getAtributes().getPerception() + 1);
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() + 1);
			}
			if (this.race.equals("Elfo Oscuro")) {
				Destrezas.minSig += 2;
				character.getKnowhowSkills().setStealth(
						character.getKnowhowSkills().getStealth() + 2);
			}
			if (this.race.equals("Enano")) {
				Atributos.minResistencia += 1;
				Atributos.minResistenciaM += 1;

				character.getAtributes().setResistance(
						character.getAtributes().getResistance() + 1);
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() + 1);
			}
			if (this.race.equals("Gnomo")) {
				Conocimientos.minCS += 2;

				character.getKnowledgeSkills()
						.setSecretKnowledge(
								character.getKnowledgeSkills()
										.getSecretKnowledge() + 2);
			}
			if (this.race.equals("Orco")) {
				Conocimientos.minAG += 1;
				Atributos.minFuerza += 1;

				character.getAtributes().setStrength(
						character.getAtributes().getStrength() + 1);
				character.getKnowledgeSkills().setArtofWar(
						character.getKnowledgeSkills().getArtofWar() + 1);
			}
			if (this.race.equals("Humano")) {
				Destrezas.minSup += 2;

				character.getKnowhowSkills().setSurvival(
						character.getKnowhowSkills().getSurvival() + 2);
			}
		} else {

			if (this.race.equals("Alto Elfo")) {
				MagicSkills.skill0 = 2;
				MagicSkills.skill1 = 2;
				MagicSkills.skill2 = 6;
				MagicSkills.skill3 = 14;
				MagicSkills.skill4 = 30;
			}
			if (this.race.equals("Addar Meddwl")) {
				CombatSkills.skill0 = 4;
				CombatSkills.skill1 = 4;
				CombatSkills.skill2 = 8;
				CombatSkills.skill3 = 16;
				CombatSkills.skill4 = 32;
				AtributosNPC.minInteligencia += 1;
				AtributosNPC.minCarisma += 1;
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() + 1);
				character.getAtributes().setCharisma(
						character.getAtributes().getCharisma() + 1);

			}
			if (this.race.equals("Naga")) {
				AtributosNPC.minResistencia += 1;

				MagiaNPC.minAgua += 1;

				character.getAtributes().setResistance(
						character.getAtributes().getResistance() + 1);
				character.getMagicSkills().setWater(
						character.getMagicSkills().getWater() + 1);
			}
			if (this.race.equals("Elfo Silvano")) {
				AtributosNPC.minDestreza += 1;
				AtributosNPC.minPercepcion += 1;

				character.getAtributes().setPerception(
						character.getAtributes().getPerception() + 1);
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() + 1);
			}
			if (this.race.equals("Elfo Oscuro")) {
				DestrezasNPC.minSig += 2;
				character.getKnowhowSkills().setStealth(
						character.getKnowhowSkills().getStealth() + 2);
			}
			if (this.race.equals("Enano")) {
				AtributosNPC.minResistencia += 1;
				AtributosNPC.minResistenciaM += 1;

				character.getAtributes().setResistance(
						character.getAtributes().getResistance() + 1);
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() + 1);
			}
			if (this.race.equals("Gnomo")) {
				ConocimientosNPC.minCS += 2;

				character.getKnowledgeSkills()
						.setSecretKnowledge(
								character.getKnowledgeSkills()
										.getSecretKnowledge() + 2);
			}
			if (this.race.equals("Orco")) {
				ConocimientosNPC.minAG += 1;
				AtributosNPC.minFuerza += 1;

				character.getAtributes().setStrength(
						character.getAtributes().getStrength() + 1);
				character.getKnowledgeSkills().setArtofWar(
						character.getKnowledgeSkills().getArtofWar() + 1);
			}
			if (this.race.equals("Humano")) {
				DestrezasNPC.minSup += 2;

				character.getKnowhowSkills().setSurvival(
						character.getKnowhowSkills().getSurvival() + 2);
			}

		}
	}

	public void CalculoRazaInv(Characters character)
			throws AtributeOutOfBoundsException, SkillOutOfBoundsException {
		if (Inicio.crear.equals("pj")) {
			if (this.race.equals("Alto Elfo")) {
				MagicSkills.skill0 = 4;
				MagicSkills.skill1 = 4;
				MagicSkills.skill2 = 8;
				MagicSkills.skill3 = 16;
				MagicSkills.skill4 = 32;
			}
			if (this.race.equals("Addar Meddwl")) {
				CombatSkills.skill0 = 1;
				CombatSkills.skill1 = 2;
				CombatSkills.skill2 = 4;
				CombatSkills.skill3 = 8;
				CombatSkills.skill4 = 16;
				Atributos.minInteligencia -= 1;
				Atributos.minCarisma -= 1;
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() - 1);
				character.getAtributes().setCharisma(
						character.getAtributes().getCharisma() - 1);

			}
			if (this.race.equals("Naga")) {
				Atributos.minResistencia -= 1;
				Magia.minAgua -= 1;

				character.getAtributes().setResistance(
						character.getAtributes().getResistance() - 1);
				character.getMagicSkills().setWater(
						character.getMagicSkills().getWater() - 1);
			}
			if (this.race.equals("Elfo Silvano")) {
				Atributos.minDestreza -= 1;
				Atributos.minPercepcion -= 1;

				character.getAtributes().setPerception(
						character.getAtributes().getPerception() - 1);
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() - 1);
			}
			if (this.race.equals("Elfo Oscuro")) {
				Destrezas.minSig -= 2;

				character.getKnowhowSkills().setStealth(
						character.getKnowhowSkills().getStealth() - 2);
			}
			if (this.race.equals("Enano")) {
				Atributos.minResistencia -= 1;
				Atributos.minResistenciaM -= 1;

				character.getAtributes().setResistance(
						character.getAtributes().getResistance() - 1);
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() - 1);
			}
			if (this.race.equals("Gnomo")) {
				Conocimientos.minCS -= 2;

				character.getKnowledgeSkills()
						.setSecretKnowledge(
								character.getKnowledgeSkills()
										.getSecretKnowledge() - 2);
			}
			if (this.race.equals("Orco")) {
				Conocimientos.minAG -= 1;
				Atributos.minFuerza -= 1;

				character.getAtributes().setStrength(
						character.getAtributes().getStrength() - 1);
				character.getKnowledgeSkills().setArtofWar(
						character.getKnowledgeSkills().getArtofWar() - 1);
			}
			if (this.race.equals("Humano")) {
				Destrezas.minSup -= 2;

				character.getKnowhowSkills().setSurvival(
						character.getKnowhowSkills().getSurvival() - 2);
			}
		} else {

			if (this.race.equals("Alto Elfo")) {
				MagicSkills.skill0 = 4;
				MagicSkills.skill1 = 4;
				MagicSkills.skill2 = 8;
				MagicSkills.skill3 = 16;
				MagicSkills.skill4 = 32;
			}
			if (this.race.equals("Addar Meddwl")) {
				CombatSkills.skill0 = 1;
				CombatSkills.skill1 = 2;
				CombatSkills.skill2 = 4;
				CombatSkills.skill3 = 8;
				CombatSkills.skill4 = 16;
				AtributosNPC.minInteligencia -= 1;
				AtributosNPC.minCarisma -= 1;
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() - 1);
				character.getAtributes().setCharisma(
						character.getAtributes().getCharisma() - 1);

			}
			if (this.race.equals("Naga")) {
				AtributosNPC.minResistencia -= 1;
				MagiaNPC.minAgua -= 1;

				character.getAtributes().setResistance(
						character.getAtributes().getResistance() - 1);
				character.getMagicSkills().setWater(
						character.getMagicSkills().getWater() - 1);
			}
			if (this.race.equals("Elfo Silvano")) {
				AtributosNPC.minDestreza -= 1;
				AtributosNPC.minPercepcion -= 1;

				character.getAtributes().setPerception(
						character.getAtributes().getPerception() - 1);
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() - 1);
			}
			if (this.race.equals("Elfo Oscuro")) {
				DestrezasNPC.minSig -= 2;

				character.getKnowhowSkills().setStealth(
						character.getKnowhowSkills().getStealth() - 2);
			}
			if (this.race.equals("Enano")) {
				AtributosNPC.minResistencia -= 1;
				AtributosNPC.minResistenciaM -= 1;

				character.getAtributes().setResistance(
						character.getAtributes().getResistance() - 1);
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() - 1);
			}
			if (this.race.equals("Gnomo")) {
				ConocimientosNPC.minCS -= 2;

				character.getKnowledgeSkills()
						.setSecretKnowledge(
								character.getKnowledgeSkills()
										.getSecretKnowledge() - 2);
			}
			if (this.race.equals("Orco")) {
				ConocimientosNPC.minAG -= 1;
				AtributosNPC.minFuerza -= 1;

				character.getAtributes().setStrength(
						character.getAtributes().getStrength() - 1);
				character.getKnowledgeSkills().setArtofWar(
						character.getKnowledgeSkills().getArtofWar() - 1);
			}
			if (this.race.equals("Humano")) {
				DestrezasNPC.minSup -= 2;

				character.getKnowhowSkills().setSurvival(
						character.getKnowhowSkills().getSurvival() - 2);
			}

		}
	}

}
