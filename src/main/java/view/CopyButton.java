package view;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import helpers.CopyFrase;

public class CopyButton extends JButton {

	private static final long serialVersionUID = 1L;
	private CopyFrase copyFrase;

	public CopyButton(CopyFrase copyFrase) {
		this.copyFrase = copyFrase;
		this.setText(copyFrase.getName());
	}
	
	public void addCopyListener(ActionListener listener) {
		this.addActionListener(listener);
	}
	
	public void copyToClipboard() {
		StringSelection selection = new StringSelection(copyFrase.getFrase());
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(selection, selection);
	    // TODO Add text to quick edit section
	}

}
