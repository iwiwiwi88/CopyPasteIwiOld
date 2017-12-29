package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTabbedPane;

public class TabsPanel extends JTabbedPane {

	private static final long serialVersionUID = 6L;
	List<TabElement> tabs = new LinkedList<TabElement>();
	
	public TabsPanel() {
		this.setBackground(Color.green);
		this.add("Tab 1", new TabElement());
		this.add("Tab 2", new TabElement());
	}
	
	public void addCopyListener(ActionListener listener) {
		for (TabElement tab : tabs) {
			tab.addCopyListener(listener);
		}
	}

	

}
