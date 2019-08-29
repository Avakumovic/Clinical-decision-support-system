package ljubisa.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Bolesti implements Serializable {

	ArrayList<Bolest> bolesti;

	public ArrayList<Bolest> getBolesti() {
		return bolesti;
	}

	public void setBolesti(ArrayList<Bolest> bolesti) {
		this.bolesti = bolesti;
	}
	
	public Bolesti() {
		super();
		bolesti = new ArrayList<>();
	}
}
