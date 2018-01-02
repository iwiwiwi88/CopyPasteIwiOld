package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CopyButton;
import view.MainView;

public class MainController {

	private MainView view;
	
	public MainController(MainView view) {
		this.view = view;
		
		this.view.addCopyListener((ActionListener) new CopyListener());
		this.view.addCopyListener((ActionListener) new AddNewButtonListener());
	}

	
	class CopyListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			try {
				CopyButton cb = (CopyButton) event.getSource();
				cb.copyToClipboard();
				view.getEditPanel().setFrase(cb.getCopyFrase().getFrase());
			} catch (Exception e) {
				view.showErrorMsg(e.getMessage());
			}
		}

	}
	
	class AddNewButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			// TODO Add new Button - add implementation
		}

	}
}
