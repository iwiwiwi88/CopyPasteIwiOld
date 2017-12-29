package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MainModel;
import view.MainView;

public class MainController {

	private MainView view;
	private MainModel model;
	
	public MainController(MainView view, MainModel model) {
		this.view = view;
		this.model = model;
		
		this.view.addCopyListener((ActionListener) new CopyListener());
	}

	
	class CopyListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
		}

	}
}
