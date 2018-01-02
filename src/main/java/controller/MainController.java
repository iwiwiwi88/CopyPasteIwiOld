package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import helpers.FileService;
import view.CopyButton;
import view.MainView;

public class MainController {

	private MainView view;
	private CopyListener copyListener;
	private AddNewButtonListener addNewButtonListener;
	private OpenFileListener openFileListener;
	private SaveFileListener saveFileListener;
	
	public MainController(MainView view) {
		this.view = view;
		copyListener = new CopyListener();
		addNewButtonListener = new AddNewButtonListener();
		openFileListener = new OpenFileListener();
		saveFileListener = new SaveFileListener();
		
		this.view.addCopyListener(copyListener);
		this.view.addAddNewButtonListener(addNewButtonListener);
		this.view.addOpenFileListener(openFileListener);
		this.view.addSaveFileListener(saveFileListener);
	}

	
	class CopyListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			try {
				CopyButton copyButton = (CopyButton) event.getSource();
				copyButton.copyToClipboard();
				view.getEditPanel().setFrase(copyButton.getFrase());
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
	
	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			FileService.openFile();
		}
	}
	
	class SaveFileListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			FileService.saveCurrentState(view);
		}
	}
}
