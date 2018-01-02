package helpers;

import java.awt.FileDialog;
import java.io.File;
import view.MainView;

public class FileService {

	public static void openFile() {
		// TODO Auto-generated method stub
		
	}

	public static void saveCurrentState(MainView view) {
		FileDialog fDialog = new FileDialog(view, "Save", FileDialog.SAVE);
        fDialog.setVisible(true);
        String path = fDialog.getDirectory() + fDialog.getFile();
        File f = new File(path);
		XmlWriter.writeToXmlFile(view.getTabsPanel(), f.getPath());
	}

}
