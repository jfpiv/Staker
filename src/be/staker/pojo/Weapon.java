package be.staker.pojo;

public class Weapon extends Button{

	private int hit;
	public final static int WHIP = 1;
	public final static int DHAROK = 2;
	public final static int DDS = 3;
	public final static int AGS = 4;

	public Weapon(int addSpec, int decreaseSpec){
		super(addSpec, decreaseSpec);
		this.setHit(hit);
	}
	
	public Weapon(int decreaseSpec){
		super(5, decreaseSpec);
		this.setHit(hit);
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
