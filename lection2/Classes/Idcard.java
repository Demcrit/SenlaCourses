public class Idcard {
    int number;
    boolean active;

     Idcard(int number,boolean active){
		this.number = number;
		this.active = active;
	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return this.number + " Active"+ this.active; 
	
	
	

}
}