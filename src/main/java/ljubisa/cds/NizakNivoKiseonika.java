package ljubisa.cds;

import java.io.Serializable;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("15m")
public class NizakNivoKiseonika implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5830083910951911479L;
	
	public NizakNivoKiseonika() {
		super();
	}
}
