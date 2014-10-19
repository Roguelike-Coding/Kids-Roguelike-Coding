package com;

public class Inventory {
	public InventorySlot[][] slots=new InventorySlot[5][5];
	public ArmorSlot armorSlot=null;
	public Inventory(){
		for(int i=0;i<slots.length;i++){
			for(int j=0;j<slots[0].length;j++){
				slots[i][j]=null;
			}
		}
	}
}
