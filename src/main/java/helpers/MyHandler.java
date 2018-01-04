package helpers;

import java.util.LinkedList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import view.CopyButton;
import view.TabElement;

public class MyHandler extends DefaultHandler {
	List<TabElement> tabs = new LinkedList<TabElement>();
	TabElement tabElement = null;
	CopyButton copyButton = null;
	boolean bButton = false;
	boolean bTab = false;

	public List<TabElement> getTabs() {
		return tabs;
	}
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("tabelement")) {
			String tabName = attributes.getValue("tabName");
			tabElement = new TabElement(tabName);
			bTab = true;
		} else if (qName.equalsIgnoreCase("button")) {
			copyButton = new CopyButton(attributes.getValue("name"),"");
			bButton = true;
		}

	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if (qName.equalsIgnoreCase("tabelement")) {
			tabs.add(tabElement);
		} else if (qName.equalsIgnoreCase("button")) {
			tabElement.add(copyButton);
		}

	}

	public void characters(char ch[], int start, int length)
			throws SAXException {

		if (bButton) {
			copyButton.setFrase(new String(ch, start, length));
			bButton = false;
		}
	}
}
