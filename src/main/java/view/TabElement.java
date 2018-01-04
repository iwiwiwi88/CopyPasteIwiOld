package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class TabElement extends JPanel {

	private static final long serialVersionUID = 3L;
	
	public TabElement(String name) {
		this.setName(name);
		this.setLayout(new GridLayout(3,3,20,20));
	}
	
	public void addButton(CopyButton button) {
		this.add(button);
	}
	
	public List<CopyButton> getButtons() {
		List<CopyButton> buttons = new LinkedList<CopyButton>();
		for (Component button : Arrays.asList(this.getComponents())) {
			buttons.add((CopyButton) button);
		}
		return buttons;
	}

	public void addCopyListener(ActionListener listener) {
		for (CopyButton button : getButtons()) {
			button.addCopyListener(listener);
		}
	}
}
