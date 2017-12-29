package view;

import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.CopyFrase;

public class MainView extends JFrame {

	private static final long serialVersionUID = 2L;

	JLabel test = new JLabel("Test Iwiwiwi");
	CopyButton button = new CopyButton(new CopyFrase("Iwi", "iwiwiwi"));

	public MainView() throws HeadlessException {
		this.setTitle("CopyPasteIwi");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		JPanel tabPanel = new JPanel();
		tabPanel.add(test);
		tabPanel.add(button);
		this.add(tabPanel);
	}

	// TODO clean it after testing it
	public String getTestValue() {
		return test.getText();
	}
	
	public void addCopyListener(ActionListener listener) {
		button.addCopyListener(listener);
	}

	public void showErrorMsg(String errorMsg) {
		JOptionPane.showMessageDialog(this, errorMsg);
	}

}
