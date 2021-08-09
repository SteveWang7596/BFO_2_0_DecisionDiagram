// Tree Node BFO decision diagram
package za.ac.uct.cs.models;

import java.util.List;

public class DecisionNode{

    private final String id;
    private Decision decision;
        
    public DecisionNode(String id, Decision decision)
    {
        this.id = id;
        this.decision = decision;
    }
    
    public String getId(){
        return this.id;
    }
    
    public Decision getDecision(){
        return this.decision;
    }
    
    public void setDecision(Decision decision){
        this.decision = decision;
    }
    
    public List<String> getChildrenNodeId(){
        return this.decision.getAllChildrenNodeId();
    }
    
    public String getParentNodeId(){
        String [] id_part = this.id.split(".");
        
        StringBuilder sb = new StringBuilder();
        
        for (String part: id_part){
            sb.append(part)
                    .append(".");
        }
        
        String temp = sb.toString();
        
        return temp.substring(0, temp.length());
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Node ID: ")
                .append(this.id);
                
        if (this.decision != null){
            sb.append("\n")
                    .append(this.decision.toString());
        }
        
        return sb.toString();
    }
    
    public Boolean equalTo(DecisionNode other){
        return (this.id.equals(other.getId()) && this.decision.equals(other.getDecision()));
    }
    
}