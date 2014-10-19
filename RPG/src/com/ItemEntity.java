package com;

import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.Action;


public class ItemEntity extends Entity implements Item {
	private boolean inInventory;
	private Action action;
	public ItemEntity(String name,String path,boolean inInventory,Action action){
		super();
		this.setName(name);
		this.setFrames(this.afterException(Interpreter.class.getResource(path)));
		this.setInInventory(inInventory);
		this.setAction(action);
	}

	@Override
	public void pickItem(ItemEntity item,Inventory inventory) {
		// TODO Auto-generated method stub
		this.setInInventory(true);
		boolean stacking =false;
		for(int i=0;i<inventory.slots.length;i++){
			for(int j=0;j<inventory.slots[0].length;j++){
				if(inventory.slots[i][j]!=null)
				if(inventory.slots[i][j].getItem().getName().equals(this.getName())){
					inventory.slots[i][j].setStack(inventory.slots[i][j].getStack()+1);
					stacking=true;
				}
			}
		}
		boolean found=false;
		if(!stacking){
			for(int i=0;i<inventory.slots.length;i++){
				for(int j=0;j<inventory.slots[0].length;j++){
					if(!found)
					if(inventory.slots[i][j]==null){
						inventory.slots[i][j]=new InventorySlot(item);
						inventory.slots[i][j].setStack(1);
						found=true;
					}
				}
			}
		}
	}

	@Override
	public Point dropItem(ItemEntity item,Player player,EntityLabel[][] items,EntityLabel playerLabel) {
		boolean found=false;
		int d=100000;
		int a=0,b=0;
		for(int i=0;i<player.inventory.slots.length;i++){
			for(int j=0;j<player.inventory.slots[0].length;j++){
				if(!found)
					if(player.inventory.slots[i][j]!=null)
				if(player.inventory.slots[i][j].getItem().equals(item)){
					if(player.inventory.slots[i][j].getStack()==1){
						player.inventory.slots[i][j]=null;
						found=true;
						for(int k=0;k<items.length;k++){
							for(int l=0;l<items[0].length;l++){
								int x=playerLabel.getX();
								int y=playerLabel.getY();
								if(d>=(Math.sqrt(Math.pow(x-items[k][l].getX(),2)+Math.pow(y-items[k][l].getY(),2)))){
									d=(int) Math.sqrt(Math.pow(x-items[k][l].getX(),2)+Math.pow(y-items[k][l].getY(),2));
									a=k;
									b=l;
									System.out.println(a+" "+b);
								}
							}
						}
					}
					else{
						player.inventory.slots[i][j].setStack(player.inventory.slots[i][j].getStack()-1);
						found=true;
						for(int k=0;k<items.length;k++){
							for(int l=0;l<items[0].length;l++){
								int x=playerLabel.getX();
								int y=playerLabel.getY();
								if(d>=(Math.sqrt(Math.pow(x-items[k][l].getX(),2)+Math.pow(y-items[k][l].getY(),2)))){
									d=(int) Math.sqrt(Math.pow(x-items[k][l].getX(),2)+Math.pow(y-items[k][l].getY(),2));
									a=k;
									b=l;
									System.out.println(a+" "+b);
								}}}
					}
				}
			}
		}
		return new Point(a,b);
		// TODO Auto-generated method stub
		
	}

	public boolean isInInventory() {
		return inInventory;
	}

	public void setInInventory(boolean inInventory) {
		this.inInventory = inInventory;
	}

	@Override
	public void addActions() {
		// TODO Auto-generated method stub
		
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public void useItem(ItemEntity item) {
		// TODO Auto-generated method stub
		getAction().actionPerformed(null);
	}
}
