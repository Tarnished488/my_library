package my_library;

public class library_card {
	private int periodOfValidity;
public library_card() {
	
}
public library_card(int periodOfValidity){
	this.periodOfValidity = periodOfValidity;
}
	public int getPeriodOfValidity() {
		return periodOfValidity;
	}

	public void setPeriodOfValidity(int periodOfValidity) {
		this.periodOfValidity = periodOfValidity;
	}
}
