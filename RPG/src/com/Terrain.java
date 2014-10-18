package com;

public class Terrain {
	public RenderType renderType;
	private String name;
	private boolean solid;
	public Terrain(RenderType renderType,String name){
		this.setName(name);
		this.setRenderType(renderType);
	}

	public Terrain getThis(){
		Terrain output = new Terrain(this.renderType,this.name);
		return output;
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

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

}
