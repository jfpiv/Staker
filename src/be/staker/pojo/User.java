package be.staker.pojo;

import be.staker.util.Util;

public class User {
	public static final int MAX_HEALTH = 99;
	public static final int MIN_HEALTH = 0;
	
	private int hp;
	private int spec;
	private int stake;
	private Shark shark;
	private boolean isDead = false;
	
	private Weapon whip;
	private Weapon dharok;
	private Weapon dds;
	private Weapon ags;
	
	public User(int hp, Shark shark, int spec, int stake){
		this.setHp(hp);
		this.setShark(shark);
		this.setSpec(spec);
		this.setStake(stake);
		
		whip = new Weapon(0);
		dharok = new Weapon(0);
		dds = new Weapon(25);
		ags = new Weapon(50);
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
		
		if (this.shark.getAmount() > 0 && !this.isDead) {
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
			
//		notenougspek.setText("");
//		if (HP_boss <= 0) {
//			return;
//		}
//		if (hp_user <= 0) {
//			hp_user = 0;
//			lblhpuser.setText("0");
//			return;
//		}
//		checkDead();
//		if (HP_boss > 0) {
//			int whip = randInt(0, 35);
//
//			if (spek_user < 100) {
//				spek_user = spek_user + 5;
//				spekuser.setValue(spek_user);
//				spekint.setText(Integer.toString(spek_user));
//			}
//			HP_boss = HP_boss - whip;
//
//			if (whip < 1) {
//				lbluserdamage.setText("0");
//			} else {
//				lbluserdamage.setForeground(Color.red);
//				lbluserdamage.setText("You hit: " + "-" + Integer.toString(whip));
//
//			}
//			progressBar.setValue(HP_boss - whip);
//			lblhpboss.setText(Integer.toString(HP_boss));
//			if (HP_boss == 0) {
//				lblhpboss.setText("0");
//			}
//			if (hp_user <= 0) {
//				hp_user = 0;
//				lblhpuser.setText("0");
//				return;
//			} else {
//				AIAttack();
//			}
//		} else {
//			return;
//		}
//		if (HP_boss <= 0) {
//			HP_boss = 0;
//			lblhpboss.setText("0");
//			progressBar.setValue(HP_boss);
//			return;
//		}
//		progressBar.setValue(HP_boss);
//		checkDead();
//		
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
