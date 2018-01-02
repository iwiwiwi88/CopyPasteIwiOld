package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class TabElement extends JPanel {

	private static final long serialVersionUID = 3L;
	List<CopyButton> buttons = new LinkedList<CopyButton>();
	
	public TabElement(String name) {
		this.setName(name);
		this.setLayout(new GridLayout(3,3));
		this.add(new CopyButton("Iwi", "Iwiwiwi was here!"));
		this.add(new CopyButton("Iwi2", "Iwiwiwi2 was here!"));
		this.add(new CopyButton("Iwi", "Iwiwiwi was here!"));
		this.add(new CopyButton("Iwi2", "Iwiwiwi2 was here!"));
		this.add(new CopyButton("Iwi", "Iwiwiwi was here!"));
		this.add(new CopyButton("Iwi2", "Iwiwiwi2 was here!"));
	}

	public List<CopyButton> getButtons() {
		return buttons;
	}

	public void addCopyListener(ActionListener listener) {
		for (CopyButton button : buttons) {
			button.addCopyListener(listener);
		}
	}
}
