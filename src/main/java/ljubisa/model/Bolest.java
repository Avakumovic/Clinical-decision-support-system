package ljubisa.model;

import java.io.Serializable;
import java.util.HashSet;

public class Bolest implements Serializable {
	
	private String naziv;
	private HashSet<SviSimptomi> sviSimptomi;
	private HashSet<SpecificniSimptomi> specificniSimptomi;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public HashSet<SviSimptomi> getSviSimptomi() {
		return sviSimptomi;
	}
	public void setSviSimptomi(HashSet<SviSimptomi> sviSimptomi) {
		this.sviSimptomi = sviSimptomi;
	}
	public HashSet<SpecificniSimptomi> getSpecificniSimptomi() {
		return specificniSimptomi;
	}
	public void setSpecificniSimptomi(HashSet<SpecificniSimptomi> specificniSimptomi) {
		this.specificniSimptomi = specificniSimptomi;
	}
	
	public Bolest(String naziv, HashSet<SviSimptomi> sviSimptomi, HashSet<SpecificniSimptomi> specificniSimptomi) {
		super();
		this.naziv = naziv;
		this.sviSimptomi = sviSimptomi;
		this.specificniSimptomi = specificniSimptomi;
	}
	
	public boolean povisenaTemperatura() {
		if(sviSimptomi==null) {
			return false;
		}
		if(sviSimptomi.contains(SviSimptomi.TEMPERATURA_VECA_OD_38) || sviSimptomi.contains(SviSimptomi.TEMPERATURA_IZMEDJU_40_I_41)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return naziv;
	}
	
}




