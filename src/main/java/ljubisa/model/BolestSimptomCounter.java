package ljubisa.model;

import java.io.Serializable;

public class BolestSimptomCounter implements Serializable {

	private Bolest bolest;
	private int brojac = 0;
	
	public Bolest getBolest() {
		return bolest;
	}
	public void setBolest(Bolest bolest) {
		this.bolest = bolest;
	}
	public int getBrojac() {
		return brojac;
	}
	public void setBrojac(int brojac) {
		this.brojac = brojac;
	}
	
	public BolestSimptomCounter(Bolest bolest, int brojac) {
		super();
		this.bolest = bolest;
		this.brojac = brojac;
	}
}
