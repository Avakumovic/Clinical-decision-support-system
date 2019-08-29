package ljubisa.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class BolestSimptomList implements Serializable {
	
	private ArrayList<BolestSimptomCounter> bolestSimptomCounter;

	public ArrayList<BolestSimptomCounter> getBolestSimptomCounter() {
		return bolestSimptomCounter;
	}

	public void setBolestSimptomCounter(ArrayList<BolestSimptomCounter> bolestSimptomCounter) {
		this.bolestSimptomCounter = bolestSimptomCounter;
	}
	
	public BolestSimptomList(ArrayList<BolestSimptomCounter> bolestSimptomCounter) {
		super();
		this.bolestSimptomCounter = bolestSimptomCounter;
	}
	
	public BolestSimptomList() {
		super();
		bolestSimptomCounter = new ArrayList<>();
	}
}
