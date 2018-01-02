package view;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CopyButton extends JButton {

	private static final long serialVersionUID = 1L;
	private String frase;

	public CopyButton(String name, String frase) {
		this.frase = frase;
		this.setText(name);
	}
	
	public void addCopyListener(ActionListener listener) {
		this.addActionListener(listener);
	}

	public String getFrase() {
		return frase;
	}
	
	public void copyToClipboard() {
		StringSelection selection = new StringSelection(frase);
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(selection, selection);
	}

}
