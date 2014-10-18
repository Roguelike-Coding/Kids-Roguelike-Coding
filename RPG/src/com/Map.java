package com;

public class Map {
	public Terrain[][] terrain;
	public Entity[][] troops;
	
	
	public Entity[][] getTroops() {
		return troops;
	}



	public void setTroops(Entity[][] troops) {
		this.troops = troops;
	}



	public Map(int x,int y){
		setTerrain(new Terrain[x][y]);
		setTroops(new Entity[x][y]);
	}


	
	public Map(Terrain[][] terrain,Entity[][] troops){
		setTerrain(terrain);
		setTroops(troops);
	}

	
	
	public Terrain[][] getTerrain() {
		return terrain;
	}



	public void setTerrainTile(Terrain terrain,int i,int j) {
		this.terrain[i][j] = terrain;
	}
	public void setTroop(Entity troop,int i,int j) {
		this.troops[i][j] = troop;
	}
	public void setTerrain(Terrain[][] terrain) {
		this.terrain = terrain;
	}
	
	public int getHeight(){
		return getTerrain().length;
		
	}
	public int getWidth(){
		return getTerrain()[0].length;
		
	}
}
