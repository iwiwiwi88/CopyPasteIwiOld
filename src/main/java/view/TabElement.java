package view;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class TabElement extends Component {

	private static final long serialVersionUID = 3L;
	List<CopyButton> buttons = new LinkedList<CopyButton>();

	public void addCopyListener(ActionListener listener) {
		for (CopyButton button : buttons) {
			button.addCopyListener(listener);
		}
	}
}
