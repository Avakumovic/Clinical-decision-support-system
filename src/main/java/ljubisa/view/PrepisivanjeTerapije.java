package ljubisa.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ljubisa.main.main;
import ljubisa.model.Bolesti;
import ljubisa.model.Lek;
import ljubisa.model.Lekovi;

public class PrepisivanjeTerapije extends JPanel {

	private JLabel bolestiLabel;
	private JLabel prepisanaTerapijaLabel;
	private JLabel preporukaLabel;
	private JTextField preporukaLekaraField;
	private ListaSimptoma listaSimptoma;
	private JComboBox<Object> bolestiComboBox;
	
	public JLabel getBolestiLabel() {
		return bolestiLabel;
	}
	public void setBolestiLabel(JLabel bolestiLabel) {
		this.bolestiLabel = bolestiLabel;
	}
	public JLabel getPrepisanaTerapijaLabel() {
		return prepisanaTerapijaLabel;
	}
	public void setPrepisanaTerapijaLabel(JLabel prepisanaTerapijaLabel) {
		this.prepisanaTerapijaLabel = prepisanaTerapijaLabel;
	}
	public JLabel getPreporukaLabel() {
		return preporukaLabel;
	}
	public void setPreporukaLabel(JLabel preporukaLabel) {
		this.preporukaLabel = preporukaLabel;
	}
	public JTextField getPreporukaLekaraField() {
		return preporukaLekaraField;
	}
	public void setPreporukaLekaraField(JTextField preporukaLekaraField) {
		this.preporukaLekaraField = preporukaLekaraField;
	}
	public ListaSimptoma getListaSimptoma() {
		return listaSimptoma;
	}
	public void setListaSimptoma(ListaSimptoma listaSimptoma) {
		this.listaSimptoma = listaSimptoma;
	}
	public JComboBox<Object> getBolestiComboBox() {
		return bolestiComboBox;
	}
	public void setBolestiComboBox(JComboBox<Object> bolestiComboBox) {
		this.bolestiComboBox = bolestiComboBox;
	}
	
	public PrepisivanjeTerapije() throws Exception {
		super();
		Bolesti bolesti = main.getBolesti();
		bolestiLabel = new JLabel("Bolesti");
		prepisanaTerapijaLabel = new JLabel("Prepisana terapija");
		preporukaLabel = new JLabel("Preporuka");
		preporukaLekaraField = new JTextField(" ");
		bolestiComboBox = new JComboBox<>(bolesti.getBolesti().toArray());
		listaSimptoma = new ListaSimptoma();
		listaSimptoma.getPossibleLabel().setText("Lekovi");
		listaSimptoma.getSelectedLabel().setText("Prepisani lekovi");
		listaSimptoma.printBtn.setText("Proveri alergicnost");
		listaSimptoma.upitBtn.setText("Prikazi simptome");
		ArrayList<String> lekoviSvi = new ArrayList<>();
		Lekovi lekovi = Lekovi.ucitajLekove();
		for(Lek lek : lekovi.getSviLekovi()) {
			lekoviSvi.add(lek.getNazivLeka());
		}
		listaSimptoma.addPossibleElements(lekoviSvi.toArray());
		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(new GridLayout(4, 1));
		sidePanel.add(preporukaLabel);
		sidePanel.add(preporukaLekaraField);
		sidePanel.add(bolestiLabel);
		sidePanel.add(bolestiComboBox);
		
		setLayout(new GridLayout(1, 2));
		add(listaSimptoma);
		add(sidePanel);
		setVisible(true);
	}
}
