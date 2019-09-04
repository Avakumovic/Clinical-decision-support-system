package ljubisa.cds;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("15m")
public class RastKiseonika implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6248046050645240891L;

	public RastKiseonika() {
		super();
	}
}
