package view;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewButtonPanel extends JPanel {

	private static final long serialVersionUID = 4L;
	JTextField buttonName = new JTextField(20);
	JTextField buttonFrase = new JTextField(200);
	JButton addButton = new JButton("Add");
	JButton clearButton = new JButton("Clear");

	public NewButtonPanel() {
		this.setLayout(new FlowLayout());

		this.add(buttonName);
		addButtons();
		this.add(buttonFrase);
	}

	private void addButtons() {
		this.add(addButton);
		this.add(clearButton);
	}
	
	
}
