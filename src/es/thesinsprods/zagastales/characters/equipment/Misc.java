package es.thesinsprods.zagastales.characters.equipment;

public class Misc extends Inventory {

	private String misc;
	private String description;
	private boolean posesion;
	private boolean legendaria;
	private Possesions possesion;

	public Possesions getPossesion() {
		return possesion;
	}

	public boolean isLegendaria() {
		return legendaria;
	}

	public void setLegendaria(boolean legendaria) {
		this.legendaria = legendaria;
	}

	public void setPossesion(Possesions possesion) {
		this.possesion = possesion;
	}

	public Misc(String misc, String description, boolean posesion, boolean legendaria,
			Possesions possesion) {
		this.possesion = possesion;
		this.misc = misc;
		this.description = description;
		this.posesion = posesion;
		this.legendaria = legendaria;
	}

	public boolean isPosesion() {
		return posesion;
	}

	public void setPosesion(boolean posesion) {
		this.posesion = posesion;
	}

	public String getMisc() {
		return misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
