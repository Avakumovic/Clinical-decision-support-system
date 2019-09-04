package ljubisa.cds;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("12h")
public class UkupnaKolicinaMokrenja implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -263969267215418985L;

	public UkupnaKolicinaMokrenja() {
		// TODO Auto-generated constructor stub
		super();
	}
}
