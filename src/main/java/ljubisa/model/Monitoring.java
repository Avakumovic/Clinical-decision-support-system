package ljubisa.model;

import java.util.ArrayList;

public class Monitoring {
	
	private ArrayList<String> print;

	public ArrayList<String> getPrint() {
		return print;
	}

	public void setPrint(ArrayList<String> print) {
		this.print = print;
	}
	
	public Monitoring() {
		super();
		print = new ArrayList<>();
	}
	
	public boolean dodaj(String string) {
		return print.add(string);
	}
}
