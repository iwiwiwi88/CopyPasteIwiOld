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
	private PinWindowListener pinWindowListener;

	public MainController(MainView view) {
		this.view = view;
		createListeners();
		addListeners();
	}

	private void createListeners() {
		copyListener = new CopyListener();
		addNewButtonListener = new AddNewButtonListener();
		openFileListener = new OpenFileListener();
		saveFileListener = new SaveFileListener();
		pinWindowListener = new PinWindowListener();
	}

	private void addListeners() {
		this.view.addCopyListener(copyListener);
		this.view.addAddNewButtonListener(addNewButtonListener);
		this.view.addOpenFileListener(openFileListener);
		this.view.addSaveFileListener(saveFileListener);
		this.view.addPinWindowListener(pinWindowListener);
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
			CopyButton button = new CopyButton(
					view.getNewButtonPanel().getNewButtonName().getText(),
					view.getNewButtonPanel().getNewButtonFrase().getText());
			view.getTabsPanel().addButtonToTheTab(button, copyListener);
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


	class PinWindowListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			view.pinWindow();
		}
	}
}
