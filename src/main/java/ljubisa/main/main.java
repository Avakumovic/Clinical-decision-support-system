package ljubisa.main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import ljubisa.model.Admini;
import ljubisa.model.Lekari;
import ljubisa.model.Lekovi;
import ljubisa.model.Osoba;
import ljubisa.model.Pacijenti;

public class main {
	public Osoba osoba;
	public Admini sviAdmini;
	public static Lekovi sviLekovi;
	public Pacijenti sviPacijenti;
	public Lekari sviLekari;
	
	public static Lekari getLekari() throws Exception {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("lekari.dat"));
		Lekari l = (Lekari) inputStream.readObject();
		inputStream.close();
		return l;
	}
	
	public static Admini getAdmini() throws Exception {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("administratori.dat"));
		Admini a = (Admini) inputStream.readObject();
		inputStream.close();
		return a;
	}
	
	
	public static void main(String[] args) throws Exception {
		
	}
}