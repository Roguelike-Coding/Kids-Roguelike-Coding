package com;

import java.awt.*;
import java.awt.image.BufferedImage;

public class IsoTile{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	private TileLabel tileLabel;
	private TileLabel backLabel;
	private TileLabel frontLabel;
	private RenderType renderer;
	/**
	 * Constructor for the tile
	 * @param renderer This is the renderer
	 * @param p This is the initial point where the tile will stay
	 */
	public IsoTile(RenderType renderer,Point p,boolean rotate){
		this.renderer=renderer;
		tileLabel=new TileLabel(renderer.getTileLayer(),true,rotate);	
		backLabel=new TileLabel(renderer.getBackLayer(),renderer.isBackTile());
		frontLabel=new TileLabel(renderer.getFrontLayer(),renderer.isFrontTile());
		tileLabel.setBounds(p.x,p.y+63,127,63);
		if(!renderer.isBackTile()){
		backLabel.setBounds(p.x,p.y,127,127);}
		else{
			backLabel.setBounds(p.x,p.y+63,127,63);
		}
		if(!renderer.isFrontTile()){
			
		}
		else{
			
		}
		backLabel.setOpaque(false);


	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public TileLabel getTileLabel() {
		return tileLabel;
	}
	/**
	 * This sets the bounds of the tile
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public void setAllBounds(int x,int y){
		tileLabel.setBounds(x,y+63,127,63);
		if(!renderer.isBackTile()){
		backLabel.setBounds(x,y,127,127);}
		else{
			backLabel.setBounds(x,y+63,127,63);
		}
		
	}
	public void setAllVisible(boolean v){
		tileLabel.setVisible(v);
		backLabel.setVisible(v);
		frontLabel.setVisible(v);
	}
	public void rePaintAll(){
		tileLabel.repaint();
		backLabel.repaint();
		frontLabel.repaint();
	}
	public void setTileLabel(TileLabel tileLabel) {
		this.tileLabel = tileLabel;
	}
	public TileLabel getBackLabel() {
		return backLabel;
	}
	public void setBackLabel(TileLabel backLabel) {
		this.backLabel = backLabel;
	}
	public TileLabel getFrontLabel() {
		return frontLabel;
	}
	public void setFrontLabel(TileLabel frontLabel) {
		this.frontLabel = frontLabel;
	}
}
