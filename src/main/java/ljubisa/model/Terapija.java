package ljubisa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import ljubisa.model.Bolest;
import ljubisa.model.Lek;

public class Terapija implements Serializable {
	
	private Bolest bolest;
	private double temperatura;
	private boolean visokPritisak;
	private Osoba lekar;
	private ArrayList<Lek> lekovi;
	private String preporuka;
	private LocalDate datum;
	
	public Bolest getBolest() {
		return bolest;
	}
	public void setBolest(Bolest bolest) {
		this.bolest = bolest;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public boolean isVisokPritisak() {
		return visokPritisak;
	}
	public void setVisokPritisak(boolean visokPritisak) {
		this.visokPritisak = visokPritisak;
	}
	public Osoba getLekar() {
		return lekar;
	}
	public void setLekar(Osoba lekar) {
		this.lekar = lekar;
	}
	public ArrayList<Lek> getLekovi() {
		return lekovi;
	}
	public void setLekovi(ArrayList<Lek> lekovi) {
		this.lekovi = lekovi;
	}
	public String getPreporuka() {
		return preporuka;
	}
	public void setPreporuka(String preporuka) {
		this.preporuka = preporuka;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	
	public Terapija(Bolest bolest, ArrayList<Lek> lekovi, String preporuka, LocalDate datum, double temperatura, boolean visokPritisak) {
		super();
		this.bolest = bolest;
		this.lekovi = lekovi;
		this.preporuka = preporuka;
		this.datum = datum;
		this.temperatura = temperatura;
		this.visokPritisak = visokPritisak;
	}
	
	public Terapija(Bolest bolest, ArrayList<Lek> lekovi, String preporuka, LocalDate datum) {
		super();
		this.bolest = bolest;
		this.lekovi = lekovi;
		this.preporuka = preporuka;
		this.datum = datum;
	}
	
	public boolean propisanaTerapijaDoSestMeseci() {
		if (datum == null) {
			return false;
		}
		if (datum.isAfter(LocalDate.now().minusDays(60))) {
			return true;
			
		} else {
			return false;
		}
	}
	
	public boolean barDesetPutaVisokPritisaDoSestMeseci() {
		if(datum == null) {
			return false;
		}
		if(datum.isAfter(LocalDate.now().minusMonths(6))) {
			return true;
		} else {
			return false;
		}
	}
	public boolean hipertenzijaViseOdSestMeseci() {
		if(datum == null) {
			return false;
		}
		if(datum.isAfter(LocalDate.now().minusMonths(6))) {
			return true;
		} else {
			return false;
		}
	}
	public boolean uZadnjih14Dana() {
		if(datum == null) {
			return false;
		}
		if(datum.isAfter(LocalDate.now().minusDays(14))) {
			return true;
		} else {
			return false;
		}
	}
	public boolean uZadnjih21Dana() {
		if(datum == null) {
			return false;
		}
		if(datum.isAfter(LocalDate.now().minusDays(21))) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean prepisanProbiotic() {
		if(lekovi==null) {
			return false;
		}
		for(Lek lek : lekovi) {
			if(lek.getTipoviLekova()==TipoviLekova.PROBIOTIC) {
				return true;
			}
		}
		return false;
	}
}
