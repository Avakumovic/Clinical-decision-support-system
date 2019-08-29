package ljubisa.model;

import org.kie.api.definition.type.Position;

public class BolestSimptomLink {
	@Position(1)
	private Bolest bolest;
	@Position(0)
	private SviSimptomi sviSimptomi;
	
	public Bolest getBolest() {
		return bolest;
	}
	public void setBolest(Bolest bolest) {
		this.bolest = bolest;
	}
	public SviSimptomi getSviSimptomi() {
		return sviSimptomi;
	}
	public void setSviSimptomi(SviSimptomi sviSimptomi) {
		this.sviSimptomi = sviSimptomi;
	}
	
	public BolestSimptomLink(SviSimptomi sviSimptomi, Bolest bolest) {
		super();
		this.sviSimptomi = sviSimptomi;
		this.bolest = bolest;
	}
	
	
	public boolean equals(Object object) {
		if(this==object) {
			return true;
		}
		if(object==null || getClass()!=object.getClass()) {
			return false;
		}
		BolestSimptomLink bsm = (BolestSimptomLink) object;
		if(sviSimptomi!=null ? !sviSimptomi.equals(bsm.sviSimptomi) : bsm.sviSimptomi!= null) {
			return false;	
		}
		if(bolest!=null ? !bolest.equals(bsm.bolest) :bsm.bolest!=null) {
			return false;
		}
		return true;
	}
	
	public int hashCode() {
		return super.hashCode();
	}
}
