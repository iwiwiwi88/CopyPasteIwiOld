package helpers;

import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import view.CopyButton;
import view.TabElement;
import view.TabsPanel;

public class XmlWriter {

	public static void writeToXmlFile(TabsPanel tabs, String fileName) {
		try {
			Element tabsPanel = new Element("tabsPanel");
			Document doc = new Document(tabsPanel);
			addTabElements(tabs, doc);

			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(fileName));
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

	private static void addTabElements(TabsPanel tabs, Document doc) {
		for (TabElement tabElement : tabs.getTabs()) {
			if (!tabElement.getName().equals("+")) {
				Element tab = new Element("tabElement");
				tab.setAttribute(
						new Attribute("tabName", tabElement.getName()));
				addButtons(tabElement, tab);
				doc.getRootElement().addContent(tab);
			}
		}
	}

	private static void addButtons(TabElement tabElement, Element tab) {
		for (CopyButton copyButton : tabElement.getButtons()) {
			Element button = new Element("button");
			button.setAttribute("name", copyButton.getText());
			button.setText(copyButton.getFrase());
			tab.addContent(button);
		}
	}
}
