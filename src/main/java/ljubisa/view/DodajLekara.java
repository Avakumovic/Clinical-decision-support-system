package ljubisa.view;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DodajLekara extends JDialog{
	private JLabel imeLabel;
	private JLabel prezimeLabel;
	private JTextField imeField;
	private JTextField prezimeField;
	
	public DodajLekara(Frame frame, String titl, boolean mod) {
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
