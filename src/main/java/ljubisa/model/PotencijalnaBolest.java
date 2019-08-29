package ljubisa.model;

public class PotencijalnaBolest {
	
	private String nazivBolesti;
	private double sansa;
	
	public String getNazivBolesti() {
		return nazivBolesti;
	}
	public void setNazivBolesti(String nazivBolesti) {
		this.nazivBolesti = nazivBolesti;
	}
	public double getSansa() {
		return sansa;
	}
	public void setSansa(double sansa) {
		this.sansa = sansa;
	}
	
	public PotencijalnaBolest(String nazivBolesti, double sansa) {
		super();
		this.nazivBolesti = nazivBolesti;
		this.sansa = sansa;
	}
	
	@Override
	public String toString() {
		if(sansa==-1.0) {
			return "";
		}
		return "PotencijalnaBolest [nazivBolesti=" + nazivBolesti + ", sansa=" + String.format("%.2f", sansa*100 ) + "%]";
	}
}
