package ljubisa.view;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DodajPacijenta extends JDialog {
	private JLabel imeLabel;
	private JLabel prezimeLabel;
	private JLabel alergijaNaLekove;
	private JLabel AlergijaNaSastav;
	private JTextField imeField;
	private JTextField prezimeField;
	
	public DodajPacijenta(Frame frame, String titl, boolean mod) {
		super(frame, titl, mod);
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
	public JLabel getAlergijaNaLekove() {
		return alergijaNaLekove;
	}
	public void setAlergijaNaLekove(JLabel alergijaNaLekove) {
		this.alergijaNaLekove = alergijaNaLekove;
	}
	public JLabel getAlergijaNaSastav() {
		return AlergijaNaSastav;
	}
	public void setAlergijaNaSastav(JLabel alergijaNaSastav) {
		AlergijaNaSastav = alergijaNaSastav;
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
}
