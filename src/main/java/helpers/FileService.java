package helpers;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.MainView;
import view.TabElement;

public class FileService {
	private final String LAST_USED_FOLDER = "LastUsedFolder";
	Preferences prefs = Preferences.userRoot().node(this.getClass().getName());

	public List<TabElement> openFileAndGetTabsList(MainView view) {
		JFileChooser openDialog = new JFileChooser(
				prefs.get(LAST_USED_FOLDER, new File(".").getAbsolutePath()));
		List<TabElement> tabs = new LinkedList<TabElement>();
		openDialog.setDialogType(JFileChooser.OPEN_DIALOG);
		openDialog
				.setFileFilter(new FileNameExtensionFilter("xml file", "xml"));
		openDialog.setVisible(true);

		if (openDialog.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
			prefs.put(LAST_USED_FOLDER,
					openDialog.getSelectedFile().getParent());
			String fileName = openDialog.getSelectedFile().toString();
			fileName = addXmlIfNeeded(fileName);
			tabs = XmlReader.readTabsFromFile(fileName);
		}
		return tabs;
	}

	public void saveCurrentState(MainView view) {
		JFileChooser saveDialog = new JFileChooser(
				prefs.get(LAST_USED_FOLDER, new File(".").getAbsolutePath()));
		saveDialog.setDialogType(JFileChooser.SAVE_DIALOG);
		saveDialog
				.setFileFilter(new FileNameExtensionFilter("xml file", "xml"));
		saveDialog.setVisible(true);

		if (saveDialog.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
			prefs.put(LAST_USED_FOLDER,
					saveDialog.getSelectedFile().getParent());
			String fileName = saveDialog.getSelectedFile().toString();
			fileName = addXmlIfNeeded(fileName);
			XmlWriter.writeToXmlFile(view.getTabsPanel(), fileName);
		}
	}

	private String addXmlIfNeeded(String fileName) {
		if (!fileName.endsWith(".xml"))
			fileName += ".xml";
		return fileName;
	}

}
