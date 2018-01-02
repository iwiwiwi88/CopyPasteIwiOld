package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CopyButton;
import view.MainView;

public class MainController {

	private MainView view;
	private CopyListener copyListener;
	private AddNewButtonListener addNewButtonListener;
	
	public MainController(MainView view) {
		this.view = view;
		copyListener = new CopyListener();
		addNewButtonListener = new AddNewButtonListener();
		
		this.view.addCopyListener(copyListener);
		this.view.addAddNewButtonListener(addNewButtonListener);
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
