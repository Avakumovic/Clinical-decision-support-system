package ljubisa.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

//import com.ljubek.view.DualListBox.RemoveListener;
//import com.ljubek.view.SortedListMod;
//import com.sun.org.apache.xpath.internal.operations.Mod;

public class ListaSimptoma extends JPanel {
	private static final Insets NO_INSETS = new Insets(0, 0, 0, 0);
	private static final String ADD_LABEL = "Dodaj";
	private static final String REMOVE_LABEL = "Ukloni";
	private static final String POSSIBLE_SYM = "Svi simptomi";
	private static final String SELECTED_SYM = "Selektovani simptomi";
	private JLabel possibleLabel;
	private JList possibleList;
	private SortedListMod possibleListModel;
	private JLabel selectedLabel;
	public JList selectedList;
	private SortedListMod selectedListModel;
	private JButton addBtn;
	private JButton removeBtn;
	private JButton printBtn;
	private JButton upitBtn;
	
	public JButton getPrintBtn() {
		return printBtn;
	}

	public void setPrintBtn(JButton printBtn) {
		this.printBtn = printBtn;
	}

	public JButton getUpitBtn() {
		return upitBtn;
	}

	public void setUpitBtn(JButton upitBtn) {
		this.upitBtn = upitBtn;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}

	public JButton getRemoveBtn() {
		return removeBtn;
	}

	public void setRemoveBtn(JButton removeBtn) {
		this.removeBtn = removeBtn;
	}

	public JLabel getPossibleLabel() {
		return possibleLabel;
	}
	
	public void setPossibleLabel(JLabel possibleLabel) {
		this.possibleLabel = possibleLabel;
	}
	
	public JList getPossibleList() {
		return possibleList;
	}
	
	public void setPossibleList(JList possibleList) {
		this.possibleList = possibleList;
	}
	
	public JLabel getSelectedLabel() {
		return selectedLabel;
	}
	
	public void setSelectedLabel(JLabel selectedLabel) {
		this.selectedLabel = selectedLabel;
	}
	
	public JList getSelectedList() {
		return selectedList;
	}
	
	public void setSelectedList(JList selectedList) {
		this.selectedList = selectedList;
	}
	
	public String getPossibleLabelTitle() {
		return possibleLabel.getText();
	}

	public void setPossibleLabelTitle(String title) {
		possibleLabel.setText(title);
	}

	public String getSelectedLabelTitle() {
		return selectedLabel.getText();
	}

	public void setSelectedLabelTitle(String title) {
		selectedLabel.setText(title);
	}
	
	public void clearPossibleListModel() {
		possibleListModel.clearAll();
	}

	public void clearSelectedListModel() {
		selectedListModel.clearAll();
	}
	
	public void addPossibleElements(ListModel lm) {
		fillList(possibleListModel, lm);
	}

	public void setPossibleElements(ListModel lm) {
		clearPossibleListModel();
		addPossibleElements(lm);
	}

	public void addSelectedElements(ListModel lm) {
		fillList(selectedListModel, lm);
	}
	
	public void setSelectedElements(ListModel lm) {
		clearSelectedListModel();
		addSelectedElements(lm);
	}
	
	private void fillList(SortedListMod mod, ListModel lm) {
		int size = lm.getSize();
		for (int i = 0; i < size; i++) {
			mod.addOne(lm.getElementAt(i));
		}
	}
	
	public void addPossibleElements(Object obj[]) {
		fillListModel(possibleListModel, obj);
	}

	public void setPossibleElements(Object obj[]) {
		clearPossibleListModel();
		addPossibleElements(obj);
	}

	public void addSelectedElements(Object obj[]) {
		fillListModel(selectedListModel, obj);
	}
	
	public void setSelectedElements(Object obj[]) {
		clearSelectedListModel();
		addSelectedElements(obj);
	}

	private void fillListModel(SortedListMod mod, Object obj[]) {
		mod.addAll(obj);
	}
	
	public void setPossibleCellRenderer(ListCellRenderer rend) {
		possibleList.setCellRenderer(rend);
	}

	public ListCellRenderer getPossibleCellRenderer() {
		return possibleList.getCellRenderer();
	}

	public void setSelectedCellRenderer(ListCellRenderer rend) {
		selectedList.setCellRenderer(rend);
	}

	public ListCellRenderer getSelectedCellRenderer() {
		return selectedList.getCellRenderer();
	}
	
	public Iterator possibleIterator() {
		return possibleListModel.iterator();
	}

	public Iterator selectedIterator() {
		return selectedListModel.iterator();
	}

	public void setVisibleRowCount(int val) {
		possibleList.setVisibleRowCount(val);
		selectedList.setVisibleRowCount(val);
	}

	public int getVisibleRowCount() {
		return possibleList.getVisibleRowCount();
	}
	
	private void clearPossible() {
		Object obj[] = possibleList.getSelectedValues();
		for (int i = obj.length - 1; i >= 0; --i) {
			possibleListModel.removeEl(obj[i]);
		}
		possibleList.getSelectionModel().clearSelection();
	}

	private void clearSelected() {
		Object obj[] = selectedList.getSelectedValues();
		for (int i = obj.length - 1; i >= 0; --i) {
			selectedListModel.removeEl(obj[i]);
		}
		selectedList.getSelectionModel().clearSelection();
	}
	
	public ListaSimptoma() {
		crate();
	}

	private void crate() {
		// TODO Auto-generated method stub
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new GridBagLayout());
		possibleLabel = new JLabel(POSSIBLE_SYM);
		possibleListModel = new SortedListMod();
		possibleList = new JList(possibleListModel);
		add(possibleLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, NO_INSETS, 0, 0));
		add(new JScrollPane(possibleList), new GridBagConstraints(0, 1, 1, 5, .5, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, NO_INSETS, 0, 0));
		addBtn = new JButton(ADD_LABEL);
		add(addBtn, new GridBagConstraints(1, 2, 1, 2, 0, .25, GridBagConstraints.CENTER, GridBagConstraints.NONE, NO_INSETS, 0, 0));
		addBtn.addActionListener(new AddButtonListener());
		removeBtn = new JButton(REMOVE_LABEL);
		add(removeBtn, new GridBagConstraints(1, 4, 1, 2, 0, .25, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 0, 5), 0, 0));
		removeBtn.addActionListener(new RemoveButtonListener());
		
		printBtn = new JButton("Najverovatnija bolest");
		upitBtn = new JButton("Prikazi moguce bolesti");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		panel.add(printBtn);
		panel.add(upitBtn);
		add(panel);
		
		selectedLabel = new JLabel(SELECTED_SYM);
		selectedListModel = new SortedListMod();
		selectedList = new JList(selectedListModel);
		add(new JScrollPane(selectedList), new GridBagConstraints(2, 1, 1, 5, .5, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, NO_INSETS, 0, 0));
		add(selectedLabel, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, NO_INSETS, 0, 0));
	}
	
	private class AddButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj[] = possibleList.getSelectedValues();
			addSelectedElements(obj);
			clearPossible();
		}
	}

	private class RemoveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj[] = selectedList.getSelectedValues();
			addPossibleElements(obj);
			clearSelected();
		}
	}
}

class SortedListMod extends AbstractListModel {
	
	SortedSet theSet;

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return theSet.toArray()[index];
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return theSet.size();
	}
	
	public SortedListMod() {
		theSet = new TreeSet();
	}
	
	public void addOne(Object e) {
		if(theSet.add(e)) {
			fireContentsChanged(this, 0, getSize());
		}
	}
	
	public void addAll(Object els[]) {
		Collection collection = Arrays.asList(els);
		theSet.addAll(collection);
		fireContentsChanged(this, 0, getSize());
	}
	
	public void clearAll() {
		theSet.clear();
		fireContentsChanged(this, 0, getSize());
	}
	
	public boolean contains(Object e) {
		return theSet.contains(e);
	}
	
	public Object firstEl() {
		return theSet.first();
	}
	
	public Iterator iterator() {
		return theSet.iterator();
	}
	
	public Object last() {
		return theSet.last();
	}
	
	public boolean removeEl(Object e) {
		boolean remove = theSet.remove(e);
		if(remove) {
			fireContentsChanged(this, 0, getSize());
		}
		return remove;
	}
}