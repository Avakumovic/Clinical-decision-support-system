package ljubisa.cds;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("15m")
public class NivoKiseonikaNeRaste implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7779809331387783595L;
	
	public NivoKiseonikaNeRaste() {
		super();
	}
	
}
