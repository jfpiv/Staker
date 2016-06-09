package be.staker.pojo;

public class Button {
	private int addSpec;
	private int decreaseSpec;
	
	public Button(int addSpec, int decreaseSpec){
		this.setAddSpec(addSpec);
		this.setDecreaseSpec(decreaseSpec);
	}

	public int getAddSpec() {
		return addSpec;
	}

	public void setAddSpec(int addSpec) {
		this.addSpec = addSpec;
	}

	public int getDecreaseSpec() {
		return decreaseSpec;
	}

	public void setDecreaseSpec(int decreaseSpec) {
		this.decreaseSpec = decreaseSpec;
	}
	
}
