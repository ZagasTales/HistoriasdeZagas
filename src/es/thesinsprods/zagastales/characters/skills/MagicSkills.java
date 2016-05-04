package es.thesinsprods.zagastales.characters.skills;

import es.thesinsprods.zagastales.characters.OutOfPointsException;

public class MagicSkills {
	private SkillPoints points;
	private int fire;
	private int water;
	private int earth;
	private int wind;
	private int arcane;
	private int druidic;
	private int white;
	private int black;
	public static int skill0 = 4;
	public static int skill1 = 4;
	public static int skill2 = 8;
	public static int skill3 = 16;
	public static int skill4 = 32;

	public MagicSkills(SkillPoints points) {
		this.fire = 0;
		this.water = 0;
		this.earth = 0;
		this.wind = 0;
		this.arcane = 0;
		this.druidic = 0;
		this.white = 0;
		this.black = 0;
		this.points = points;

	}

	public int getFire() {
		return fire;
	}

	public void setFire(int fire) throws SkillOutOfBoundsException {
		if (this.fire < 0 || this.fire > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.fire = fire;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) throws SkillOutOfBoundsException {
		if (this.water < 0 || this.water > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.water = water;
	}

	public int getEarth() {
		return earth;
	}

	public void setEarth(int earth) throws SkillOutOfBoundsException {
		if (this.earth < 0 || this.earth > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.earth = earth;
	}

	public int getWind() {
		return wind;
	}

	public void setWind(int wind) throws SkillOutOfBoundsException {
		if (this.wind < 0 || this.wind > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.wind = wind;
	}

	public int getArcane() {
		return arcane;
	}

	public void setArcane(int arcane) throws SkillOutOfBoundsException {
		if (this.arcane < 0 || this.arcane > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.arcane = arcane;
	}

	public int getDruidic() {
		return druidic;
	}

	public void setDruidic(int druidic) throws SkillOutOfBoundsException {
		if (this.druidic < 0 || this.druidic > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.druidic = druidic;
	}

	public int getWhite() {
		return white;
	}

	public void setWhite(int white) throws SkillOutOfBoundsException {
		if (this.white < 0 || this.white > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.white = white;
	}

	public int getBlack() {
		return black;
	}

	public void setBlack(int black) throws SkillOutOfBoundsException {
		if (this.black < 0 || this.black > 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		}
		this.black = black;
	}

	public void increaseFire(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {

		if (this.getFire() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.fire == 0) {
				this.points.remove(skill0);

				this.fire = 1;
			} else if (this.fire == 1) {
				this.points.remove(skill1);

				this.fire = 2;
			} else if (this.fire == 2) {
				this.points.remove(skill2);

				this.fire = 3;
			} else if (this.fire == 3) {
				this.points.remove(skill3);

				this.fire = 4;
			} else if (this.fire == 4) {
				this.points.remove(skill4);

				this.fire = 5;
			}
		}

	}

	public void increaseWater(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getWater() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.water == 0) {
				this.points.remove(skill0);

				this.water = 1;
			} else if (this.water == 1) {
				this.points.remove(skill1);

				this.water = 2;
			} else if (this.water == 2) {
				this.points.remove(skill2);

				this.water = 3;
			} else if (this.water == 3) {
				this.points.remove(skill3);

				this.water = 4;
			} else if (this.water == 4) {
				this.points.remove(skill4);

				this.water = 5;
			}
		}

	}

	public void increaseEarth(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getEarth() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.earth == 0) {
				this.points.remove(skill0);

				this.earth = 1;
			} else if (this.earth == 1) {
				this.points.remove(skill1);

				this.earth = 2;
			} else if (this.earth == 2) {
				this.points.remove(skill2);

				this.earth = 3;
			} else if (this.earth == 3) {
				this.points.remove(skill3);

				this.earth = 4;
			} else if (this.earth == 4) {
				this.points.remove(skill4);

				this.earth = 5;
			}
		}

	}

	public void increaseWind(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getWind() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.wind == 0) {
				this.points.remove(skill0);

				this.wind = 1;
			} else if (this.wind == 1) {
				this.points.remove(skill1);

				this.wind = 2;
			} else if (this.wind == 2) {
				this.points.remove(skill2);

				this.wind = 3;
			} else if (this.wind == 3) {
				this.points.remove(skill3);

				this.wind = 4;
			} else if (this.wind == 4) {
				this.points.remove(skill4);

				this.wind = 5;
			}
		}

	}

	public void increaseArcane(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getArcane() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.arcane == 0) {
				this.points.remove(skill0);

				this.arcane = 1;
			} else if (this.arcane == 1) {
				this.points.remove(skill1);

				this.arcane = 2;
			} else if (this.arcane == 2) {
				this.points.remove(skill2);

				this.arcane = 3;
			} else if (this.arcane == 3) {
				this.points.remove(skill3);

				this.arcane = 4;
			} else if (this.arcane == 4) {
				this.points.remove(skill4);

				this.arcane = 5;
			}
		}

	}

	public void increaseDruidic(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getDruidic() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.druidic == 0) {
				this.points.remove(skill0);

				this.druidic = 1;
			} else if (this.druidic == 1) {
				this.points.remove(skill1);

				this.druidic = 2;
			} else if (this.druidic == 2) {
				this.points.remove(skill2);

				this.druidic = 3;
			} else if (this.druidic == 3) {
				this.points.remove(skill3);

				this.druidic = 4;
			} else if (this.druidic == 4) {
				this.points.remove(skill4);

				this.druidic = 5;
			}
		}

	}

	public void increaseWhite(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getWhite() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.white == 0) {
				this.points.remove(skill0);

				this.white = 1;
			} else if (this.white == 1) {
				this.points.remove(skill1);

				this.white = 2;
			} else if (this.white == 2) {
				this.points.remove(skill2);

				this.white = 3;
			} else if (this.white == 3) {
				this.points.remove(skill3);

				this.white = 4;
			} else if (this.white == 4) {
				this.points.remove(skill4);

				this.white = 5;
			}
		}

	}

	public void increaseBlack(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getBlack() >= 5) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.black == 0) {
				this.points.remove(skill0);

				this.black = 1;
			} else if (this.black == 1) {
				this.points.remove(skill1);

				this.black = 2;
			} else if (this.black == 2) {
				this.points.remove(skill2);

				this.black = 3;
			} else if (this.black == 3) {
				this.points.remove(skill3);

				this.black = 4;
			} else if (this.black == 4) {
				this.points.remove(skill4);

				this.black = 5;
			}
		}

	}

	public void decreaseFire(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getFire() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.fire == 5) {
				this.fire = 4;
				this.points.add(skill4);
			} else if (this.fire == 4) {
				this.fire = 3;
				this.points.add(skill3);
			} else if (this.fire == 3) {
				this.fire = 2;
				this.points.add(skill2);
			} else if (this.fire == 2) {
				this.fire = 1;
				this.points.add(skill1);
			} else if (this.fire == 1) {
				this.fire = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseWater(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getWater() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.water == 5) {
				this.water = 4;
				this.points.add(skill4);
			} else if (this.water == 4) {
				this.water = 3;
				this.points.add(skill3);
			} else if (this.water == 3) {
				this.water = 2;
				this.points.add(skill2);
			} else if (this.water == 2) {
				this.water = 1;
				this.points.add(skill1);
			} else if (this.water == 1) {
				this.water = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseEarth(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getEarth() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.earth == 5) {
				this.earth = 4;
				this.points.add(skill4);
			} else if (this.earth == 4) {
				this.earth = 3;
				this.points.add(skill3);
			} else if (this.earth == 3) {
				this.earth = 2;
				this.points.add(skill2);
			} else if (this.earth == 2) {
				this.earth = 1;
				this.points.add(skill1);
			} else if (this.earth == 1) {
				this.earth = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseWind(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getWind() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.wind == 5) {
				this.wind = 4;
				this.points.add(skill4);
			} else if (this.wind == 4) {
				this.wind = 3;
				this.points.add(skill3);
			} else if (this.wind == 3) {
				this.wind = 2;
				this.points.add(skill2);
			} else if (this.wind == 2) {
				this.wind = 1;
				this.points.add(skill1);
			} else if (this.wind == 1) {
				this.wind = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseArcane(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getArcane() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.arcane == 5) {
				this.arcane = 4;
				this.points.add(skill4);
			} else if (this.arcane == 4) {
				this.arcane = 3;
				this.points.add(skill3);
			} else if (this.arcane == 3) {
				this.arcane = 2;
				this.points.add(skill2);
			} else if (this.arcane == 2) {
				this.arcane = 1;
				this.points.add(skill1);
			} else if (this.arcane == 1) {
				this.arcane = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseDruidic(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getDruidic() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.druidic == 5) {
				this.druidic = 4;
				this.points.add(skill4);
			} else if (this.druidic == 4) {
				this.druidic = 3;
				this.points.add(skill3);
			} else if (this.druidic == 3) {
				this.druidic = 2;
				this.points.add(skill2);
			} else if (this.druidic == 2) {
				this.druidic = 1;
				this.points.add(skill1);
			} else if (this.druidic == 1) {
				this.druidic = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseWhite(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getWhite() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.white == 5) {
				this.white = 4;
				this.points.add(skill4);
			} else if (this.white == 4) {
				this.white = 3;
				this.points.add(skill3);
			} else if (this.white == 3) {
				this.white = 2;
				this.points.add(skill2);
			} else if (this.white == 2) {
				this.white = 1;
				this.points.add(skill1);
			} else if (this.white == 1) {
				this.white = 0;
				this.points.add(skill0);
			}
		}

	}

	public void decreaseBlack(SkillPoints points)
			throws SkillOutOfBoundsException, OutOfPointsException {
		if (this.getBlack() <= 0) {
			throw new SkillOutOfBoundsException(
					"Valor invalido para la habilidad");
		} else {
			if (this.black == 5) {
				this.black = 4;
				this.points.add(skill4);
			} else if (this.black == 4) {
				this.black = 3;
				this.points.add(skill3);
			} else if (this.black == 3) {
				this.black = 2;
				this.points.add(skill2);
			} else if (this.black == 2) {
				this.black = 1;
				this.points.add(skill1);
			} else if (this.black == 1) {
				this.black = 0;
				this.points.add(skill0);
			}
		}

	}

	public boolean isUniversalista() {

		int dos = 0;
		int tres = 0;

		if (getArcane() == 2) {
			dos += 1;
		}
		if (getBlack() == 2) {
			dos += 1;
		}
		if (getWhite() == 2) {
			dos += 1;
		}
		if (getDruidic() == 2) {
			dos += 1;
		}
		if (getFire() == 2) {
			dos += 1;
		}
		if (getWater() == 2) {
			dos += 1;
		}
		if (getEarth() == 2) {
			dos += 1;
		}
		if (getWind() == 2) {
			dos += 1;
		}
		if (getArcane() == 3) {
			tres += 1;
		}
		if (getBlack() == 3) {
			tres += 1;
		}
		if (getWhite() == 3) {
			tres += 1;
		}
		if (getDruidic() == 3) {
			tres += 1;
		}
		if (getFire() == 3) {
			tres += 1;
		}
		if (getWater() == 3) {
			tres += 1;
		}
		if (getEarth() == 3) {
			tres += 1;
		}
		if (getWind() == 3) {
			tres += 1;
		}

		if (dos >= 4 && tres >= 2) {

			return true;
		} else {
			return false;
		}

	}

}
