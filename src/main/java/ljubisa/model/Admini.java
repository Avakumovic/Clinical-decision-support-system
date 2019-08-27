package ljubisa.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Admini implements Serializable {
	
	ArrayList<Admin> admini;

	public ArrayList<Admin> getAdmini() {
		return admini;
	}

	public void setAdmini(ArrayList<Admin> admini) {
		this.admini = admini;
	}
	
	public Admini() {
		super();
		admini = new ArrayList<>();
	}
	
	public Admin provera(String username, String sifra) {
		for(Admin allAdmins : admini) {
			if(allAdmins.getSifra().equals(sifra) && allAdmins.getUsername().equals(username)) {
				return allAdmins;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Admini: " + admini;
	}
}
