package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class TabsPanel extends JPanel {

	private static final long serialVersionUID = 6L;
	List<TabElement> tabs = new LinkedList<TabElement>();
	

	public TabsPanel() {
		this.setBackground(Color.green);
	}
	
	public void addCopyListener(ActionListener listener) {
		for (TabElement tab : tabs) {
			tab.addCopyListener(listener);
		}
	}

	

}
