package view;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ribbon extends JMenuBar {

	private static final long serialVersionUID = 7L;
	JMenu fileMenu = new JMenu("File");
	JMenuItem open = new JMenuItem("Open");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem exit = new JMenuItem("Exit");
	JMenu toolsMenu = new JMenu("Tools");
	JMenuItem settings = new JMenuItem("Settings");
	JMenu helpMenu = new JMenu("Help");
	JMenuItem about = new JMenuItem("About");
	JMenuItem help = new JMenuItem("Help");
	JMenu tabMenu = new JMenu("Tabs");
	ImageIcon pinIcon = new ImageIcon("images/pin.png");
	ImageIcon unpinIcon = new ImageIcon("images/unpin.png");
	JMenuItem iconItem = new JMenuItem();

	public Ribbon() {
		addFileMenu();
		tabMenu.setEnabled(false);
		this.add(tabMenu);
		addToolsMenu();
		addHelpMenu();
		addPin(true);
	}

	public void addOpenFileMenuListener(ActionListener listener) {
		open.addActionListener(listener);
	}

	public void addSaveFileMenuListener(ActionListener listener) {
		save.addActionListener(listener);
	}

	public void addPinWindowListener(ActionListener listener) {
		iconItem.addActionListener(listener);
	}

	private void addFileMenu() {
		this.add(fileMenu);
		fileMenu.add(open);
		fileMenu.add(save);
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

	public void addPin(boolean isPinned) {
		setPin(isPinned);
		iconItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		this.add(iconItem);
	}

	public void setPin(boolean isPinned) {
		if (isPinned) {
			iconItem.setIcon(pinIcon);
		} else {
			iconItem.setIcon(unpinIcon);
		}
	}

}
