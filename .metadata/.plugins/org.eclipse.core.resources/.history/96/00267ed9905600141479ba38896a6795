package com;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Constants {
	public String R="Red";
	public String B="Blue";
	public String G="Green";
	public String Y="Yellow";
	
	public BufferedImage GRASS_BORDER_NORTH=afterException(Interpreter.class.getResource("/com/resources/terrain/grassBorderNorth.png"));
	public BufferedImage GRASS_BORDER_SOUTH=afterException(Interpreter.class.getResource("/com/resources/terrain/grassBorderSouth.png"));
	public BufferedImage GRASS_BORDER_WEST=afterException(Interpreter.class.getResource("/com/resources/terrain/grassBorderWest.png"));
	public BufferedImage GRASS_BORDER_EAST=afterException(Interpreter.class.getResource("/com/resources/terrain/grassBorderEast.png"));
	public BufferedImage SAND_BORDER_NORTH=afterException(Interpreter.class.getResource("/com/resources/terrain/sandBorderNorth.png"));
	public BufferedImage SAND_BORDER_SOUTH=afterException(Interpreter.class.getResource("/com/resources/terrain/sandBorderSouth.png"));
	public BufferedImage SAND_BORDER_WEST=afterException(Interpreter.class.getResource("/com/resources/terrain/sandBorderWest.png"));
	public BufferedImage SAND_BORDER_EAST=afterException(Interpreter.class.getResource("/com/resources/terrain/sandBorderEast.png"));
	
	public ConnectionType GRASS= new ConnectionType(new BufferedImage[]{null,GRASS_BORDER_SOUTH,GRASS_BORDER_WEST,GRASS_BORDER_NORTH,GRASS_BORDER_EAST},new String[]{"Plains","Forest","Mountains","House","Road","Castle"});
	public ConnectionType SAND= new ConnectionType(new BufferedImage[]{null,SAND_BORDER_SOUTH,SAND_BORDER_WEST,SAND_BORDER_NORTH,SAND_BORDER_EAST},new String[]{"Sand"});
	public ConnectionType ROAD= new ConnectionType(null,new String[]{"Road"});
	public ConnectionType GRASS_SAND= new ConnectionType(null,new ConnectionType[]{SAND,GRASS});
	
	public RenderType PLAINS=new RenderType("/com/resources/terrain/plainsTile",false,null,0,false);
	public RenderType BEACH=new RenderType("/com/resources/terrain/sandTile",true,GRASS,1,false);
	public RenderType WATER_PLAINS=new RenderType("/com/resources/terrain/waterTile",true,GRASS_SAND,1,true);
	public RenderType FOREST_PLAINS=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/forestBack",false,false,null,0,false);
	public RenderType MOUNTAINS_PLAINS=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/mountainsBack",false,false,null,0,false);
	public RenderType HOUSE_PLAINS=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/houseBack",false,false,null,0,false);
	public RenderType HOUSE_PLAINS_BLUE=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/houseBlueBack",false,false,null,0,false);
	public RenderType HOUSE_PLAINS_RED=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/houseRedBack",false,false,null,0,false);
	public RenderType HOUSE_PLAINS_GREEN=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/houseGreenBack",false,false,null,0,false);
	public RenderType HOUSE_PLAINS_YELLOW=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/houseYellowBack",false,false,null,0,false);
	public RenderType CASTLE_PLAINS=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/castleBack",false,false,null,0,false);
	public RenderType CASTLE_PLAINS_BLUE=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/castleBlueBack",false,false,null,0,false);
	public RenderType CASTLE_PLAINS_RED=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/castleRedBack",false,false,null,0,false);
	public RenderType CASTLE_PLAINS_GREEN=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/castleGreenBack",false,false,null,0,false);
	public RenderType CASTLE_PLAINS_YELLOW=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/castleYellowBack",false,false,null,0,false);
	public RenderType ROAD_PLAINS=new RenderType("/com/resources/terrain/plainsTile","/com/resources/terrain/roadGrassBack",true,true,ROAD,2,false);
	
	public Terrain T_PLAINS = new Terrain(10,10,PLAINS.getThis(),null/*For the moment*/,"Plains");
	public Terrain T_BEACH = new Terrain(10,15,BEACH.getThis(),null/*For the moment*/,"Sand");
	public Terrain T_WATER_PLAINS = new Terrain(0,30,WATER_PLAINS.getThis(),null/*For the moment*/,"Water");
	public Terrain T_FOREST_PLAINS = new Terrain(20,20,FOREST_PLAINS.getThis(),null,"Forest");
	public Terrain T_MOUNTAINS_PLAINS = new Terrain(30,30,MOUNTAINS_PLAINS.getThis(),null,"Mountains");
	public Terrain T_HOUSE_PLAINS= new Terrain(30,10,HOUSE_PLAINS.getThis(),null,"House");
	public Terrain T_HOUSE_PLAINS_BLUE= new Terrain(30,10,HOUSE_PLAINS_BLUE.getThis(),null,"House");
	public Terrain T_HOUSE_PLAINS_RED= new Terrain(30,10,HOUSE_PLAINS_RED.getThis(),null,"House");
	public Terrain T_HOUSE_PLAINS_GREEN= new Terrain(30,10,HOUSE_PLAINS_GREEN.getThis(),null,"House");
	public Terrain T_HOUSE_PLAINS_YELLOW= new Terrain(30,10,HOUSE_PLAINS_YELLOW.getThis(),null,"House");
	public Terrain T_CASTLE_PLAINS= new Terrain(30,10,CASTLE_PLAINS.getThis(),null,"Castle");
	public Terrain T_CASTLE_PLAINS_BLUE= new Terrain(30,10,CASTLE_PLAINS_BLUE.getThis(),null,"Castle");
	public Terrain T_CASTLE_PLAINS_RED= new Terrain(30,10,CASTLE_PLAINS_RED.getThis(),null,"Castle");
	public Terrain T_CASTLE_PLAINS_GREEN= new Terrain(30,10,CASTLE_PLAINS_GREEN.getThis(),null,"Castle");
	public Terrain T_CASTLE_PLAINS_YELLOW= new Terrain(30,10,CASTLE_PLAINS_YELLOW.getThis(),null,"Castle");
	public Terrain T_ROAD_PLAINS = new Terrain(10,10,ROAD_PLAINS.getThis(),null/*For the moment*/,"Road");
	
	public Troop ARCHER_B=new Troop(100, 110, 20, 40, "Archer", B, 300);
	public Troop ARCHER_R=new Troop(100, 110, 20, 40, "Archer", R, 300);
	public Troop ARCHER_G=new Troop(100, 110, 20, 40, "Archer", G, 300);
	public Troop ARCHER_Y=new Troop(100, 110, 20, 40, "Archer", Y, 300);
	public Troop COMMANDER_B=new Troop(100, 120, 40, 30, "Commander", B, -1);
	public Troop COMMANDER_R=new Troop(100, 120, 40, 30, "Commander", R, -1);
	public Troop COMMANDER_G=new Troop(100, 120, 40, 30, "Commander", G, -1);
	public Troop COMMANDER_Y=new Troop(100, 120, 40, 30, "Commander", Y, -1);
	public Troop IMP_B=new Troop(100, 100, 60, 60, "Imp", B, 1000);
	public Troop IMP_R=new Troop(100, 100, 60, 60, "Imp", R, 1000);
	public Troop IMP_G=new Troop(100, 100, 60, 60, "Imp", G, 1000);
	public Troop IMP_Y=new Troop(100, 100, 60, 60, "Imp", Y, 1000);
	public Troop MAGE_B=new Troop(100, 80, 30, 30, "Mage", B, 400);
	public Troop MAGE_R=new Troop(100, 80, 30, 30, "Mage", R, 400);
	public Troop MAGE_G=new Troop(100, 80, 30, 30, "Mage", G, 400);
	public Troop MAGE_Y=new Troop(100, 80, 30, 30, "Mage", Y, 400);
	public Troop MILITIA_B=new Troop(100, 50, 20, 30, "Militia", B, 100);
	public Troop MILITIA_R=new Troop(100, 50, 20, 30, "Militia", R, 100);
	public Troop MILITIA_G=new Troop(100, 50, 20, 30, "Militia", G, 100);
	public Troop MILITIA_Y=new Troop(100, 50, 20, 30, "Militia", Y, 100);
	public Troop SKELETON_B=new Troop(100, 60, 10, 30, "Skeleton", B, -1);
	public Troop SKELETON_R=new Troop(100, 60, 10, 30, "Skeleton", R, -1);
	public Troop SKELETON_G=new Troop(100, 60, 10, 30, "Skeleton", G, -1);
	public Troop SKELETON_Y=new Troop(100, 60, 10, 30, "Skeleton", Y, -1);
	public Troop SOLDIER_B=new Troop(100, 70, 30, 30, "Soldier", B, 150);
	public Troop SOLDIER_R=new Troop(100, 70, 30, 30, "Soldier", R, 150);
	public Troop SOLDIER_G=new Troop(100, 70, 30, 30, "Soldier", G, 150);
	public Troop SOLDIER_Y=new Troop(100, 70, 30, 30, "Soldier", Y, 150);
	public Troop SPIDER_B=new Troop(100, 70, 20, 50, "Spider", B, 700);
	public Troop SPIDER_R=new Troop(100, 70, 20, 50, "Spider", R, 700);
	public Troop SPIDER_G=new Troop(100, 70, 20, 50, "Spider", G, 700);
	public Troop SPIDER_Y=new Troop(100, 70, 20, 50, "Spider", Y, 700);
	public Troop TOMB=new Troop(-1,-1,-1,-1,"Tomb",null,-1);
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
