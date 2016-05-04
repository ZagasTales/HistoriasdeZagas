package es.thesinsprods.zagastales.characters.blessings;

import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.AtributosNPC;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.ConocimientosNPC;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Atributos;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Conocimientos;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

public class Blessing {

	private String blessing;

	public Blessing(String blessing) {
		this.blessing = blessing;
	}

	public String getBlessing() {
		return blessing;
	}

	public void setBlessing(String blessing) {
		this.blessing = blessing;
	}

	public void calculoCampeon(Characters character)
			throws SkillOutOfBoundsException, AtributeOutOfBoundsException {
		if (this.blessing.equals("Arcanista de Sylendyl")) {
			character.getMagicSkills().setArcane(
					character.getMagicSkills().getArcane() + 1);
			if (character.getMagicSkills().getFire() < 2) {
				character.getMagicSkills().setFire(2);
			}
			if (character.getMagicSkills().getWater() < 2) {
				character.getMagicSkills().setWater(2);
			}
			if (character.getMagicSkills().getEarth() < 2) {
				character.getMagicSkills().setEarth(2);
			}
			if (character.getMagicSkills().getWind() < 2) {
				character.getMagicSkills().setWind(2);
			}
			if (character.getMagicSkills().getWhite() < 2) {
				character.getMagicSkills().setWhite(2);
			}
			if (character.getMagicSkills().getDruidic() < 2) {
				character.getMagicSkills().setDruidic(2);
			}
		}

		if (this.blessing.equals("Caballero Arcano de Sylendyl")) {
			character.getAtributes().setMagicres(
					character.getAtributes().getMagicres() + 1);
			AtributosNPC.minResistenciaM += 1;

		}

		if (this.blessing.equals("Druida de Yanirem")) {
			character.getMagicSkills().setDruidic(
					character.getMagicSkills().getDruidic() + 1);

		}
		if (this.blessing.equals("Guardabosques de Yanirem")) {
			character.getPrivileges().getPrivilegio().add("");
			character.getPrivileges().getPrivilegio().add("");
			character.getPrivileges().getPrivilegio().add("");
			character.getPrivileges().getPrivilegio().add("");
			character.getPrivileges().getPrivilegio().add("");
			character.getPrivileges().getPrivilegio().add(5, "Aliado");
			character.getPrivileges().getPrivilegio().add(6, "Aliado");

		}
		if (this.blessing.equals("Erudito de Bodvar")) {
		}
		if (this.blessing.equals("Ingeniero de Bodvar")) {

		}
		if (this.blessing.equals("Geomante de Gralnach")) {

			character.getMagicSkills().setEarth(
					character.getMagicSkills().getEarth() + 1);

		}
		if (this.blessing.equals("Montaña de Gralnach")) {
			character.getAtributes().setResistance(
					character.getAtributes().getResistance() + 1);
			AtributosNPC.minResistencia += 1;

		}
		if (this.blessing.equals("Piromante de Yánguin")) {

			character.getMagicSkills().setFire(
					character.getMagicSkills().getFire() + 1);

		}
		if (this.blessing.equals("Dragón de Yánguin")) {

		}
		if (this.blessing.equals("Acuamante de Sérpos")) {

			character.getMagicSkills().setWater(
					character.getMagicSkills().getWater() + 1);

		}
		if (this.blessing.equals("Kraken de Sérpos")) {

		}
		if (this.blessing.equals("Aeromante de K'aris")) {

			character.getMagicSkills().setWind(
					character.getMagicSkills().getWind() + 1);

		}
		if (this.blessing.equals("Vendaval de K'aris")) {

			character.getAtributes().setDexterity(
					character.getAtributes().getDexterity() + 1);
			AtributosNPC.minDestreza += 1;

		}
		if (this.blessing.equals("Sacerdote de Diliges")) {
			character.getMagicSkills().setWhite(
					character.getMagicSkills().getWhite() + 1);

		}
		if (this.blessing.equals("Paladín de Diliges")) {

		}
		if (this.blessing.equals("Sacerdote Negro de Tenerus")) {
			character.getMagicSkills().setBlack(
					character.getMagicSkills().getBlack() + 1);
			character.setMana(character.getMana() + 6);

		}
		if (this.blessing.equals("Guerrero Oscuro de Tenerus")) {

		}
		if (this.blessing.equals("Hechicero Oscuro de Mavrila")) {

		}
		if (this.blessing.equals("Asesino de Mavrila")) {

		}
		if (this.blessing.equals("Ladrón de Vida de Aurelius")) {

		}
		if (this.blessing.equals("Guardia Negro de Aurelius")) {

		}
		if (this.blessing.equals("Nigromante de Voltarus")) {

		}
		if (this.blessing.equals("Pactante de Voltarus")) {

		}
		if (this.blessing.equals("Espectro de Timor")) {

		}
		if (this.blessing.equals("Legionario de Timor")) {

		}
		if (this.blessing.equals("Mago Sangriento de Timoria")) {

		}
		if (this.blessing.equals("Brazo de Timoria")) {

		}
		if (this.blessing.equals("Mago de Batalla de Éktra")) {

		}
		if (this.blessing.equals("Espada de Éktra")) {

		}
		if (this.blessing.equals("Embustero de Pséftis")) {

		}
		if (this.blessing.equals("Audaz de Pséftis")) {

		}

	}

	public void calculoCampeonInv(Characters character)
			throws SkillOutOfBoundsException, AtributeOutOfBoundsException {
		if (this.blessing.equals("Arcanista de Sylendyl")) {
			character.getMagicSkills().setFire(0);
			character.getMagicSkills().setWater(0);
			character.getMagicSkills().setEarth(0);
			character.getMagicSkills().setWind(0);
			character.getMagicSkills().setDruidic(0);
			character.getMagicSkills().setBlack(0);
			character.getMagicSkills().setWhite(0);
			character.getMagicSkills().setArcane(0);

		}

		if (this.blessing.equals("Caballero Arcano de Sylendyl")) {
			character.getAtributes().setMagicres(
					character.getAtributes().getMagicres() - 1);
			AtributosNPC.minResistenciaM -= 1;

		}

		if (this.blessing.equals("Druida de Yanirem")) {
			character.getMagicSkills().setDruidic(
					character.getMagicSkills().getDruidic() - 1);

		}
		if (this.blessing.equals("Guardabosques de Yanirem")) {

			character.getPrivileges().getPrivilegio().remove(5);
			character.getPrivileges().getPrivilegio().remove(6);

		}
		if (this.blessing.equals("Erudito de Bodvar")) {
		}
		if (this.blessing.equals("Ingeniero de Bodvar")) {

		}
		if (this.blessing.equals("Geomante de Gralnach")) {

			character.getMagicSkills().setEarth(
					character.getMagicSkills().getEarth() - 1);

		}
		if (this.blessing.equals("Montaña de Gralnach")) {
			character.getAtributes().setResistance(
					character.getAtributes().getResistance() - 1);
			AtributosNPC.minResistencia -= 1;

		}
		if (this.blessing.equals("Piromante de Yánguin")) {

			character.getMagicSkills().setFire(
					character.getMagicSkills().getFire() - 1);

		}
		if (this.blessing.equals("Dragón de Yánguin")) {

		}
		if (this.blessing.equals("Acuamante de Sérpos")) {

			character.getMagicSkills().setWater(
					character.getMagicSkills().getWater() - 1);

		}
		if (this.blessing.equals("Kraken de Sérpos")) {

		}
		if (this.blessing.equals("Aeromante de K'aris")) {

			character.getMagicSkills().setWind(
					character.getMagicSkills().getWind() - 1);

		}
		if (this.blessing.equals("Vendaval de K'aris")) {

			character.getAtributes().setDexterity(
					character.getAtributes().getDexterity() - 1);
			AtributosNPC.minDestreza -= 1;

		}
		if (this.blessing.equals("Sacerdote de Diliges")) {
			character.getMagicSkills().setWhite(
					character.getMagicSkills().getWhite() - 1);

		}
		if (this.blessing.equals("Paladín de Diliges")) {

		}
		if (this.blessing.equals("Sacerdote Negro de Tenerus")) {
			character.getMagicSkills().setBlack(
					character.getMagicSkills().getBlack() - 1);
			character.setMana(character.getMana() - 6);

		}
		if (this.blessing.equals("Guerrero Oscuro de Tenerus")) {

		}
		if (this.blessing.equals("Hechicero Oscuro de Mavrila")) {

		}
		if (this.blessing.equals("Asesino de Mavrila")) {

		}
		if (this.blessing.equals("Ladrón de Vida de Aurelius")) {

		}
		if (this.blessing.equals("Guardia Negro de Aurelius")) {

		}
		if (this.blessing.equals("Nigromante de Voltarus")) {

		}
		if (this.blessing.equals("Pactante de Voltarus")) {

		}
		if (this.blessing.equals("Espectro de Timor")) {

		}
		if (this.blessing.equals("Legionario de Timor")) {

		}
		if (this.blessing.equals("Mago Sangriento de Timoria")) {

		}
		if (this.blessing.equals("Brazo de Timoria")) {

		}
		if (this.blessing.equals("Mago de Batalla de Éktra")) {

		}
		if (this.blessing.equals("Espada de Éktra")) {

		}
		if (this.blessing.equals("Embustero de Pséftis")) {

		}
		if (this.blessing.equals("Audaz de Pséftis")) {

		}

	}

	public void calculoExtras(Characters character)
			throws SkillOutOfBoundsException, AtributeOutOfBoundsException {

		if (Inicio.crear.equals("pj")) {
			if (this.blessing.equals("Arcanista de Sylendyl")) {
				character.setMana(character.getMana() + 6);

			}

			if (this.blessing.equals("Caballero Arcano de Sylendyl")) {
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() + 1);
				Atributos.minResistenciaM += 1;

			}
			if (this.blessing.equals("Druida de Yanirem")) {

			}
			if (this.blessing.equals("Guardabosques de Yanirem")) {

			}
			if (this.blessing.equals("Erudito de Bodvar")) {
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() + 1);
				Atributos.minInteligencia += 1;

			}
			if (this.blessing.equals("Ingeniero de Bodvar")) {
				Conocimientos.minCS += 1;

				character.getKnowledgeSkills()
						.setSecretKnowledge(
								character.getKnowledgeSkills()
										.getSecretKnowledge() + 1);

			}
			if (this.blessing.equals("Geomante de Gralnach")) {

			}
			if (this.blessing.equals("Montaña de Gralnach")) {
				character.getAtributes().setResistance(
						character.getAtributes().getResistance() + 1);
				Atributos.minResistencia += 1;

			}
			if (this.blessing.equals("Piromante de Yánguin")) {

			}
			if (this.blessing.equals("Dragón de Yánguin")) {

			}
			if (this.blessing.equals("Acuamante de Sérpos")) {

			}
			if (this.blessing.equals("Kraken de Sérpos")) {

				if (character.getRace().getRace().equals("Naga")) {

					character.getAtributes().setStrength(
							1 + character.getAtributes().getStrength());
					Atributos.minFuerza = Atributos.minFuerza + 1;

				}

			}
			if (this.blessing.equals("Aeromante de K'aris")) {

			}
			if (this.blessing.equals("Vendaval de K'aris")) {

			}
			if (this.blessing.equals("Sacerdote de Diliges")) {

			}
			if (this.blessing.equals("Paladín de Diliges")) {

			}
			if (this.blessing.equals("Sacerdote Negro de Tenerus")) {

			}
			if (this.blessing.equals("Guerrero Oscuro de Tenerus")) {

			}
			if (this.blessing.equals("Hechicero Oscuro de Mavrila")) {

			}
			if (this.blessing.equals("Asesino de Mavrila")) {

			}
			if (this.blessing.equals("Ladrón de Vida de Aurelius")) {

			}
			if (this.blessing.equals("Guardia Negro de Aurelius")) {

			}
			if (this.blessing.equals("Nigromante de Voltarus")) {

			}
			if (this.blessing.equals("Pactante de Voltarus")) {

			}
			if (this.blessing.equals("Espectro de Timor")) {

			}
			if (this.blessing.equals("Legionario de Timor")) {

			}
			if (this.blessing.equals("Mago Sangriento de Timoria")) {

			}
			if (this.blessing.equals("Brazo de Timoria")) {
				Atributos.minDestreza += 1;
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() + 1);

			}
			if (this.blessing.equals("Mago de Batalla de Éktra")) {

			}
			if (this.blessing.equals("Espada de Éktra")) {

			}
			if (this.blessing.equals("Embustero de Pséftis")) {

			}
			if (this.blessing.equals("Audaz de Pséftis")) {

			}

		}

		else {
			if (this.blessing.equals("Arcanista de Sylendyl")) {
				character.setMana(character.getMana() + 6);

			}

			if (this.blessing.equals("Caballero Arcano de Sylendyl")) {
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() + 1);
				AtributosNPC.minResistenciaM += 1;

			}
			if (this.blessing.equals("Druida de Yanirem")) {

			}
			if (this.blessing.equals("Guardabosques de Yanirem")) {

			}
			if (this.blessing.equals("Erudito de Bodvar")) {
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() + 1);
				AtributosNPC.minInteligencia += 1;

			}
			if (this.blessing.equals("Ingeniero de Bodvar")) {
				ConocimientosNPC.minCS += 1;

				character.getKnowledgeSkills()
						.setSecretKnowledge(
								character.getKnowledgeSkills()
										.getSecretKnowledge() + 1);

			}
			if (this.blessing.equals("Geomante de Gralnach")) {

			}
			if (this.blessing.equals("Montaña de Gralnach")) {
				character.getAtributes().setResistance(
						character.getAtributes().getResistance() + 1);
				AtributosNPC.minResistencia += 1;

			}
			if (this.blessing.equals("Piromante de Yánguin")) {

			}
			if (this.blessing.equals("Dragón de Yánguin")) {

			}
			if (this.blessing.equals("Acuamante de Sérpos")) {

			}
			if (this.blessing.equals("Kraken de Sérpos")) {

				if (character.getRace().getRace().equals("Naga")) {

					character.getAtributes().setStrength(
							1 + character.getAtributes().getStrength());
					AtributosNPC.minFuerza = AtributosNPC.minFuerza + 1;

				}

			}
			if (this.blessing.equals("Aeromante de K'aris")) {

			}
			if (this.blessing.equals("Vendaval de K'aris")) {

			}
			if (this.blessing.equals("Sacerdote de Diliges")) {

			}
			if (this.blessing.equals("Paladín de Diliges")) {

			}
			if (this.blessing.equals("Sacerdote Negro de Tenerus")) {

			}
			if (this.blessing.equals("Guerrero Oscuro de Tenerus")) {

			}
			if (this.blessing.equals("Hechicero Oscuro de Mavrila")) {

			}
			if (this.blessing.equals("Asesino de Mavrila")) {

			}
			if (this.blessing.equals("Ladrón de Vida de Aurelius")) {

			}
			if (this.blessing.equals("Guardia Negro de Aurelius")) {

			}
			if (this.blessing.equals("Nigromante de Voltarus")) {

			}
			if (this.blessing.equals("Pactante de Voltarus")) {

			}
			if (this.blessing.equals("Espectro de Timor")) {

			}
			if (this.blessing.equals("Legionario de Timor")) {

			}
			if (this.blessing.equals("Mago Sangriento de Timoria")) {

			}
			if (this.blessing.equals("Brazo de Timoria")) {
				AtributosNPC.minDestreza += 1;
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() + 1);

			}
			if (this.blessing.equals("Mago de Batalla de Éktra")) {

			}
			if (this.blessing.equals("Espada de Éktra")) {

			}
			if (this.blessing.equals("Embustero de Pséftis")) {

			}
			if (this.blessing.equals("Audaz de Pséftis")) {

			}

		}

	}

	public void calculoExtrasInv(Characters character)
			throws SkillOutOfBoundsException, AtributeOutOfBoundsException {

		if (Inicio.crear.equals("pj")) {
			if (this.blessing.equals("Arcanista de Sylendyl")) {
				character.setMana(character.getMana() - 6);

			}

			if (this.blessing.equals("Caballero Arcano de Sylendyl")) {
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() - 1);
				Atributos.minResistenciaM -= 1;

			}
			if (this.blessing.equals("Druida de Yanirem")) {

			}
			if (this.blessing.equals("Guardabosques de Yanirem")) {

			}
			if (this.blessing.equals("Erudito de Bodvar")) {
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() - 1);
				Atributos.minInteligencia -= 1;

			}
			if (this.blessing.equals("Ingeniero de Bodvar")) {
				Conocimientos.minCS -= 1;

				character.getKnowledgeSkills()
						.setSecretKnowledge(
								character.getKnowledgeSkills()
										.getSecretKnowledge() - 1);

			}
			if (this.blessing.equals("Geomante de Gralnach")) {

			}
			if (this.blessing.equals("Montaña de Gralnach")) {
				character.getAtributes().setResistance(
						character.getAtributes().getResistance() - 1);
				Atributos.minResistencia -= 1;

			}
			if (this.blessing.equals("Piromante de Yánguin")) {

			}
			if (this.blessing.equals("Dragón de Yánguin")) {

			}
			if (this.blessing.equals("Acuamante de Sérpos")) {

			}
			if (this.blessing.equals("Kraken de Sérpos")) {

				if (character.getRace().getRace().equals("Naga")) {

					character.getAtributes().setStrength(
							character.getAtributes().getStrength() - 1);
					Atributos.minFuerza = Atributos.minFuerza - 1;

				}

			}
			if (this.blessing.equals("Aeromante de K'aris")) {

			}
			if (this.blessing.equals("Vendaval de K'aris")) {

			}
			if (this.blessing.equals("Sacerdote de Diliges")) {

			}
			if (this.blessing.equals("Paladín de Diliges")) {

			}
			if (this.blessing.equals("Sacerdote Negro de Tenerus")) {

			}
			if (this.blessing.equals("Guerrero Oscuro de Tenerus")) {

			}
			if (this.blessing.equals("Hechicero Oscuro de Mavrila")) {

			}
			if (this.blessing.equals("Asesino de Mavrila")) {

			}
			if (this.blessing.equals("Ladrón de Vida de Aurelius")) {

			}
			if (this.blessing.equals("Guardia Negro de Aurelius")) {

			}
			if (this.blessing.equals("Nigromante de Voltarus")) {

			}
			if (this.blessing.equals("Pactante de Voltarus")) {

			}
			if (this.blessing.equals("Espectro de Timor")) {

			}
			if (this.blessing.equals("Legionario de Timor")) {

			}
			if (this.blessing.equals("Mago Sangriento de Timoria")) {

			}
			if (this.blessing.equals("Brazo de Timoria")) {
				Atributos.minDestreza -= 1;
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() - 1);

			}
			if (this.blessing.equals("Mago de Batalla de Éktra")) {

			}
			if (this.blessing.equals("Espada de Éktra")) {

			}
			if (this.blessing.equals("Embustero de Pséftis")) {

			}
			if (this.blessing.equals("Audaz de Pséftis")) {

			}
		} else {
			if (this.blessing.equals("Arcanista de Sylendyl")) {
				character.setMana(character.getMana() - 6);

			}

			if (this.blessing.equals("Caballero Arcano de Sylendyl")) {
				character.getAtributes().setMagicres(
						character.getAtributes().getMagicres() - 1);
				AtributosNPC.minResistenciaM -= 1;

			}
			if (this.blessing.equals("Druida de Yanirem")) {

			}
			if (this.blessing.equals("Guardabosques de Yanirem")) {

			}
			if (this.blessing.equals("Erudito de Bodvar")) {
				character.getAtributes().setIntelligence(
						character.getAtributes().getIntelligence() - 1);
				AtributosNPC.minInteligencia -= 1;

			}
			if (this.blessing.equals("Ingeniero de Bodvar")) {
				ConocimientosNPC.minCS -= 1;

				character.getKnowledgeSkills()
						.setSecretKnowledge(
								character.getKnowledgeSkills()
										.getSecretKnowledge() - 1);

			}
			if (this.blessing.equals("Geomante de Gralnach")) {

			}
			if (this.blessing.equals("Montaña de Gralnach")) {
				character.getAtributes().setResistance(
						character.getAtributes().getResistance() - 1);
				AtributosNPC.minResistencia -= 1;

			}
			if (this.blessing.equals("Piromante de Yánguin")) {

			}
			if (this.blessing.equals("Dragón de Yánguin")) {

			}
			if (this.blessing.equals("Acuamante de Sérpos")) {

			}
			if (this.blessing.equals("Kraken de Sérpos")) {

				if (character.getRace().getRace().equals("Naga")) {
					AtributosNPC.minFuerza = AtributosNPC.minFuerza - 1;
					character.getAtributes().setStrength(
							character.getAtributes().getStrength() - 1);

				}

			}
			if (this.blessing.equals("Aeromante de K'aris")) {

			}
			if (this.blessing.equals("Vendaval de K'aris")) {

			}
			if (this.blessing.equals("Sacerdote de Diliges")) {

			}
			if (this.blessing.equals("Paladín de Diliges")) {

			}
			if (this.blessing.equals("Sacerdote Negro de Tenerus")) {

			}
			if (this.blessing.equals("Guerrero Oscuro de Tenerus")) {

			}
			if (this.blessing.equals("Hechicero Oscuro de Mavrila")) {

			}
			if (this.blessing.equals("Asesino de Mavrila")) {

			}
			if (this.blessing.equals("Ladrón de Vida de Aurelius")) {

			}
			if (this.blessing.equals("Guardia Negro de Aurelius")) {

			}
			if (this.blessing.equals("Nigromante de Voltarus")) {

			}
			if (this.blessing.equals("Pactante de Voltarus")) {

			}
			if (this.blessing.equals("Espectro de Timor")) {

			}
			if (this.blessing.equals("Legionario de Timor")) {

			}
			if (this.blessing.equals("Mago Sangriento de Timoria")) {

			}
			if (this.blessing.equals("Brazo de Timoria")) {
				AtributosNPC.minDestreza -= 1;
				character.getAtributes().setDexterity(
						character.getAtributes().getDexterity() - 1);

			}
			if (this.blessing.equals("Mago de Batalla de Éktra")) {

			}
			if (this.blessing.equals("Espada de Éktra")) {

			}
			if (this.blessing.equals("Embustero de Pséftis")) {

			}
			if (this.blessing.equals("Audaz de Pséftis")) {

			}

		}

	}
}
