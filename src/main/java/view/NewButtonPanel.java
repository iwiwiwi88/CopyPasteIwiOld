package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewButtonPanel extends JPanel {

	private static final long serialVersionUID = 4L;
	JTextField newButtonName = new JTextField(20);
	JTextArea newButtonFrase = new JTextArea(4, 40);
	JButton addButton = new JButton("Add");
	JButton clearButton = new JButton("Clear");

	public NewButtonPanel() {
		this.setLayout(new FlowLayout());
		addNameField();
		addButtons();
		addTextArea();
		this.setPreferredSize(new Dimension(450, 150));
	}

	private void addNameField() {
		JLabel nameLabel = new JLabel("New Button's Text:");
		this.add(nameLabel);
		this.add(newButtonName);
	}

	private void addTextArea() {
		JLabel nameLabel = new JLabel("Text To Be Copied:");
		newButtonFrase.setLineWrap(true);
		newButtonFrase.setWrapStyleWord(true);
		JScrollPane jScrollPane1 = new JScrollPane(newButtonFrase);
		this.add(nameLabel);
		this.add(jScrollPane1);
	}

	private void addButtons() {
		this.add(addButton);
		addClearActionListener();
		this.add(clearButton);
	}

	public void addAddButtonListener(ActionListener listener) {
		addButton.addActionListener(listener);
	}

	private void addClearActionListener() {
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				newButtonName.setText("");
				newButtonFrase.setText("");
			}
		});
	}

}
