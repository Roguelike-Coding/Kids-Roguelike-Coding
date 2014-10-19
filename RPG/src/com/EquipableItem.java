package com;

public interface EquipableItem extends Item {
	public Inventory equipItem(ItemEntity item,Inventory inventory);
	
	public Inventory unequipItem(Inventory inventory);
}
