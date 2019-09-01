package ljubisa.view;

import java.awt.HeadlessException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.org.apache.xml.internal.security.Init;

import ljubisa.model.Pacijenti;
import ljubisa.model.SviSimptomi;

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
		setSize(1000, 1000);
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
		
	}
}
