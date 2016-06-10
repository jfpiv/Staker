package be.staker.pojo;

import be.staker.ui.*;
import be.staker.util.Util;

public class User {
	public static final int MAX_HEALTH = 100;
	public static final int MIN_HEALTH = 0;
	
	private int hp;
	private int spec;
	private int stake;
	private Shark shark;
	
	private Weapon whip;
	private Weapon dharok;
	private Weapon dds;
	private Weapon ags;
	
	public User(int hp, Shark shark, int spec, int stake){
		this.setHp(hp);
		this.setShark(shark);
		this.setSpec(spec);
		this.setStake(stake);
		
		whip = new Weapon(0, 0);
		dharok = new Weapon(0, 0);
		dds = new Weapon(0, 25);
		ags = new Weapon(0, 50);
	}
	
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getSpec() {
		return spec;
	}
	public void setSpec(int spec) {
		this.spec = spec;
	}
	public int getStake() {
		return stake;
	}
	public void setStake(int stake) {
		this.stake = stake;
	}
	public Shark getShark() {
		return shark;
	}
	public void setShark(Shark shark) {
		this.shark = shark;
	}
	
	public void addSpec(Weapon weapon) {
		this.spec = this.spec + weapon.getAddSpec();
	}
	public void decreaseSpec(Weapon weapon) {
		this.spec = this.spec - weapon.getDecreaseSpec();
	}
	public String decreaseHp(int damage){
		if(!this.isDead()){
			this.hp = this.hp - damage;
			return "Damage";
		} else {
			return "isDead";
		}
	}
	
	public boolean isDead(){
		boolean isDead = false;
				
		if(this.hp <= User.MIN_HEALTH){
			isDead = true;
		}
		
		return isDead;
	}
	
	public String eatShark(){
		
		boolean success = this.shark.decreaseAmount(1);
		
		if (success) {
			this.hp = this.hp + this.shark.getHealing();
			return "Shark eaten";
		} else {
			return "No sharks left";
		}
			
	}
	
	/*
	 * Attack target with a chosen weapon
	 */
	public void doAttack(int weapon, User target){
		switch (weapon) {
		case Weapon.WHIP:
			this.doWhip(target);
			break;
		case Weapon.DHAROK:
			this.doDharok(target);
			break;
		case Weapon.DDS:
			this.doDDS(target);
			break;
		case Weapon.AGS:
			this.doAGS(target);
			break;
		default:
			break;
		}
	}
	
	/*
	 * Attack target with a random weapon
	 */
	public void doAttack(User target){
		int random = Util.randInt(0, 4);
		
		switch (random) {
		case Weapon.WHIP:
			this.doWhip(target);
			break;
		case Weapon.DHAROK:
			this.doDharok(target);
			break;
		case Weapon.DDS:
			this.doDDS(target);
			break;
		case Weapon.AGS:
			this.doAGS(target);
			break;
		default:
			break;
		}
	}
	
	private void doWhip(User target){
		//Logica damage calculation
	}
	
	private void doDharok(User target){
		//Logica) damage calculation
	}
	
	private void doDDS(User target){
		//Logica damage calculation
	}
	
	private void doAGS(User target){
		//Logica damage calculation
	}
}
