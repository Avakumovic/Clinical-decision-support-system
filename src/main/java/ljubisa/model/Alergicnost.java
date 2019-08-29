package ljubisa.model;

public class Alergicnost {
	
	private boolean jeAlergican;

	public boolean isJeAlergican() {
		return jeAlergican;
	}

	public void setJeAlergican(boolean jeAlergican) {
		this.jeAlergican = jeAlergican;
	}
	
	public Alergicnost(boolean jeAlergican) {
		super();
		this.jeAlergican = jeAlergican;
	}
}
