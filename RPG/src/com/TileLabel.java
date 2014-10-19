package com;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class TileLabel extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	private BufferedImage[] imgs=new BufferedImage[0];
	private int frame=0;
	private boolean ifTile;
	/**
	 * 
	 * @param bufferedImage
	 * @param ifTile
	 */
	public TileLabel(BufferedImage[] bufferedImage,boolean ifTile,boolean rotate){
		if(rotate||bufferedImage[0].getHeight()==64)
		img=RenderType.convertTo45Degree(bufferedImage,64)[0];
		else
			img=bufferedImage[0];
		if(rotate||bufferedImage[0].getHeight()==64)
		setImgs(bufferedImage);
		this.setIfTile(ifTile);
		this.setVisible(true);
	}
	public TileLabel(BufferedImage bufferedImage,boolean ifTile){
		this.img=bufferedImage;
		this.setIfTile(ifTile);
		this.setVisible(true);
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage bufferedImage) {
		if(this.isIfTile())
		this.img = RenderType.convertTo45Degree(new BufferedImage[]{bufferedImage},64)[0];
		else
			this.img =bufferedImage;
	}
	@Override
	public void paint(Graphics g){
		if(isIfTile()){
		Graphics2D g2d=(Graphics2D)g;
		AffineTransform aff=new AffineTransform();
		aff.scale(1, 0.5);
		g2d.drawImage(getImg(),aff,this);}//(int)(1.5*64*Math.sqrt(2)),(int)(1.5*32*Math.sqrt(2))
		else{
		AffineTransform aff=new AffineTransform();
		aff.scale(1, 1);
		Graphics2D g2d=(Graphics2D)g;
		g2d.drawImage(getImg(),aff,this);
		}
		}
	public boolean isIfTile() {
		return ifTile;
	}
	public void setIfTile(boolean ifTile) {
		this.ifTile = ifTile;
	}
	public int getFrame() {
		return frame;
	}
	public void setFrame(int frame) {
		this.frame = frame;
		this.repaint();
	}
	public BufferedImage[] getImgs() {
		return imgs;
	}
	public void setImgs(BufferedImage[] imgs) {
		this.imgs = imgs;
	}
	public int getNrOfFrames(){
		return getImgs().length;
	}
}
