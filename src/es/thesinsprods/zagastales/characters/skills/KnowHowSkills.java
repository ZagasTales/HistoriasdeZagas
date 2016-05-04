package es.thesinsprods.zagastales.characters.skills;

import es.thesinsprods.zagastales.characters.OutOfPointsException;

public class KnowHowSkills {
	private SkillPoints points;
	private int athletics;
	private int survival;
	private int traps;
	private int equitation;
	private int stealth;

	public KnowHowSkills(SkillPoints points) {

		this.athletics = 0;
		this.survival = 0;
		this.traps = 0;
		this.equitation = 0;
		this.stealth = 0;
		this.points = points;
	}

	public int getAthletics() {
		return athletics;
	}

	public void setAthletics(int athletics) throws SkillOutOfBoundsException {
		if (this.athletics < 0 || this.athletics > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.athletics = athletics;
	}

	public int getSurvival() {
		return survival;
	}

	public void setSurvival(int survival) throws SkillOutOfBoundsException {
		if (this.survival < 0 || this.survival > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.survival = survival;
	}

	public int getTraps() {
		return traps;
	}

	public void setTraps(int traps) throws SkillOutOfBoundsException {
		if (this.traps < 0 || this.traps > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.traps = traps;
	}

	public int getEquitation() {
		return equitation;
	}

	public void setEquitation(int equitation) throws SkillOutOfBoundsException {
		if (this.equitation < 0 || this.equitation > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.equitation = equitation;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) throws SkillOutOfBoundsException {
		if (this.stealth < 0 || this.stealth > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.stealth = stealth;
	}

	public void increaseAthletics(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getAthletics() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.athletics == 0) {
				this.points.remove(1);
				this.athletics = 1;

			} else if (this.athletics == 1) {
				this.points.remove(2);

				this.athletics = 2;
			} else if (this.athletics == 2) {
				this.points.remove(4);

				this.athletics = 3;
			} else if (this.athletics == 3) {
				this.points.remove(8);

				this.athletics = 4;
			} else if (this.athletics == 4) {
				this.points.remove(16);

				this.athletics = 5;
			}
		}

	}

	public void increaseSurvival(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getSurvival() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.survival == 0) {
				this.points.remove(1);

				this.survival = 1;
			} else if (this.survival == 1) {
				this.points.remove(2);

				this.survival = 2;
			} else if (this.survival == 2) {
				this.points.remove(4);

				this.survival = 3;
			} else if (this.survival == 3) {
				this.points.remove(8);

				this.survival = 4;
			} else if (this.survival == 4) {
				this.points.remove(16);

				this.survival = 5;
			}
		}

	}

	public void increaseTraps(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getTraps() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.traps == 0) {
				this.points.remove(1);

				this.traps = 1;
			} else if (this.traps == 1) {
				this.points.remove(2);

				this.traps = 2;
			} else if (this.traps == 2) {
				this.points.remove(4);

				this.traps = 3;
			} else if (this.traps == 3) {
				this.points.remove(8);

				this.traps = 4;
			} else if (this.traps == 4) {
				this.points.remove(16);

				this.traps = 5;
			}
		}

	}

	public void increaseEquitation(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getEquitation() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.equitation == 0) {
				this.points.remove(1);

				this.equitation = 1;
			} else if (this.equitation == 1) {
				this.points.remove(2);

				this.equitation = 2;
			} else if (this.equitation == 2) {
				this.points.remove(4);

				this.equitation = 3;
			} else if (this.equitation == 3) {
				this.points.remove(8);

				this.equitation = 4;
			} else if (this.equitation == 4) {
				this.points.remove(16);

				this.equitation = 5;
			}
		}

	}

	public void increaseStealth(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getStealth() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.stealth == 0) {
				this.points.remove(1);

				this.stealth = 1;
			} else if (this.stealth == 1) {
				this.points.remove(2);

				this.stealth = 2;
			} else if (this.stealth == 2) {
				this.points.remove(4);

				this.stealth = 3;
			} else if (this.stealth == 3) {
				this.points.remove(8);

				this.stealth = 4;
			} else if (this.stealth == 4) {
				this.points.remove(16);

				this.stealth = 5;
			}
		}

	}

	public void decreaseAthletics(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getAthletics() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.athletics == 5) {
				this.athletics = 4;
				this.points.add(16);
			} else if (this.athletics == 4) {
				this.athletics = 3;
				this.points.add(8);
			} else if (this.athletics == 3) {
				this.athletics = 2;
				this.points.add(4);
			} else if (this.athletics == 2) {
				this.athletics = 1;
				this.points.add(2);
			} else if (this.athletics == 1) {
				this.athletics = 0;
				this.points.add(1);
			}
		}

	}

	public void decreaseSurvival(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getSurvival() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.survival == 5) {
				this.survival = 4;
				this.points.add(16);
			} else if (this.survival == 4) {
				this.survival = 3;
				this.points.add(8);
			} else if (this.survival == 3) {
				this.survival = 2;
				this.points.add(4);
			} else if (this.survival == 2) {
				this.survival = 1;
				this.points.add(2);
			} else if (this.survival == 1) {
				this.survival = 0;
				this.points.add(1);
			}
		}

	}

	public void decreaseTraps(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getTraps() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.traps == 5) {
				this.traps = 4;
				this.points.add(16);
			} else if (this.traps == 4) {
				this.traps = 3;
				this.points.add(8);
			} else if (this.traps == 3) {
				this.traps = 2;
				this.points.add(4);
			} else if (this.traps == 2) {
				this.traps = 1;
				this.points.add(2);
			} else if (this.traps == 1) {
				this.traps = 0;
				this.points.add(1);
			}
		}

	}

	public void decreaseEquitation(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getEquitation() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.equitation == 5) {
				this.equitation = 4;
				this.points.add(16);
			} else if (this.equitation == 4) {
				this.equitation = 3;
				this.points.add(8);
			} else if (this.equitation == 3) {
				this.equitation = 2;
				this.points.add(4);
			} else if (this.equitation == 2) {
				this.equitation = 1;
				this.points.add(2);
			} else if (this.equitation == 1) {
				this.equitation = 0;
				this.points.add(1);
			}
		}

	}

	public void decreaseStealth(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getStealth() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.stealth == 5) {
				this.stealth = 4;
				this.points.add(16);
			} else if (this.stealth == 4) {
				this.stealth = 3;
				this.points.add(8);
			} else if (this.stealth == 3) {
				this.stealth = 2;
				this.points.add(4);
			} else if (this.stealth == 2) {
				this.stealth = 1;
				this.points.add(2);
			} else if (this.stealth == 1) {
				this.stealth = 0;
				this.points.add(1);
			}
		}

	}
}
