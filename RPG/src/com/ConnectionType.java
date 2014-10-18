package com;

import java.awt.image.BufferedImage;

public class ConnectionType {
	private BufferedImage[] connectionType;
	private String[] terrainTypes;
	private ConnectionType[] multiple;
	private int type;
	public ConnectionType(BufferedImage[] connectionType, String[] terrainTypes){
		setConectionType(connectionType);
		setTerrainTypes(terrainTypes);
		setType(1);
	}
	public ConnectionType(BufferedImage[] connectionType,ConnectionType[] multiple){
		setConectionType(connectionType);
		setMultiple(multiple);
		setType(2);
	}
	public String[] getTerrainTypes() {
		return terrainTypes;
	}
	public void setTerrainTypes(String[] terrainTypes) {
		this.terrainTypes = terrainTypes;
	}
	public BufferedImage[] getConectionType() {
		return connectionType;
	}
	public void setConectionType(BufferedImage[] connectionType) {
		this.connectionType = connectionType;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ConnectionType[] getMultiple() {
		return multiple;
	}
	public void setMultiple(ConnectionType[] multiple) {
		this.multiple = multiple;
	}
}
