package es.thesinsprods.zagastales.characters.blessings;

import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;

public class Curse {

	private String curse;

	public Curse(String curse) {

		this.curse = curse;
	}

	public String getCurse() {
		return curse;
	}

	public void setCurse(String curse) {
		this.curse = curse;
	}

	public void calculoExtras(Characters character, boolean campeon)
			throws SkillOutOfBoundsException, AtributeOutOfBoundsException {
		if (this.curse.equals("Maldición de Sylendyl")) {
			character.setMana(14);

		}
		if (this.curse.equals("Maldición de Yanirem")) {

			character.getMagicSkills().setDruidic(
					character.getMagicSkills().getDruidic() - 1);

		}
		if (this.curse.equals("Maldición de Tenerus")) {

			character.getMagicSkills().setBlack(
					character.getMagicSkills().getBlack() - 1);

		}
		if (this.curse.equals("Maldición de Gralnach")) {

			character.getMagicSkills().setEarth(
					character.getMagicSkills().getEarth() - 1);

		}
		if (this.curse.equals("Maldición de Bodvar")) {

			character.getKnowledgeSkills().setSecretKnowledge(
					character.getKnowledgeSkills().getSecretKnowledge() - 2);
		}
		if (this.curse.equals("Maldición de Mavrila")) {

			character.getKnowhowSkills().setStealth(
					character.getKnowhowSkills().getStealth() - 1);

		}
		if (this.curse.equals("Maldición de Voltarus")) {

		}
		if (this.curse.equals("Maldición de Aurelius")) {

		}
		if (this.curse.equals("Maldición de Timoria")) {

			character.getAtributes().setDexterity(
					character.getAtributes().getDexterity() - 2);

		}
		if (this.curse.equals("Maldición de Timor")) {

		}
		if (this.curse.equals("Maldición de Pséftis")) {

			character.getKnowhowSkills().setTraps(
					character.getKnowhowSkills().getTraps() - 1);

		}
		if (this.curse.equals("Maldición de Sérpos")) {

			character.getMagicSkills().setWater(
					character.getMagicSkills().getWater() - 1);

		}
		if (this.curse.equals("Maldición de Diliges")) {

			character.getMagicSkills().setWhite(
					character.getMagicSkills().getWhite() - 1);

		}
		if (this.curse.equals("Maldición de Ektra")) {

		}
		if (this.curse.equals("Maldición de K'aris")) {

			character.getMagicSkills().setWind(
					character.getMagicSkills().getWind() - 1);

		}
		if (this.curse.equals("Maldición de Yánguin")) {

			character.getMagicSkills().setFire(
					character.getMagicSkills().getFire() - 1);

		}
	}

	public void calculoExtrasInv(Characters character, boolean campeon)
			throws SkillOutOfBoundsException, AtributeOutOfBoundsException {
		if (this.curse.equals("Maldición de Sylendyl")) {
			character.setMana(20);

		}
		if (this.curse.equals("Maldición de Yanirem")) {

			character.getMagicSkills().setDruidic(
					character.getMagicSkills().getDruidic() + 1);

		}
		if (this.curse.equals("Maldición de Tenerus")) {

			character.getMagicSkills().setBlack(
					character.getMagicSkills().getBlack() + 1);

		}
		if (this.curse.equals("Maldición de Gralnach")) {

			character.getMagicSkills().setEarth(
					character.getMagicSkills().getEarth() + 1);

		}
		if (this.curse.equals("Maldición de Bodvar")) {

			character.getKnowledgeSkills().setSecretKnowledge(
					character.getKnowledgeSkills().getSecretKnowledge() + 2);
		}
		if (this.curse.equals("Maldición de Mavrila")) {

			character.getKnowhowSkills().setStealth(
					character.getKnowhowSkills().getStealth() + 1);

		}
		if (this.curse.equals("Maldición de Voltarus")) {

		}
		if (this.curse.equals("Maldición de Aurelius")) {

		}
		if (this.curse.equals("Maldición de Timoria")) {

			character.getAtributes().setDexterity(
					character.getAtributes().getDexterity() + 2);

		}
		if (this.curse.equals("Maldición de Timor")) {

		}
		if (this.curse.equals("Maldición de Pséftis")) {

			character.getKnowhowSkills().setTraps(
					character.getKnowhowSkills().getTraps() + 1);

		}
		if (this.curse.equals("Maldición de Sérpos")) {

			character.getMagicSkills().setWater(
					character.getMagicSkills().getWater() + 1);

		}
		if (this.curse.equals("Maldición de Diliges")) {

			character.getMagicSkills().setWhite(
					character.getMagicSkills().getWhite() + 1);

		}
		if (this.curse.equals("Maldición de Ektra")) {

		}
		if (this.curse.equals("Maldición de K'aris")) {

			character.getMagicSkills().setWind(
					character.getMagicSkills().getWind() + 1);

		}
		if (this.curse.equals("Maldición de Yánguin")) {

			character.getMagicSkills().setFire(
					character.getMagicSkills().getFire() + 1);

		}
	}

}
