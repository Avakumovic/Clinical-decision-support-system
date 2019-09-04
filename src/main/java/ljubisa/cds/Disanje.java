package ljubisa.cds;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;


@Role(Role.Type.EVENT)
@Expires("15m")
public class Disanje implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3102106018643435216L;
	private int kiseonik;
	
	public int getKiseonik() {
		return kiseonik;
	}

	public void setKiseonik(int kiseonik) {
		this.kiseonik = kiseonik;
	}

	public Disanje() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Disanje(int kiseonik) {
		super();
		this.kiseonik = kiseonik;
	}
	
}
