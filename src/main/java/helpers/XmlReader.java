package helpers;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import view.TabsPanel;

public class XmlReader {
	public static void readTabsFromFile(TabsPanel tabs, String fileName) {
		try {
			System.out.println("filename: "+fileName);
			SAXParserFactory sfactory = SAXParserFactory.newInstance();
			SAXParser parser = sfactory.newSAXParser();
			XMLReader xmlparser = parser.getXMLReader();
			xmlparser.setContentHandler(new DefaultHandler());
			xmlparser.parse(new InputSource(fileName));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
