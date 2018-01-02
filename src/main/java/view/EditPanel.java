package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditPanel extends JPanel {

	private static final long serialVersionUID = 5L;
	JTextArea frase = new JTextArea(4, 40);
	JButton copyButton = new JButton("Copy");
	JButton clearButton = new JButton("Clear");

	public EditPanel() {
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(450, 150));
		addTextArea();
		addButtons();
	}

	private void addTextArea() {
		JLabel nameLabel = new JLabel("Edit Text:");
		frase.setLineWrap(true);
		frase.setWrapStyleWord(true);
		JScrollPane jScrollPane1 = new JScrollPane(frase);
		this.add(nameLabel);
		this.add(jScrollPane1);
	}

	private void addButtons() {
		addCopyButtonListener();
		this.add(copyButton);
		addClearActionListener();
		this.add(clearButton);
	}

	public void setFrase(String frase) {
		this.frase.setText(frase);
	}

	public void addCopyButtonListener() {
		copyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				copyToClipboard();
			}
		});
	}
	
	public void copyToClipboard() {
		StringSelection selection = new StringSelection(frase.getText());
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(selection, selection);
	}

	private void addClearActionListener() {
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				frase.setText("");
			}
		});
	}
}
