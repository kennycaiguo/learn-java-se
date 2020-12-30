package dom4j_write_xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class dom4jwiriteDemo2 {
    public static void main(String[] args) throws Exception {
    	SAXReader reader=new SAXReader();
    	Document doc=reader.read(new File("src/contact.xml"));
    	Element rootEl=doc.getRootElement();
    	Element element = rootEl.element("contact");
    	Element element2 = element.element("name");
    	element2.setText("May");
    	
		FileOutputStream fos=new FileOutputStream("e:/contact.xml");
		XMLWriter writer=new XMLWriter(fos);
		writer.write(doc);
		writer.close();
	}
}
