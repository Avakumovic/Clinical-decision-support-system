package ljubisa.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

import ljubisa.model.Admin;
import ljubisa.model.Admini;
import ljubisa.model.Bolest;
import ljubisa.model.Bolesti;
import ljubisa.model.Lek;
import ljubisa.model.Lekar;
import ljubisa.model.Lekari;
import ljubisa.model.Lekovi;
import ljubisa.model.Pacijent;
import ljubisa.model.Pacijenti;
import ljubisa.model.SastavLeka;
import ljubisa.model.SpecificniSimptomi;
import ljubisa.model.SviSimptomi;
import ljubisa.model.TipoviLekova;

public class DataBase {

	public static void main(String[] args) {

		HashSet<SviSimptomi> s = new HashSet<>();
		s.add(SviSimptomi.CURENJE_IZ_NOSA);
		s.add(SviSimptomi.BOL_U_GRLU);
		s.add(SviSimptomi.GLAVOBOLJA);
		s.add(SviSimptomi.KIJANJE);
		s.add(SviSimptomi.KASALJ);
		Bolest prehlada = new Bolest("prehlada", s, null);

		HashSet<SviSimptomi> s2 = new HashSet<>();
		s2.add(SviSimptomi.KIJANJE);
		s2.add(SviSimptomi.BOL_U_GRLU);
		s2.add(SviSimptomi.KASALJ);
		s2.add(SviSimptomi.TEMPERATURA_VECA_OD_38);
		s2.add(SviSimptomi.CURENJE_IZ_NOSA);
		s2.add(SviSimptomi.GLAVOBOLJA);
		s2.add(SviSimptomi.DRHTAVICA);
		Bolest groznica = new Bolest("groznica", s2, null);

		HashSet<SviSimptomi> s3 = new HashSet<>();
		s3.add(SviSimptomi.BOL_U_GRLU);
		s3.add(SviSimptomi.BOL_KOJI_SE_SIRI_OD_USIJU);
		s3.add(SviSimptomi.GLAVOBOLJA);
		s3.add(SviSimptomi.TEMPERATURA_IZMEDJU_40_I_41);
		s3.add(SviSimptomi.DRHTAVICA);
		s3.add(SviSimptomi.GUBITAK_APETITA);
		s3.add(SviSimptomi.UMOR);
		s3.add(SviSimptomi.ZUTI_SEKRET_IZ_NOSA);
		Bolest upalaKrajnika = new Bolest("upalaKrajnika", s3, null);

		HashSet<SviSimptomi> s4 = new HashSet<>();
		s4.add(SviSimptomi.OTICANJE_OKO_OCIJU);
		s4.add(SviSimptomi.GLAVOBOLJA);
		s4.add(SviSimptomi.ZUTI_SEKRET_IZ_NOSA);
		s4.add(SviSimptomi.BOL_U_GRLU);
		s4.add(SviSimptomi.TEMPERATURA_VECA_OD_38);
		s4.add(SviSimptomi.KASALJ);
		s4.add(SviSimptomi.BOLOVANJE_OD_PREHLADE_ILI_GROZNICE_U_PROTEKLIH_60_DANA);
		Bolest sinusnaInfekcija = new Bolest("sinusnaInfekcija", s4, null);
		
		HashSet<SviSimptomi> sDijabetes = new HashSet<>();
		sDijabetes.add(SviSimptomi.CESTO_URINIRANJE);
		sDijabetes.add(SviSimptomi.GUBITAK_TESENE_TEZINE);
		sDijabetes.add(SviSimptomi.UMOR);
		sDijabetes.add(SviSimptomi.MUCNINA_I_POVRACANJE);
	  	Bolest dijabetes = new Bolest("dijabetes", sDijabetes, null);
		
	  	HashSet<SviSimptomi> sHipertenzija = new HashSet<>();
	  	sHipertenzija.add(SviSimptomi.U_POSLEDNJIH_6_MESECI_ZABELEZEN_BAR_10_SLUCAJEVA_U_KOJEM_PACIJENT_IMA_VISOK_PRITISAK);
	  	Bolest hipertenzija = new Bolest("hipertenzija", sHipertenzija, null);
		
	  	HashSet<SviSimptomi> s5RegularniSviSimptomi = new HashSet<>();
		s5RegularniSviSimptomi.add(SviSimptomi.UMOR);
		s5RegularniSviSimptomi.add(SviSimptomi.NOCTURIA);
		s5RegularniSviSimptomi.add(SviSimptomi.OTOCI_NOGU_I_ZGLOBOVA);
		s5RegularniSviSimptomi.add(SviSimptomi.GUSENJE);
		s5RegularniSviSimptomi.add(SviSimptomi.BOL_U_GRUDIMA);
		
		HashSet<SpecificniSimptomi> s5Specificni = new HashSet<>();
		s5Specificni.add(SpecificniSimptomi.BOLUJE_OD_DIJABETESA);
		s5Specificni.add(SpecificniSimptomi.BOLUJE_OD_HIPERTENZIJE_DUZE_OD_6_MESECI);
		Bolest hronicnaBubreznaBolest = new Bolest("hronicnaBubreznaBolest", s5RegularniSviSimptomi, s5Specificni);
		
		HashSet<SviSimptomi> s6RegularniSviSimptomi = new HashSet<>();
		s6RegularniSviSimptomi.add(SviSimptomi.UMOR);
		s6RegularniSviSimptomi.add(SviSimptomi.GUSENJE);
		s6RegularniSviSimptomi.add(SviSimptomi.OTOCI_NOGU_I_ZGLOBOVA);
		s6RegularniSviSimptomi.add(SviSimptomi.DIJAREJA);
		
		HashSet<SpecificniSimptomi> s6Specifnici = new HashSet<>();
		s6Specifnici.add(SpecificniSimptomi.OPORAVLJA_SE_OD_OPERACIJE);
		s6Specifnici.add(SpecificniSimptomi.POVISENA_TEMPERATURA_U_POSLEDNJIH_14_DANA);
		s6Specifnici.add(SpecificniSimptomi.PREPISANI_ANTIBIOTICI_U_POSLEDNIH_21_DAN);
		Bolest akutnaBubreznaBolest = new Bolest("akutnaBubreznaBolest", s6RegularniSviSimptomi, s6Specifnici);
		
		Bolesti bolesti = new Bolesti();
		bolesti.getBolesti().add(prehlada);
		bolesti.getBolesti().add(groznica);
		bolesti.getBolesti().add(upalaKrajnika);
		bolesti.getBolesti().add(sinusnaInfekcija);
		bolesti.getBolesti().add(dijabetes);
		bolesti.getBolesti().add(hipertenzija);
		bolesti.getBolesti().add(hronicnaBubreznaBolest);
		bolesti.getBolesti().add(akutnaBubreznaBolest);
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bolesti.dat"));
			out.writeObject(bolesti);
			out.close();
			System.out.println("snimljene bolesti");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("bolesti.dat"));
			Bolesti b = (Bolesti)in.readObject();
			in.close();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Pacijent Pacijent1 = new Pacijent("Pero", "Peric");
		Pacijent1.dodajAlergijuNaSastav(SastavLeka.MAGNEZIJUM.toString());
		Pacijent Pacijent2 = new Pacijent("Niko", "Nikic");
		
		Pacijenti pac = new Pacijenti();
		pac.addWithIncrement(Pacijent1);
		pac.addWithIncrement(Pacijent2);
		
		Lekar lekar1 = new Lekar("Dejan", "Petkovic", "doc1", "doc1");
		Lekar lekar2 = new Lekar("Svetozar", "Tomic", "doc2", "doc2");

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pacijenti.dat"));
			out.writeObject(pac);
			out.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("pacijenti.dat"));
			Pacijenti p = (Pacijenti)in.readObject();
			in.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		HashSet<SastavLeka> lek1sastav = new HashSet<>();
		lek1sastav.add(SastavLeka.LAKTOZA);
		lek1sastav.add(SastavLeka.SAHARAOZA);
		lek1sastav.add(SastavLeka.MAGNEZIJUM);
		
		Lek lek1 = new Lek(TipoviLekova.ANTIDEPRESIV, lek1sastav, "Lek1");
		
		HashSet<SastavLeka> lek2sastav = new HashSet<>();
		lek2sastav.add(SastavLeka.SKROB);
		lek2sastav.add(SastavLeka.VESTACKA_BOJA_310);
		
		Lek lek2 = new Lek(TipoviLekova.PROBIOTIC, lek2sastav, "Lek2");
		
		HashSet<SastavLeka> lek3sastav = new HashSet<>();
		lek3sastav.add(SastavLeka.VESTACKA_BOJA_310);
		lek3sastav.add(SastavLeka.SAHARAOZA);
		
		Lek lek3 = new Lek(TipoviLekova.ANTIHISTAMIN, lek3sastav, "Lek3");
		
		Lekovi lekovi = new Lekovi();
		lekovi.getSviLekovi().add(lek1);
		lekovi.getSviLekovi().add(lek2);
		lekovi.getSviLekovi().add(lek3);
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("lekovi.dat"));
			out.writeObject(lekovi);
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("lekovi.dat"));
			Lekovi lek = (Lekovi)in.readObject();
			in.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Lekari sviLekari = new Lekari();
		sviLekari.getLekari().add(lekar1);
		sviLekari.getLekari().add(lekar2);
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("lekari.dat"));
			out.writeObject(sviLekari);
			out.close();
			System.out.println("snimio lekare");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("lekari.dat"));
			Lekari leka = (Lekari)in.readObject();
			in.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Admin a1 = new  Admin("Aleksandar", "Avakumovic", "admin1","admin1");
		Admin a2 = new Admin("Ljubisa", "Avakumovic", "admin2", "admin2");
		Admini admini = new Admini();
		admini.getAdmini().add(a1);
		admini.getAdmini().add(a2);
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("administratori.dat"));
			out.writeObject(admini);
			out.close();
			System.out.println("snimio administratore");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("administratori.dat"));
			Admini adm = (Admini)in.readObject();
			in.close();
			System.out.println("kraj");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
