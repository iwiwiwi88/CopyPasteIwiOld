package view;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabsPanel extends JTabbedPane {

	private static final long serialVersionUID = 6L;
	private TabElement plusTab = new TabElement("+");

	public TabsPanel() {
		this.add(plusTab.getName(), plusTab);
		//addPlusTabListener();
	}

	public void addTab(String tabName) {
		TabElement tab = new TabElement(tabName);
		addTab(tab);
	}

	public void addTab(TabElement tab) {
		if (this.getTabCount() == 0) {
			this.add(tab);
			this.add(plusTab.getName(), plusTab);
		} else {
			this.add(tab, this.getTabCount() - 1);
		}
		this.setSelectedIndex(this.getTabCount() - 2);
	}

	public void addCopyListener(ActionListener listener) {
		for (TabElement tab : getTabs()) {
			tab.addCopyListener(listener);
		}
	}

	public void addPlusTabListener() {
		final TabsPanel tabPane = this;
		tabPane.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				if (tabPane.getSelectedComponent().getName().equals("+")) {
					String tabName = JOptionPane
							.showInputDialog("New Tab Name:");
					if (!tabName.trim().equals("")) {
						// tabPane.addTab(tabName);
					}
				}
			}
		});
	}

	public void addButtonToTheTab(CopyButton button, ActionListener listener) {
		TabElement selectedTab = (TabElement) this.getSelectedComponent();
		selectedTab.addButton(button);
		button.addActionListener(listener);
		this.repaint();
	}

	public List<TabElement> getTabs() {
		List<TabElement> tabs = new LinkedList<TabElement>();
		for (Component tab : Arrays.asList(this.getComponents())) {
			tabs.add((TabElement) tab);
		}
		return tabs;
	}

}
