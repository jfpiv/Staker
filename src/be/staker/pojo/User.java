package be.staker.pojo;

import be.staker.util.Util;

public class User {
	public static final int MAX_HEALTH = 99;
	public static final int MIN_HEALTH = 0;
	public static final int MAX_SPEC = 100;
	public static final int MIN_SPEC = 0;
	
	private int hp;
	private int spec;
	private int stake;
	private int money;
	private Shark shark;
	private boolean isDead = false;
	
	private Weapon whip;
	private Weapon dharok;
	private Weapon dds;
	private Weapon ags;
	
	public User(int hp, Shark shark, int spec, int money){
		this.setHp(hp);
		this.setShark(shark);
		this.setSpec(spec);
		this.setMoney(money);
		
		whip = new Weapon(0);
		dharok = new Weapon(0);
		dds = new Weapon(25);
		ags = new Weapon(50);
	}
	

	public int getHp() {
		if (hp > MAX_HEALTH) {
			hp = MAX_HEALTH;
		} else if(hp < MIN_HEALTH){
			hp = MIN_HEALTH;
		}
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getSpec() {
		if (spec > MAX_SPEC) {
			spec = MAX_SPEC;
		} else if(spec < MIN_SPEC){
			spec = MIN_SPEC;
		}
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Shark getShark() {
		return shark;
	}
	public void setShark(Shark shark) {
		this.shark = shark;
	}
	
	
	public Weapon getWhip() {
		return whip;
	}
	public Weapon getDharok() {
		return dharok;
	}
	public Weapon getDds() {
		return dds;
	}
	public Weapon getAgs() {
		return ags;
	}

	public void setSpecFive(){
		this.spec += 5;
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
			this.setHp(0);
			return "isDead";
		}
	}
	
	public boolean isDead(){
		
		if(this.hp <= User.MIN_HEALTH){
			isDead = true;
		}
		
		return isDead;
	}
	
	public boolean eatShark(){
		boolean success;
		
		if (this.shark.getAmount() > 0 && !this.isDead && this.getHp() < MAX_HEALTH) {
			this.shark.decreaseAmount(1);
			this.hp = this.hp + this.shark.getHealing();
			success = true;
		} else {
			success = false;
		}
		
		return success;
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

		this.whip.setHit(Util.randInt(0, 26));
		target.decreaseHp(this.whip.getHit());
		
		this.addSpec(this.whip);
		this.decreaseSpec(this.whip);
			
		//
	
	}
	
	private void doDharok(User target){
		
		if (target.getHp() <= 99 && target.getHp() > 80) {
			this.dharok.setHit(Util.randInt(0, 20));
		} else if (target.getHp() <= 80 && target.getHp() > 60) {
			this.dharok.setHit(Util.randInt(0, 25));
		} else if (target.getHp() <= 60 && target.getHp() > 45) {
			this.dharok.setHit(Util.randInt(0, 30));
		} else if (target.getHp() <= 45 && target.getHp() > 35) {
			this.dharok.setHit(Util.randInt(0, 35));
		} else if (target.getHp() <= 35 && target.getHp() > 10) {
			this.dharok.setHit(Util.randInt(0, 40));
		} else if (target.getHp() <= 10 && target.getHp() > 5) {
			this.dharok.setHit(Util.randInt(0, 45));
		} else if (target.getHp() <= 5 && target.getHp() > 3) {
			this.dharok.setHit(Util.randInt(0, 50));
		} else if (target.getHp() <= 3 && target.getHp() > 1) {
			this.dharok.setHit(Util.randInt(0, 55));
		} else if (target.getHp() <= 1) {
			this.dharok.setHit(Util.randInt(0, 60));
		}
		
		target.decreaseHp(this.dharok.getHit());
		
		this.addSpec(this.dharok);
		this.decreaseSpec(this.dharok);
			
		
		
	}
	
	private void doDDS(User target){
		
		this.dds.setHit(Util.randInt(0, 60));
		target.decreaseHp(this.dds.getHit());
		
		this.addSpec(this.dds);
		this.decreaseSpec(this.dds);
			
		
		
	}
	
	private void doAGS(User target){
		this.ags.setHit(Util.randInt(0, 60));
		target.decreaseHp(this.ags.getHit());
		
		this.addSpec(this.ags);
		this.decreaseSpec(this.ags);
			
		//target.doAttack(this);
	}
}
