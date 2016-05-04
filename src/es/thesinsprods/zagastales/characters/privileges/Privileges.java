package es.thesinsprods.zagastales.characters.privileges;

import java.util.ArrayList;

import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.CombatSkills;
import es.thesinsprods.zagastales.characters.skills.KnowledgeSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.AtributosNPC;

public class Privileges {
	private ArrayList<String> privilegio;

	public Privileges() {
		this.privilegio = new ArrayList<String>();
	}

	public void add(String privilegio) throws PrivilegeOutOfBoundsException {
		int contador = 0;
		int repetido = 0;
		if (this.privilegio.size() < 5) {
			for (int i = 0; i < this.privilegio.size(); i++) {
				if (this.privilegio.get(i).equals(privilegio)) {
					repetido = i;
					contador = contador + 1;
				} else {
					if (this.privilegio.get(i) != null) {
						contador = contador + 1;
					} else {
						break;
					}
				}
			}
			if (contador == 5) {
				throw new PrivilegeOutOfBoundsException(
						"No puedes tener más de 5 privilegios");
			} else {
				if (this.privilegio.size() == 0) {
					this.privilegio.add(privilegio);
				} else {
					if (this.privilegio.get(repetido) != privilegio
							|| privilegio.equals("Posesión")) {
						this.privilegio.add(privilegio);
					}
				}
			}
		}
	}

	public ArrayList<String> getPrivilegio() {
		return privilegio;
	}

	public boolean Search(String privilegio) {
		boolean found = false;
		for (int i = 0; i < this.privilegio.size(); i++) {

			if (this.privilegio.get(i).equals(privilegio)) {
				found = true;
			}
		}

		return found;

	}

	public int ContarPosesiones() {
		int contador = 0;
		for (int i = 0; i < this.privilegio.size(); i++) {
			if (this.privilegio.get(i).equals("Posesión")) {
				contador = contador + 1;
			}

		}
		return contador;
	}

	public int ContarLegendario() {
		int contador = 0;
		for (int i = 0; i < this.privilegio.size(); i++) {
			if (this.privilegio.get(i).equals("Artefacto Legendario")) {
				contador = contador + 1;
			}

		}
		return contador;
	}

	public void setPrivilegio(ArrayList<String> privilegio) {
		this.privilegio = privilegio;
	}

	public void CalculoPrivilegios(Characters character)
			throws AtributeOutOfBoundsException {
		for (int i = 0; i < this.privilegio.size(); i++) {
			if (this.privilegio.get(i).equals("Afinidad Arcana")) {
				MagicSkills.skill0 = 2;
				MagicSkills.skill1 = 2;
				MagicSkills.skill2 = 6;
				MagicSkills.skill3 = 14;
				MagicSkills.skill4 = 30;

			}
			if (this.privilegio.get(i).equals("Torrente Arcano")) {

				character.setMana(character.getMana() + 5);

			}
			if (this.privilegio.get(i).equals("Duro")) {

				character.setLife(character.getLife() + 3);
			}
			if (this.privilegio.get(i).equals("Incansable")) {

				character.setEndurance(character.getEndurance() + 5);
			}
			if (this.privilegio.get(i).equals("Fornido")) {

			}
			if (this.privilegio.get(i).equals("Mente Ágil")) {
				KnowledgeSkills.skill0 = 1;
				KnowledgeSkills.skill1 = 2;
				KnowledgeSkills.skill2 = 4;
				KnowledgeSkills.skill3 = 8;
				KnowledgeSkills.skill4 = 16;
			}
			if (this.privilegio.get(i).equals("Posesión")) {
			}
			if (this.privilegio.get(i).equals("Experto")) {
			}
			if (this.privilegio.get(i).equals("Maestro")) {
			}
			if (this.privilegio.get(i).equals("Noble")) {
			}
			if (this.privilegio.get(i).equals("Curación Rápida")) {
			}
			if (this.privilegio.get(i).equals("Talento")) {
			}
			if (this.privilegio.get(i).equals("Aliado")) {
			}
			if (this.privilegio.get(i).equals("Buena Estrella")) {
			}
			if (this.privilegio.get(i).equals(
					"Maestro de Armas:Armas de Una Mano")) {
			}
			if (this.privilegio.get(i).equals(
					"Maestro de Armas:Armas de Dos Manos")) {
			}
			if (this.privilegio.get(i).equals("Maestro de Armas:Armas de Asta")) {
			}
			if (this.privilegio.get(i).equals(
					"Maestro de Armas:Armas a Distancia")) {
			}
			if (this.privilegio.get(i).equals("Maestro de Armas:Esquivar")) {
			}
			if (this.privilegio.get(i).equals("Maestro de Armas:Bloquear")) {
			}
			if (this.privilegio.get(i).equals("Erudito")) {
			}
			if (this.privilegio.get(i).equals("Archimago")) {
			}
			if (this.privilegio.get(i).equals("Virtuoso")) {
			}
			if (this.privilegio.get(i).equals("Berseker")) {
			}
			if (this.privilegio.get(i).equals("Mago Universalista")) {

				MagicSkills.skill0 = 1;
				MagicSkills.skill1 = 2;
				MagicSkills.skill2 = 4;
				MagicSkills.skill3 = 8;
				MagicSkills.skill4 = 16;

			}
			if (this.privilegio.get(i).equals("Geiser Arcano")) {

				character.setMana(character.getMana() + 10);

			}
			if (this.privilegio.get(i).equals("Enérgico")) {
				character.setEndurance(character.getEndurance() + 10);
			}
			if (this.privilegio.get(i).equals("Hercúleo")) {
				character.getAtributes().setStrength(
						character.getAtributes().getStrength() + 3);
				AtributosNPC.minFuerza += 3;
			}
			if (this.privilegio.get(i).equals("Hábil")) {
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() + 3);
				AtributosNPC.minDestreza += 3;
			}
			if (this.privilegio.get(i).equals("Sólido")) {
				character.getAtributes().setResistance(
						character.getAtributes().getResistance() + 3);
				AtributosNPC.minResistencia += 3;
			}
			if (this.privilegio.get(i).equals("Anti-Magia")) {
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() + 3);
				AtributosNPC.minResistenciaM += 3;
			}
			if (this.privilegio.get(i).equals("Gran Cerebro")) {
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() + 3);
				AtributosNPC.minInteligencia += 3;
			}
			if (this.privilegio.get(i).equals("Ojo de Halcón")) {
				character.getAtributes().setPerception(
						character.getAtributes().getPerception() + 3);
				AtributosNPC.minPercepcion += 3;
			}
			if (this.privilegio.get(i).equals("Engatusador")) {
				character.getAtributes().setCharisma(
						character.getAtributes().getCharisma() + 3);
				AtributosNPC.minCarisma += 3;
			}
			if (this.privilegio.get(i).equals("Artefacto Legendario")) {
			}

		}

	}

	public void CalculoPrivilegiosInv(Characters character)
			throws AtributeOutOfBoundsException {
		for (int i = 0; i < this.privilegio.size(); i++) {
			if (this.privilegio.get(i).equals("Afinidad Arcana")) {
				MagicSkills.skill0 = 4;
				MagicSkills.skill1 = 4;
				MagicSkills.skill2 = 8;
				MagicSkills.skill3 = 16;
				MagicSkills.skill4 = 32;

			}
			if (this.privilegio.get(i).equals("Torrente Arcano")) {

				character.setMana(character.getMana() - 5);

			}
			if (this.privilegio.get(i).equals("Duro")) {

				character.setLife(character.getLife() - 3);
			}
			if (this.privilegio.get(i).equals("Incansable")) {

				character.setEndurance(character.getEndurance() - 5);
			}
			if (this.privilegio.get(i).equals("Fornido")) {

			}
			if (this.privilegio.get(i).equals("Mente Ágil")) {
				KnowledgeSkills.skill0 = 1;
				KnowledgeSkills.skill1 = 2;
				KnowledgeSkills.skill2 = 6;
				KnowledgeSkills.skill3 = 12;
				KnowledgeSkills.skill4 = 20;
			}
			if (this.privilegio.get(i).equals("Posesión")) {
			}
			if (this.privilegio.get(i).equals("Experto")) {
			}
			if (this.privilegio.get(i).equals("Maestro")) {
			}
			if (this.privilegio.get(i).equals("Noble")) {
			}
			if (this.privilegio.get(i).equals("Curación Rápida")) {
			}
			if (this.privilegio.get(i).equals("Talento")) {
			}
			if (this.privilegio.get(i).equals("Aliado")) {
			}
			if (this.privilegio.get(i).equals("Buena Estrella")) {
			}
			if (this.privilegio.get(i).equals("Maestro de Armas")) {
			}
			if (this.privilegio.get(i).equals("Erudito")) {
			}
			if (this.privilegio.get(i).equals("Archimago")) {
			}
			if (this.privilegio.get(i).equals("Virtuoso")) {
			}
			if (this.privilegio.get(i).equals("Berseker")) {
			}
			if (this.privilegio.get(i).equals("Mago Universalista")) {

				MagicSkills.skill0 = 4;
				MagicSkills.skill1 = 4;
				MagicSkills.skill2 = 8;
				MagicSkills.skill3 = 16;
				MagicSkills.skill4 = 32;

			}
			if (this.privilegio.get(i).equals("Geiser Arcano")) {

				character.setMana(character.getMana() - 10);

			}
			if (this.privilegio.get(i).equals("Enérgico")) {
				character.setEndurance(character.getEndurance() - 10);
			}
			if (this.privilegio.get(i).equals("Hercúleo")) {
				character.getAtributes().setStrength(
						character.getAtributes().getStrength() - 3);
				AtributosNPC.minFuerza -= 3;
			}
			if (this.privilegio.get(i).equals("Hábil")) {
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() - 3);
				AtributosNPC.minDestreza -= 3;
			}
			if (this.privilegio.get(i).equals("Sólido")) {
				character.getAtributes().setResistance(
						character.getAtributes().getResistance() - 3);
				AtributosNPC.minResistencia -= 3;
			}
			if (this.privilegio.get(i).equals("Anti-Magia")) {
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() - 3);
				AtributosNPC.minResistenciaM -= 3;
			}
			if (this.privilegio.get(i).equals("Gran Cerebro")) {
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() - 3);
				AtributosNPC.minInteligencia -= 3;
			}
			if (this.privilegio.get(i).equals("Ojo de Halcón")) {
				character.getAtributes().setPerception(
						character.getAtributes().getPerception() - 3);
				AtributosNPC.minPercepcion -= 3;
			}
			if (this.privilegio.get(i).equals("Engatusador")) {
				character.getAtributes().setCharisma(
						character.getAtributes().getCharisma() - 3);
				AtributosNPC.minCarisma -= 3;
			}
			if (this.privilegio.get(i).equals("Artefacto Legendario")) {
			}
		}

	}
}
