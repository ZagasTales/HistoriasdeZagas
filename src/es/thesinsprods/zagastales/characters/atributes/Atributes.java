package es.thesinsprods.zagastales.characters.atributes;

import es.thesinsprods.zagastales.characters.OutOfPointsException;

public class Atributes {
	private AtributePoints points;
	private int strength;
	private int charisma;
	private int resistance;
	private int perception;
	private int intelligence;
	private int dexterity;
	private int magicres;

	public Atributes(AtributePoints points) {

		this.strength = 6;
		this.charisma = 6;
		this.resistance = 6;
		this.perception = 6;
		this.intelligence = 6;
		this.dexterity = 6;
		this.magicres = 6;
		this.points = points;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) throws AtributeOutOfBoundsException {
		if (strength < 6 || strength > 20) {
			throw new AtributeOutOfBoundsException(
					"Valor invalido para un atributo");
		}
		this.strength = strength;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) throws AtributeOutOfBoundsException {
		if (charisma < 6 || charisma > 20) {
			throw new AtributeOutOfBoundsException(
					"Valor invalido para un atributo");
		}
		this.charisma = charisma;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance)
			throws AtributeOutOfBoundsException {
		if (resistance < 6 || resistance > 20) {
			throw new AtributeOutOfBoundsException(
					"Valor invalido para un atributo");
		}
		this.resistance = resistance;
	}

	public int getPerception() {
		return perception;
	}

	public void setPerception(int perception)
			throws AtributeOutOfBoundsException {
		if (perception < 6 || perception > 20) {
			throw new AtributeOutOfBoundsException(
					"Valor invalido para un atributo");
		}
		this.perception = perception;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence)
			throws AtributeOutOfBoundsException {
		if (intelligence < 6 || intelligence > 20) {
			throw new AtributeOutOfBoundsException(
					"Valor invalido para un atributo");
		}
		this.intelligence = intelligence;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) throws AtributeOutOfBoundsException {
		if (dexterity < 6 || dexterity > 20) {
			throw new AtributeOutOfBoundsException(
					"Valor invalido para un atributo");
		}
		this.dexterity = dexterity;
	}

	public int getMagicres() {
		return magicres;
	}

	public void setMagicres(int magicres) throws AtributeOutOfBoundsException {
		if (magicres < 6 || magicres > 20) {
			throw new AtributeOutOfBoundsException(
					"Valor invalido para un atributo");
		}
		this.magicres = magicres;
	}

	public void decreaseStrength(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.strength <= 6) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.strength <= 14) {
				this.points.add(1);
				this.strength = this.strength - 1;
			} else {
				if (this.strength <= 17) {
					this.points.add(2);
					this.strength = this.strength - 1;

				} else {
					if (strength <= 19) {
						this.points.add(3);
						this.strength = this.strength - 1;
					} else {
						this.points.add(4);
						this.strength = this.strength - 1;
					}
				}
			}
		}
	}

	public void decreaseCharisma(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.charisma <= 6) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.charisma <= 14) {
				this.points.add(1);
				this.charisma = this.charisma - 1;
			} else {
				if (this.charisma <= 17) {
					this.points.add(2);
					this.charisma = this.charisma - 1;

				} else {
					if (charisma <= 19) {
						this.points.add(3);
						this.charisma = this.charisma - 1;
					} else {
						this.points.add(4);
						this.charisma = this.charisma - 1;
					}
				}
			}
		}
	}

	public void decreaseResistance(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.resistance <= 6) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.resistance <= 14) {
				this.points.add(1);
				this.resistance = this.resistance - 1;
			} else {
				if (this.resistance <= 17) {
					this.points.add(2);
					this.resistance = this.resistance - 1;

				} else {
					if (resistance <= 19) {
						this.points.add(3);
						this.resistance = this.resistance - 1;
					} else {
						this.points.add(4);
						this.resistance = this.resistance - 1;
					}
				}
			}
		}
	}

	public void decreasePerception(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.perception <= 6) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.perception <= 14) {
				this.points.add(1);
				this.perception = this.perception - 1;
			} else {
				if (this.perception <= 17) {
					this.points.add(2);
					this.perception = this.perception - 1;

				} else {
					if (perception <= 19) {
						this.points.add(3);
						this.perception = this.perception - 1;
					} else {
						this.points.add(4);
						this.perception = this.perception - 1;
					}
				}
			}
		}

	}

	public void decreaseIntelligence(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.intelligence <= 6) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.intelligence <= 14) {
				this.points.add(1);
				this.intelligence = this.intelligence - 1;
			} else {
				if (this.intelligence <= 17) {
					this.points.add(2);
					this.intelligence = this.intelligence - 1;

				} else {
					if (intelligence <= 19) {
						this.points.add(3);
						this.intelligence = this.intelligence - 1;
					} else {
						this.points.add(4);
						this.intelligence = this.intelligence - 1;
					}
				}
			}
		}
	}

	public void decreaseDexterity(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.dexterity <= 6) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.dexterity <= 14) {
				this.points.add(1);
				this.dexterity = this.dexterity - 1;
			} else {
				if (this.dexterity <= 17) {
					this.points.add(2);
					this.dexterity = this.dexterity - 1;

				} else {
					if (dexterity <= 19) {
						this.points.add(3);
						this.dexterity = this.dexterity - 1;
					} else {
						this.points.add(4);
						this.dexterity = this.dexterity - 1;
					}
				}
			}
		}
	}

	public void decreaseMagicRes(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.magicres <= 6) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.magicres <= 14) {
				this.points.add(1);
				this.magicres = this.magicres - 1;
			} else {
				if (this.magicres <= 17) {
					this.points.add(2);
					this.magicres = this.magicres - 1;

				} else {
					if (magicres <= 19) {
						this.points.add(3);
						this.magicres = this.magicres - 1;
					} else {
						this.points.add(4);
						this.magicres = this.magicres - 1;
					}
				}
			}
		}
	}

	public void increaseStrength(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.strength >= 20) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.strength < 14) {
				this.points.remove(1);
				this.strength = this.strength + 1;
			} else {
				if (this.strength < 17) {
					this.points.remove(2);
					this.strength = this.strength + 1;

				} else {
					if (strength < 19) {
						this.points.remove(3);
						this.strength = this.strength + 1;
					} else {
						this.points.remove(4);
						this.strength = this.strength + 1;
					}
				}
			}
		}
	}

	public void increaseCharisma(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.charisma >= 20) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.charisma < 14) {
				this.points.remove(1);
				this.charisma = this.charisma + 1;
			} else {
				if (this.charisma < 17) {
					this.points.remove(2);
					this.charisma = this.charisma + 1;

				} else {
					if (charisma < 19) {
						this.points.remove(3);
						this.charisma = this.charisma + 1;
					} else {
						this.points.remove(4);
						this.charisma = this.charisma + 1;
					}
				}
			}
		}
	}

	public void increaseResistance(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.resistance >= 20) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.resistance < 14) {
				this.points.remove(1);
				this.resistance = this.resistance + 1;
			} else {
				if (this.resistance < 17) {
					this.points.remove(2);
					this.resistance = this.resistance + 1;

				} else {
					if (resistance < 19) {
						this.points.remove(3);
						this.resistance = this.resistance + 1;
					} else {
						this.points.remove(4);
						this.resistance = this.resistance + 1;
					}
				}
			}
		}
	}

	public void increasePerception(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.perception >= 20) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.perception < 14) {
				this.points.remove(1);
				this.perception = this.perception + 1;
			} else {
				if (this.perception < 17) {
					this.points.remove(2);
					this.perception = this.perception + 1;

				} else {
					if (perception < 19) {
						this.points.remove(3);
						this.perception = this.perception + 1;
					} else {
						this.points.remove(4);
						this.perception = this.perception + 1;
					}
				}
			}
		}
	}

	public void increaseIntelligence(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.intelligence >= 20) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.intelligence < 14) {
				this.points.remove(1);
				this.intelligence = this.intelligence + 1;
			} else {
				if (this.intelligence < 17) {
					this.points.remove(2);
					this.intelligence = this.intelligence + 1;

				} else {
					if (intelligence < 19) {
						this.points.remove(3);
						this.intelligence = this.intelligence + 1;
					} else {
						this.points.remove(4);
						this.intelligence = this.intelligence + 1;
					}
				}
			}
		}
	}

	public void increaseDexterity(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.dexterity >= 20) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.dexterity < 14) {
				this.points.remove(1);
				this.dexterity = this.dexterity + 1;
			} else {
				if (this.dexterity < 17) {
					this.points.remove(2);
					this.dexterity = this.dexterity + 1;

				} else {
					if (dexterity < 19) {
						this.points.remove(3);
						this.dexterity = this.dexterity + 1;
					} else {
						this.points.remove(4);
						this.dexterity = this.dexterity + 1;
					}
				}
			}
		}
	}

	public void increaseMagicRes(AtributePoints points)
			throws OutOfPointsException, AtributeOutOfBoundsException {
		if (this.magicres >= 20) {

			throw new AtributeOutOfBoundsException(
					"Valor de atributo no valido");
		} else {
			if (this.magicres < 14) {
				this.points.remove(1);
				this.magicres = this.magicres + 1;
			} else {
				if (this.magicres < 17) {
					this.points.remove(2);
					this.magicres = this.magicres + 1;

				} else {
					if (magicres < 19) {
						this.points.remove(3);
						this.magicres = this.magicres + 1;
					} else {
						this.points.remove(4);
						this.magicres = this.magicres + 1;
					}
				}
			}
		}
	}

}
