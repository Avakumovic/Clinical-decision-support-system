package ljubisa.cds;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("10m")
public class NedostatakKiseonika implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NedostatakKiseonika() {
		super();
	}
}
