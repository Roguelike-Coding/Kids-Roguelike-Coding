package com;

import java.awt.Point;

import javax.swing.Action;

public interface Item {
	
	public void pickItem(ItemEntity item,Inventory inventory);
	
	public Point dropItem(ItemEntity item,Player player,EntityLabel[][] items,EntityLabel playerLabel);
	
	public void useItem(ItemEntity item);
	
	public void addActions();


	
}