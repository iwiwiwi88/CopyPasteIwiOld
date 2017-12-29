package controller;

import model.MainModel;
import view.MainView;

public class App {
	public static void main(String[] args) {
		MainModel model = new MainModel();
		MainView view = new MainView();
		MainController controller = new MainController(view, model);

		view.setVisible(true);
	}
}
