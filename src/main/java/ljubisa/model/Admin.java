package ljubisa.model;

import java.io.Serializable;

public class Admin extends Osoba implements Serializable {
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

	public Admin(String ime, String prezime, String username, String sifra) {
		// TODO Auto-generated constructor stub
		super(ime, prezime);
		this.username = username;
		this.sifra = sifra;
	}
	
	@Override
	public String toString() {
		return getIme() + " " + getPrezime();
	}	
}




