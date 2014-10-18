package com;

public class Troop {
	private int hpMax;
	private int hp;
	private boolean turn=true;
	private boolean moved=false;
	private int damage;
	public int damageFinal;
	private int defense;
	public int defenseFinal;
	private boolean aura=false;
	private boolean poison=false;
	private boolean regen=false;
	private int moveP;
	private String name;
	private String customName=null;
	private String team;
	private int cost;
	public Troop(int hpMax,int damage,int defense,int moveP,String name,String team,int cost){
		this.setHpMax(hpMax);
		this.setHp(hpMax);
		this.setDamage(damage);
		this.setDefense(defense);
		this.setMoveP(moveP);
		this.setName(name);
		this.setTeam(team);
		this.setCost(cost);
	}
	public Troop(int hpMax,int currentHp,int damage,int defense,int moveP,String name,String customName,String team,int cost){
		this.setHpMax(hpMax);
		this.setHp(currentHp);
		this.setDamage(damage);
		this.setDefense(defense);
		this.setMoveP(moveP);
		this.setName(name);
		this.setTeam(team);
		this.setCost(cost);
		this.setCustomName(customName);
	}
	public Troop getThis(){
		Troop output = new Troop( hpMax,hp,damage,defense,moveP,name,customName,team,cost);
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
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	public boolean isMoved() {
		return moved;
	}
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public boolean isAura() {
		return aura;
	}
	public void setAura(boolean aura) {
		this.aura = aura;
	}
	public boolean isPoison() {
		return poison;
	}
	public void setPoison(boolean poison) {
		this.poison = poison;
	}
	public boolean isRegen() {
		return regen;
	}
	public void setRegen(boolean regen) {
		this.regen = regen;
	}
	public int getMoveP() {
		return moveP;
	}
	public void setMoveP(int moveP) {
		this.moveP = moveP;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
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
	public char getTeamShort(){
		return getTeam().charAt(0);
	}
}
