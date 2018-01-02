package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainView extends JFrame {

	private static final long serialVersionUID = 2L;
	Ribbon menu = new Ribbon();
	NewButtonPanel newButtonPanel = new NewButtonPanel();
	TabsPanel tabsPanel = new TabsPanel();
	EditPanel editPanel = new EditPanel();

	public MainView() throws HeadlessException {
		this.setTitle("CopyPasteIwi");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize();
		addMenuBar();
		addGrid();
	}

	private void setSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getMaximumWindowBounds();
		int taskBarHeight = screenSize.height - winSize.height;
		int windowWidth = 500;
		this.setSize(windowWidth, screenSize.height - taskBarHeight);
		this.setLocation(screenSize.width - windowWidth, 0);
	}

	private void addMenuBar() {
		menu.addTabsToTheTabMenu(tabsPanel);
		this.setJMenuBar(menu);
	}

	private void addGrid() {
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(newButtonPanel, BorderLayout.NORTH);
		container.add(tabsPanel);
		container.add(editPanel, BorderLayout.SOUTH);
	}

	public Ribbon getMenu() {
		return menu;
	}

	public TabsPanel getTabsPanel() {
		return tabsPanel;
	}

	public EditPanel getEditPanel() {
		return editPanel;
	}
	
	public NewButtonPanel getNewButtonPanel() {
		return newButtonPanel;
	}

	public void addCopyListener(ActionListener listener) {
		tabsPanel.addCopyListener(listener);
	}

	public void addAddNewButtonListener(ActionListener listener) {
		newButtonPanel.addAddNewButtonListener(listener);
	}

	public void showErrorMsg(String errorMsg) {
		JOptionPane.showMessageDialog(this, errorMsg);
	}

	public void addOpenFileListener(ActionListener listener) {
		menu.addOpenFileMenuListener(listener);
	}

	public void addSaveFileListener(ActionListener listener) {
		menu.addSaveFileMenuListener(listener);
	}

}
