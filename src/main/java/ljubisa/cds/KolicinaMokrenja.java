package ljubisa.cds;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("12h")
public class KolicinaMokrenja implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int kolicinaMililitri;
	
	public KolicinaMokrenja() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public KolicinaMokrenja(int kolicinaMililitri) {
		super();
		this.kolicinaMililitri = kolicinaMililitri;
	}
	
	public int getKolicinaMililitri() {
		return kolicinaMililitri;
	}
	
	public void setKolicinMililitri(int kolicinaMililitri) {
		this.kolicinaMililitri = kolicinaMililitri;
	}
}
