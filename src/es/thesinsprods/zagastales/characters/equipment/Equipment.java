package es.thesinsprods.zagastales.characters.equipment;

import java.util.ArrayList;

public class Equipment {

	private ArrayList<Inventory> inventory;

	public Equipment() {
		this.inventory = new ArrayList<Inventory>();
	}

	public ArrayList<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Inventory> inventory) {
		this.inventory = inventory;
	}

	public void add(Inventory inventory) {
		this.inventory.add(inventory);

	}

	public int CalculoPesoWeapons(int strenght) {

		if (strenght <= 10) {

			return 1;
		}
		if (strenght > 10 && strenght <= 12) {

			return 2;
		}
		if (strenght > 12 && strenght <= 16) {

			return 3;
		} else {
			return 4;
		}
	}

	public int CalculoPesoMisc(int strenght) {

		if (strenght <= 10) {

			return 2;
		}
		if (strenght > 10 && strenght <= 12) {

			return 2;
		}
		if (strenght > 12 && strenght <= 16) {

			return 3;
		} else {
			return 4;
		}
	}
}
