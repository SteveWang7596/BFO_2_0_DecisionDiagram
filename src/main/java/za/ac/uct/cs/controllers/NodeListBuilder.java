/// TODO: DOCUMENTATION
package za.ac.uct.cs.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import za.ac.uct.cs.models.Decision;
import za.ac.uct.cs.models.DecisionNode;

public class NodeListBuilder{
        
    private static final String BFO_2_0_DEFAULT_PATH = "src/main/resources/za/ac/uct/cs/xml/BFO_2_0_decision_tree.xml";

    public static Map<String, DecisionNode> buildNodeList(){
        return buildNodeList(null);
    }
    
    public static Map<String, DecisionNode> buildNodeList(String XML_file_path){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // Process XML securely, avoid attacks like XML External Entites (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // Parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            // Determine XML file path
            String file_path = XML_file_path == null ? BFO_2_0_DEFAULT_PATH : XML_file_path;

            Document doc = db.parse(new File(file_path));

            // Normalise XML file elements
            doc.getDocumentElement().normalize();
            
            // Get <branch>
            NodeList branch_list = doc.getElementsByTagName("branch");
            
            // Construct a mapping of NodeId to Node
            Map<String, DecisionNode> NodeList = InitaliseNodeList(branch_list);
            
            printNodeMapping(NodeList);
            
            return NodeList;
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(NodeListBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static Map<String,DecisionNode> InitaliseNodeList(NodeList branch_list){
        Map<String, DecisionNode> NodeMap = new HashMap<String, DecisionNode>();
        
        for(int i=0; i<branch_list.getLength(); i++ ){
            Node node = branch_list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element node_element = (Element) node;
                String node_id = getBranchId(node_element);
                System.out.println("initialising node : " + node_id);
                DecisionNode decisionNode = new DecisionNode(node_id, getDecision(node_element));
                NodeMap.put(node_id, decisionNode);
            }
        }
        
        return NodeMap;
    }
    
    private static String getBranchId(Element element){
        return element.getAttributes().getNamedItem(XMLTag.ID).getTextContent();
    }
    
    private static String getConceptName(Element element){
        NodeList list = element.getElementsByTagName(XMLTag.CONCEPT);
        
        if (list.item(0) == null)
            return null;
        else
            return list.item(0).getTextContent();
    }
    
    private static boolean isLeafNode(Element element){
        NodeList fork_list = element.getElementsByTagName(XMLTag.FORK);
        return fork_list.getLength() == 0;
    }
    
    private static List<String> getChildrenIds (Element element){
        List<String> childrenId = new ArrayList<String>();
        
        NodeList forkList = element.getElementsByTagName(XMLTag.FORK);
        for (int i=0; i<forkList.getLength(); i++){
            Node node = forkList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element fork_element = (Element)node;
                String target_id = fork_element.getAttributes().getNamedItem(XMLTag.TRAGET).getTextContent();
                childrenId.add(target_id);
            }
        }
        return childrenId;
    }
    
    private static Decision getDecision(Element element){
        NodeList question_list = element.getElementsByTagName(XMLTag.CONTENT);
        String question = null;
        Map<String, String> answer_target = null;
        
        if (question_list.item(0) != null){
            question = question_list.item(0).getTextContent();
            
            answer_target = new HashMap<String, String>();
        
            NodeList forkList = element.getElementsByTagName(XMLTag.FORK);
            for (int i=0; i<forkList.getLength(); i++){
                Node node = forkList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element fork_element = (Element)node;
                    String target_id = fork_element.getAttributes().getNamedItem(XMLTag.TRAGET).getTextContent();
                    String answer = fork_element.getTextContent();
                    answer_target.put(answer, target_id);
                }
            }
        }
        
        return new Decision(question, answer_target, getConceptName(element));
    }
    
    private static void printNodeMapping(Map<String, DecisionNode> mapping){
        StringBuilder sb = new StringBuilder("Node List:");
        
        for(String key: mapping.keySet()){
            sb.append("\n")
                    .append(mapping.get(key).toString());
        }
        
        System.out.println(sb.toString());
    }
    
    public class XMLTag{
        public static final String BRANCH   = "branch";
        public static final String CONTENT  = "content";
        public static final String FORK     = "fork";
        public static final String CONCEPT  = "concept";
        public static final String ID       = "id";
        public static final String TRAGET   = "target";
    }

    // Main method to tests, remove when done
    public static void main(String args[]) 
    {
        buildNodeList(null);
    }
}