package view;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;

public class TabElement extends JComponent {

	private static final long serialVersionUID = 3L;
	List<CopyButton> buttons = new LinkedList<CopyButton>();

	public void addCopyListener(ActionListener listener) {
		for (CopyButton button : buttons) {
			button.addCopyListener(listener);
		}
	}
}
