package helpers;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.MainView;

public class FileService {

	public static void openFile(MainView view) {
		JFileChooser openDialog = new JFileChooser();
		openDialog.setDialogType(JFileChooser.OPEN_DIALOG);
		openDialog
				.setFileFilter(new FileNameExtensionFilter("xml file", "xml"));
		openDialog.setVisible(true);

		if (openDialog.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
			String fileName = openDialog.getSelectedFile().toString();
			fileName = addXmlIfNeeded(fileName);
			XmlReader.readTabsFromFile(view.getTabsPanel(), fileName);
		}
	}

	public static void saveCurrentState(MainView view) {
		JFileChooser saveDialog = new JFileChooser();
		saveDialog.setDialogType(JFileChooser.SAVE_DIALOG);
		saveDialog
				.setFileFilter(new FileNameExtensionFilter("xml file", "xml"));
		saveDialog.setVisible(true);

		if (saveDialog.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
			String fileName = saveDialog.getSelectedFile().toString();
			fileName = addXmlIfNeeded(fileName);
			XmlWriter.writeToXmlFile(view.getTabsPanel(), fileName);
		}
	}

	private static String addXmlIfNeeded(String fileName) {
		if (!fileName.endsWith(".xml"))
			fileName += ".xml";
		return fileName;
	}

}
