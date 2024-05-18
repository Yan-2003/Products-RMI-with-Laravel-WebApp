import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLParser extends DOM {


    public NodeList parse(){
        try{
            File xmlFile = new File(super.filename);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            super.list = doc.getElementsByTagName("product");

            return super.list;

        } catch (Exception e) {
           System.out.println(e);
        }

        return null;
    }


    



    
}
