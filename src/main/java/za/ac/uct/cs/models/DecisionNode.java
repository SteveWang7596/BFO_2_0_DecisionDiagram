// Tree Node BFO decision diagram
package za.ac.uct.cs.models;

import java.util.List;

public class DecisionNode {

    private final String id;
    private Decision value;
        
    public DecisionNode(String id, Decision value){
        this.id = id;
        this.value = value;
    }
    
    public String getId(){
        return this.id;
    }
    
    public Decision getValue(){
        return this.value;
    }
    
    public void setDecision(Decision value){
        this.value = value;
    }
    
    public List<String> getChildrenNodeId(){
        return this.value.getAllChildrenNodeId();
    }
    
    public String getParentNodeId(){
        int last_dot = this.id.lastIndexOf(".");      
        if (last_dot == -1) { return ""; }   
        
        String parentId = this.id.substring(0, last_dot); 
        return parentId;
    }
    
    @Override
    public String toString(){
        String to_string = String.format(
            "Node ID: %s%s", 
            this.id,
            (this.value == null)? "" : ("\n" + this.value.toString())
        );
        
        return to_string;
    }
    
    public boolean equals(DecisionNode other){
        return (this.id.equals(other.getId()) && this.value.equals(other.getValue()));
    }

    public boolean isLeaf(){
        return this.value.isLeaf();
    }
    
}