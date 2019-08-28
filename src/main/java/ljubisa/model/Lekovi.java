package ljubisa.model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Lekovi implements Serializable {
	ArrayList<Lek> sviLekovi;

	public ArrayList<Lek> getSviLekovi() {
		return sviLekovi;
	}

	public void setSviLekovi(ArrayList<Lek> sviLekovi) {
		this.sviLekovi = sviLekovi;
	}
	
	public Lekovi() {
		super();
		sviLekovi = new ArrayList<>();
	}
	
	public static Lekovi ucitajLekove() {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("lekovi.dat"));
			Lekovi sviLekovi = (Lekovi) input.readObject();
			input.close();
			return sviLekovi;
		} catch (Exception ex) {
			
		}
		return null;
	}
}
