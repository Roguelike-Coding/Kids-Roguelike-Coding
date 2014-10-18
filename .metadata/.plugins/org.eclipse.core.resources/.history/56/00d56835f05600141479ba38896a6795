package com;

public class Terrain {
	private int defense;
	private int movementCost;
	public RenderType renderType;
	private Terrain[] buildings;
	private String name;
	public Terrain(int defense,int movementCost,RenderType renderType,Terrain[] buildings,String name){
		this.setBuildings(buildings);
		this.setDefense(defense);
		this.setMovementCost(movementCost);
		this.setName(name);
		this.setRenderType(renderType);
	}

	public Terrain getThis(){
		Terrain output = new Terrain(this.defense,this.movementCost,this.renderType,this.buildings,this.name);
		return output;
	}
	public Terrain[] getBuildings() {
		return buildings;
	}

	public void setBuildings(Terrain[] buildings) {
		this.buildings = buildings;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getMovementCost() {
		return movementCost;
	}

	public void setMovementCost(int movementCost) {
		this.movementCost = movementCost;
	}

	public RenderType getRenderType() {
		return renderType;
	}

	public void setRenderType(RenderType renderType) {
		this.renderType = renderType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
