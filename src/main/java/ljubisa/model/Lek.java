package ljubisa.model;

import java.io.Serializable;
import java.util.HashSet;

public class Lek implements Serializable {
	
	private String nazivLeka;
	private TipoviLekova tipoviLekova;
	private HashSet<SastavLeka> sastav;
	
	public String getNazivLeka() {
		return nazivLeka;
	}
	public void setNazivLeka(String nazivLeka) {
		this.nazivLeka = nazivLeka;
	}
	public TipoviLekova getTipoviLekova() {
		return tipoviLekova;
	}
	public void setTipoviLekova(TipoviLekova tipoviLekova) {
		this.tipoviLekova = tipoviLekova;
	}
	public HashSet<SastavLeka> getSastav() {
		return sastav;
	}
	public void setSastav(HashSet<SastavLeka> sastav) {
		this.sastav = sastav;
	}
	
	public Lek(TipoviLekova tipoviLekova, HashSet<SastavLeka> sastav, String nazivLeka) {
		super();
		this.nazivLeka = nazivLeka;
		this.sastav = sastav;
		this.tipoviLekova = tipoviLekova;
	}
	
	public boolean jeProbiotic() {
		if (tipoviLekova == null) {
			return false;
		}
		if (tipoviLekova == TipoviLekova.PROBIOTIC) {
			return true;
		} else {
			return false;
		}
	}
}
