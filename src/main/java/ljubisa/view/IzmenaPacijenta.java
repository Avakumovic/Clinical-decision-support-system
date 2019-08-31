package ljubisa.view;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ljubisa.model.Lekovi;
import ljubisa.model.Pacijent;

public class IzmenaPacijenta extends JDialog {
	
	private JButton okBtn;
	private JButton cancel;
	private JLabel imeLabel;
	private JLabel prezimeLabel;
	private JTextField imeField;
	private JTextField prezimeField;
	private Pacijent pacijentt;
	private Lekovi lekovi;
	private JPanel northPanel;
	private JPanel centralPanel;
	private JPanel southPanel;
	private JLabel prepisaneTerapijeLabel;
	private JComboBox<Object> prepisaneTerapije;
	private ListaSimptoma alergijaNaLekove;
	private ListaSimptoma alergijaNaSastav;
	
	public JButton getOkBtn() {
		return okBtn;
	}
	public void setOkBtn(JButton okBtn) {
		this.okBtn = okBtn;
	}
	public JButton getCancel() {
		return cancel;
	}
	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}
	public JLabel getImeLabel() {
		return imeLabel;
	}
	public void setImeLabel(JLabel imeLabel) {
		this.imeLabel = imeLabel;
	}
	public JLabel getPrezimeLabel() {
		return prezimeLabel;
	}
	public void setPrezimeLabel(JLabel prezimeLabel) {
		this.prezimeLabel = prezimeLabel;
	}
	public JTextField getImeField() {
		return imeField;
	}
	public void setImeField(JTextField imeField) {
		this.imeField = imeField;
	}
	public JTextField getPrezimeField() {
		return prezimeField;
	}
	public void setPrezimeField(JTextField prezimeField) {
		this.prezimeField = prezimeField;
	}
	public Pacijent getPacijentt() {
		return pacijentt;
	}
	public void setPacijentt(Pacijent pacijentt) {
		this.pacijentt = pacijentt;
	}
	public Lekovi getLekovi() {
		return lekovi;
	}
	public void setLekovi(Lekovi lekovi) {
		this.lekovi = lekovi;
	}
	public JPanel getNorthPanel() {
		return northPanel;
	}
	public void setNorthPanel(JPanel northPanel) {
		this.northPanel = northPanel;
	}
	public JPanel getCentralPanel() {
		return centralPanel;
	}
	public void setCentralPanel(JPanel centralPanel) {
		this.centralPanel = centralPanel;
	}
	public JPanel getSouthPanel() {
		return southPanel;
	}
	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}
	public JLabel getPrepisaneTerapijeLabel() {
		return prepisaneTerapijeLabel;
	}
	public void setPrepisaneTerapijeLabel(JLabel prepisaneTerapijeLabel) {
		this.prepisaneTerapijeLabel = prepisaneTerapijeLabel;
	}
	public JComboBox<Object> getPrepisaneTerapije() {
		return prepisaneTerapije;
	}
	public void setPrepisaneTerapije(JComboBox<Object> prepisaneTerapije) {
		this.prepisaneTerapije = prepisaneTerapije;
	}
	public ListaSimptoma getAlergijaNaLekove() {
		return alergijaNaLekove;
	}
	public void setAlergijaNaLekove(ListaSimptoma alergijaNaLekove) {
		this.alergijaNaLekove = alergijaNaLekove;
	}
	public ListaSimptoma getAlergijaNaSastav() {
		return alergijaNaSastav;
	}
	public void setAlergijaNaSastav(ListaSimptoma alergijaNaSastav) {
		this.alergijaNaSastav = alergijaNaSastav;
	}
	
	private IzmenaPacijenta(Frame frame, Pacijent pacijent, boolean mod) {
		super(frame, "Pacijent: "+ pacijent.toString(), mod);
		pacijentt = pacijent;
	}
	
	private void ListaLekova() throws Exception {
		alergijaNaLekove = new ListaSimptoma();
		ArrayList<String> jeAlergicanNa = new ArrayList<>();
		ArrayList<String> nijeAlergicanNa = new ArrayList<>();
		DodatneOpcije dodatneOpcije = DodatneOpcije.getDodatneOpcije(null);
		
	}
}



