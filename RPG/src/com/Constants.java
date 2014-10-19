
package com;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Constants {
	public BufferedImage COBBLE_BORDER_NORTH=afterException(Interpreter.class.getResource("/com/resources/terrain/CobbleBorderNorth.png"));
	public BufferedImage COBBLE_BORDER_SOUTH=afterException(Interpreter.class.getResource("/com/resources/terrain/CobbleBorderSouth.png"));
	public BufferedImage COBBLE_BORDER_WEST=afterException(Interpreter.class.getResource("/com/resources/terrain/CobbleBorderWest.png"));
	public BufferedImage COBBLE_BORDER_EAST=afterException(Interpreter.class.getResource("/com/resources/terrain/CobbleBorderEast.png"));
	
	public ConnectionType COBBLE =new ConnectionType(new BufferedImage[]{null,COBBLE_BORDER_SOUTH,COBBLE_BORDER_WEST,COBBLE_BORDER_NORTH,COBBLE_BORDER_EAST}, new String[]{"Wall","Floor"});
	public ConnectionType COBBLE1 =new ConnectionType(null,new ConnectionType[]{COBBLE});
	public RenderType WALL1 = new RenderType("/com/resources/terrain/plainsTile", "/com/resources/terrain/wall1", false, false, null, 0, false);
	public RenderType WALL2 = new RenderType("/com/resources/terrain/plainsTile", "/com/resources/terrain/wall2", false, false, null, 0, false);
	public RenderType WALL3 = new RenderType("/com/resources/terrain/plainsTile", "/com/resources/terrain/wall3", false, false, null, 0, false);
	public RenderType WALL4 = new RenderType("/com/resources/terrain/plainsTile", "/com/resources/terrain/wall4", false, false, null, 0, false);
	public RenderType DOOR = new RenderType("/com/resources/terrain/cobblestone", "/com/resources/terrain/door", false, false, null, 0, false);
	public RenderType FLOOR_COBBLE = new RenderType("/com/resources/terrain/cobblestone", false, null, 0, false);
	public RenderType FLOOR_MOSS = new RenderType("/com/resources/terrain/mossstone", false, null, 0, false);
	public RenderType FLOOR_WATER = new RenderType("/com/resources/terrain/waterTile", true, COBBLE, 1, true);
	public Player AUX = new Player(0, 0, 0, "Me", "/com/resources/entity/SoldierR.gif");
	
	public BufferedImage PROP_WEB = afterException(Interpreter.class.getResource("/com/resources/terrain/web.png"));
	public BufferedImage PROP_FIRECAMP = afterException(Interpreter.class.getResource("/com/resources/terrain/fire.png"));
	public BufferedImage PROP_BARREL = afterException(Interpreter.class.getResource("/com/resources/terrain/barrel.png"));
	public BufferedImage PROP_STAND1 = afterException(Interpreter.class.getResource("/com/resources/terrain/stand1.png"));
	public BufferedImage PROP_STAND2 = afterException(Interpreter.class.getResource("/com/resources/terrain/stand2.png"));
	public BufferedImage PROP_CHEST_CLOSED = afterException(Interpreter.class.getResource("/com/resources/terrain/woodChestClosed.png"));
	public BufferedImage PROP_CHEST_EMPTY = afterException(Interpreter.class.getResource("/com/resources/terrain/woodChestEmpty.png"));
	public BufferedImage PROP_CHEST_GOLD = afterException(Interpreter.class.getResource("/com/resources/terrain/woodChestGold.png"));
	
	public Terrain T_WALL1=new Terrain(WALL1,"Wall");
	public Terrain T_WALL2=new Terrain(WALL2,"Wall");
	public Terrain T_WALL3=new Terrain(WALL3,"Wall");
	public Terrain T_WALL4=new Terrain(WALL4,"Wall");
	public Terrain T_DOOR=new Terrain(DOOR,"Wall");
	public Terrain T_FLOOR_COBBLE=new Terrain(FLOOR_COBBLE,"Floor");
	public Terrain T_FLOOR_MOSS=new Terrain(FLOOR_MOSS,"Floor");
	public Terrain T_FLOOR_WATER=new Terrain(FLOOR_WATER,"Water");
	
	public Potion P_HEALTH = new Potion("Health Potion","/com/resources/items/health_potion.gif",false,new AbstractAction(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Hi");
		}
		
	});
	public static BufferedImage afterException(URL url){
		BufferedImage aux = null;
		try {
			aux = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}
}
