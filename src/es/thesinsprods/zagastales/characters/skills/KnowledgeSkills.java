package es.thesinsprods.zagastales.characters.skills;

import es.thesinsprods.zagastales.characters.OutOfPointsException;

public class KnowledgeSkills {
	private SkillPoints points;
	private int artofWar;
	private int diplomacy;
	private int etiquette;
	private int medicine;
	private int occultism;
	private int research;
	private int negotiation;
	private int secretKnowledge;
	private int profession;
	public static int skill0 = 1;
	public static int skill1 = 2;
	public static int skill2 = 6;
	public static int skill3 = 12;
	public static int skill4 = 20;

	public KnowledgeSkills(SkillPoints points) {
		this.artofWar = 0;
		this.diplomacy = 0;
		this.etiquette = 0;
		this.medicine = 0;
		this.occultism = 0;
		this.research = 0;
		this.negotiation = 0;
		this.secretKnowledge = 0;
		this.profession = 0;
		this.points = points;

	}

	public int getArtofWar() {

		return artofWar;
	}

	public void setArtofWar(int artofWar) throws SkillOutOfBoundsException {
		if (this.artofWar < 0 || this.artofWar > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.artofWar = artofWar;
	}

	public int getDiplomacy() {
		return diplomacy;
	}

	public void setDiplomacy(int diplomacy) throws SkillOutOfBoundsException {
		if (this.diplomacy < 0 || this.diplomacy > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.diplomacy = diplomacy;
	}

	public int getEtiquette() {
		return etiquette;
	}

	public void setEtiquette(int etiquette) throws SkillOutOfBoundsException {
		if (this.etiquette < 0 || this.etiquette > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.etiquette = etiquette;
	}

	public int getMedicine() {
		return medicine;
	}

	public void setMedicine(int medicine) throws SkillOutOfBoundsException {
		if (this.medicine < 0 || this.medicine > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.medicine = medicine;
	}

	public int getOccultism() {
		return occultism;
	}

	public void setOccultism(int occultism) throws SkillOutOfBoundsException {
		if (this.occultism < 0 || this.occultism > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.occultism = occultism;
	}

	public int getResearch() {
		return research;
	}

	public void setResearch(int research) throws SkillOutOfBoundsException {
		if (this.research < 0 || this.research > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.research = research;
	}

	public int getNegotiation() {
		return negotiation;
	}

	public void setNegotiation(int negotiation)
			throws SkillOutOfBoundsException {
		if (this.negotiation < 0 || this.negotiation > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.negotiation = negotiation;
	}

	public int getSecretKnowledge() {
		return secretKnowledge;
	}

	public void setSecretKnowledge(int secretKnowledge)
			throws SkillOutOfBoundsException {
		if (this.secretKnowledge < 0 || this.secretKnowledge > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.secretKnowledge = secretKnowledge;
	}

	public int getProfession() {
		return profession;
	}

	public void setProfession(int profession) {
		this.profession = profession;
	}

	public void increaseArtOfWar(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getArtofWar() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.artofWar == 0) {
				this.points.remove(skill0);

				this.artofWar = 1;
			} else if (this.artofWar == 1) {
				this.points.remove(skill1);

				this.artofWar = 2;
			} else if (this.artofWar == 2) {
				this.points.remove(skill2);

				this.artofWar = 3;
			} else if (this.artofWar == 3) {
				this.points.remove(skill3);

				this.artofWar = 4;
			} else if (this.artofWar == 4) {
				this.points.remove(skill4);

				this.artofWar = 5;
			}
		}

	}

	public void increaseDiplomacy(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getDiplomacy() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.diplomacy == 0) {
				this.points.remove(skill0);

				this.diplomacy = 1;
			} else if (this.diplomacy == 1) {
				this.points.remove(skill1);

				this.diplomacy = 2;
			} else if (this.diplomacy == 2) {
				this.points.remove(skill2);

				this.diplomacy = 3;
			} else if (this.diplomacy == 3) {
				this.points.remove(skill3);

				this.diplomacy = 4;
			} else if (this.diplomacy == 4) {
				this.points.remove(skill4);

				this.diplomacy = 5;
			}
		}

	}

	public void increaseEtiquette(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getEtiquette() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.etiquette == 0) {
				this.points.remove(skill0);

				this.etiquette = 1;
			} else if (this.etiquette == 1) {
				this.points.remove(skill1);

				this.etiquette = 2;
			} else if (this.etiquette == 2) {
				this.points.remove(skill2);

				this.etiquette = 3;
			} else if (this.etiquette == 3) {
				this.points.remove(skill3);

				this.etiquette = 4;
			} else if (this.etiquette == 4) {
				this.points.remove(skill4);

				this.etiquette = 5;
			}
		}

	}

	public void increaseMedicine(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getMedicine() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.medicine == 0) {
				this.points.remove(skill0);

				this.medicine = 1;
			} else if (this.medicine == 1) {
				this.points.remove(skill1);

				this.medicine = 2;
			} else if (this.medicine == 2) {
				this.points.remove(skill2);

				this.medicine = 3;
			} else if (this.medicine == 3) {
				this.points.remove(skill3);

				this.medicine = 4;
			} else if (this.medicine == 4) {
				this.points.remove(skill4);

				this.medicine = 5;
			}
		}

	}

	public void increaseOccultism(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getOccultism() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.occultism == 0) {
				this.points.remove(skill0);

				this.occultism = 1;
			} else if (this.occultism == 1) {
				this.points.remove(skill1);

				this.occultism = 2;
			} else if (this.occultism == 2) {
				this.points.remove(skill2);

				this.occultism = 3;
			} else if (this.occultism == 3) {
				this.points.remove(skill3);

				this.occultism = 4;
			} else if (this.occultism == 4) {
				this.points.remove(skill4);

				this.occultism = 5;
			}
		}

	}

	public void increaseResearch(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getResearch() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.research == 0) {
				this.points.remove(skill0);

				this.research = 1;
			} else if (this.research == 1) {
				this.points.remove(skill1);

				this.research = 2;
			} else if (this.research == 2) {
				this.points.remove(skill2);

				this.research = 3;
			} else if (this.research == 3) {
				this.points.remove(skill3);

				this.research = 4;
			} else if (this.research == 4) {
				this.points.remove(skill4);

				this.research = 5;
			}
		}

	}

	public void increaseNegotiation(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getNegotiation() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.negotiation == 0) {
				this.points.remove(skill0);

				this.negotiation = 1;
			} else if (this.negotiation == 1) {
				this.points.remove(skill1);

				this.negotiation = 2;
			} else if (this.negotiation == 2) {
				this.points.remove(skill2);

				this.negotiation = 3;
			} else if (this.negotiation == 3) {
				this.points.remove(skill3);

				this.negotiation = 4;
			} else if (this.negotiation == 4) {
				this.points.remove(skill4);

				this.negotiation = 5;
			}
		}

	}

	public void increaseSecretKnowledge(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getSecretKnowledge() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.secretKnowledge == 0) {
				this.points.remove(skill0);

				this.secretKnowledge = 1;
			} else if (this.secretKnowledge == 1) {
				this.points.remove(skill1);

				this.secretKnowledge = 2;
			} else if (this.secretKnowledge == 2) {
				this.points.remove(skill2);

				this.secretKnowledge = 3;
			} else if (this.secretKnowledge == 3) {
				this.points.remove(skill3);

				this.secretKnowledge = 4;
			} else if (this.secretKnowledge == 4) {
				this.points.remove(skill4);

				this.secretKnowledge = 5;
			}
		}

	}

	public void decreaseArtOfWar(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getArtofWar() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.artofWar == 5) {
				this.artofWar = 4;
				this.points.add(skill4);
			} else if (this.artofWar == 4) {
				this.artofWar = 3;
				this.points.add(skill3);
			} else if (this.artofWar == 3) {
				this.artofWar = 2;
				this.points.add(skill2);
			} else if (this.artofWar == 2) {
				this.artofWar = 1;
				this.points.add(skill1);
			} else if (this.artofWar == 1) {
				this.artofWar = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseDiplomacy(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getDiplomacy() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.diplomacy == 5) {
				this.diplomacy = 4;
				this.points.add(skill4);
			} else if (this.diplomacy == 4) {
				this.diplomacy = 3;
				this.points.add(skill3);
			} else if (this.diplomacy == 3) {
				this.diplomacy = 2;
				this.points.add(skill2);
			} else if (this.diplomacy == 2) {
				this.diplomacy = 1;
				this.points.add(skill1);
			} else if (this.diplomacy == 1) {
				this.diplomacy = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseEtiquette(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getEtiquette() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.etiquette == 5) {
				this.etiquette = 4;
				this.points.add(skill4);
			} else if (this.etiquette == 4) {
				this.etiquette = 3;
				this.points.add(skill3);
			} else if (this.etiquette == 3) {
				this.etiquette = 2;
				this.points.add(skill2);
			} else if (this.etiquette == 2) {
				this.etiquette = 1;
				this.points.add(skill1);
			} else if (this.etiquette == 1) {
				this.etiquette = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseMedicine(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getMedicine() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.medicine == 5) {
				this.medicine = 4;
				this.points.add(skill4);
			} else if (this.medicine == 4) {
				this.medicine = 3;
				this.points.add(skill3);
			} else if (this.medicine == 3) {
				this.medicine = 2;
				this.points.add(skill2);
			} else if (this.medicine == 2) {
				this.medicine = 1;
				this.points.add(skill1);
			} else if (this.medicine == 1) {
				this.medicine = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseOccultism(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getOccultism() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.occultism == 5) {
				this.occultism = 4;
				this.points.add(skill4);
			} else if (this.occultism == 4) {
				this.occultism = 3;
				this.points.add(skill3);
			} else if (this.occultism == 3) {
				this.occultism = 2;
				this.points.add(skill2);
			} else if (this.occultism == 2) {
				this.occultism = 1;
				this.points.add(skill1);
			} else if (this.occultism == 1) {
				this.occultism = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseResearch(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getResearch() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.research == 5) {
				this.research = 4;
				this.points.add(skill4);
			} else if (this.research == 4) {
				this.research = 3;
				this.points.add(skill3);
			} else if (this.research == 3) {
				this.research = 2;
				this.points.add(skill2);
			} else if (this.research == 2) {
				this.research = 1;
				this.points.add(skill1);
			} else if (this.research == 1) {
				this.research = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseNegotiation(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getNegotiation() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.negotiation == 5) {
				this.negotiation = 4;
				this.points.add(skill4);
			} else if (this.negotiation == 4) {
				this.negotiation = 3;
				this.points.add(skill3);
			} else if (this.negotiation == 3) {
				this.negotiation = 2;
				this.points.add(skill2);
			} else if (this.negotiation == 2) {
				this.negotiation = 1;
				this.points.add(skill1);
			} else if (this.negotiation == 1) {
				this.negotiation = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseSecretKnowledge(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getSecretKnowledge() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.secretKnowledge == 5) {
				this.secretKnowledge = 4;
				this.points.add(skill4);
			} else if (this.secretKnowledge == 4) {
				this.secretKnowledge = 3;
				this.points.add(skill3);
			} else if (this.secretKnowledge == 3) {
				this.secretKnowledge = 2;
				this.points.add(skill2);
			} else if (this.secretKnowledge == 2) {
				this.secretKnowledge = 1;
				this.points.add(skill1);
			} else if (this.secretKnowledge == 1) {
				this.secretKnowledge = 0;
				this.points.add(skill0);
			}
		}

	}
}
