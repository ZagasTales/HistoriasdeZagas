package es.thesinsprods.zagastales.characters.equipment;

public class Accesories extends Inventory {

	private String accesory;
	private String description;
	private boolean posesion;
	private boolean legendaria;
	private Possesions possesion;

	public boolean isLegendaria() {
		return legendaria;
	}

	public void setLegendaria(boolean legendaria) {
		this.legendaria = legendaria;
	}

	public Accesories(String accesory, String description, boolean posesion,boolean legendaria,
			Possesions possesion) {
		this.posesion = posesion;
		this.accesory = accesory;
		this.description = description;
		this.possesion = possesion;
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

	public Accesories(String accesory, String description) {
		this.accesory = accesory;
		this.description = description;

	}

}
