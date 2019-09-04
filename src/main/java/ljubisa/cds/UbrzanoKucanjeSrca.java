package ljubisa.cds;

import java.io.Serializable;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("10m")
public class UbrzanoKucanjeSrca implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5145573357726858066L;

	public UbrzanoKucanjeSrca() {
		super();
	}
}
