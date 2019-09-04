package ljubisa.cds;

import java.io.Serializable;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("15m")
public class NivoKiseonikaRaste implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1412776087776861161L;

	public NivoKiseonikaRaste() {
		super();
	}
}
