package com;

import javax.swing.Action;

public class Potion extends ItemEntity implements TrowableItem {

	public Potion(String name, String path, boolean inInventory,Action action) {
		super(name, path, inInventory, action);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trowItem(int x,int y) {
		
		
	}

}
