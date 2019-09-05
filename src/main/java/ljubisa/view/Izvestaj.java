package ljubisa.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.kie.api.runtime.KieSession;

public class Izvestaj extends JDialog {
	private JButton hronicnaOboljenjaBtn;
	private JButton moguciZavisniciBtn;
	private JButton oslabljenImunitetBtn;
	private JButton okBtn;
	private JTextArea ispis;
	private KieSession session;
	
	public JButton getHronicnaOboljenjaBtn() {
		return hronicnaOboljenjaBtn;
	}
	public void setHronicnaOboljenjaBtn(JButton hronicnaOboljenjaBtn) {
		this.hronicnaOboljenjaBtn = hronicnaOboljenjaBtn;
	}
	public JButton getMoguciZavisniciBtn() {
		return moguciZavisniciBtn;
	}
	public void setMoguciZavisniciBtn(JButton moguciZavisniciBtn) {
		this.moguciZavisniciBtn = moguciZavisniciBtn;
	}
	public JButton getOslabljenImunitetBtn() {
		return oslabljenImunitetBtn;
	}
	public void setOslabljenImunitetBtn(JButton oslabljenImunitetBtn) {
		this.oslabljenImunitetBtn = oslabljenImunitetBtn;
	}
	public JButton getOkBtn() {
		return okBtn;
	}
	public void setOkBtn(JButton okBtn) {
		this.okBtn = okBtn;
	}
	public JTextArea getIspis() {
		return ispis;
	}
	public void setIspis(JTextArea ispis) {
		this.ispis = ispis;
	}
	public KieSession getSession() {
		return session;
	}
	public void setSession(KieSession session) {
		this.session = session;
	}
	
	public Izvestaj(Frame frame, KieSession ksession, boolean mod) {
		super(frame, mod);
		session = ksession;
		setTitle("Izvestaji");
		setSize(900, 600);
		
		moguciZavisniciBtn = new JButton("Zavisniciavisnici");
		hronicnaOboljenjaBtn = new JButton("Hronica oboljenja");
		oslabljenImunitetBtn = new JButton("Pacijenti sa oslabljenim imunitetom");
		ispis = new JTextArea();
		okBtn = new JButton("zatvori");
		ispis.setEditable(false);
		
		this.setLayout(new BorderLayout());
		JPanel upper = new JPanel();
		upper.setLayout(new GridLayout(1, 3));
		upper.add(hronicnaOboljenjaBtn);
		upper.add(oslabljenImunitetBtn);
		upper.add(moguciZavisniciBtn);
		
		add(upper, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane(ispis);
		add(scrollPane, BorderLayout.CENTER);
		add(okBtn, BorderLayout.SOUTH);
		
		setVisible(true);
		
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		hronicnaOboljenjaBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				session.getAgenda().getAgendaGroup("hronicni").setFocus();
				session.insert(ispis);
				session.fireAllRules();
			}
		});
		
		
		moguciZavisniciBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				session.getAgenda().getAgendaGroup("moguciZavisnici").setFocus();
				session.insert(ispis);
				session.fireAllRules();
			}
		});
		
		oslabljenImunitetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				session.getAgenda().getAgendaGroup("osabljeniImunitet").setFocus();
				session.insert(ispis);
				session.fireAllRules();
			}
		});
	}
	
	
	
	
	
}












