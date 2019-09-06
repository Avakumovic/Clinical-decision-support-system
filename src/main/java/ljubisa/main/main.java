package ljubisa.main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import ljubisa.model.Admin;
import ljubisa.model.Admini;
import ljubisa.model.Alergicnost;
import ljubisa.model.Bolest;
import ljubisa.model.Bolesti;
import ljubisa.model.Lek;
import ljubisa.model.Lekari;
import ljubisa.model.Lekovi;
import ljubisa.model.Osoba;
import ljubisa.model.Pacijent;
import ljubisa.model.Pacijenti;
import ljubisa.model.PotencijalnaBolest;
import ljubisa.model.Pregled;
import ljubisa.model.SastavLeka;
import ljubisa.model.SpecificniSimptomi;
import ljubisa.model.SviSimptomi;
import ljubisa.model.Terapija;
import ljubisa.view.DodatneOpcije;
import ljubisa.view.Izvestaj;
import ljubisa.view.MonitoringPacijenta;
import ljubisa.view.PrepisivanjeTerapije;

public class main {
	static Osoba osoba;
	static Admini sviAdmini;
	public static Lekovi sviLekovi;
	static Pacijenti sviPacijenti;
	static Lekari sviLekari;
	
	public static Lekari getLekari() throws Exception {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("lekari.dat"));
		Lekari l = (Lekari) inputStream.readObject();
		inputStream.close();
		return l;
	}
	
	public static Admini getAdmini() throws Exception {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("administratori.dat"));
		Admini a = (Admini) inputStream.readObject();
		inputStream.close();
		return a;
	}
	
	public static Bolesti getBolesti() throws Exception {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("bolesti.dat"));
		Bolesti bolesti = (Bolesti) inputStream.readObject(); 
		inputStream.close();
		return bolesti;
	}
	
	public static Pacijenti getPacijenti() throws Exception {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("pacijenti.dat"));
		Pacijenti pac = (Pacijenti) inputStream.readObject(); 
		inputStream.close();
		return pac;
	}
	
	public static Lekovi getLekovi() throws Exception {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("lekovi.dat"));
		Lekovi lek = (Lekovi) inputStream.readObject(); 
		inputStream.close();
		return lek;
	}
	
	public static void bolestiPrveGrupe(HashSet<PotencijalnaBolest> potencijalna) {
		potencijalna.clear();
		PotencijalnaBolest prva = new PotencijalnaBolest("groznica", -1.0);
		PotencijalnaBolest druga = new PotencijalnaBolest("prehlada", -1.0);
		PotencijalnaBolest treca = new PotencijalnaBolest("sinusnaInfekcija", -1.0);
		PotencijalnaBolest cetvrta = new PotencijalnaBolest("upalaKrajnika", -1.0);
		
		potencijalna.add(prva);
		potencijalna.add(druga);
		potencijalna.add(treca);
		potencijalna.add(cetvrta);
		
	}
	
	public static void bolestiDrugeGrupe(HashSet<PotencijalnaBolest> potencijalna) {
		potencijalna.clear();
		PotencijalnaBolest prva = new PotencijalnaBolest("dijabetes", -1.0);
		PotencijalnaBolest druga = new PotencijalnaBolest("hipertenzija", -1.0);
		
		potencijalna.add(prva);
		potencijalna.add(druga);
	}
	
	public static void bolestiTreceGrupe(HashSet<PotencijalnaBolest> potencijalna) {
		potencijalna.clear();
		PotencijalnaBolest prva = new PotencijalnaBolest("hronicnaBubreznaBolest", -1.0);
		PotencijalnaBolest druga = new PotencijalnaBolest("akutnaBubreznaBolest", -1.0);
		
		potencijalna.add(prva);
		potencijalna.add(druga);
		
	}
	
	public static void resetujPotencijaleBolesti(HashSet<PotencijalnaBolest> potencijalnaBolests) {
		for (PotencijalnaBolest p : potencijalnaBolests) {
			p.setSansa(-1.0);
		}
	}
	
	public static int logInWindow() {
		JPanel pane = new JPanel();
		JLabel usernameLabel = new JLabel("Username");
		JLabel passwordLabel = new JLabel("Password");
		JTextField username = new JTextField(50);
		JTextField password = new JTextField(50);
		pane.setLayout(new GridLayout(1, 4));
		pane.add(usernameLabel);
		pane.add(username);
		pane.add(passwordLabel);
		pane.add(password);
		int response = JOptionPane.showConfirmDialog((null), pane, "log in", JOptionPane.YES_NO_OPTION);
		
		osoba = sviAdmini.provera(username.getText(), password.getText());
		if(osoba == null) {
			osoba = sviLekari.provera(username.getText(), password.getText());
		}
		
		if(osoba == null && response!= -1 && response!= 1) {
			response = -10;
		}
		return response;
	}
	
	public static void main(String[] args) throws Exception {
		Bolesti bol = getBolesti();
		sviPacijenti = getPacijenti();
		sviLekovi = getLekovi();
		sviLekari = getLekari();
		sviAdmini = getAdmini();

		int login = logInWindow();

		while (login == -10) {
			login = logInWindow();
		}
		if (login == -1 || login == 1) {
			System.exit(0);
		}

		DodatneOpcije dod = DodatneOpcije.getDodatneOpcije(sviPacijenti);
		dod.setTitle("CDSS");
		if (osoba instanceof Admin) {
			dod.getDodavanjeLekara().setEnabled(true);
			dod.getDodavanjeLekara().setVisible(true);
		}
		KieServices kie = KieServices.Factory.get();
		KieContainer container = kie.getKieClasspathContainer();
		dod.setVisible(true);
		dod.repaint();

		Bolest prehlada = bol.getBolesti().get(1);
		Bolest groznica = bol.getBolesti().get(0);
		Bolest upalaKrajnika = bol.getBolesti().get(3);
		Bolest sinusnaInfekcija = bol.getBolesti().get(2);
		Bolest dijabetes = bol.getBolesti().get(4);
		Bolest hipertenzija = bol.getBolesti().get(5);
		Bolest hronicnaBubreznaBolest = bol.getBolesti().get(6);
		Bolest akutnaBubreznaBolest = bol.getBolesti().get(7);

		HashSet<PotencijalnaBolest> potencijalnaBolest = new HashSet<>();
		PotencijalnaBolest druga = new PotencijalnaBolest("prehlada", -1.0);
		PotencijalnaBolest prva = new PotencijalnaBolest("groznica", -1.0);
		PotencijalnaBolest cetvrta = new PotencijalnaBolest("upalaKrajnika", -1.0);
		PotencijalnaBolest treca = new PotencijalnaBolest("sinusnaInfekcija", -1.0);

		potencijalnaBolest.add(prva);
		potencijalnaBolest.add(druga);
		potencijalnaBolest.add(treca);
		potencijalnaBolest.add(cetvrta);

		KieSession kie2 = container.newKieSession("ksession-rules");
		kie2.setGlobal("prehlada", prehlada);
		kie2.setGlobal("groznica", groznica);
		kie2.setGlobal("upalaKrajnika", upalaKrajnika);
		kie2.setGlobal("sinusnaInfekcija", sinusnaInfekcija);

		kie2.setGlobal("dijabetes", dijabetes);
		kie2.setGlobal("hipertenzija", hipertenzija);
		kie2.setGlobal("hronicnaBubreznaBolest", hronicnaBubreznaBolest);
		kie2.setGlobal("akutnaBubreznaBolest", akutnaBubreznaBolest);
		
		KieSession kSessionProveraAlergije = container.newKieSession("ksession-ProveriAlergije");
		kSessionProveraAlergije.setGlobal(sviLekovi.getSviLekovi().get(0).getNazivLeka(), sviLekovi.getSviLekovi().get(0));
		kSessionProveraAlergije.setGlobal(sviLekovi.getSviLekovi().get(1).getNazivLeka(), sviLekovi.getSviLekovi().get(1));
		kSessionProveraAlergije.setGlobal(sviLekovi.getSviLekovi().get(2).getNazivLeka(), sviLekovi.getSviLekovi().get(2));
		
		KieSession ksessionMonitoringPacijenta = container.newKieSession("cepConfigKsessionRealtimeClock");
		
		KieSession ksQuerry = container.newKieSession("ksession-Querry");
		ksQuerry.getAgenda().getAgendaGroup("prikaziSimptomeNekeBolesti").setFocus();
		ksQuerry.setGlobal("prehlada", prehlada);
		ksQuerry.setGlobal("groznica", groznica);
		ksQuerry.setGlobal("upalaKrajnika", upalaKrajnika);
		ksQuerry.setGlobal("sinusnaInfekcija", sinusnaInfekcija);

		ksQuerry.setGlobal("dijabetes", dijabetes);
		ksQuerry.setGlobal("hipertenzija", hipertenzija);
		ksQuerry.setGlobal("hronicnaBubreznaBolest", hronicnaBubreznaBolest);
		ksQuerry.setGlobal("akutnaBubreznaBolest", akutnaBubreznaBolest);
		
		KieSession kSessionIzvestaji = container.newKieSession("ksession-rulesIzveshtaji");

		dod.getListaSimptoma().getPrintBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bolestiPrveGrupe(potencijalnaBolest);

				ArrayList<String> thelist = new ArrayList<>();

				for (int i = 0; i < dod.getListaSimptoma().selectedList.getModel().getSize(); i++) {
					thelist.add(dod.getListaSimptoma().selectedList.getModel().getElementAt(i).toString());
				}

				HashSet<SviSimptomi> izabrani = new HashSet<>();
				for (SviSimptomi simptomi : SviSimptomi.values()) {
					if (thelist.contains(simptomi.toString())) {
						izabrani.add(simptomi);
					}
				}

				Double double1 = -1.0;
				//potential proble
				String str = dod.getTrenutnoStanje().getTemp().getText().getText();
				try {
					double1 = Double.valueOf(str);
					dod.getGreska().setText("");
				} catch (NumberFormatException nuberFormaTEXeption) {
					dod.getGreska().setText("Temperatura nije uneta");

				}

				Pacijent pacSelektovan = (Pacijent) dod.getPacijentCombo().getSelectedItem();
				Pregled pregled = new Pregled(pacSelektovan, izabrani, null, double1, dod.getTrenutnoStanje().getPritisak().isSelected(), potencijalnaBolest);
				
				
				
				dod.getPrvaGrupa().setText("");
				kie2.insert(dod.getPrvaGrupa());
				
				kie2.insert(pregled);
				kie2.getAgenda().getAgendaGroup("prva").setFocus();
				kie2.fireAllRules();
			
				resetujPotencijaleBolesti(potencijalnaBolest);
				bolestiDrugeGrupe(potencijalnaBolest);
				pregled = new Pregled(pacSelektovan, izabrani, null, double1, dod.getTrenutnoStanje().getPritisak().isSelected(), potencijalnaBolest);
				
				dod.getDrugaGrupa().setText("");
				kie2.insert(dod.getDrugaGrupa());
				
				kie2.insert(pregled);
				kie2.getAgenda().getAgendaGroup("druga").setFocus();
				kie2.fireAllRules();
				
				dod.getDrugaGrupa().setText(potencijalnaBolest.toString());

				bolestiTreceGrupe(potencijalnaBolest);
				
				kie2.insert(dod.getTrecaGrupa());
				
				HashSet<SpecificniSimptomi> ss = new HashSet<>();
				if (dod.getTrenutnoStanje().getOporavak().isSelected()) {
					ss.add(SpecificniSimptomi.OPORAVLJA_SE_OD_OPERACIJE);
				}
				pregled = new Pregled(pacSelektovan, izabrani, ss, double1,
						dod.getTrenutnoStanje().getPritisak().isSelected(), potencijalnaBolest);
				kie2.insert(pregled);
				kie2.getAgenda().getAgendaGroup("treca").setFocus();
				kie2.fireAllRules();
				dod.getTrecaGrupa().setText(potencijalnaBolest.toString());

			}
		});

		dod.getPrepisivanjeTerapijePanel().getListaSimptoma().printBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dod.getAlergijaNaSastav().setText("");
						dod.getAlergijaNaLek().setText("");
						Double dd = -1.0;
						String s = dod.getTrenutnoStanje().getTemp().getText().getText();
						try {
							dd = Double.valueOf(s);
							dod.getGreska().setText("");
						} catch (NumberFormatException nuberFormaTEXeption) {

						}

						Pacijent pac = (Pacijent) dod.getPacijentCombo().getSelectedItem();
			
						HashSet<String> nazivIzabranihLekovaSet = new HashSet<>();
						for (int i = 0; i < dod.getPrepisivanjeTerapijePanel().getListaSimptoma().selectedList.getModel().getSize(); i++) {
							nazivIzabranihLekovaSet.add(dod.getPrepisivanjeTerapijePanel().getListaSimptoma().selectedList.getModel().getElementAt(i).toString());
						}
						dod.getAlergijaNaLek().setText("");
						kSessionProveraAlergije.insert(pac);
					
						kSessionProveraAlergije.insert(dod.getAlergijaNaLek());
						
						ArrayList<Lek> prepisaniLekoviArr = new ArrayList<>();
						HashSet<String> prepisaniLekoviStr = new HashSet<>();

						for (int i = 0; i < dod.getPrepisivanjeTerapijePanel().getListaSimptoma().selectedList.getModel().getSize(); i++) {
							prepisaniLekoviStr.add(dod.getPrepisivanjeTerapijePanel().getListaSimptoma().selectedList
									.getModel().getElementAt(i).toString());

						}
						for (Lek ll : sviLekovi.getSviLekovi()) {
							for (String ssss : prepisaniLekoviStr) {
								if (ll.getNazivLeka().equals(ssss)) {
									prepisaniLekoviArr.add(ll);
								}
							}
						}
						
						if(!prepisaniLekoviArr.isEmpty()) {
							for(Lek l : prepisaniLekoviArr) {
								kSessionProveraAlergije.insert(l);
							}
						}
						Alergicnost jeAlergican = new Alergicnost(false);
						kSessionProveraAlergije.insert(jeAlergican);
					
						HashSet<String> sastojciIzabranihLekova = new HashSet<>();
						if(!prepisaniLekoviArr.isEmpty()) {
							for(Lek l : prepisaniLekoviArr) {
								for(SastavLeka sastojakLekaTemp : l.getSastav() ) {
									sastojciIzabranihLekova.add(sastojakLekaTemp.toString());
								}
							}
						}						
						

						kSessionProveraAlergije.insert(sastojciIzabranihLekova);
						
						
						kSessionProveraAlergije.getAgenda().getAgendaGroup("proveriAlergije").setFocus();
						kSessionProveraAlergije.fireAllRules();
						dod.getPrepisiTerapiju().setEnabled(!jeAlergican.isJeAlergican());
					
					}
				});
		
		dod.getPrepisivanjeTerapijePanel().getListaSimptoma().getAddBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dod.getPrepisiTerapiju().setEnabled(false);
				
			}
		});
		
		dod.getPrepisivanjeTerapijePanel().getListaSimptoma().getRemoveBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dod.getPrepisiTerapiju().setEnabled(false);
				
			}
		});
		
		dod.getPrepisivanjeTerapijePanel().getBolestiComboBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dod.getPrepisiTerapiju().setEnabled(false);
				
			}
		});
		
		dod.getIzmenaPacijenta().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dod.getPrepisiTerapiju().setEnabled(false);
				
			}
		});
		
		dod.getBrisanjePacijenta().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dod.getPrepisiTerapiju().setEnabled(false);
				
			}
		});
		dod.getPacijentCombo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dod.getPrepisiTerapiju().setEnabled(false);
				
			}
		});;
		
		

		
		dod.getMonitoring().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				MonitoringPacijenta monitor = new MonitoringPacijenta(dod, (Pacijent) dod.getPacijentCombo().getSelectedItem(), true, ksessionMonitoringPacijenta);
				monitor.addWindowListener( new WindowAdapter() {

					@Override
					public void windowDeactivated(WindowEvent e) {
						super.windowDeactivated(e);
						try {
							monitor.stopThread();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						monitor.deleteAll();
					}


					
					
				});
			}
		});
		dod.getPrepisivanjeTerapijePanel().getListaSimptoma().upitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Bolest selektovana = (Bolest) dod.getPrepisivanjeTerapijePanel().getBolestiComboBox().getSelectedItem();
				
				ksQuerry.getAgenda().getAgendaGroup("prikaziSimptomeNekeBolesti").setFocus();
				ksQuerry.insert(selektovana);
				
				JTextArea taSimpomiZaOvuBolest = new JTextArea();
				taSimpomiZaOvuBolest.setEditable(false);
				ksQuerry.insert(taSimpomiZaOvuBolest);
				
				ksQuerry.fireAllRules();
				JOptionPane.showMessageDialog(dod, taSimpomiZaOvuBolest, "Simptomi: "+ selektovana.getNaziv(), JOptionPane.YES_OPTION );
				
			}
		});
		dod.getListaSimptoma().upitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> chosenList = new ArrayList<>();
				
				for (int i = 0; i < dod.getListaSimptoma().selectedList.getModel().getSize(); i++) {
					chosenList.add(dod.getListaSimptoma().selectedList.getModel().getElementAt(i).toString());
				}

				HashSet<SviSimptomi> izabrani = new HashSet<>();
				for (SviSimptomi s : SviSimptomi.values()) {
					if (chosenList.contains(s.toString())) {
						izabrani.add(s);
					}
				}
				ksQuerry.setGlobal("akutnaBubreznaBolest", akutnaBubreznaBolest);
				
				for(SviSimptomi sTempIzabrani : izabrani) {
					ksQuerry.insert(sTempIzabrani);
				}
				JTextArea taIspis = new JTextArea(); 
				taIspis.setEditable(false);
				ksQuerry.insert(taIspis);
				ksQuerry.getAgenda().getAgendaGroup("SimpUBolestima").setFocus();
				
				
				
				Double ddd = -1.0;
				String s = dod.getTrenutnoStanje().getTemp().getText().getText();
				try {
					ddd = Double.valueOf(s);
					dod.getGreska().setText("");
				} catch (NumberFormatException nuberFormaTExeption) {

				}
				Pregled p = new Pregled(null, null, null, ddd, true, null);
				ksQuerry.insert(p);
				
				if (dod.getTrenutnoStanje().getOporavak().isSelected()) {
					ksQuerry.insert(SpecificniSimptomi.OPORAVLJA_SE_OD_OPERACIJE);
				}
				
				ksQuerry.fireAllRules();
				
		
				JOptionPane.showMessageDialog(dod, taIspis, "Bolesti: ", JOptionPane.YES_OPTION );
				
			}
		});
		
		
		dod.getIzvestaj().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				ArrayList<Pacijent> pactemp = sviPacijenti.getPacijenti();
				for(Pacijent ppp : pactemp) {
					kSessionIzvestaji.insert(ppp);
				}
				Izvestaj iDialog = new Izvestaj(dod, kSessionIzvestaji, true);
				iDialog.addWindowListener(new WindowAdapter() {

					@Override
					public void windowDeactivated(WindowEvent e) {
						super.windowDeactivated(e);
						if(!kSessionIzvestaji.getFactHandles().isEmpty()) {
							for(FactHandle f: kSessionIzvestaji.getFactHandles()) {
								kSessionIzvestaji.delete(f);	
							}
						}
	
					}
				});
			}
		});
		

		dod.getPrepisiTerapiju().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Lek> prepisaniLekoviLek = new ArrayList<>();
				HashSet<String> prepisaniLekoviString = new HashSet<>();

				for (int i = 0; i < dod.getPrepisivanjeTerapijePanel().getListaSimptoma().selectedList.getModel()
						.getSize(); i++) {
					prepisaniLekoviString.add(dod.getPrepisivanjeTerapijePanel().getListaSimptoma().selectedList.getModel().getElementAt(i).toString());

				}
				Bolest theBolest = (Bolest) dod.getPrepisivanjeTerapijePanel().getBolestiComboBox().getSelectedItem();
				String preporukaLekara = dod.getPrepisivanjeTerapijePanel().getPreporukaLekaraField().getText();
				LocalDate datumPrepisaneTerapiej = LocalDate.now();
				ArrayList<Lek> prepisaniLekoviTemp = new ArrayList<>();
				for (Lek lek : sviLekovi.getSviLekovi()) {
					for (String s : prepisaniLekoviString) {
						if (lek.getNazivLeka().equals(s)) {
							prepisaniLekoviLek.add(lek);
						}
					}
				}

				Boolean visokPritisak = dod.getTrenutnoStanje().getPritisak().isSelected();
				Double temperatura = -1.0;
				try {
					temperatura = Double.valueOf(dod.getTrenutnoStanje().getTemp().getText().getText());
				} catch (Exception e) {
				}

				Terapija prepisanaTerapija = new Terapija(theBolest, prepisaniLekoviLek,
						preporukaLekara, datumPrepisaneTerapiej, temperatura, visokPritisak);
				prepisanaTerapija.setLekar(osoba);

				Pacijent pacijentSelektovan = (Pacijent) dod.getPacijentCombo().getSelectedItem();
				pacijentSelektovan.dodajTerapiju(prepisanaTerapija);
				int idPacijentaOdArrayListe = -100;
				try {
					for (int i = 0; i < sviPacijenti.getPacijenti().size(); i++) {
						if (sviPacijenti.getPacijenti().get(i).getId() == pacijentSelektovan.getId()) {
							idPacijentaOdArrayListe = i;
						}
					}
					sviPacijenti.getPacijenti().set(idPacijentaOdArrayListe, pacijentSelektovan);
				
					sviPacijenti.zapisiPacijente(sviPacijenti);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					sviPacijenti = sviPacijenti.ucitajPacijente();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		
		
		
		
	}
	
	
	
}




