package view;

import java.awt.*;
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
		this.setSize(600, 600);
		addGrid();
	}

	private void addGrid() {
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3,1));
		container.add(newButtonPanel);
		container.add(tabsPanel);
		container.add(editPanel);
	}
	
	public void addCopyListener(ActionListener listener) {
		tabsPanel.addCopyListener(listener);
	}

	public void showErrorMsg(String errorMsg) {
		JOptionPane.showMessageDialog(this, errorMsg);
	}

}
