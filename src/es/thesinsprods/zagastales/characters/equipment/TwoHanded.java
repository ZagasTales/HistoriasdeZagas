package es.thesinsprods.zagastales.characters.equipment;

public class TwoHanded extends Weapons {

	private String weapon;
	private String description;
	private boolean posesion;
	private boolean legendaria;
	private Possesions possesion;
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public TwoHanded(String weapon, String description,
			boolean posesion,boolean legendaria, Possesions possesion, String tipo) {
		super(weapon, description, posesion,legendaria, possesion, tipo);
		this.weapon = weapon;
		this.description = description;
		this.posesion = posesion;
		this.possesion = possesion;
		this.legendaria = legendaria;
		this.tipo=tipo;
	}

	public boolean isLegendaria() {
		return legendaria;
	}

	public void setLegendaria(boolean legendaria) {
		this.legendaria = legendaria;
	}

	public Possesions getPossesion() {
		return possesion;
	}

	public void setPossesion(Possesions possesion) {
		this.possesion = possesion;
	}

	public boolean isPosesion() {
		return posesion;
	}

	public void setPosesion(boolean posesion) {
		this.posesion = posesion;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
