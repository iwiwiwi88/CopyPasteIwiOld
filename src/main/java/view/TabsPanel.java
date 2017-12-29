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
		this.add("Tab 1", new TabElement());
		this.add("Tab 2", new TabElement());
	}
	
	public void addCopyListener(ActionListener listener) {
		for (TabElement tab : getTabs()) {
			tab.addCopyListener(listener);
		}
	}

	public List<TabElement> getTabs() {
		List<TabElement> tabs = new LinkedList<TabElement>();
		for (Component tab : Arrays.asList(this.getComponents())) {
			tabs.add((TabElement) tab);
		}
		return tabs;
	}

	

}
