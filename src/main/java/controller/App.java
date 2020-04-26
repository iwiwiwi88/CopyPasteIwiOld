package controller;

import view.MainView;

public class App {
	public static void main(String[] args) {
		MainView view = new MainView();
		MainController controller = new MainController(view);
		view.setVisible(true);
	}
}