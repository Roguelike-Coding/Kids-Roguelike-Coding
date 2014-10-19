package com;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Interpreter implements Runnable{
	/**
	 * 
	 */
	JLabel itemLabels[][]=new JLabel[5][5];
	JLabel inventoryLabel=new JLabel();
	JLabel left=new JLabel();
	JLabel right=new JLabel();
	boolean W=false;
	boolean D=false;
	boolean A=false;
	boolean S=false;
	static IsoTile[][] tiles;
	static EntityLabel[][] troops;
	EntityLabel[][] items;
	static Map map;
	private static boolean translated=false;
	public JLayeredPane pane;
	Constants constant = new Constants();
	Player player=constant.AUX;
	EntityLabel playerLabel=new EntityLabel(player);
	public class gifLoop implements Runnable{

		@Override
		public void run() {
			while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=0;i<tiles.length;i++){
				for(int j=0;j<tiles[0].length;j++){
					if(tiles[i][j].getTileLabel().getImgs().length>1){
					if(tiles[i][j].getTileLabel().getFrame()<tiles[i][j].getTileLabel().getImgs().length-1){
						tiles[i][j].getTileLabel().setFrame(tiles[i][j].getTileLabel().getFrame()+1);
					}else{
						tiles[i][j].getTileLabel().setFrame(0);
					}
					tiles[i][j].getTileLabel().setImg(tiles[i][j].getTileLabel().getImgs()[tiles[i][j].getTileLabel().getFrame()]);
					}
			}
		}
		}}
	}
	public class gameLoop implements Runnable{

		@Override
		public void run() {
			while (true) {
			try {
				Thread.sleep(12);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int ax=tiles[tiles.length-2][0].getBackLabel().getX()+63;
			int ay=tiles[tiles.length-2][0].getBackLabel().getY()+32;
			int bx=tiles[tiles.length-2][tiles[0].length-2].getBackLabel().getX()+63;
			int by=tiles[tiles.length-2][tiles[0].length-2].getBackLabel().getY()+32;
			int cx=tiles[0][tiles[0].length-2].getBackLabel().getX()+63;
			int cy=tiles[0][tiles[0].length-2].getBackLabel().getY()+32;
			int dx=tiles[0][0].getBackLabel().getX()+63;
			int dy=tiles[0][0].getBackLabel().getY()+32;
			int tx=playerLabel.getX()+24;
			int ty=playerLabel.getY()-8;
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++){
					if(player.inventory.slots[i][j]!=null){
					itemLabels[i][j].setIcon(new ImageIcon(player.inventory.slots[i][j].getItem().getFrames()[0]));
					itemLabels[i][j].setVisible(true);}
					if(player.inventory.slots[i][j]==null){
					itemLabels[i][j].setIcon(null);
					itemLabels[i][j].setVisible(false);}
				}
			}
			if(W){
				if(!(Integer.signum( (bx-ax)*(ty-ay) - (by-ay)*(tx-ax) )==-1||Integer.signum( (cx-bx)*(ty-by) - (cy-by)*(tx-bx) )==-1))
				playerLabel.setLocation(playerLabel.getX(), playerLabel.getY()-1);
				for(int i=0;i<map.position.length;i++){
					for(int j=0;j<map.position[0].length;j++){
						if(playerLabel.getX()>tiles[i][j].getTileLabel().getX()&&playerLabel.getX()<tiles[i][j].getTileLabel().getX()+137&&playerLabel.getY()+64>tiles[i][j].getTileLabel().getY()+63-32&&playerLabel.getY()+64<tiles[i][j].getTileLabel().getY()+64){
							pane.setLayer(playerLabel, 0, map.position[i][j]);
						}
					}
				}
			}
			if(D){
				if(!(Integer.signum( (cx-bx)*(ty-by) - (cy-by)*(tx-bx) )==-1||Integer.signum( (dx-cx)*(ty-cy) - (dy-cy)*(tx-cx) )==-1))
				playerLabel.setLocation(playerLabel.getX()+2, playerLabel.getY());
				
				for(int i=0;i<map.position.length;i++){
					for(int j=0;j<map.position[0].length;j++){
						if(playerLabel.getX()>tiles[i][j].getTileLabel().getX()&&playerLabel.getX()<tiles[i][j].getTileLabel().getX()+137&&playerLabel.getY()+64>tiles[i][j].getTileLabel().getY()+63-32&&playerLabel.getY()+64<tiles[i][j].getTileLabel().getY()+64){
							pane.setLayer(playerLabel, 0, map.position[i][j]);
						}
					}
				}
			}
			if(S){
				if(!(Integer.signum( (dx-cx)*(ty-cy) - (dy-cy)*(tx-cx) )==-1||Integer.signum( (ax-dx)*(ty-dy) - (ay-dy)*(tx-dx) )==-1))
				playerLabel.setLocation(playerLabel.getX(), playerLabel.getY()+1);
				
				for(int i=0;i<map.position.length;i++){
					for(int j=0;j<map.position[0].length;j++){
						if(playerLabel.getX()>tiles[i][j].getTileLabel().getX()&&playerLabel.getX()<tiles[i][j].getTileLabel().getX()+137&&playerLabel.getY()+64>tiles[i][j].getTileLabel().getY()+63-32&&playerLabel.getY()+64<tiles[i][j].getTileLabel().getY()+64){
							pane.setLayer(playerLabel, 0, map.position[i][j]);

						}
					}
				}
			}
			if(A){
				//playerLabel=EntityMoveToolkit.moveLeft(map, playerLabel, pane, tiles);
				if(!(Integer.signum( (ax-dx)*(ty-dy) - (ay-dy)*(tx-dx) )==-1||Integer.signum( (bx-ax)*(ty-ay) - (by-ay)*(tx-ax) )==-1))
				playerLabel.setLocation(playerLabel.getX()-2, playerLabel.getY());
			
				for(int i=0;i<map.position.length;i++){
					for(int j=0;j<map.position[0].length;j++){
						if(playerLabel.getX()>tiles[i][j].getTileLabel().getX()&&playerLabel.getX()<tiles[i][j].getTileLabel().getX()+137&&playerLabel.getY()+64>tiles[i][j].getTileLabel().getY()+63-32&&playerLabel.getY()+64<tiles[i][j].getTileLabel().getY()+64){
							pane.setLayer(playerLabel, 0, map.position[i][j]);
						}
					}
				}
			}
		}}
	}
	public Map generateMap(){
		int x=randInt(5,9)+1;
		int y=randInt(5,9)+1;
		Map map = new Map(x, y);
		boolean door=false;
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				map.terrain[i][j]=constant.T_FLOOR_COBBLE.getThis();
				if(i==x-1||j==y-1){
					map.terrain[i][j]=constant.T_WALL1.getThis();
					if(randInt(4,8)>=8){
						door=true;
						map.terrain[i][j]=constant.T_DOOR.getThis();
					}
				}
			}
		}
		if(!door){
			map.terrain[x-1][4]=constant.T_DOOR.getThis();
		}
		for(int i=0;i<randInt(4,12);i++){
			int k=randInt(0,x-2);
			int l=randInt(0,y-2);
			map.terrain[k][l]=constant.T_FLOOR_MOSS.getThis();
		}
		int w= randInt(0,10);
		int k=randInt(0,x-2);
		int l=randInt(0,y-2);
		for(int i=0;i<w;i++){
			map.terrain[k][l]=constant.T_FLOOR_WATER.getThis();
			int a= randInt(1,4);
			if(a==1){
				k++;
				if(k>x-2)
				k=x-2;
			}
			if(a==2){
				k--;
				if(k<0)
				k=0;
			}
			if(a==3){
				l++;
				if(l>y-2)
				l=y-2;
			}
			if(a==4){
				l--;
				if(l<0)
				l=0;
			}
		}
		int t= randInt(0,8);
		if(t<=8){
			for 
			(int m=0;m<randInt(2,4);m++){
				int i= randInt(0,x-2);
				int j= randInt(0,y-2);
				int n= randInt(1,8);
				
				if(n==1)
					map.terrain[i][j]=constant.T_FLOOR_BARREL.getThis();
				if(n==2)
					map.terrain[i][j]=constant.T_FLOOR_CHEST_CLOSED.getThis();
				if(n==3)
					map.terrain[i][j]=constant.T_FLOOR_CHEST_EMPTY.getThis();
				if(n==4)
					map.terrain[i][j]=constant.T_FLOOR_CHEST_GOLD.getThis();
				if(n==5)
					map.terrain[i][j]=constant.T_FLOOR_FIRECAMP.getThis();
				if(n==6)
					map.terrain[i][j]=constant.T_FLOOR_STAND1.getThis();
				if(n==7)
					map.terrain[i][j]=constant.T_FLOOR_STAND2.getThis();
				if(n==8)
					map.terrain[i][j]=constant.T_FLOOR_WEB.getThis();
			}
		}
		
		
		return map;
		
	}
	public static int randInt(int min, int max) {
	    
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	public IsoTile[][] translateMapTerrain(){
		
		IsoTile[][] output = new IsoTile[map.getHeight()][map.getWidth()];
		for(int i=0;i<map.getHeight();i++){
			for(int j=0;j<map.getWidth();j++){
				if(translated){
				pane.remove(tiles[i][j].getBackLabel());
				pane.remove(tiles[i][j].getFrontLabel());
				pane.remove(tiles[i][j].getTileLabel());
				}
				output[i][j]=new IsoTile(map.terrain[i][j].renderType,new Point(400-124/2*i+124/2*j,400-62/2*j-62/2*i));
			}
		}
		return output;
	}
	public EntityLabel[][] translateMapTroops(){
		
		EntityLabel[][] output = new EntityLabel[map.getHeight()][map.getWidth()];
		for(int i=0;i<map.getHeight();i++){
			for(int j=0;j<map.getWidth();j++){
				output[i][j]=new EntityLabel(null);
				if(map.getTroops()[i][j]!=null){
					output[i][j]=new EntityLabel(map.getTroops()[i][j]);
				if(translated){
				pane.remove(troops[i][j]);
				}
				
				output[i][j].setVisible(true);
				output[i][j].setSize(64, 64);}
			}
		}
		return output;
	}
public EntityLabel[][] translateMapItems(){
		
		EntityLabel[][] output = new EntityLabel[map.getHeight()][map.getWidth()];
		for(int i=0;i<map.getHeight();i++){
			for(int j=0;j<map.getWidth();j++){
				output[i][j]=new EntityLabel(null);
				if(map.getItems()[i][j]!=null){
					output[i][j]=new EntityLabel(map.getItems()[i][j]);
				if(translated){
				pane.remove(items[i][j]);
				}
				
				output[i][j].setVisible(true);
				output[i][j].setSize(64, 64);}
			}
		}
		translated=true;
		return output;
	}
	public void reCalculate(){
		for(int i=0;i<map.getTerrain().length;i++){
			for(int j=0;j<map.getTerrain()[0].length;j++){
			
				if(map.getTerrain()[i][j].getRenderType().isConnected()){
					RenderType auxiliar = map.getTerrain()[i][j].renderTypeBase.getThis();
					if(map.getTerrain()[i][j].getRenderType().getLayer()==1){
						drawConected(i,j,map.getTerrain()[i][j].renderType.getThis().getConnections());
					}
					if(map.getTerrain()[i][j].getRenderType().getLayer()==2){
						auxiliar.setBackLayer(RenderType.convertTo45Degree(RenderType.afterException(Interpreter.class.getResource(map.getTerrain()[i][j].renderType.getBackPath()+drawBasicConected(i,j,map.getTerrain()[i][j].renderType.getConnections())+".png")),64)[0]);
						map.terrain[i][j].setRenderType(auxiliar);
					}
					if(map.getTerrain()[i][j].getRenderType().getLayer()==3){
	
					}
					
					//mapCode.terrain[i][j].setRenderType(new RenderType(RenderType.convertTo45Degree(RenderType.fromGIFtoImages(Interpretor.class.getResource("/com/resources/terrain/waterTile"+drawConected(i,j,"Water",null)+".gif")), 64),true,new Terrain[]{constant.T_WATER_PLAINS}));
				}
			}
		}
		tiles=translateMapTerrain();
		troops=translateMapTroops();
		items=translateMapItems();
	}
	public void reRender(){
		reCalculate();
		showMap();
	}
	public void showMapFirst(){
		tiles=translateMapTerrain();
		troops=translateMapTroops();
		items=translateMapItems();
		playerLabel.setBounds(500+36+3-127/2*3+127/2*3,500+45-63/2*3-63/2*3, 64, 64);
		int x=0;
		for(int i=0;i<tiles.length;i++){
			for(int j=0;j<tiles[0].length;j++){
				pane.add(tiles[i][j].getTileLabel(),-1,x);
				
				
				pane.add(tiles[i][j].getFrontLabel(),2,x);
				pane.add(troops[i][j],0,x);
				x++;
				pane.add(items[i][j],0,x);
				
				x++;
				
				pane.add(tiles[i][j].getBackLabel(),0,x);
				
				x++;
				items[i][j].setLocation(500+36+j-127/2*i+127/2*j,500+45-63/2*j-63/2*i);
				troops[i][j].setLocation(500+36+j-126/2*i+126/2*j,500+45-63/2*j-63/2*i);
				tiles[i][j].setAllVisible(true);
				tiles[i][j].setAllBounds(500-126/2*i+126/2*j,500-63/2*j-63/2*i);	
				
			}
		}
		reRender();
	
	}
	public static void main(String[] args) throws InterruptedException,
	InvocationTargetException {

			SwingUtilities.invokeAndWait(new Interpreter());

	}
	public void showMap(){
		int x=0;
		pane.add(playerLabel,0,x);
		
		playerLabel.setVisible(true);
		map.position=new int[map.terrain.length][map.terrain[0].length];
		for(int i=0;i<tiles.length;i++){
			for(int j=0;j<tiles[0].length;j++){
				pane.add(tiles[i][j].getTileLabel(),-1,x);
				
				
				pane.add(tiles[i][j].getFrontLabel(),2,x);
				
				pane.add(troops[i][j],0,x);
				map.position[i][j]=x-1;
				x++;
				pane.add(items[i][j],0,x);
				
				x++;
				
				pane.add(tiles[i][j].getBackLabel(),0,x);
				
				x++;
				items[i][j].setLocation(500+36+j-127/2*i+127/2*j,500+45-63/2*j-63/2*i);
				troops[i][j].setLocation(500+36+j-127/2*i+127/2*j,500+45-63/2*j-63/2*i);
				tiles[i][j].setAllVisible(true);
				tiles[i][j].setAllBounds(500-127/2*i+127/2*j,500-63/2*j-63/2*i);	
			}
		}
		left.setLocation(tiles[map.terrain.length-1][0].getTileLabel().getX()+64-100,tiles[map.terrain.length-1][0].getTileLabel().getY()-63);
		right.setLocation(tiles[0][map.terrain[0].length-1].getTileLabel().getX()+64,tiles[0][map.terrain[0].length-1].getTileLabel().getY()-63);
	}
	public String drawBasicConected(int i,int j,ConnectionType connectionType){
		String term="";
		if(connectionType.getType()==1){
		boolean n=false,e=false,s=false,v=false;
		for(int k=0;k<connectionType.getTerrainTypes().length;k++){
		if(!n){
			try {
				
			if (map.getTerrain()[i][j + 1].getName().equals(connectionType.getTerrainTypes()[k])) {
				term+="N";
				
				n=true;
			}
		} catch (Exception x) {
			term+="N";
			n=true;
		}}}
		for(int k=0;k<connectionType.getTerrainTypes().length;k++){
		// East
		if(!e){
		try {
			if (map.getTerrain()[i-1][j].getName().equals(connectionType.getTerrainTypes()[k])) {
				term+="E";
				e=true;
			}
		} catch (Exception x ) {
			term+="E";
			e=true;
		}}}
		// South
		for(int k=0;k<connectionType.getTerrainTypes().length;k++){
		if(!s){
		try {
			if (map.getTerrain()[i][j - 1].getName().equals(connectionType.getTerrainTypes()[k])) {
				term+="S";
				s=true;
			}
		} catch (Exception x) {
			term+="S";
			s=true;
		}}}
		// Vest
		for(int k=0;k<connectionType.getTerrainTypes().length;k++){
		if(!v){
		try {
			if (map.getTerrain()[i+1][j].getName().equals(connectionType.getTerrainTypes()[k])) {
				term+="V";
				v=true;
			}
		}
		 catch (Exception x) {
			 term+="V";
			v=true;
		}}
		} 
		}else{
			boolean n=false,e=false,s=false,v=false;
			for(int o=0;o<connectionType.getMultiple().length;o++){
				
				ConnectionType aux=connectionType.getMultiple()[o];
				for(int k=0;k<aux.getTerrainTypes().length;k++){
				if(!n){
					try {
						
					if (map.getTerrain()[i][j + 1].getName().equals(aux.getTerrainTypes()[k])) {
						term+="N";
						
						n=true;
					}
				} catch (Exception x) {
					term+="N";
					n=true;
				}}}}
			for(int o=0;o<connectionType.getMultiple().length;o++){

				ConnectionType aux=connectionType.getMultiple()[o];
				for(int k=0;k<aux.getTerrainTypes().length;k++){
				// East
				if(!e){
				try {
					if (map.getTerrain()[i-1][j].getName().equals(aux.getTerrainTypes()[k])) {
						term+="E";
						e=true;
					}
				} catch (Exception x ) {
					term+="E";
					e=true;
				}}}}
			for(int o=0;o<connectionType.getMultiple().length;o++){
				
				ConnectionType aux=connectionType.getMultiple()[o];
				// South
				for(int k=0;k<aux.getTerrainTypes().length;k++){
				if(!s){
				try {
					if (map.getTerrain()[i][j - 1].getName().equals(aux.getTerrainTypes()[k])) {
						term+="S";
						s=true;
					}
				} catch (Exception x) {
					term+="S";
					s=true;
				}}}}
			for(int o=0;o<connectionType.getMultiple().length;o++){
					
				ConnectionType aux=connectionType.getMultiple()[o];
				// Vest
				for(int k=0;k<aux.getTerrainTypes().length;k++){
				if(!v){
				try {
					if (map.getTerrain()[i+1][j].getName().equals(aux.getTerrainTypes()[k])) {
						term+="V";
						v=true;
					}
				}
				 catch (Exception x) {
					 term+="V";
					v=true;
				}}
				} 
			}
		}
		return term;
	}
	public void drawConected(int i,int j,ConnectionType connectionType){
		boolean n=false,e=false,s=false,v=false;
		RenderType aux=map.getTerrain()[i][j].renderType.getThis();
		if(connectionType.getType()==1){
		
		for(int k=0;k<connectionType.getTerrainTypes().length;k++){
		if(!n){
			try {
				
				if (map.getTerrain()[i][j + 1].getName().equals(connectionType.getTerrainTypes()[k])) {
					aux.mergeTwoImages(connectionType.getConectionType(), 1);
					n=true;
				}
		} catch (Exception x) {
			
			n=true;
		}}
		// East
		if(!e){
		try {
			if (map.getTerrain()[i-1][j].getName().equals(connectionType.getTerrainTypes()[k])) {
				aux.mergeTwoImages(connectionType.getConectionType(), 2);
				e=true;
			}
		} catch (Exception x ) {
			
			e=true;
		}}
		if(!s){
		try {
			if (map.getTerrain()[i][j - 1].getName().equals(connectionType.getTerrainTypes()[k])) {
				aux.mergeTwoImages(connectionType.getConectionType(), 3);
				s=true;
			}
		} catch (Exception x) {
			
			s=true;
		}}
		if(!v){
		try {
			if (map.getTerrain()[i+1][j].getName().equals(connectionType.getTerrainTypes()[k])) {
				
				aux.mergeTwoImages(connectionType.getConectionType(), 4);
				v=true;
			}
		}
		 catch (Exception x) {
			
			v=true;
		}}
		} 
		}else{
			for(int o=0;o<connectionType.getMultiple().length;o++){
				
				ConnectionType aux2=connectionType.getMultiple()[o];
				for(int k=0;k<aux2.getTerrainTypes().length;k++){
				if(!n){
					try {
						if (map.getTerrain()[i][j + 1].getName().equals(aux2.getTerrainTypes()[k])) {
							aux.mergeTwoImages(aux2.getConectionType(), 1);
							n=true;
						}
				} catch (Exception x) {
					n=true;
				}}
				// East
				if(!e){
				try {
					if (map.getTerrain()[i-1][j].getName().equals(aux2.getTerrainTypes()[k])) {
						aux.mergeTwoImages(aux2.getConectionType(), 2);
						e=true;
					}
				} catch (Exception x ) {
					
					e=true;
				}}
				if(!s){
					try {
						if (map.getTerrain()[i][j - 1].getName().equals(aux2.getTerrainTypes()[k])) {
							aux.mergeTwoImages(aux2.getConectionType(), 3);
							s=true;
							
						}
					} catch (Exception x) {
						
						s=true;
					}}
				if(!v){
					try {
						if (map.getTerrain()[i+1][j].getName().equals(aux2.getTerrainTypes()[k])) {
							aux.mergeTwoImages(aux2.getConectionType(), 4);
							v=true;
							
						}
					} catch (Exception x) {
						
						v=true;
					}}
				} 
			}
		}
		map.getTerrain()[i][j].renderType=aux;
	}
	public void run() {
		JFrame frame=new JFrame();
		pane=new JLayeredPane();
		frame.add(pane);
		
		frame.setTitle("dsdasfsdf");
		frame.setVisible(true);
		frame.setSize(1300,1200);
		pane.setVisible(true);
		pane.setSize(100001,100000);
		pane.setLocation(0,0);
		pane.setOpaque(true);
		pane.setBackground(Color.black);
		
		pane.add(inventoryLabel,4,0);
		inventoryLabel.setVisible(false);
		inventoryLabel.setSize(400,500);
		inventoryLabel.setIcon(new ImageIcon(Interpreter.class.getResource("/com/resources/gui/inv hud.png")));
		inventoryLabel.setLocation(0,0);

		
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				itemLabels[i][j]=new JLabel();
				inventoryLabel.add(itemLabels[i][j]);
				itemLabels[i][j].setBounds(17+i*64+12*i,125+64*j+11*j, 64, 64);
				itemLabels[i][j].setVisible(true);
			}
		}
		player.inventory.slots[0][0]=new InventorySlot(constant.P_HEALTH);
		/*
		map=new Map(new Terrain[][]{
				{constant.T_FLOOR_COBBLE.getThis(),constant.T_FLOOR_COBBLE.getThis(),constant.T_FLOOR_COBBLE.getThis(),constant.T_FLOOR_MOSS.getThis(),constant.T_FLOOR_COBBLE.getThis(),constant.T_WALL4.getThis()},
				{constant.T_FLOOR_COBBLE.getThis(),constant.T_FLOOR_MOSS.getThis(),constant.T_FLOOR_WATER.getThis(),constant.T_FLOOR_WATER.getThis(),constant.T_FLOOR_COBBLE.getThis(),constant.T_DOOR.getThis()},
				{constant.T_FLOOR_COBBLE.getThis(),constant.T_FLOOR_WATER.getThis(),constant.T_FLOOR_WATER.getThis(),constant.T_FLOOR_WATER.getThis(),constant.T_FLOOR_COBBLE.getThis(),constant.T_WALL2.getThis()},
				{constant.T_FLOOR_COBBLE.getThis(),constant.T_FLOOR_WATER.getThis(),constant.T_FLOOR_COBBLE.getThis(),constant.T_FLOOR_COBBLE.getThis(),constant.T_FLOOR_COBBLE.getThis(),constant.T_WALL1.getThis()},
				{constant.T_WALL1.getThis(),constant.T_WALL3.getThis(),constant.T_DOOR.getThis(),constant.T_WALL2.getThis(),constant.T_WALL1.getThis(),constant.T_WALL1.getThis()}
		},
		new Entity[][]{
				{null,null,null,null,null,null},
				{null,null,null,null,null,null},
				{null,null,null,null,null,null},
				{null,null,null,null,null,null},
				{null,null,null,null,null,null}
		},
		new ItemEntity[][]{
				{null,null,null,null,null,null},
				{null,null,null,null,null,null},
				{null,null,null,null,null,null},
				{null,null,null,constant.P_HEALTH,null,null},
				{null,null,null,null,null,null}
		}
		);
*/
		map=generateMap();
		pane.add(left,2,0);
		pane.add(right,2,0);
		left.setSize(100, 200);
		right.setSize(100, 200);
		left.setBackground(Color.BLACK);
		right.setBackground(Color.BLACK);
		left.setOpaque(true);
		right.setOpaque(true);
		left.setVisible(true);
		right.setVisible(true);
		showMapFirst();
		Thread gifThread ;
		gifLoop glp = this.new gifLoop();
		gifThread = new Thread(glp);
		gifThread.start();
		Thread gifThread1 ;
		gameLoop glp1 = this.new gameLoop();
		gifThread1 = new Thread(glp1);
		gifThread1.start();
		frame.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_W){
					W=true;
				}
				if(arg0.getKeyCode()==KeyEvent.VK_D){
					D=true;
				}
				if(arg0.getKeyCode()==KeyEvent.VK_S){
					S=true;
				}
				if(arg0.getKeyCode()==KeyEvent.VK_A){
					A=true;
				}
				if(arg0.getKeyCode()==KeyEvent.VK_I){
					
					inventoryLabel.setVisible(!inventoryLabel.isVisible());
				}
				if(arg0.getKeyCode()==KeyEvent.VK_R){
					for(int x1=0;x1<map.getHeight();x1++){
						for(int y1=0;y1<map.getWidth();y1++){
							pane.remove(tiles[x1][y1].getBackLabel());
							pane.remove(tiles[x1][y1].getFrontLabel());
							pane.remove(tiles[x1][y1].getTileLabel());
							pane.remove(troops[x1][y1]);
							pane.remove(items[x1][y1]);
							
				}
					}
					map=generateMap();
					translated=false;
					showMapFirst();
				}
				if(arg0.getKeyCode()==KeyEvent.VK_E){
					int x=playerLabel.getX()+32;
					int y=playerLabel.getY()+32;
					boolean found=false;
					for(int i=0;i<items.length;i++){
						for(int j=0;j<items[0].length;j++){
							if(items[i][j].getX()+32>=x-64&&items[i][j].getX()+32<=x+64&&items[i][j].getY()+32>=y-64&&items[i][j].getY()+32>=y-64&&!found&&items[i][j].getEntity()!=null){
								found=true;
								ItemEntity aux=(ItemEntity) items[i][j].getEntity();
								items[i][j].setEntity(null);
								pane.remove(items[i][j]);
								map.items[i][j]=null;
								aux.pickItem(aux, player.inventory);
								reRender();
							}
						}
					}
					for(int i=0;i<items.length;i++){
						for(int j=0;j<items[0].length;j++){
							if(tiles[i][j].getTileLabel().getX()+264>=x-64&&tiles[i][j].getTileLabel().getX()+264<=x+64&&tiles[i][j].getTileLabel().getY()+232>=y-64&&tiles[i][j].getTileLabel().getY()+232>=y-64&&map.terrain[i][j].getName().equals("Door")){
								System.out.println("a");
								}
						}
					}
				}
				if(arg0.getKeyCode()==KeyEvent.VK_Q){
					ItemEntity item = player.inventory.slots[0][0].getItem();
					Point point=player.inventory.slots[0][0].getItem().dropItem(player.inventory.slots[0][0].getItem(), player, items, playerLabel);
					System.out.println(point);
					map.items[point.x][point.y]=item;
					reRender();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_W){
					W=false;
				}
				if(arg0.getKeyCode()==KeyEvent.VK_D){
					D=false;
				}
				if(arg0.getKeyCode()==KeyEvent.VK_S){
					S=false;
				}
				if(arg0.getKeyCode()==KeyEvent.VK_A){
					A=false;
				}
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		/*
		KeyStroke testKeyStroke = KeyStroke.getKeyStroke("W");
		Action testAction = new AbstractAction()
		{
		    
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
		    	playerLabel=EntityMoveToolkit.moveUp(playerLabel, pane);
		    	System.out.println("W");
		    }
		};

		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(testKeyStroke, "W");
		frame.getRootPane().getActionMap().put("W",testAction);
		KeyStroke testKeyStroke1 = KeyStroke.getKeyStroke("D");
		Action testAction1 = new AbstractAction()
		{
		   
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
		    	playerLabel=EntityMoveToolkit.moveRight(playerLabel, pane);
		    	System.out.println("D");
		    }
		};

		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(testKeyStroke1, "D");
		frame.getRootPane().getActionMap().put("D",testAction1);*/
	}
	}
