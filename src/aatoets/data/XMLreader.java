package aatoets.data;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLreader {


    private Document doc;

    public XMLreader(String filePath) {

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbbuilder = dbfactory.newDocumentBuilder();
            this.doc = dbbuilder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getByTag() {
        List<String[]> tagList = new ArrayList<>();
        NodeList nList = this.doc.getElementsByTagName("aminozuur");
        for (int i = 0; i < nList.getLength(); i++){
            Node nNode = nList.item(i);
            String[] sa;

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) (nNode);
                sa = new String[] {eElement.getAttribute("id"),
                                   eElement.getElementsByTagName("code-1").item(0).getTextContent(),
                                   eElement.getElementsByTagName("code-3").item(0).getTextContent(),
                                   eElement.getElementsByTagName("hydrofobiciteit").item(0).getTextContent(),
                                   eElement.getElementsByTagName("lading").item(0).getTextContent(),
                                   eElement.getElementsByTagName("grootte").item(0).getTextContent(),
                                   eElement.getElementsByTagName("structuur3d").item(0).getTextContent()};
                tagList.add(sa);
            }
        }
        return tagList;
    }

}
