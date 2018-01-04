package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import helpers.FileService;
import view.CopyButton;
import view.MainView;

public class MainController {

	private MainView view;
	private FileService fileService = new FileService();
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

	public void addListeners() {
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
			String name = view.getNewButtonPanel().getNewButtonName().getText();
			String frase = view.getNewButtonPanel().getNewButtonFrase()
					.getText();
			if (!name.equals("") & !frase.equals("")) {
				CopyButton button = new CopyButton(name, frase);
				view.getTabsPanel().addButtonToTheTab(button, copyListener);
			} else {
				JOptionPane.showMessageDialog(view,
						"Both fields ('New Button's Text' and 'Text To Be Copied') should contain text!",
						"Add A New Button - Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}


	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			RepaintController.repaintTabs(view,
					fileService.openFileAndGetTabsList(view));
			view.addCopyListener(copyListener);
		}
	}


	class SaveFileListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			fileService.saveCurrentState(view);
		}
	}


	class PinWindowListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			view.pinWindow();
		}
	}
}
