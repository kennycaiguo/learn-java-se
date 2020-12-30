package dom4jHml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Dom4jHtmlDemo {
   public static void main(String[] args) throws Exception {
	     SAXReader saxReader = new SAXReader();
	     Document doc=saxReader.read(new File("src/user.html"));
	    // System.out.println(doc);
	     String xpath=null;
	     xpath="//tr[@id]";
	     List<Element> list = doc.selectNodes(xpath);
	    // System.out.println(list);
	     StringBuilder sb=new StringBuilder();
	     for (Element e : list) {
        	    //  System.out.println(e.getStringValue());
	    	       List<Element> list1=e.elements();
	    	       for (Element el : list1) {
					sb.append(el.getStringValue()+":");
				}
	    	       sb.append("\r\n");
			  }
	     System.out.println(sb.toString());
		}
	      
  }

