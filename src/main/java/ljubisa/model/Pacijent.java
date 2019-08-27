package ljubisa.model;

import java.io.Serializable;

public class Pacijent extends Osoba implements Serializable {
	
	private int id;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Pacijent(String ime, String prezime) {
		super(ime, prezime);
		
	}
}
