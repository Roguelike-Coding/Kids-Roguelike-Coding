package com;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Entity {
	private int baseHp;
	private int hpMax;
	private int hp;
	private int baseDamage;
	public int finalDamage;
	private int baseDefense;
	public int finalDefense;
	private String name;
	private String customName=null;
	private BufferedImage[] frames;
	public BufferedImage[] afterException(URL url){
		BufferedImage[] aux = new BufferedImage[1];
		try {
			aux[0] = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}
	public Entity(){
		
	}
	public Entity(int baseHp,int damage,int defense,String name,String imgPath){
		this.setBaseHp(baseHp);
		this.setHp(baseHp);
		this.setBaseDamage(damage);
		this.setBaseDefense(defense);
		this.setName(name);
		this.setFrames(afterException(Interpreter.class.getResource(imgPath)));
	}
	public Entity(int baseHp,int hpMax,int currentHp,int damage,int defense,String name,String customName,String imgPath){
		this.setBaseHp(baseHp);
		this.setHpMax(hpMax);
		this.setHp(currentHp);
		this.setBaseDamage(damage);
		this.setBaseDefense(defense);
		this.setName(name);
		this.setCustomName(customName);
		this.setFrames(afterException(Interpreter.class.getResource(imgPath)));
	}
	public Entity(int baseHp,int hpMax,int currentHp,int damage,int defense,String name,String customName,BufferedImage[] frames){
		this.setBaseHp(baseHp);
		this.setHpMax(hpMax);
		this.setHp(currentHp);
		this.setBaseDamage(damage);
		this.setBaseDefense(defense);
		this.setName(name);
		this.setCustomName(customName);
		this.setFrames(frames);
	}
	public Entity getThis(){
		Entity output = new Entity(baseHp,hpMax,hp,baseDamage,baseDefense,name,customName,frames);
		return output;
	}
	public int getHpMax() {
		return hpMax;
	}
	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(int damage) {
		this.baseDamage = damage;
	}
	public int getBaseDefense() {
		return baseDefense;
	}
	public void setBaseDefense(int defense) {
		this.baseDefense = defense;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomName() {
		if(customName!=null){
			return name;
		}
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public int getBaseHp() {
		return baseHp;
	}
	public void setBaseHp(int baseHp) {
		this.baseHp = baseHp;
	}
	public BufferedImage[] getFrames() {
		return frames;
	}
	public void setFrames(BufferedImage[] frames) {
		this.frames = frames;
	}
}
