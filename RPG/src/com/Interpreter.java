package com;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;

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
	boolean W=false;
	boolean D=false;
	boolean A=false;
	boolean S=false;
	static IsoTile[][] tiles;
	static EntityLabel[][] troops;
	static Map map;
	private static boolean translated=false;
	public JLayeredPane pane;
	Constants constant = new Constants();
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
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(W){
				//troops[2][2]=EntityMoveToolkit.moveUp(map, troops[2][2], pane, tiles);
				troops[2][2].setLocation(troops[2][2].getX(), troops[2][2].getY()-1);
				
				for(int i=0;i<map.position.length;i++){
					for(int j=0;j<map.position[0].length;j++){
						if(troops[2][2].getX()>tiles[i][j].getTileLabel().getX()&&troops[2][2].getX()<tiles[i][j].getTileLabel().getX()+137&&troops[2][2].getY()+64>tiles[i][j].getTileLabel().getY()+69-35&&troops[2][2].getY()+64<tiles[i][j].getTileLabel().getY()+69){
							pane.setLayer(troops[2][2], 0, map.position[i][j]);
							System.out.println(map.position[i][j]);
						}
					}
				}
			}
			if(D){
				//troops[2][2]=EntityMoveToolkit.moveRight(map, troops[2][2], pane, tiles);
				troops[2][2].setLocation(troops[2][2].getX()+2, troops[2][2].getY());
				
				for(int i=0;i<map.position.length;i++){
					for(int j=0;j<map.position[0].length;j++){
						if(troops[2][2].getX()>tiles[i][j].getTileLabel().getX()&&troops[2][2].getX()<tiles[i][j].getTileLabel().getX()+137&&troops[2][2].getY()+64>tiles[i][j].getTileLabel().getY()+69-35&&troops[2][2].getY()+64<tiles[i][j].getTileLabel().getY()+69){
							pane.setLayer(troops[2][2], 0, map.position[i][j]);
							System.out.println(map.position[i][j]);
						}
					}
				}
			}
			if(S){
				//troops[2][2]=EntityMoveToolkit.moveDown(map, troops[2][2], pane, tiles);
				troops[2][2].setLocation(troops[2][2].getX(), troops[2][2].getY()+1);
				
				for(int i=0;i<map.position.length;i++){
					for(int j=0;j<map.position[0].length;j++){
						if(troops[2][2].getX()>tiles[i][j].getTileLabel().getX()&&troops[2][2].getX()<tiles[i][j].getTileLabel().getX()+137&&troops[2][2].getY()+64>tiles[i][j].getTileLabel().getY()+69-35&&troops[2][2].getY()+64<tiles[i][j].getTileLabel().getY()+69){
							pane.setLayer(troops[2][2], 0, map.position[i][j]);
							System.out.println(map.position[i][j]);
						}
					}
				}
			}
			if(A){
				//troops[2][2]=EntityMoveToolkit.moveLeft(map, troops[2][2], pane, tiles);
				troops[2][2].setLocation(troops[2][2].getX()-2, troops[2][2].getY());
				
				for(int i=0;i<map.position.length;i++){
					for(int j=0;j<map.position[0].length;j++){
						if(troops[2][2].getX()>tiles[i][j].getTileLabel().getX()&&troops[2][2].getX()<tiles[i][j].getTileLabel().getX()+137&&troops[2][2].getY()+64>tiles[i][j].getTileLabel().getY()+69-35&&troops[2][2].getY()+64<tiles[i][j].getTileLabel().getY()+69){
							pane.setLayer(troops[2][2], 0, map.position[i][j]);
							System.out.println(map.position[i][j]);
						}
					}
				}
			}
		}}
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
		translated=true;
		return output;
	}
	public void reCalculate(){
		for(int i=0;i<map.getTerrain().length;i++){
			for(int j=0;j<map.getTerrain()[0].length;j++){
				if(map.getTerrain()[i][j].getRenderType().isConnected()){
					RenderType auxiliar = map.getTerrain()[i][j].getRenderType().getThis();
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
	}
	public void reRender(){
		reCalculate();
		showMap();
	}
	public void showMapFirst(){
		tiles=translateMapTerrain();
		troops=translateMapTroops();
		int x=0;
		for(int i=0;i<tiles.length;i++){
			for(int j=0;j<tiles[0].length;j++){
				pane.add(tiles[i][j].getTileLabel(),-1,x);
				pane.add(troops[i][j],0,x);
				pane.add(tiles[i][j].getFrontLabel(),2,x);
				x++;
				pane.add(tiles[i][j].getBackLabel(),0,x);
				
				x++;
				troops[i][j].setLocation(400+36+j-126/2*i+126/2*j,400+45-63/2*j-63/2*i);
				tiles[i][j].setAllVisible(true);
				tiles[i][j].setAllBounds(400-126/2*i+126/2*j,400-63/2*j-63/2*i);	
				
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
		map.position=new int[map.terrain.length][map.terrain[0].length];
		for(int i=0;i<tiles.length;i++){
			for(int j=0;j<tiles[0].length;j++){
				pane.add(tiles[i][j].getTileLabel(),-1,x);
				pane.add(troops[i][j],0,x);
				pane.add(tiles[i][j].getFrontLabel(),2,x);
				map.position[i][j]=x;
				x++;
				
				pane.add(tiles[i][j].getBackLabel(),0,x);
				
				x++;
				troops[i][j].setLocation(400+36+j-124/2*i+124/2*j,400+45-62/2*j-62/2*i);
				tiles[i][j].setAllVisible(true);
				tiles[i][j].setAllBounds(400-124/2*i+124/2*j,400-62/2*j-62/2*i);	
			}
		}
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
		frame.setSize(1000,800);
		pane.setVisible(true);
		pane.setSize(100001,100000);
		pane.setLocation(0,0);
		pane.setOpaque(true);
		pane.setBackground(Color.black);
		map=new Map(new Terrain[][]{
				{constant.T_PLAINS.getThis(),constant.T_WATER_PLAINS.getThis(),constant.T_PLAINS.getThis(),constant.T_PLAINS.getThis(),constant.T_PLAINS.getThis(),constant.T_PLAINS.getThis()},
				{constant.T_FOREST_PLAINS.getThis(),constant.T_WATER_PLAINS.getThis(),constant.T_PLAINS.getThis(),constant.T_WATER_PLAINS.getThis(),constant.T_BEACH.getThis(),constant.T_PLAINS.getThis()},
				{constant.T_MOUNTAINS_PLAINS.getThis(),constant.T_WATER_PLAINS.getThis(),constant.T_PLAINS.getThis(),constant.T_WATER_PLAINS.getThis(),constant.T_BEACH.getThis(),constant.T_FOREST_PLAINS.getThis()},
				{constant.T_HOUSE_PLAINS_BLUE.getThis(),constant.T_WATER_PLAINS.getThis(),constant.T_PLAINS.getThis(),constant.T_MOUNTAINS_PLAINS.getThis(),constant.T_BEACH.getThis(),constant.T_PLAINS.getThis()},
				{constant.T_MOUNTAINS_PLAINS.getThis(),constant.T_WATER_PLAINS.getThis(),constant.T_PLAINS.getThis(),constant.T_PLAINS.getThis(),constant.T_BEACH.getThis(),constant.T_PLAINS.getThis()}
		},
		new Entity[][]{
				{null,null,null,null,null,null},
				{null,null,null,null,null,null},
				{null,null,constant.AUX,null,null,null},
				{null,null,null,null,null,null},
				{null,null,null,null,null,null}
		}
		);
		
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
		    	troops[2][2]=EntityMoveToolkit.moveUp(troops[2][2], pane);
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
		    	troops[2][2]=EntityMoveToolkit.moveRight(troops[2][2], pane);
		    	System.out.println("D");
		    }
		};

		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(testKeyStroke1, "D");
		frame.getRootPane().getActionMap().put("D",testAction1);*/
	}
	}
