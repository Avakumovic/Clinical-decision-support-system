package ljubisa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;


public class Pacijent extends Osoba implements Serializable {
	
	private int id;
	List<Terapija> terapije;
	private HashSet<Lek> alergicanNaLekove;
	private HashSet<String> alergijaNaSastav;
	
	
	public List<Terapija> getTerapije() {
		return terapije;
	}


	public void setTerapije(List<Terapija> terapije) {
		this.terapije = terapije;
	}


	public HashSet<Lek> getAlergicanNaLekove() {
		return alergicanNaLekove;
	}


	public void setAlergicanNaLekove(HashSet<Lek> alergicanNaLekove) {
		this.alergicanNaLekove = alergicanNaLekove;
	}


	public HashSet<String> getAlergijaNaSastav() {
		return alergijaNaSastav;
	}


	public void setAlergijaNaSastav(HashSet<String> alergijaNaSastav) {
		this.alergijaNaSastav = alergijaNaSastav;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public boolean dodajAlergijuNaLek(Lek l) {
		if(alergicanNaLekove.add(l)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean dodajAlergijuNaSastav(String str) {
		if(alergijaNaSastav.add(str)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void dodajTerapiju(Terapija terapija) {
		terapije.add(terapija);
	}

	public Pacijent(String ime, String prezime) {
		super(ime, prezime);
		this.terapije = new ArrayList<>();
		this.alergicanNaLekove = new HashSet<>();
		this.alergijaNaSastav = new HashSet<>();
		
	}
}
