package com;

public class Map {
	public Terrain[][] terrain;
	public Troop[][] troops;
	
	
	public Troop[][] getTroops() {
		return troops;
	}



	public void setTroops(Troop[][] troops) {
		this.troops = troops;
	}



	public Map(int x,int y){
		setTerrain(new Terrain[x][y]);
		setTroops(new Troop[x][y]);
	}


	
	public Map(Terrain[][] terrain,Troop[][] troops){
		setTerrain(terrain);
		setTroops(troops);
	}

	
	
	public Terrain[][] getTerrain() {
		return terrain;
	}



	public void setTerrainTile(Terrain terrain,int i,int j) {
		this.terrain[i][j] = terrain;
	}
	public void setTroop(Troop troop,int i,int j) {
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
