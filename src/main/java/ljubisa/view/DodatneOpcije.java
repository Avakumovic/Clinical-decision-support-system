package ljubisa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.org.apache.xml.internal.security.Init;

import javafx.scene.layout.Border;
import ljubisa.main.main;
import ljubisa.model.Admin;
import ljubisa.model.Admini;
import ljubisa.model.Pacijent;
import ljubisa.model.Pacijenti;
import ljubisa.model.SviSimptomi;
import ljubisa.model.Lekari;
import ljubisa.model.Lekar;
import ljubisa.view.IzmenaPacijenta;

public class DodatneOpcije extends JFrame {
	private static DodatneOpcije dodatneOpcije;
	private ListaSimptoma listaSimptoma;
	private TrenutnoStanje trenutnoStanje;
	private JComboBox<Object> pacijentCombo;
	private JButton izmenaPacijenta;
	private JButton dodavanjePacijenta;
	private JButton brisanjePacijenta;
	private JButton dodavanjeLekara;
	private JTextField prvaGrupa;
	private JTextField drugaGrupa;
	private JTextField trecaGrupa;
	private JPanel preporuka;
	private JTextField greska;
	private Pacijenti pacijenti;
	private JButton prepisiTerapiju;
	private JButton monitoring;
	private JButton izvestaj;
	private JTextArea alergijaNaLek;
	private JTextArea alergijaNaSastav;
	private boolean dodavanjeTerapijeCheck = false;
	private PrepisivanjeTerapije prepisivanjeTerapijePanel;
	private IzmenaPacijenta izmenaPacijentaDia;
	
	public TrenutnoStanje getTrenutnoStanje() {
		return trenutnoStanje;
	}

	public void setTrenutnoStanje(TrenutnoStanje trenutnoStanje) {
		this.trenutnoStanje = trenutnoStanje;
	}

	public JTextField getTrecaGrupa() {
		return trecaGrupa;
	}

	public void setTrecaGrupa(JTextField trecaGrupa) {
		this.trecaGrupa = trecaGrupa;
	}

	public static DodatneOpcije getDodatneOpcije() {
		return dodatneOpcije;
	}
	
	public PrepisivanjeTerapije getPrepisivanjeTerapijePanel() {
		return prepisivanjeTerapijePanel;
	}

	public void setPrepisivanjeTerapijePanel(PrepisivanjeTerapije prepisivanjeTerapijePanel) {
		this.prepisivanjeTerapijePanel = prepisivanjeTerapijePanel;
	}

	public IzmenaPacijenta getIzmenaPacijentaDia() {
		return izmenaPacijentaDia;
	}

	public void setIzmenaPacijentaDia(IzmenaPacijenta izmenaPacijentaDia) {
		this.izmenaPacijentaDia = izmenaPacijentaDia;
	}

	private DodatneOpcije(Pacijenti pacijenti) throws HeadlessException {
		super("Stavi ulogovanog lekara");
		initCreate(pacijenti);
	}
	
	public static DodatneOpcije getDodatneOpcije(Pacijenti pacijenti) {
		if(dodatneOpcije == null) {
			dodatneOpcije = new DodatneOpcije(pacijenti);
		}
		return dodatneOpcije;
	}
	public static void setDodatneOpcije(DodatneOpcije dodatneOpcije) {
		DodatneOpcije.dodatneOpcije = dodatneOpcije;
	}
	public ListaSimptoma getListaSimptoma() {
		return listaSimptoma;
	}
	public void setListaSimptoma(ListaSimptoma listaSimptoma) {
		this.listaSimptoma = listaSimptoma;
	}
	public JComboBox<Object> getPacijentCombo() {
		return pacijentCombo;
	}
	public void setPacijentCombo(JComboBox<Object> pacijentCombo) {
		this.pacijentCombo = pacijentCombo;
	}
	public JButton getIzmenaPacijenta() {
		return izmenaPacijenta;
	}
	public void setIzmenaPacijenta(JButton izmenaPacijenta) {
		this.izmenaPacijenta = izmenaPacijenta;
	}
	public JButton getDodavanjePacijenta() {
		return dodavanjePacijenta;
	}
	public void setDodavanjePacijenta(JButton dodavanjePacijenta) {
		this.dodavanjePacijenta = dodavanjePacijenta;
	}
	public JButton getBrisanjePacijenta() {
		return brisanjePacijenta;
	}
	public void setBrisanjePacijenta(JButton brisanjePacijenta) {
		this.brisanjePacijenta = brisanjePacijenta;
	}
	public JButton getDodavanjeLekara() {
		return dodavanjeLekara;
	}
	public void setDodavanjeLekara(JButton dodavanjeLekara) {
		this.dodavanjeLekara = dodavanjeLekara;
	}
	public JTextField getPrvaGrupa() {
		return prvaGrupa;
	}
	public void setPrvaGrupa(JTextField prvaGrupa) {
		this.prvaGrupa = prvaGrupa;
	}
	public JTextField getDrugaGrupa() {
		return drugaGrupa;
	}
	public void setDrugaGrupa(JTextField drugaGrupa) {
		this.drugaGrupa = drugaGrupa;
	}
	public JPanel getPreporuka() {
		return preporuka;
	}
	public void setPreporuka(JPanel preporuka) {
		this.preporuka = preporuka;
	}
	public JTextField getGreska() {
		return greska;
	}
	public void setGreska(JTextField greska) {
		this.greska = greska;
	}
	public Pacijenti getPacijenti() {
		return pacijenti;
	}
	public void setPacijenti(Pacijenti pacijenti) {
		this.pacijenti = pacijenti;
	}
	public JButton getPrepisiTerapiju() {
		return prepisiTerapiju;
	}
	public void setPrepisiTerapiju(JButton prepisiTerapiju) {
		this.prepisiTerapiju = prepisiTerapiju;
	}
	public JButton getMonitoring() {
		return monitoring;
	}
	public void setMonitoring(JButton monitoring) {
		this.monitoring = monitoring;
	}
	public JButton getIzvestaj() {
		return izvestaj;
	}
	public void setIzvestaj(JButton izvestaj) {
		this.izvestaj = izvestaj;
	}
	public JTextArea getAlergijaNaLek() {
		return alergijaNaLek;
	}
	public void setAlergijaNaLek(JTextArea alergijaNaLek) {
		this.alergijaNaLek = alergijaNaLek;
	}
	public JTextArea getAlergijaNaSastav() {
		return alergijaNaSastav;
	}
	public void setAlergijaNaSastav(JTextArea alergijaNaSastav) {
		this.alergijaNaSastav = alergijaNaSastav;
	}
	public boolean isDodavanjeTerapijeCheck() {
		return dodavanjeTerapijeCheck;
	}
	public void setDodavanjeTerapijeCheck(boolean dodavanjeTerapijeCheck) {
		this.dodavanjeTerapijeCheck = dodavanjeTerapijeCheck;
	}

	private void initCreate(Pacijenti pac) {
		setSize(1370, 725);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		listaSimptoma = new ListaSimptoma();
		ArrayList<String> simptomList = new ArrayList<>();
		for(SviSimptomi simp : SviSimptomi.values()) {
			if(simp != SviSimptomi.TEMPERATURA_IZMEDJU_40_I_41 && simp != SviSimptomi.TEMPERATURA_VECA_OD_38 && simp != SviSimptomi.BOLOVANJE_OD_PREHLADE_ILI_GROZNICE_U_PROTEKLIH_60_DANA
					&& simp != SviSimptomi.U_POSLEDNJIH_6_MESECI_ZABELEZEN_BAR_10_SLUCAJEVA_U_KOJEM_PACIJENT_IMA_VISOK_PRITISAK) {
				simptomList.add(simp.toString());
			}
		}
		pacijenti = pac;
		
		listaSimptoma.addPossibleElements(simptomList.toArray());
		trenutnoStanje = TrenutnoStanje.getInstance();
		Object[] pacijentObj = pac.getPacijenti().toArray();
		pacijentCombo = new JComboBox<>(pac.getPacijenti().toArray());
		
		izmenaPacijenta = new JButton("Izmeni pacijenta");
		izmenaPacijenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				izmenaPacijentaDia = new IzmenaPacijenta(getDodatneOpcije(null), ((Pacijent) pacijentCombo.getSelectedItem()), true);
				izmenaPacijentaDia.init();
				pacijentCombo.repaint();
			}
		});
		
		setLayout(new BorderLayout());
		JPanel firstpanel = new JPanel();
		firstpanel.setLayout(new GridLayout(2, 1));
		firstpanel.add(pacijentCombo);
		firstpanel.add(trenutnoStanje);
		
		dodavanjePacijenta = new JButton("Dodaj pacijenta");
		dodavanjePacijenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel pane = new JPanel();
				JLabel imeLabel = new JLabel("Ime");
				JLabel prezimeLabel = new JLabel("Prezime");
				JTextField imeTf = new JTextField(50);
				JTextField prezimeTf = new JTextField(50);
				pane.setLayout(new GridLayout(2, 2));

				pane.add(imeLabel);
				pane.add(imeTf);
				pane.add(prezimeLabel);
				pane.add(prezimeTf);

				int a = JOptionPane.showConfirmDialog(getDodatneOpcije(null), pane, "Dodavanje novog pacijenta", JOptionPane.YES_NO_CANCEL_OPTION);
				if (a == 0) {
					Pacijent pac = new Pacijent(imeTf.getText(), prezimeTf.getText());
					pacijenti.addWithIncrement(pac);

					try {
						pacijenti.zapisiPacijente(pacijenti);
						pacijenti = pacijenti.ucitajPacijente();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					pacijentCombo.addItem(pac);
					pacijentCombo.repaint();
				}
			}
		});

		dodavanjeLekara = new JButton("Dodaj lekara");
		dodavanjeLekara.setVisible(false);
		dodavanjeLekara.setEnabled(false);
		

		dodavanjeLekara.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel pane = new JPanel();
				JLabel imeLabel = new JLabel("Ime");
				JLabel prezimeLabel = new JLabel("Prezime");
				JLabel usernameLabel = new JLabel("Username");
				JLabel passwordLabel = new JLabel("Sifra");

				JTextField imeTf = new JTextField(50);
				JTextField prezimeTf = new JTextField(50);
				JTextField usernameTf = new JTextField(50);
				JTextField sifraTf = new JTextField();
				pane.setLayout(new GridLayout(4, 2));

				pane.add(imeLabel);
				pane.add(imeTf);
				pane.add(prezimeLabel);
				pane.add(prezimeTf);
				pane.add(usernameLabel);
				pane.add(usernameTf);
				pane.add(passwordLabel);
				pane.add(sifraTf);
				

				int num = JOptionPane.showConfirmDialog(getDodatneOpcije(null), pane, "Dodavanje lekara", JOptionPane.YES_NO_CANCEL_OPTION);
				if (num == 0) {
					try {
						Admini admini = main.getAdmini();
						Lekari lekari= main.getLekari();
						
						boolean postojiUsername = false;
						for(Admin admin : admini.getAdmini()) {
							if(admin.getUsername().equals(usernameTf.getText())) {
								postojiUsername = true;
							}
						}
						
						for(Lekar lekar : lekari.getLekari()) {
							if(lekar.getUsername().equals(usernameTf.getText())) {
								postojiUsername = true;
							}
						}
						
						if(!postojiUsername) {
							lekari.dodajLekara(new Lekar(imeTf.getText(), prezimeTf.getText(), usernameTf.getText(), sifraTf.getText()));
							greska.setText("");
							Lekari.zapisiLekare(lekari);
							lekari = Lekari.ucitajLekare();
						} else {
							greska.setText("korisnicko ime vec postoji");}	
						
					} catch (Exception eee) {
						eee.printStackTrace();
					}
					try {
					} catch (Exception ee) {
						ee.printStackTrace();
					}
				}
			}
		});

		brisanjePacijenta = new JButton("Obrisi pacijenta");
		brisanjePacijenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int resultOption = JOptionPane.showConfirmDialog(getDodatneOpcije(null), "Da li ste sigurni da zelite da izbrisete: \n" + ((Pacijent) pacijentCombo.getSelectedItem()).toString(), "Brisanje pacijenta", JOptionPane.YES_NO_CANCEL_OPTION);
					if (resultOption == 0) {
						pacijenti.ukloniPacijenta((Pacijent) pacijentCombo.getSelectedItem());
						try {
							pacijenti.zapisiPacijente(pacijenti);
							pacijenti = pacijenti.ucitajPacijente();
						} catch (Exception ee) {
							// TODO Auto-generated catch block
							ee.printStackTrace();
						}
						DodatneOpcije dd = DodatneOpcije.getDodatneOpcije(null);
						dd.getPacijentCombo().removeItem((Pacijent) pacijentCombo.getSelectedItem());
						getDodatneOpcije(null).repaint();
					}

				} catch (Exception ex) {
					greska.setText("Nijedan pacijent nije selektovan");
				}
			}
		});
		
		monitoring = new JButton("Monitoring");
		izvestaj = new JButton("Izvestaj");

		JPanel secondpanel = new JPanel();
		secondpanel.setLayout(new GridLayout(3, 1));
		secondpanel.add(dodavanjePacijenta);
		secondpanel.add(brisanjePacijenta);
		//secondpanel.add(izmenaPacijenta);
		//secondpanel.add(monitoring);
		//secondpanel.add(izvestaj);
		secondpanel.add(dodavanjeLekara);

		JPanel upperpanel = new JPanel();

		upperpanel.setLayout(new GridLayout(1, 2));
		upperpanel.add(secondpanel);
		upperpanel.add(firstpanel);

		greska = new JTextField(100);
		greska.setForeground(Color.BLUE);
		greska.setEditable(false);
		prvaGrupa = new JTextField(100);
		drugaGrupa = new JTextField(100);
		trecaGrupa = new JTextField(100);
		preporuka = new JPanel();
		preporuka.setLayout(new GridLayout(4, 1));
		preporuka.add(greska);
		preporuka.add(prvaGrupa);
		preporuka.add(drugaGrupa);
		preporuka.add(trecaGrupa);
		
		add(upperpanel, BorderLayout.NORTH);
		
		try {
			prepisivanjeTerapijePanel = new PrepisivanjeTerapije();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JPanel thirdpanel = new JPanel();
		JPanel forthpanel = new JPanel();
		forthpanel.setLayout(new BorderLayout());
		
		forthpanel.add(new JLabel(" "), BorderLayout.NORTH);
		forthpanel.add(thirdpanel, BorderLayout.CENTER);

		
		thirdpanel.setLayout(new GridLayout(3, 1));
		thirdpanel.add(listaSimptoma);
		
		JPanel thesplit = new JPanel();
		prepisiTerapiju = new JButton("Prepisi terapiju");
		prepisiTerapiju.setEnabled(false);
		prepisiTerapiju.setToolTipText("Prvo proverite alergicnost pacijenta");
		
		thesplit.setLayout(new BorderLayout());
		thesplit.add(prepisivanjeTerapijePanel, BorderLayout.CENTER);
		thesplit.add(prepisiTerapiju, BorderLayout.EAST);
		
		thirdpanel.add(thesplit);
		add(forthpanel, BorderLayout.CENTER); 
		forthpanel.setVisible(true);
		add(preporuka, BorderLayout.SOUTH);
		JPanel panelEast = new JPanel();
		panelEast.setLayout(new GridLayout(1, 1));
		panelEast.setSize(200, 200);
		alergijaNaLek = new JTextArea();
		alergijaNaSastav = new JTextArea();
		alergijaNaSastav.setEditable(false);
		alergijaNaLek.setEditable(false);	
		
		
		JPanel alergijaSastavPane = new JPanel();
		alergijaSastavPane.setLayout(new BorderLayout());
		
		
		alergijaSastavPane.add(new JLabel("Alergije na sastojak iz leka"), BorderLayout.NORTH);
		JScrollPane scrollPaneAlergijeNaSastojak = new JScrollPane(alergijaNaSastav);
		alergijaSastavPane.add(scrollPaneAlergijeNaSastojak, BorderLayout.CENTER);
				
		JPanel alergijaLekPane = new JPanel();
		alergijaLekPane.setLayout(new BorderLayout());
		alergijaLekPane.add(new JLabel("Alergije"),BorderLayout.NORTH);
		JScrollPane scrollPanelAlergijeNaLek = new JScrollPane(alergijaNaLek);
		alergijaLekPane.add(scrollPanelAlergijeNaLek,BorderLayout.CENTER);
		
		panelEast.add(alergijaLekPane);
		thirdpanel.add(panelEast);
		
		setVisible(true);
	}
}




