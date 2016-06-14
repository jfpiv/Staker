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
	private int sharkAmount;
	private Shark shark;
	private boolean isDead = false;
	
	private Whip whip;
	private Dharok dharok;
	private Dds dds;
	private Ags ags;

	private String hitString;
	
	public User(int hp, int sharkAmount, int spec, int money){
		this.setHp(hp);
		this.setSpec(spec);
		this.setMoney(money);
		this.sharkAmount = sharkAmount;

		shark = new Shark();
		whip = new Whip();
		dharok = new Dharok();
		dds = new Dds();
		ags = new Ags();
	}
	
	public String getHitString() {
		return hitString;
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
		money = money - stake;
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

	public int getSharkAmount() {
		return sharkAmount;
	}

	public void setSharkAmount(int sharkAmount) {
		this.sharkAmount = sharkAmount;
	}

	public Whip getWhip() {
		return whip;
	}
	public Dharok getDharok() {
		return dharok;
	}
	public Dds getDds() {
		return dds;
	}
	public Ags getAgs() {
		return ags;
	}

	public void addSpecFive(){
		this.spec += 5;
	}

	public void decreaseSpec(int decreaseSpec) {
		this.spec -= decreaseSpec;
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
		
		if (this.sharkAmount > 0 && !this.isDead && this.getHp() < MAX_HEALTH) {
			this.sharkAmount--;
			this.hp = this.hp + this.shark.getHealing();
			this.addSpecFive();
			success = true;
		} else {
			success = false;
		}
		
		return success;
	}
	
	/*
	 * Attack target with a chosen weapon
	 */
	public void doAttack(Weapon weapon, User target){
		if(weapon instanceof Whip){
			doWhip(target);
		}
		else if( weapon instanceof Dharok){
			doDharok(target);
		}
		else if( weapon instanceof Dds){
			doDDS(target);
		}
		else if( weapon instanceof Ags){
			doAGS(target);
		}
	}
	
	/*
	 * Attack target with a random weapon
	 */
	public void doAttack(User target){
		int random = Util.randInt(0, 4);
		switch (random) {
		case 1:
			this.doWhip(target);
			break;
		case 2:
			this.doDharok(target);
			break;
		case 3:
			this.doDDS(target);
			break;
		case 4:
			this.doAGS(target);
			break;
		default:
			break;
		}
	}
	
	public void doWhip(User target){
		int damage = this.whip.getHit();
		target.decreaseHp(damage);
		
		this.addSpecFive();

		hitString = "Whip: -" + damage;
	}

	public void doDharok(User target){
		int damage = this.dharok.getHitDharok(hp);
		target.decreaseHp(damage);
		this.addSpecFive();

		hitString = "Dh: -" + damage;
	}

	public void doDDS(User target){
		int damage1 = this.dds.getHit();
		int damage2 = this.dds.getHit2();
		target.decreaseHp(damage1);
		target.decreaseHp(damage2);
		this.addSpecFive();
		this.decreaseSpec(this.dds.getDecreaseSpec());

		hitString = "DDS: -" + damage1 + " + -" + damage2;
		
	}

	public void doAGS(User target){
		int damage = this.ags.getHit();
		target.decreaseHp(damage);
		
		this.addSpecFive();
		this.decreaseSpec(this.ags.getDecreaseSpec());
			
		hitString = "AGS: -" + damage;
	}

	public void resetStats(){
		this.hp = 99;
		this.spec = 100;
		this.sharkAmount = 5;
		isDead = false;
	}

	public void addStakeMoney(){
		this.money = this.money + 2*this.stake;
	}

}
