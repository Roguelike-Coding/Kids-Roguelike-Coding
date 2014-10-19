package com;

public class ArmorSlot extends InventorySlot {
	private Armor armor;
	public ArmorSlot(Armor armor) {
		// TODO Auto-generated constructor stub
		this.setArmor(armor);
	}
	public Armor getArmor() {
		return armor;
	}
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
}
