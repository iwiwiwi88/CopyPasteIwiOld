package controller;

import java.util.List;
import view.*;

public class RepaintController {
	public static void repaintTabs(MainView view, List<TabElement> tabs) {
		TabsPanel panel = view.getTabsPanel();
		panel.removeAll();
		addTabs(panel, tabs);
		view.repaint();
	}

	private static void addTabs(TabsPanel panel, List<TabElement> tabs) {
		for (TabElement tab : tabs) {
			panel.add(tab.getName(), tab);
		}
	}
}
