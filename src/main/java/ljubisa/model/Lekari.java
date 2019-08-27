package ljubisa.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Lekari implements Serializable {
	
	ArrayList<Lekar> lekari;

	public ArrayList<Lekar> getLekari() {
		return lekari;
	}

	public void setLekari(ArrayList<Lekar> lekari) {
		this.lekari = lekari;
	}
	
	public Lekari() {
		super();
		lekari = new ArrayList<>();
	}
	
	public Lekar provera(String username, String sifra) {
		for(Lekar sviLekari : lekari) {
			if(sviLekari.getSifra().equals(sifra) && sviLekari.getUsername().equals(username)) {
				return sviLekari;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Lekari: " + lekari;
	}
	
	public boolean dodajLekara(Lekar lekar) {
		return lekari.add(lekar);
	}
	
	public static void zapisiLekare(Lekari lekari) throws Exception {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("lekari.dat"));
			output.writeObject(lekari);
			output.close();
		} catch (Exception e) {
			
		}
	}
	
	public static Lekari ucitajLekare() throws Exception {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("lekari.dat"));
		Lekari lekari = (Lekari) input.readObject();
		input.close();
		return lekari;
	}
}




