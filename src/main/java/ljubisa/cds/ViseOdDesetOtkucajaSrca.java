package ljubisa.cds;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("30m")
public class ViseOdDesetOtkucajaSrca implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5449733865656355900L;

	public ViseOdDesetOtkucajaSrca() {
		super();
	}
}
