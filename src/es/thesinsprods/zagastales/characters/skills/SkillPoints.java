package es.thesinsprods.zagastales.characters.skills;

import es.thesinsprods.zagastales.characters.OutOfPointsException;

public class SkillPoints {

	private int points;

	public SkillPoints() {

		this.points = 60;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) throws OutOfPointsException {
		if (points < 0) {
			throw new OutOfPointsException("No puedes poner puntos negativos");
		}
		this.points = points;
	}

	public void add(int extra) {

		this.points = this.points + extra;

	}

	public void remove(int lost) throws OutOfPointsException {
		if (this.points - lost < 0) {
			throw new OutOfPointsException(
					"No tienes tantos puntos para añadir a la habilidad. Puntos restantes"
							+ this.points);
		} else {
			this.points = this.points - lost;
		}
	}
}
