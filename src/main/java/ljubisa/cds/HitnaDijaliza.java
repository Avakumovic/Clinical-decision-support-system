package ljubisa.cds;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("30m")
public class HitnaDijaliza implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 6693286675770479527L;

	public HitnaDijaliza() {
		// TODO Auto-generated constructor stub
		 super();
	}
}
