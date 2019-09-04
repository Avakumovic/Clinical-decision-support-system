package ljubisa.cds;

import java.io.Serializable;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("30m")
public class HronicnaBubreznaBolest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5498017635300921239L;

	public HronicnaBubreznaBolest( ) {
		super();
	}
}
