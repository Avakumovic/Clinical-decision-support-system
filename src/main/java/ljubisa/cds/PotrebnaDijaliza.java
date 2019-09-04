package ljubisa.cds;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("10m")
public class PotrebnaDijaliza implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1143340321689358338L;

	public PotrebnaDijaliza() {
		// TODO Auto-generated constructor stub
		super();
	}
}
