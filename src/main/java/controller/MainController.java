package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainView;

public class MainController {

	private MainView view;
	
	public MainController(MainView view) {
		this.view = view;
		
		this.view.addCopyListener((ActionListener) new CopyListener());
		this.view.addCopyListener((ActionListener) new AddButtonListener());
	}

	
	class CopyListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			// TODO copy listener - add implementations
		}

	}
	
	class AddButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			// TODO Add new Button - add implementation
		}

	}
}
