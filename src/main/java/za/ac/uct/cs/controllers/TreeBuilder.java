/// TODO: DOCUMENTATION
package za.ac.uct.cs.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import za.ac.uct.cs.models.DecisionNode;

public class TreeBuilder{
    // make everything static?
    // think about how to indicate that an early stop is possible...
    private DecisionNode root;
    private boolean builtTree = false;
        
    private static final String BFO_2_0_DEFAULT_PATH = "src/main/resources/za/ac/uct/cs/xml/BFO_2_0_decision_tree.xml";

    public static void buildTree(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // Process XML securely, avoid attacks like XML External Entites (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // Parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(BFO_2_0_DEFAULT_PATH));

            // Normalise XML file elements
            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            
            // Get <branch>
            NodeList branch_list = doc.getElementsByTagName("branch");
            
            List<Element> element_list = new ArrayList<Element>();
            
            for(int i = 0; i < branch_list.getLength(); i++){
                Node node = branch_list.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    
                    element_list.add((Element)node);
                }
            }
            
            printElementList(element_list);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TreeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TreeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TreeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private static void printElementList(List<Element> element_list)
    {
        for (Element element: element_list)
        {
            System.out.println("Element Name: " + element.getElementsByTagName("concept").item(0).getTextContent());
        }
    }

    public DecisionNode getRoot(){
            if (!this.builtTree) { return null; }
            return this.root;
    }

    private class DecisionTreeXMLHandler{
            //private bool tree = false; // check if true before making any nodes
            //private bool title = false; // skip (or display)
            //private bool description = false; // skip (or display)
            //private bool branch = false; // new decision node
            //private bool content = false; // question (+ maybe example text)
            //private bool fork = false; // options
            //private bool concept = false; // axiom

            //...
    }

    // Main method to tests, remove when done
    public static void main(String args[]) 
    {
        buildTree();
    }
}