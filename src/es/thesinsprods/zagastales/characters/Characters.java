package es.thesinsprods.zagastales.characters;

import es.thesinsprods.zagastales.characters.atributes.Atributes;
import es.thesinsprods.zagastales.characters.blessings.Blessing;
import es.thesinsprods.zagastales.characters.equipment.Accesories;
import es.thesinsprods.zagastales.characters.equipment.Armor;
import es.thesinsprods.zagastales.characters.equipment.Equipment;
import es.thesinsprods.zagastales.characters.equipment.Misc;
import es.thesinsprods.zagastales.characters.equipment.Weapons;
import es.thesinsprods.zagastales.characters.privileges.Privileges;
import es.thesinsprods.zagastales.characters.privileges.Setbacks;
import es.thesinsprods.zagastales.characters.race.Race;
import es.thesinsprods.zagastales.characters.skills.CombatSkills;
import es.thesinsprods.zagastales.characters.skills.KnowHowSkills;
import es.thesinsprods.zagastales.characters.skills.KnowledgeSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;

public class Characters {

	private String name;
	private Race race;
	private int age;
	private int fate;
	private int life;
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	private int endurance;
	private int mana;
	private Atributes atributes;
	private CombatSkills combatSkills;
	private KnowledgeSkills knowledgeSkills;
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	private MagicSkills magicSkills;
	private KnowHowSkills knowhowSkills;
	private Blessing blessing;
	private Privileges privileges;
	private Setbacks setbacks;
	private boolean campeon;
	private Armor armor;
	private Equipment equipment;
	private Weapons weapon1;
	private Weapons weapon2;
	public Weapons getWeapon1() {
		return weapon1;
	}

	public void setWeapon1(Weapons weapon1) {
		this.weapon1 = weapon1;
	}

	public Weapons getWeapon2() {
		return weapon2;
	}

	public void setWeapon2(Weapons weapon2) {
		this.weapon2 = weapon2;
	}

	public Weapons getWeapon3() {
		return weapon3;
	}

	public void setWeapon3(Weapons weapon3) {
		this.weapon3 = weapon3;
	}

	public Weapons getWeapon4() {
		return weapon4;
	}

	public void setWeapon4(Weapons weapon4) {
		this.weapon4 = weapon4;
	}

	public Misc getMisc1() {
		return misc1;
	}

	public void setMisc1(Misc misc1) {
		this.misc1 = misc1;
	}

	public Misc getMisc2() {
		return misc2;
	}

	public void setMisc2(Misc misc2) {
		this.misc2 = misc2;
	}

	public Misc getMisc3() {
		return misc3;
	}

	public void setMisc3(Misc misc3) {
		this.misc3 = misc3;
	}

	public Misc getMisc4() {
		return misc4;
	}

	public void setMisc4(Misc misc4) {
		this.misc4 = misc4;
	}

	public Accesories getAcc1() {
		return acc1;
	}

	public void setAcc1(Accesories acc1) {
		this.acc1 = acc1;
	}

	public Accesories getAcc2() {
		return acc2;
	}

	public void setAcc2(Accesories acc2) {
		this.acc2 = acc2;
	}

	public Accesories getAcc3() {
		return acc3;
	}

	public void setAcc3(Accesories acc3) {
		this.acc3 = acc3;
	}

	public Accesories getAcc4() {
		return acc4;
	}

	public void setAcc4(Accesories acc4) {
		this.acc4 = acc4;
	}

	private Weapons weapon3;
	private Weapons weapon4;
	private Misc misc1;
	private Misc misc2;
	private Misc misc3;
	private Misc misc4;
	private Accesories acc1;
	private Accesories acc2;
	private Accesories acc3;
	private Accesories acc4;
	private String description;
	private int experience;
	private String extras;
	private int dinero;
	private String modificadores;
	private String poderes;
	private int nivel;
	private String estado;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Characters(String name, Race race, String description, int age,
			int fate, int life, int endurance, int mana, Atributes atributes,
			CombatSkills combatSkills, KnowledgeSkills knowledgeSkills,
			MagicSkills magicSkills, KnowHowSkills knowhowSkills,
			Blessing blessing, Privileges privileges, Setbacks setbacks,
			boolean campeon, Armor armor,Equipment equipment,Weapons weapon1,Weapons weapon2,Weapons weapon3,Weapons weapon4, Misc misc1,Misc misc2,Misc misc3,Misc misc4,Accesories acc1,Accesories acc2,Accesories acc3,Accesories acc4, int experience,
			int nivel,int dinero, String extras, String modificadores, String poderes) {
		this.name = name;
		this.race = race;
		this.age = age;
		this.fate = fate;
		this.life = life;
		this.endurance = endurance;
		this.mana = mana;
		this.atributes = atributes;
		this.combatSkills = combatSkills;
		this.knowledgeSkills = knowledgeSkills;
		this.magicSkills = magicSkills;
		this.knowhowSkills = knowhowSkills;
		this.blessing = blessing;
		this.privileges = privileges;
		this.setbacks = setbacks;
		this.campeon = campeon;
		this.armor = armor;
		this.equipment = equipment;
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.weapon3 = weapon3;
		this.weapon4 = weapon4;
		this.misc1 = misc1;
		this.misc2 = misc2;
		this.misc3 = misc3;
		this.misc4 = misc4;
		this.acc1 = acc1;
		this.acc2 = acc2;
		this.acc3 = acc3;
		this.acc4 = acc4;
		this.experience = experience;
		this.nivel = nivel;
		this.dinero= dinero;
		this.extras =extras;
		this.modificadores= modificadores;
		this.poderes=poderes;
		this.estado= "Normal";
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public String getModificadores() {
		return modificadores;
	}

	public void setModificadores(String modificadores) {
		this.modificadores = modificadores;
	}

	public String getPoderes() {
		return poderes;
	}

	public void setPoderes(String poderes) {
		this.poderes = poderes;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	
	public boolean isCampeon() {
		return campeon;
	}

	public void setCampeon(boolean campeon) {
		this.campeon = campeon;
	}

	public Setbacks getSetbacks() {
		return setbacks;
	}

	public void setSetbacks(Setbacks setbacks) {
		this.setbacks = setbacks;
	}

	public Privileges getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Privileges privileges) {
		this.privileges = privileges;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getFate() {
		return fate;
	}

	public void setFate(int fate) {
		this.fate = fate;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public Atributes getAtributes() {
		return atributes;
	}

	public void setAtributes(Atributes atributes) {
		this.atributes = atributes;
	}

	public CombatSkills getCombatSkills() {
		return combatSkills;
	}

	public void setCombatSkills(CombatSkills combatSkills) {
		this.combatSkills = combatSkills;
	}

	public KnowledgeSkills getKnowledgeSkills() {
		return knowledgeSkills;
	}

	public void setKnowledgeSkills(KnowledgeSkills knowledgeSkills) {
		this.knowledgeSkills = knowledgeSkills;
	}

	public MagicSkills getMagicSkills() {
		return magicSkills;
	}

	public void setMagicSkills(MagicSkills magicSkills) {
		this.magicSkills = magicSkills;
	}

	public KnowHowSkills getKnowhowSkills() {
		return knowhowSkills;
	}

	public void setKnowhowSkills(KnowHowSkills knowhowSkills) {
		this.knowhowSkills = knowhowSkills;
	}

	public Blessing getBlessing() {
		return blessing;
	}

	public void setBlessing(Blessing blessing) {
		this.blessing = blessing;
	}

}
