package be.staker.pojo;

public class Shark extends Button{
	public static final int MIN_AMOUNT = 0;
	
	private int amount = 5;
	private int healing = 40;
	
	public Shark(int amount, int healing, int addSpec){
		super(addSpec, 0);
		this.setAmount(amount);
		this.setHealing(healing);
	}

	public int getHealing() {
		return healing;
	}

	public void setHealing(int healing) {
		this.healing = healing;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public boolean decreaseAmount(int amount) {
		boolean success;
		
		if(this.amount > MIN_AMOUNT){
			success = true;
			this.amount = this.amount - amount;
		} else {
			success = false;
		}
		
		return success;
		
	}
}
