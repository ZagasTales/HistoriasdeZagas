package es.thesinsprods.zagastales.characters.equipment;

public class Weapons extends Inventory {

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



	private String weapon;
	private String description;
	private boolean posesion;
	private boolean legendaria;
	private String tipo;
	public boolean isLegendaria() {
		return legendaria;
	}

	public void setLegendaria(boolean legendaria) {
		this.legendaria = legendaria;
	}

	private Possesions possesion;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Weapons(String weapon, String description,
			boolean posesion,boolean legendaria, Possesions possesion, String tipo) {
		this.weapon = weapon;
		this.description = description;
		this.posesion = posesion;
		this.legendaria =legendaria;
		this.possesion = possesion;
		this.tipo=tipo;

	}

	public String atributo(){
			
		if(this.tipo.equals("Látigo")){return "Destreza";}
		else if(this.tipo.equals("Arma de Puño")){return "Fuerza";}
		else if(this.tipo.equals("Daga")){return "Destreza";}
		else if(this.tipo.equals("Estoque")){return "Destreza";}
		else if(this.tipo.equals("Espada")){return "Fuerza";}
		else if(this.tipo.equals("Espada Curva")){return "Destreza";}
		else if(this.tipo.equals("Katana")){return "Destreza";}
		else if(this.tipo.equals("Hacha")){return "Fuerza";}
		else if(this.tipo.equals("Maza")){return "Fuerza";}
		else if(this.tipo.equals("Espadón")){return "Fuerza";}
		else if(this.tipo.equals("Hacha de Guerra")){return "Fuerza";}
		else if(this.tipo.equals("Martillo de Guerra")){return "Fuerza";}
		else if(this.tipo.equals("Ultra-Espadón")){return "Fuerza";}
		else if(this.tipo.equals("Lanza")){return "Destreza";}
		else if(this.tipo.equals("Alabarda")){return "Fuerza";}
		else if(this.tipo.equals("Bardiche")){return "Fuerza";}
		else if(this.tipo.equals("Guadaña")){return "Destreza";}
		else if(this.tipo.equals("Bastón de Combate")){return "Destreza";}
		else if(this.tipo.equals("Martilo de Lucerna")){return "Fuerza";}
		else if(this.tipo.equals("Arma Arrojadiza")){return "Destreza";}
		else if(this.tipo.equals("Arco")){return "Destreza";}
		else if(this.tipo.equals("Ballesta")){return "Destreza";}
		else if(this.tipo.equals("Arma de Fuego")){return "Destreza";}
		else if(this.tipo.equals("Escudo Pequeño")){return "Fuerza";}
		else if(this.tipo.equals("Escudo Mediano")){return "Fuerza";}
		else if(this.tipo.equals("Escudo de Torre")){return "Fuerza";}
		
		
		
		
		return description;}
}
