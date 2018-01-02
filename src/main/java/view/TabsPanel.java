package view;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTabbedPane;

public class TabsPanel extends JTabbedPane {

	private static final long serialVersionUID = 6L;
	
	public TabsPanel() {
		TabElement tab1 = new TabElement("Tab 1");
		this.add(tab1.getName(), tab1);
	}
	
	public void addCopyListener(ActionListener listener) {
		for (TabElement tab : getTabs()) {
			tab.addCopyListener(listener);
		}
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
