package ljubisa.view;

import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TrenutnoStanje extends JPanel {
	private static TrenutnoStanje instance = null;
	private JCheckBox pritisak;
	private JCheckBox oporavak;
	private JPanel panel;
	private Temperatura temp;
	
	public static TrenutnoStanje getInstance() {
		if (instance == null) {
			instance = new TrenutnoStanje();
		}
		return instance;
	}
	
	class Temperatura extends JPanel {
		private JTextField text;
		private JLabel label;
		public Temperatura(String str) {
			text = new JTextField(4);
			label = new JLabel(str);
			setLayout(new GridLayout(2,1));
			add(text);
			add(label);
		}
		
		public JTextField getText() {
			return text;
		}
		
		public void setText(JTextField text) {
			this.text = text;
		}
		
		public JLabel getLabel() {
			return label;
		}
		
		public void setLabel(JLabel label) {
			this.label = label;
		}
	}
	
	public JCheckBox getPritisak() {
		return pritisak;
	}
	
	public void setPritisak(JCheckBox pritisak) {
		this.pritisak = pritisak;
	}
	
	public JCheckBox getOporavak() {
		return oporavak;
	}
	
	public void setOproavak(JCheckBox oporavak) {
		this.oporavak = oporavak;
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	private TrenutnoStanje() {
		create();
	}
	
	private void create() {
		setSize(300,300);
		temp = new Temperatura("Temperatura");
		pritisak = new JCheckBox("Visok pritisak");
		oporavak = new JCheckBox("Oporavlja se od operacije");
		panel = new JPanel();
		panel.add(temp);
		panel.add(pritisak);
		panel.add(oporavak);
		add(panel);
		setVisible(true);
	}
}




