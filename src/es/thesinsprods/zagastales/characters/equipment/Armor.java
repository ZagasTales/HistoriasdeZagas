package es.thesinsprods.zagastales.characters.equipment;

public class Armor extends Inventory {

	private String armor;
	private String description;
	private boolean posesion;
	private boolean legendaria;
	private Possesions possesion;

	public Armor(String armor, String description, boolean posesion,boolean legendaria, 
			Possesions possesion) {

		this.armor = armor;
		this.description = description;
		this.posesion = posesion;
		this.possesion = possesion;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArmor() {
		return armor;
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}

}
