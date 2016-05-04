package es.thesinsprods.zagastales.characters.equipment;

public class Cloak extends Accesories {

	private String accesory;
	private String description;
	private boolean posesion;
	private boolean legendaria;
	private Possesions possesion;

	public Cloak(String accesory, String description, boolean posesion,boolean legendaria,
			Possesions possesion) {
		super(accesory, description, posesion,legendaria, possesion);
		this.possesion = possesion;
		this.posesion = posesion;
		this.description = description;
		this.accesory = accesory;
		this.legendaria = legendaria;
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

	public String getAccesory() {
		return accesory;
	}

	public void setAccesory(String accesory) {
		this.accesory = accesory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
