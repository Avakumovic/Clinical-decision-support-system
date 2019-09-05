package ljubisa.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import ljubisa.cds.Disanje;
import ljubisa.cds.KolicinaMokrenja;
import ljubisa.cds.OtkucajSrca;
import ljubisa.model.Monitoring;
import ljubisa.model.Pacijent;

public class MonitoringPacijenta extends JDialog {
	private JTextArea ispis;
	private JTextField otkucajiSrca;
	private JTextField kiseonikUkrvi;
	private JButton ubrzajOtkucajeSrca;
	private JButton usporiOtkucajeSrca;
	private JButton uvecajKiseonik;
	private JButton umanjiKiseonik;
	private JButton start;
	private JButton stop;
	private Pacijent pacijent;
	private Monitoring monitoring;
	private KieSession session;
	private Thread the = new Thread();
	private boolean kucaSrce;
	private double n = 2;
	private int trenutniKiseonik = 0;
	
	public JTextArea getIspis() {
		return ispis;
	}
	public void setIspis(JTextArea ispis) {
		this.ispis = ispis;
	}
	public JTextField getOtkucajiSrca() {
		return otkucajiSrca;
	}
	public void setOtkucajiSrca(JTextField otkucajiSrca) {
		this.otkucajiSrca = otkucajiSrca;
	}
	public JTextField getKiseonikUkrvi() {
		return kiseonikUkrvi;
	}
	public void setKiseonikUkrvi(JTextField kiseonikUkrvi) {
		this.kiseonikUkrvi = kiseonikUkrvi;
	}
	public JButton getUbrzajOtkucajeSrca() {
		return ubrzajOtkucajeSrca;
	}
	public void setUbrzajOtkucajeSrca(JButton ubrzajOtkucajeSrca) {
		this.ubrzajOtkucajeSrca = ubrzajOtkucajeSrca;
	}
	public JButton getUsporiOtkucajeSrca() {
		return usporiOtkucajeSrca;
	}
	public void setUsporiOtkucajeSrca(JButton usporiOtkucajeSrca) {
		this.usporiOtkucajeSrca = usporiOtkucajeSrca;
	}
	public JButton getUvecajKiseonik() {
		return uvecajKiseonik;
	}
	public void setUvecajKiseonik(JButton uvecajKiseonik) {
		this.uvecajKiseonik = uvecajKiseonik;
	}
	public JButton getUmanjiKiseonik() {
		return umanjiKiseonik;
	}
	public void setUmanjiKiseonik(JButton umanjiKiseonik) {
		this.umanjiKiseonik = umanjiKiseonik;
	}
	public JButton getStart() {
		return start;
	}
	public void setStart(JButton start) {
		this.start = start;
	}
	public JButton getStop() {
		return stop;
	}
	public void setStop(JButton stop) {
		this.stop = stop;
	}
	public Pacijent getPacijent() {
		return pacijent;
	}
	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}
	public Monitoring getMonitoring() {
		return monitoring;
	}
	public void setMonitoring(Monitoring monitoring) {
		this.monitoring = monitoring;
	}
	public KieSession getSession() {
		return session;
	}
	public void setSession(KieSession session) {
		this.session = session;
	}
	public Thread getThe() {
		return the;
	}
	public void setThe(Thread the) {
		this.the = the;
	}
	public boolean isKucaSrce() {
		return kucaSrce;
	}
	public void setKucaSrce(boolean kucaSrce) {
		this.kucaSrce = kucaSrce;
	}
	public double getN() {
		return n;
	}
	public void setN(double n) {
		this.n = n;
	}
	public int getTrenutniKiseonik() {
		return trenutniKiseonik;
	}
	public void setTrenutniKiseonik(int trenutniKiseonik) {
		this.trenutniKiseonik = trenutniKiseonik;
	}

	public MonitoringPacijenta(Frame frame, Pacijent pac, boolean mod, KieSession ksession) {
		super(frame, "Monitoring", mod);
		pacijent = pac;
		ksession = session;
		create();
	}
	
	private void create() {
		setSize(800, 500);
		setLayout(new GridLayout(2, 1));
		ispis = new JTextArea();
		ispis.setEditable(false);
		otkucajiSrca = new JTextField(50);
		otkucajiSrca.setEditable(false);
		kiseonikUkrvi = new JTextField(50);
		kiseonikUkrvi.setEditable(false);
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		southPanel.setLayout(new BorderLayout());
		
		JScrollPane pane = new JScrollPane(ispis);
		southPanel.add(new JLabel("Informacije "), BorderLayout.NORTH);
		southPanel.add(pane, BorderLayout.CENTER);
		
		stop = new JButton("Stop");
		stop.setEnabled(false);
		ubrzajOtkucajeSrca = new JButton("Ubrzaj otkucaje srca");
		usporiOtkucajeSrca = new JButton("Uspori otkucaje srca");
		uvecajKiseonik = new JButton("Uvecaj kolicinu kiseonika");
		umanjiKiseonik = new JButton("Umanji kolicinu kiseonika");
		ubrzajOtkucajeSrca.setEnabled(false);
		usporiOtkucajeSrca.setEnabled(false);
		uvecajKiseonik.setEnabled(false);
		umanjiKiseonik.setEnabled(false);
		
		start = new JButton();
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				start.setEnabled(false);
				stop.setEnabled(true);
				ubrzajOtkucajeSrca.setEnabled(true);
				usporiOtkucajeSrca.setEnabled(true);
				uvecajKiseonik.setEnabled(true);
				umanjiKiseonik.setEnabled(true);
				
				session.insert(pacijent);
				session.insert(ispis);
				
				the = new Thread() {
					@Override
					public void run() {
						KolicinaMokrenja km = new KolicinaMokrenja(1000);
						session.insert(km);
						while (kucaSrce) {
							OtkucajSrca otkucaj = new OtkucajSrca();
							Disanje disanje = new Disanje(trenutniKiseonik + 75);
							session.insert(otkucaj);
							session.insert(disanje);
							otkucajiSrca.setText(n + "otkucaja u sekundi");
							kiseonikUkrvi.setText((75 + trenutniKiseonik)+ "kiseonika u krvi");
							try {
								int time = (int) Math.round(100/n);
								Thread.sleep(time);
							} catch (InterruptedException ie) {
								
							}
						}
					}
				};
				
				the.setDaemon(true);
				the.start();
				
				Thread the2 = new Thread() {
					@Override
					
					public void run() {
						session.fireUntilHalt();
					}
				};
				
				the2.setDaemon(true);
				the2.start();
			}
		});
		
		usporiOtkucajeSrca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				usporiOtkucajeSrca.setEnabled(true);
				ubrzajOtkucajeSrca.setEnabled(true);
				if (n == 1) {
					usporiOtkucajeSrca.setEnabled(false);
				}
			}
		});
		
		uvecajKiseonik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				trenutniKiseonik += 5;
			}
		});
		
		
		umanjiKiseonik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				trenutniKiseonik -= 5;
			}
		});
		
		JPanel newpanel = new JPanel();
		newpanel.setLayout(new GridLayout(4, 2));
		newpanel.add(start);
		newpanel.add(stop);
		newpanel.add(umanjiKiseonik);
		newpanel.add(uvecajKiseonik);
		newpanel.add(usporiOtkucajeSrca);
		newpanel.add(ubrzajOtkucajeSrca);
		newpanel.add(kiseonikUkrvi);
		newpanel.add(otkucajiSrca);
		
		northPanel.add(newpanel, BorderLayout.CENTER);
		add(northPanel);
		add(southPanel);
		
		setVisible(true);
	}
	
	public void stopThread() throws Exception {
		if(the.isAlive()) {
			the.stop();
		}
		session.halt();
	}
	
	public void deleteAll() {
		if (session.getFactHandles().isEmpty()) {
			for (FactHandle factHandle : session.getFactHandles()) {
				session.delete(factHandle);
			}
		}
		session.halt();
	}
}