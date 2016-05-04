package es.thesinsprods.zagastales.characters.privileges;

import java.util.ArrayList;

import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.KnowledgeSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.AtributosNPC;

public class Setbacks {
	private ArrayList<String> reves;

	public Setbacks() {
		this.reves = new ArrayList<String>();
	}

	public void add(String privilegio) throws PrivilegeOutOfBoundsException {
		int contador = 0;
		int repetido = 0;
		if (this.reves.size() < 4) {
			for (int i = 0; i < this.reves.size(); i++) {
				if (this.reves.get(i).equals(privilegio)) {
					repetido = i;
					contador = contador + 1;
				} else {
					if (this.reves.get(i) != null) {
						contador = contador + 1;
					} else {
						break;
					}
				}
			}
			if (contador == 4) {
				throw new PrivilegeOutOfBoundsException(
						"No puedes tener más de 4 reveses");
			} else {
				if (this.reves.size() == 0) {
					this.reves.add(privilegio);
				} else {
					if (this.reves.get(repetido) != privilegio) {
						this.reves.add(privilegio);
					}
				}
			}
		}
	}

	public ArrayList<String> getReves() {
		return reves;
	}

	public void setReves(ArrayList<String> reves) {
		this.reves = reves;
	}

	public void CalculoReveses(Characters character)
			throws AtributeOutOfBoundsException {
		for (int i = 0; i < this.reves.size(); i++) {
			if (this.reves.get(i).equals("Inutilidad Arcana")) {
				MagicSkills.skill0 = 6;
				MagicSkills.skill1 = 6;
				MagicSkills.skill2 = 10;
				MagicSkills.skill3 = 18;
				MagicSkills.skill4 = 34;

			}
			if (this.reves.get(i).equals("Debilidad Arcana")) {

				character.setMana(character.getMana() - 5);

			}
			if (this.reves.get(i).equals("Frágil")) {

				character.setLife(character.getLife() - 3);
			}
			if (this.reves.get(i).equals("Baja Forma")) {

				character.setEndurance(character.getEndurance() - 5);
			}
			if (this.reves.get(i).equals("Debilidad")) {

			}
			if (this.reves.get(i).equals("Mente Lenta")) {
				KnowledgeSkills.skill0 = 2;
				KnowledgeSkills.skill1 = 4;
				KnowledgeSkills.skill2 = 12;
				KnowledgeSkills.skill3 = 24;
				KnowledgeSkills.skill4 = 40;
			}
			if (this.reves.get(i).equals("Aprendiz")) {
			}

			if (this.reves.get(i).equals("Descastado")) {
			}
			if (this.reves.get(i).equals("Curación Lenta")) {
			}
			if (this.reves.get(i).equals("Inutil")) {
			}
			if (this.reves.get(i).equals("Enemigo")) {
			}
			if (this.reves.get(i).equals("Mala Estrella")) {
			}
			if (this.reves.get(i).equals("Buscado por la Ley")) {
			}
			if (this.reves.get(i).equals("Imposibilidad Arcana")) {

				character.setMana(character.getMana() - 10);

			}

			if (this.reves.get(i).equals("Enclenque")) {
				character.getAtributes().setStrength(
						character.getAtributes().getStrength() - 3);
				AtributosNPC.minFuerza -= 3;
			}
			if (this.reves.get(i).equals("Incompetente")) {
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() - 3);
				AtributosNPC.minDestreza -= 3;
			}
			if (this.reves.get(i).equals("Quebradizo")) {
				character.getAtributes().setResistance(
						character.getAtributes().getResistance() - 3);
				AtributosNPC.minResistencia -= 3;
			}
			if (this.reves.get(i).equals("Perdición Arcana")) {
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() - 3);
				AtributosNPC.minResistenciaM -= 3;
			}
			if (this.reves.get(i).equals("Estúpido")) {
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() - 3);
				AtributosNPC.minInteligencia -= 3;
			}
			if (this.reves.get(i).equals("Ceguera")) {
				character.getAtributes().setPerception(
						character.getAtributes().getPerception() - 3);
				AtributosNPC.minPercepcion -= 3;
			}
			if (this.reves.get(i).equals("Tímido")) {
				character.getAtributes().setCharisma(
						character.getAtributes().getCharisma() - 3);
				AtributosNPC.minCarisma -= 3;
			}

		}

	}

	public void CalculoRevesesInv(Characters character)
			throws AtributeOutOfBoundsException {
		for (int i = 0; i < this.reves.size(); i++) {
			if (this.reves.get(i).equals("Inutilidad Arcana")) {
				MagicSkills.skill0 = 4;
				MagicSkills.skill1 = 4;
				MagicSkills.skill2 = 8;
				MagicSkills.skill3 = 16;
				MagicSkills.skill4 = 32;

			}
			if (this.reves.get(i).equals("Debilidad Arcana")) {

				character.setMana(character.getMana() + 5);

			}
			if (this.reves.get(i).equals("Frágil")) {

				character.setLife(character.getLife() + 3);
			}
			if (this.reves.get(i).equals("Baja Forma")) {

				character.setEndurance(character.getEndurance() + 5);
			}
			if (this.reves.get(i).equals("Debilidad")) {

			}
			if (this.reves.get(i).equals("Mente Lenta")) {
				KnowledgeSkills.skill0 = 2;
				KnowledgeSkills.skill1 = 4;
				KnowledgeSkills.skill2 = 6;
				KnowledgeSkills.skill3 = 12;
				KnowledgeSkills.skill4 = 20;
			}
			if (this.reves.get(i).equals("Aprendiz")) {
			}

			if (this.reves.get(i).equals("Descastado")) {
			}
			if (this.reves.get(i).equals("Curación Lenta")) {
			}
			if (this.reves.get(i).equals("Inutil")) {
			}
			if (this.reves.get(i).equals("Enemigo")) {
			}
			if (this.reves.get(i).equals("Mala Estrella")) {
			}
			if (this.reves.get(i).equals("Buscado por la Ley")) {
			}
			if (this.reves.get(i).equals("Imposibilidad Arcana")) {

				character.setMana(character.getMana() + 10);

			}

			if (this.reves.get(i).equals("Enclenque")) {
				character.getAtributes().setStrength(
						character.getAtributes().getStrength() + 3);
				AtributosNPC.minFuerza += 3;
			}
			if (this.reves.get(i).equals("Incompetente")) {
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() + 3);
				AtributosNPC.minDestreza += 3;
			}
			if (this.reves.get(i).equals("Quebradizo")) {
				character.getAtributes().setResistance(
						character.getAtributes().getResistance() + 3);
				AtributosNPC.minResistencia += 3;
			}
			if (this.reves.get(i).equals("Perdición Arcana")) {
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() + 3);
				AtributosNPC.minResistenciaM += 3;
			}
			if (this.reves.get(i).equals("Estúpido")) {
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() + 3);
				AtributosNPC.minInteligencia += 3;
			}
			if (this.reves.get(i).equals("Ceguera")) {
				character.getAtributes().setPerception(
						character.getAtributes().getPerception() + 3);
				AtributosNPC.minPercepcion += 3;
			}
			if (this.reves.get(i).equals("Tímido")) {
				character.getAtributes().setCharisma(
						character.getAtributes().getCharisma() + 3);
				AtributosNPC.minCarisma += 3;
			}

		}

	}

	public boolean Search(String reves) {
		boolean found = false;
		for (int i = 0; i < this.reves.size(); i++) {

			if (this.reves.get(i).equals(reves)) {
				found = true;
			}
		}

		return found;

	}
}
