package helpers;

import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import view.TabElement;

public class XmlReader {
	public static List<TabElement> readTabsFromFile(String fileName) {
		MyHandler handler = new MyHandler();
		try {
			SAXParserFactory sfactory = SAXParserFactory.newInstance();
			SAXParser parser = sfactory.newSAXParser();

			XMLReader xmlparser = parser.getXMLReader();
			xmlparser.setContentHandler(handler);
			xmlparser.parse(new InputSource(fileName));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return handler.getTabs();
	}

}
