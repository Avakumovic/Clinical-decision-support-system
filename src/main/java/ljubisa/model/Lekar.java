package ljubisa.model;

import java.io.Serializable;

public class Lekar extends Osoba implements Serializable {
	
	private String username;
	private String sifra;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	
	
	public Lekar(String ime, String prezime, String username, String sifra) {
		super(ime, prezime);
		this.sifra = sifra;
		this.username = username;
	}
	
	@Override
	public String toString() {
		return getIme() + " " + getPrezime();
	}	
}
