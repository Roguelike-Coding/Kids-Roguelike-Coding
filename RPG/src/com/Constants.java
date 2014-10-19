
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
	public RenderType FLOOR_WEB = new RenderType("/com/resources/terrain/cobblestone", "/com/resources/terrain/web", false, false, null, 0, false);
	public RenderType FLOOR_FIRECAMP = new RenderType("/com/resources/terrain/cobblestone", "/com/resources/terrain/fire", false, false, null, 0, false);
	public RenderType FLOOR_BARREL = new RenderType("/com/resources/terrain/cobblestone", "/com/resources/terrain/barrel", false, false, null, 0, false);
	public RenderType FLOOR_STAND1 = new RenderType("/com/resources/terrain/cobblestone", "/com/resources/terrain/stand1", false, false, null, 0, false);
	public RenderType FLOOR_STAND2 = new RenderType("/com/resources/terrain/cobblestone", "/com/resources/terrain/stand2", false, false, null, 0, false);
	public RenderType FLOOR_CHEST_CLOSED = new RenderType("/com/resources/terrain/cobblestone", "/com/resources/terrain/woodChestClosed", false, false, null, 0, false);
	public RenderType FLOOR_CHEST_EMPTY = new RenderType("/com/resources/terrain/cobblestone", "/com/resources/terrain/woodChestEmpty", false, false, null, 0, false);
	public RenderType FLOOR_CHEST_GOLD= new RenderType("/com/resources/terrain/cobblestone", "/com/resources/terrain/woodChestGold", false, false, null, 0, false);
	public RenderType FLOOR_MOSS = new RenderType("/com/resources/terrain/mossstone", false, null, 0, false);
	public RenderType FLOOR_WATER = new RenderType("/com/resources/terrain/waterTile", true, COBBLE, 1, true);
	public Player AUX = new Player(0, 0, 0, "Me", "/com/resources/entity/SoldierR.gif");
	
	public Terrain T_WALL1=new Terrain(WALL1.getThis(),"Wall");
	public Terrain T_WALL2=new Terrain(WALL2.getThis(),"Wall");
	public Terrain T_WALL3=new Terrain(WALL3.getThis(),"Wall");
	public Terrain T_WALL4=new Terrain(WALL4.getThis(),"Wall");
	public Terrain T_DOOR=new Terrain(DOOR.getThis(),"Wall");
	public Terrain T_FLOOR_WEB=new Terrain(FLOOR_WEB.getThis(),"Floor");
	public Terrain T_FLOOR_BARREL=new Terrain(FLOOR_BARREL.getThis(),"Floor");
	public Terrain T_FLOOR_STAND1=new Terrain(FLOOR_STAND1.getThis(),"Floor");
	public Terrain T_FLOOR_STAND2=new Terrain(FLOOR_STAND2.getThis(),"Floor");
	public Terrain T_FLOOR_FIRECAMP=new Terrain(FLOOR_FIRECAMP.getThis(),"Floor");
	public Terrain T_FLOOR_CHEST_CLOSED=new Terrain(FLOOR_CHEST_CLOSED.getThis(),"Floor");
	public Terrain T_FLOOR_CHEST_EMPTY=new Terrain(FLOOR_CHEST_EMPTY.getThis(),"Floor");
	public Terrain T_FLOOR_CHEST_GOLD=new Terrain(FLOOR_CHEST_GOLD.getThis(),"Floor");
	public Terrain T_FLOOR_COBBLE=new Terrain(FLOOR_COBBLE.getThis(),"Floor");
	public Terrain T_FLOOR_MOSS=new Terrain(FLOOR_MOSS.getThis(),"Floor");
	public Terrain T_FLOOR_WATER=new Terrain(FLOOR_WATER.getThis(),"Water");
	
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
