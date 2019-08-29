package ljubisa.model;

import java.util.Set;

public class Pregled {
	
	
	private Pacijent pacijent;
	private Set<SviSimptomi> sviSimptomi;
	private Set<SpecificniSimptomi> specificniSimptomi;
	private Set<PotencijalnaBolest> potencijalneBolesti;
	private double najboljaProcena;
	private double temperatura;
	private boolean povisenPritisak;
	
	public Pregled(Set<SviSimptomi> sviSimptomi, Set<SpecificniSimptomi> specificniSimptomi, Set<PotencijalnaBolest> potencijalneBolesti, Pacijent pacijent) {
		super();
		this.sviSimptomi = sviSimptomi;
		this.specificniSimptomi = specificniSimptomi;
		this.potencijalneBolesti = potencijalneBolesti;
		this.pacijent = pacijent;
		this.najboljaProcena = -10.0;
	}
	
	public Pregled(Pacijent pacijent, Set<SviSimptomi> sviSimptomi, Set<SpecificniSimptomi> specificniSimptomi, double temperatura, boolean povisenPritisak, Set<PotencijalnaBolest> potencijalneBolesti) {
		super();
		this.sviSimptomi = sviSimptomi;
		this.specificniSimptomi = specificniSimptomi;
		this.potencijalneBolesti = potencijalneBolesti;
		this.pacijent = pacijent;
		this.najboljaProcena = -10.0;
		this.povisenPritisak = povisenPritisak;
		this.temperatura = temperatura;
	}
	
	public Pacijent getPacijent() {
		return pacijent;
	}
	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}
	public Set<SviSimptomi> getSviSimptomi() {
		return sviSimptomi;
	}
	public void setSviSimptomi(Set<SviSimptomi> sviSimptomi) {
		this.sviSimptomi = sviSimptomi;
	}
	public Set<SpecificniSimptomi> getSpecificniSimptomi() {
		return specificniSimptomi;
	}
	public void setSpecificniSimptomi(Set<SpecificniSimptomi> specificniSimptomi) {
		this.specificniSimptomi = specificniSimptomi;
	}
	public Set<PotencijalnaBolest> getPotencijalneBolesti() {
		return potencijalneBolesti;
	}
	public void setPotencijalneBolesti(Set<PotencijalnaBolest> potencijalneBolesti) {
		this.potencijalneBolesti = potencijalneBolesti;
	}
	public double getNajboljaProcena() {
		return najboljaProcena;
	}
	public void setNajboljaProcena(double najboljaProcena) {
		this.najboljaProcena = najboljaProcena;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public boolean isPovisenPritisak() {
		return povisenPritisak;
	}
	public void setPovisenPritisak(boolean povisenPritisak) {
		this.povisenPritisak = povisenPritisak;
	}
	
}
