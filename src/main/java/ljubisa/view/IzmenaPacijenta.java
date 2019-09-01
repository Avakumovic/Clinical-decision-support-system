package ljubisa.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.layout.Border;
import ljubisa.main.main;
import ljubisa.model.Lek;
import ljubisa.model.Lekovi;
import ljubisa.model.Pacijent;
import ljubisa.model.SastavLeka;

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
		//lekovi = main.lekovi;
		
		for(Lek l1 : pacijentt.getAlergicanNaLekove()) {
			jeAlergicanNa.add(l1.getNazivLeka());
		}
		for(Lek l2 : lekovi.getSviLekovi()) {
			nijeAlergicanNa.add(l2.getNazivLeka());
		}
		for(Lek l2 : pacijentt.getAlergicanNaLekove()) {
			nijeAlergicanNa.remove(l2.getNazivLeka());
		}
		
		alergijaNaLekove.addPossibleElements(nijeAlergicanNa.toArray());
		alergijaNaLekove.addSelectedElements(jeAlergicanNa.toArray());
		alergijaNaLekove.printBtn.setVisible(false);
		alergijaNaLekove.getPossibleLabel().setText("Nije alergican");
		alergijaNaLekove.getSelectedLabel().setText("Jeste alergican");
		
	}
	
	private void ListaSastojaka() {
		alergijaNaSastav = new ListaSimptoma();
		ArrayList<String> sastavCeli = new ArrayList<>();
		ArrayList<String> sastavJeAlergican = new ArrayList<>();
		for(SastavLeka sastav : SastavLeka.values()) {
			if(pacijentt.getAlergijaNaSastav().contains(sastav.toString())) {
				sastavJeAlergican.add(sastav.toString());
			} else {
				sastavCeli.add(sastav.toString());
			}
		}
		alergijaNaSastav.addPossibleElements(sastavCeli.toArray());
		alergijaNaSastav.addSelectedElements(sastavJeAlergican.toArray());
		alergijaNaSastav.printBtn.setVisible(false);
		alergijaNaSastav.upitBtn.setVisible(false);
		alergijaNaSastav.getPossibleLabel().setText("Nije alergican na sastav");
		alergijaNaSastav.getSelectedLabel().setText("Jeste alergican na sastav");
	}
	
	public void init() {
		setSize(800, 800);
		setLayout(new BorderLayout());
		imeLabel = new JLabel("Ime");
		prezimeLabel = new JLabel("Prezime");
		imeField = new JTextField(50);
		prezimeField = new JTextField(50);
		imeField.setText(pacijentt.getIme());
		prezimeField.setText(pacijentt.getPrezime());
		okBtn = new JButton("OK");
		cancel = new JButton("Cancel");
		southPanel = new JPanel();
		southPanel.add(okBtn);
		southPanel.add(cancel);
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 2));
		northPanel.add(imeLabel);
		northPanel.add(prezimeLabel);
		northPanel.add(imeField);
		northPanel.add(prezimeField);
		
		centralPanel = new JPanel();
		try {
			ListaLekova();
		} catch (Exception ee) {
			// TODO: handle exception
			ee.printStackTrace();
		}
		ListaSastojaka();
		prepisaneTerapijeLabel = new JLabel("Prepisane terapije");
		prepisaneTerapije = new JComboBox<>(pacijentt.getTerapije().toArray());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(prepisaneTerapijeLabel);
		panel.add(prepisaneTerapije);
		centralPanel.setLayout(new GridLayout(3, 1));
		centralPanel.add(alergijaNaLekove);
		centralPanel.add(alergijaNaSastav);
		centralPanel.add(panel);
		
		add(southPanel, BorderLayout.SOUTH);
		add(northPanel, BorderLayout.NORTH);
		add(centralPanel, BorderLayout.CENTER);
		
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pacijentt.setIme(imeField.getText());
				pacijentt.setPrezime(prezimeField.getText());
				HashSet<String> thelist = new HashSet<>();
				for(int i = 0; i < alergijaNaSastav.selectedList.getModel().getSize(); i++) {
					thelist.add(alergijaNaSastav.selectedList.getModel().getElementAt(i).toString());
				}
				pacijentt.setAlergijaNaSastav(thelist);	
				HashSet<String> thelist2 = new HashSet<>();
				for(int i = 0; i < alergijaNaLekove.selectedList.getModel().getSize(); i++) {
						
				}
			}
		});
	}
}



