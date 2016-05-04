package es.thesinsprods.zagastales.characters.skills;

import es.thesinsprods.zagastales.characters.OutOfPointsException;

public class CombatSkills {
	private SkillPoints points;
	private int oneHanded;
	private int twoHanded;
	private int pole;
	private int ranged;
	private int dodge;
	private int block;
	public static int skill0 = 1;
	public static int skill1 = 2;
	public static int skill2 = 4;
	public static int skill3 = 8;
	public static int skill4 = 16;

	public CombatSkills(SkillPoints points) {

		this.oneHanded = 0;
		this.twoHanded = 0;
		this.pole = 0;
		this.ranged = 0;
		this.dodge = 0;
		this.block = 0;
		this.points = points;
	}

	public int getOneHanded() {
		return oneHanded;
	}

	public void setOneHanded(int oneHanded) throws SkillOutOfBoundsException {
		if (this.oneHanded < 0 || this.oneHanded > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.oneHanded = oneHanded;
	}

	public int getTwoHanded() {

		return twoHanded;
	}

	public void setTwoHanded(int twoHanded) throws SkillOutOfBoundsException {
		if (this.twoHanded < 0 || this.twoHanded > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.twoHanded = twoHanded;
	}

	public int getPole() {
		return pole;
	}

	public void setPole(int pole) throws SkillOutOfBoundsException {
		if (this.pole < 0 || this.pole > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.pole = pole;
	}

	public int getRanged() {
		return ranged;
	}

	public void setRanged(int ranged) throws SkillOutOfBoundsException {
		if (this.ranged < 0 || this.ranged > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.ranged = ranged;
	}

	public int getDodge() {
		return dodge;
	}

	public void setDodge(int dodge) throws SkillOutOfBoundsException {
		if (this.dodge < 0 || this.dodge > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.dodge = dodge;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) throws SkillOutOfBoundsException {
		if (this.block < 0 || this.block > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.block = block;
	}

	public void increaseOne(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getOneHanded() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.oneHanded == 0) {
				this.points.remove(skill0);
				this.oneHanded = 1;

			} else if (this.oneHanded == 1) {
				this.points.remove(skill1);
				this.oneHanded = 2;

			} else if (this.oneHanded == 2) {
				this.points.remove(skill2);
				this.oneHanded = 3;

			} else if (this.oneHanded == 3) {
				this.points.remove(skill3);
				this.oneHanded = 4;

			} else if (this.oneHanded == 4) {
				this.points.remove(skill4);
				this.oneHanded = 5;

			}
		}

	}

	public void increaseTwo(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getTwoHanded() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.twoHanded == 0) {
				this.points.remove(skill0);
				this.twoHanded = 1;

			} else if (this.twoHanded == 1) {
				this.points.remove(skill1);
				this.twoHanded = 2;

			} else if (this.twoHanded == 2) {
				this.points.remove(skill2);
				this.twoHanded = 3;

			} else if (this.twoHanded == 3) {
				this.points.remove(skill3);
				this.twoHanded = 4;

			} else if (this.twoHanded == 4) {
				this.points.remove(skill4);
				this.twoHanded = 5;

			}
		}

	}

	public void increasePole(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getPole() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.pole == 0) {
				this.points.remove(skill0);
				this.pole = 1;

			} else if (this.pole == 1) {
				this.points.remove(skill1);
				this.pole = 2;

			} else if (this.pole == 2) {
				this.points.remove(skill2);
				this.pole = 3;

			} else if (this.pole == 3) {
				this.points.remove(skill3);
				this.pole = 4;

			} else if (this.pole == 4) {
				this.points.remove(skill4);
				this.pole = 5;

			}
		}

	}

	public void increaseRanged(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getRanged() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.ranged == 0) {
				this.points.remove(skill0);
				this.ranged = 1;

			} else if (this.ranged == 1) {
				this.ranged = 2;
				this.points.remove(skill1);
			} else if (this.ranged == 2) {
				this.points.remove(skill2);
				this.ranged = 3;

			} else if (this.ranged == 3) {
				this.points.remove(skill3);
				this.ranged = 4;

			} else if (this.ranged == 4) {
				this.points.remove(skill4);
				this.ranged = 5;

			}
		}

	}

	public void increaseDodge(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getDodge() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.dodge == 0) {
				this.points.remove(skill0);
				this.dodge = 1;

			} else if (this.dodge == 1) {
				this.points.remove(skill1);
				this.dodge = 2;

			} else if (this.dodge == 2) {
				this.points.remove(skill2);
				this.dodge = 3;
			} else if (this.dodge == 3) {

				this.points.remove(skill3);
				this.dodge = 4;
			} else if (this.dodge == 4) {

				this.points.remove(skill4);
				this.dodge = 5;

			}
		}

	}

	public void increaseBlock(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getBlock() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.block == 0) {
				this.points.remove(skill0);

				this.block = 1;
			} else if (this.block == 1) {
				this.points.remove(skill1);

				this.block = 2;
			} else if (this.block == 2) {
				this.points.remove(skill2);

				this.block = 3;
			} else if (this.block == 3) {
				this.points.remove(skill3);

				this.block = 4;
			} else if (this.block == 4) {
				this.points.remove(skill4);

				this.block = 5;
			}
		}

	}

	public void decreaseOne(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getOneHanded() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.oneHanded == 5) {
				this.oneHanded = 4;
				this.points.add(skill4);
			} else if (this.oneHanded == 4) {
				this.oneHanded = 3;
				this.points.add(skill3);
			} else if (this.oneHanded == 3) {
				this.oneHanded = 2;
				this.points.add(skill2);
			} else if (this.oneHanded == 2) {
				this.oneHanded = 1;
				this.points.add(skill1);
			} else if (this.oneHanded == 1) {
				this.oneHanded = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseTwo(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getTwoHanded() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.twoHanded == 5) {
				this.twoHanded = 4;
				this.points.add(skill4);
			} else if (this.twoHanded == 4) {
				this.twoHanded = 3;
				this.points.add(skill3);
			} else if (this.twoHanded == 3) {
				this.twoHanded = 2;
				this.points.add(skill2);
			} else if (this.twoHanded == 2) {
				this.twoHanded = 1;
				this.points.add(skill1);
			} else if (this.twoHanded == 1) {
				this.twoHanded = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreasePole(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getPole() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.pole == 5) {
				this.pole = 4;
				this.points.add(skill4);
			} else if (this.pole == 4) {
				this.pole = 3;
				this.points.add(skill3);
			} else if (this.pole == 3) {
				this.pole = 2;
				this.points.add(skill2);
			} else if (this.pole == 2) {
				this.pole = 1;
				this.points.add(skill1);
			} else if (this.pole == 1) {
				this.pole = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseRanged(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getRanged() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.ranged == 5) {
				this.ranged = 4;
				this.points.add(skill4);
			} else if (this.ranged == 4) {
				this.ranged = 3;
				this.points.add(skill3);
			} else if (this.ranged == 3) {
				this.ranged = 2;
				this.points.add(skill2);
			} else if (this.ranged == 2) {
				this.ranged = 1;
				this.points.add(skill1);
			} else if (this.ranged == 1) {
				this.ranged = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseDodge(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getDodge() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.dodge == 5) {
				this.dodge = 4;
				this.points.add(skill4);
			} else if (this.dodge == 4) {
				this.dodge = 3;
				this.points.add(skill3);
			} else if (this.dodge == 3) {
				this.dodge = 2;
				this.points.add(skill2);
			} else if (this.dodge == 2) {
				this.dodge = 1;
				this.points.add(skill1);
			} else if (this.dodge == 1) {
				this.dodge = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseBlock(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getBlock() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.block == 5) {
				this.block = 4;
				this.points.add(skill4);
			} else if (this.block == 4) {
				this.block = 3;
				this.points.add(skill3);
			} else if (this.block == 3) {
				this.block = 2;
				this.points.add(skill2);
			} else if (this.block == 2) {
				this.block = 1;
				this.points.add(skill1);
			} else if (this.block == 1) {
				this.block = 0;
				this.points.add(skill0);
			}
		}

	}
}
