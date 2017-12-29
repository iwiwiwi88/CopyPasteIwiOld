package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

public class Ribbon extends JMenuBar {

	private static final long serialVersionUID = 7L;
	JMenu fileMenu = new JMenu("File");
	JMenuItem open = new JMenuItem("Open");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem saveAs = new JMenuItem("Save as...");
	JMenuItem exit = new JMenuItem("Exit");
	JMenu toolsMenu = new JMenu("Tools");
	JMenuItem settings = new JMenuItem("Settings");
	JMenu helpMenu = new JMenu("Help");
	JMenuItem about = new JMenuItem("About");
	JMenuItem help = new JMenuItem("Help");
	JMenu tabMenu = new JMenu("Tabs");

	public Ribbon() {
		addFileMenu();
		tabMenu.setEnabled(false);
		this.add(tabMenu);
		addToolsMenu();
		addHelpMenu();
	}

	private void addFileMenu() {
		this.add(fileMenu);
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(saveAs);
		fileMenu.addSeparator();
		addExitMenuItem();
	}

	private void addExitMenuItem() {
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.exit(0);
			}
		});
		fileMenu.add(exit);
	}

	private void addToolsMenu() {
		this.add(toolsMenu);
		toolsMenu.add(settings);
	}

	private void addHelpMenu() {
		this.add(helpMenu);
		helpMenu.add(about);
		helpMenu.add(help);
	}

	public void addTabsToTheTabMenu(JTabbedPane tabPane) {
		if (tabPane.getTabCount() > 0)
			tabMenu.setEnabled(true);
		for (int i = 0; i < tabPane.getTabCount(); i++) {
			String title = tabPane.getTitleAt(i);
			tabMenu.add(new JCheckBoxMenuItem(title));
		}
	}

}
