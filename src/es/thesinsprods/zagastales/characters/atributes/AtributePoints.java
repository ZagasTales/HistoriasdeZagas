package es.thesinsprods.zagastales.characters.atributes;

import es.thesinsprods.zagastales.characters.OutOfPointsException;

public class AtributePoints {

	private int points;

	public AtributePoints() {
		this.points = 45;

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
					"No tienes tantos puntos para añadir al atributo. Puntos restantes"
							+ this.points);
		} else {
			this.points = this.points - lost;
		}
	}

}
