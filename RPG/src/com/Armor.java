package com;

import javax.swing.Action;

public class Armor extends ItemEntity implements EquipableItem , UpgradableItem  {
	private int upgradeLevel;
	public Armor(String name, String path, boolean inInventory,Action action,int defense ,int upgradeLevel) {
		super(name, path, inInventory, action);
		this.setBaseDefense(defense);
		this.setUpgradeLevel(upgradeLevel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void upgradeItem(ItemEntity item) {
		if(item.getName().equals("Scroll of Upgrade"))
		setUpgradeLevel(getUpgradeLevel()+1);
	}

	@Override
	public Inventory equipItem(ItemEntity item,Inventory inventory) {
		return inventory;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inventory unequipItem(Inventory inventory) {
		return inventory;
		// TODO Auto-generated method stub
		
	}

	public int getUpgradeLevel() {
		return upgradeLevel;
	}

	public void setUpgradeLevel(int upgradeLevel) {
		this.upgradeLevel = upgradeLevel;
	}

}
