package ljubisa.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Pacijenti implements Serializable {
	
	ArrayList<Pacijent> pacijenti;

	public ArrayList<Pacijent> getPacijenti() {
		return pacijenti;
	}

	public void setPacijenti(ArrayList<Pacijent> pacijenti) {
		this.pacijenti = pacijenti;
	}
	
	public void dodajPacijenta(Pacijent pacijent) {
		pacijenti.add(pacijent);
	}
	
	public boolean ukloniPacijenta(Pacijent pac) {
		for (Pacijent pacijent : pacijenti) {
			if(pacijent.getId() == pac.getId()) {
				pacijenti.remove(pacijent);
				return true;
			}
		}
		return false;
	}
	
	public Pacijenti() {
		super();
		pacijenti = new ArrayList<>();
	}
	
	public static void zapisiPacijente(Pacijenti pacijenti) throws Exception {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("pacijenti.dat"));
			output.writeObject(pacijenti);
			output.close();
		} catch (Exception e) {
			
		}
	}
	
	public static Pacijenti ucitajPacijente() throws Exception {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("pacijenti.dat"));
		Pacijenti pacijenti = (Pacijenti) input.readObject();
		input.close();
		return pacijenti;
	}
}