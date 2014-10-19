package com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class RenderType {
	public BufferedImage[] tileLayer;
	private BufferedImage backLayer;
	private BufferedImage frontLayer;
	private boolean connect;
	private ConnectionType connections;
	private int layer;
	private boolean animated;
	private boolean backTile;
	private boolean frontTile;
	private String tilePath;
	private String backPath;
	private String frontPath;
	private static BufferedImage[] auxiliarImage;
	
	/** 
	 * This is the constructor for a basic render type with one layer. This layer is the tile layer
	 * @param tilePath This is the path of the file
	 * @param connect This specifies if one layer connects to another tile
	 * @param connections This argument should be an array of the names of the tiles, which this tile should connect
	 * @param layer This is the layer which has connected textures
	 * @param animated This specifies if the tile layer is animated
	 */
	public RenderType(String tilePath,boolean connect,ConnectionType connections,int layer,boolean animated){
		this.setConnected(connect);
		this.setLayer(layer);
		this.setAnimated(animated);
		this.setConnections(connections);	
		this.setTilePath(tilePath);
		if(animated){
			this.setTileLayer(fromGIFtoImages(Interpreter.class.getResource(tilePath+".gif")));
		}else{
			this.setTileLayer(afterException(Interpreter.class.getResource(tilePath+".gif")));
		}
	}
	/**
	 * This is the constructor for a bit more advanced render type with one layer which is the tile and one on the tile which stays behind the troop.
	 * @param tilePath This is the path of the file
	 * @param backPath This is the path of the file
	 * @param backTile This marks if this layer is a tile
	 * @param connect This specifies if one layer connects to another tile
	 * @param connections This argument should be an array of the names of the tiles, which this tile should connect
	 * @param layer This is the layer which has connected textures
	 * @param animated This specifies if the tile layer is animated
	 */
	public RenderType(String tilePath, String backPath,boolean backTile,boolean connect,ConnectionType connections,int layer,boolean animated){
		this.setAnimated(animated);
		this.setConnected(connect);
		this.setLayer(layer);
		this.setConnections(connections);
		this.setTilePath(tilePath);
		this.setBackPath(backPath);
		if(animated){
			this.setTileLayer(fromGIFtoImages(Interpreter.class.getResource(tilePath+".gif")));
		}else{
			this.setTileLayer(afterException(Interpreter.class.getResource(tilePath+".gif")));
		}
		if(backTile)
		this.setBackLayer(afterException(Interpreter.class.getResource(backPath+".png"))[0]);
		else
		this.setBackLayer(afterException(Interpreter.class.getResource(backPath+".png"))[0]);
		this.setBackTile(backTile);
	}
	/**
	 * 
	 * @param tilePath This is the path of the file
	 * @param backPath This is the path of the file
	 * @param backTile This marks if this layer is a tile
	 * @param frontPath This is the path of the file
	 * @param frontTile This marks if this layer is a tile
	 * @param connect This specifies if one layer connects to another tile
	 * @param connections This argument should be an array of the names of the tiles, which this tile should connect
	 * @param layer This is the layer which has connected textures
	 * @param animated This specifies if the tile layer is animated
	 */
	public RenderType(String tilePath, String backPath,boolean backTile, String frontPath,boolean frontTile,boolean connect,ConnectionType connections,int layer,boolean animated){
		this.setAnimated(animated);
		if(animated){
			this.setTileLayer(fromGIFtoImages(Interpreter.class.getResource(tilePath+".gif")));
		}else{
			this.setTileLayer(afterException(Interpreter.class.getResource(tilePath+".gif")));
		}
		if(backTile)
			this.setBackLayer(afterException(Interpreter.class.getResource(backPath+".png"))[0]);
			else
			this.setBackLayer(afterException(Interpreter.class.getResource(backPath+".png"))[0]);
		this.setLayer(layer);
		this.setTilePath(tilePath);
		this.setBackPath(backPath);
		this.setFrontPath(frontPath);
		this.setFrontTile(frontTile);
		this.setBackTile(backTile);
		this.setFrontLayer(convertTo45Degree(afterException(Interpreter.class.getResource(frontPath)),64)[0]);
		this.setConnected(connect);
		this.setConnections(connections);
	}
	/**
	 * Converts gif to frames
	 * @param url The path of the file
	 * @return Returns an array with the frames of the gif
	 */
	public static BufferedImage[] fromGIFtoImages(URL url){
		ImageReader reader = ImageIO.getImageReadersBySuffix("GIF").next();  
		ImageInputStream in = null;
		try {
			in = ImageIO.createImageInputStream(new File(url.toURI()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		reader.setInput(in);  
		int count = 1;
		try {
			count = reader.getNumImages(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage[] output=new BufferedImage[count];
		for (int i = 0;  i < count; i++)  
		{  
		    BufferedImage image = null;
			try {
				image = reader.read(i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			output[i]=image;
			
		}  

		
		return output;
		
	}/*
	public void changeTile(URL url){
		setTileLayer(convertTo45Degree(fromGIFtoImages(url),64));
	}*/
	public static BufferedImage[] afterException(URL url){
		BufferedImage[] aux = new BufferedImage[1];
		try {
			aux[0] = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}
	public BufferedImage[] getTileLayer() {
		return tileLayer;
	}
	public void setTileLayer(BufferedImage[] tileLayer) {
		this.tileLayer = tileLayer;
	}
	public BufferedImage getBackLayer() {
		return backLayer;
	}
	public void setBackLayer(BufferedImage backLayer) {
		this.backLayer = backLayer;
	}
	public BufferedImage getFrontLayer() {
		return frontLayer;
	}
	public void setFrontLayer(BufferedImage frontLayer) {
		this.frontLayer = frontLayer;
	}
	/**
	 * Rotates an image to 45 degrees and doubles the size
	 * @param image These are the frames
	 * @param r This is the size of the image
	 * @return
	 */
	public static BufferedImage[] convertTo45Degree(BufferedImage[] image,int r){
		auxiliarImage=new BufferedImage[image.length];
		for(int i=0;i<image.length;i++){
		auxiliarImage[i] =new BufferedImage(r*2-1,r*2-1,BufferedImage.TYPE_INT_ARGB);
		int strx=r-1,finx=r-1,size=r*2-1,h=0;
		recursiveDraw(strx,finx,size,h,image[i],i);
		}
		
		return auxiliarImage;
	}
	public static void recursiveDraw(int strx,int finx,int size,int h,BufferedImage image,int index){
		int x,y;
		if(h<image.getHeight()){
			x=0;
			y=h;
		}
		else{
			x=h-image.getHeight()+1;
			y=image.getHeight()-1;
		}

		boolean mid=true;
		for(int i=strx;i<=finx;i++){
			if(mid){
				try{
				auxiliarImage[index].setRGB(i,h,image.getRGB(x, y));}
				catch(Exception e){
					
				}
			x++;
			y--;}
			else{
				int a1=new Color(image.getRGB(x-1,y+1)).getAlpha();
				int a2=new Color(image.getRGB(x,y)).getAlpha();
				int newa=(a1+a2)/2;
				if(newa>100)
					try{
				auxiliarImage[index].setRGB(i,h,image.getRGB(x, y));
					}catch(Exception e){
					
				}
			}
			mid=!mid;
		}
		if(h<size){
		if(h<image.getHeight()-1){
			recursiveDraw(strx-1,finx+1,size,h+1,image,index);
			
		}else{
			recursiveDraw(strx+1,finx-1,size,h+1,image,index);
		}}
	}
	public boolean isConnected() {
		return connect;
	}
	public void setConnected(boolean connect) {
		this.connect = connect;
	}
	public ConnectionType getConnections() {
		return connections;
	}
	public void setConnections(ConnectionType connections2) {
		this.connections = connections2;
	}
	public RenderType getThis(){
		RenderType output;
		if(backPath!=null)
		output=new RenderType(this.getTilePath(),this.getBackPath(), this.isBackTile(),this.isConnected(), this.getConnections(), this.getLayer(), this.isAnimated());
		else
		output=new RenderType(this.getTilePath(),this.isConnected(), this.getConnections(), this.getLayer(), this.isAnimated());
		return output;
		
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	public boolean isAnimated() {
		return animated;
	}
	public void setAnimated(boolean animated) {
		this.animated = animated;
	}
	public boolean isBackTile() {
		return backTile;
	}
	public void setBackTile(boolean backTile) {
		this.backTile = backTile;
	}
	public boolean isFrontTile() {
		return frontTile;
	}
	public void setFrontTile(boolean frontTile) {
		this.frontTile = frontTile;
	}
	public String getTilePath() {
		return tilePath;
	}
	public void setTilePath(String tilePath) {
		this.tilePath = tilePath;
	}
	public String getBackPath() {
		return backPath;
	}
	public void setBackPath(String backPath) {
		this.backPath = backPath;
	}
	public String getFrontPath() {
		return frontPath;
	}
	public void setFrontPath(String frontPath) {
		this.frontPath = frontPath;
	}
	public void mergeTwoImages(BufferedImage[] overlay,int direction){

		int w = tileLayer[0].getWidth();
		int h = tileLayer[0].getHeight();
		BufferedImage[] output=new BufferedImage[tileLayer.length];
		for(int i=0;i<tileLayer.length;i++){
		BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

		// paint both images, preserving the alpha channels
		
		Graphics g = combined.getGraphics();
		if(direction==1){
			g.drawImage(tileLayer[i], 0, 0, null);
			g.drawImage(overlay[direction], 0, 0, null);

		}
		if(direction==2){
			g.drawImage(tileLayer[i], 0, 0, null);
			g.drawImage(overlay[direction], 56, 0, null);
		}
		if(direction==3){
			g.drawImage(tileLayer[i], 0, 0, null);
			g.drawImage(overlay[direction], 0, 56,  null);
		}
		if(direction==4){
			g.drawImage(tileLayer[i], 0, 0, null);
			g.drawImage(overlay[direction], 0, 0, null);
		}
		
		output[i]=combined;
		}
		tileLayer=output;
	}
}
