// Tree Node BFO decision diagram
package za.ac.uct.cs.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Decision {
    
    public final String question;
    private Map<String, String> answer_target_map;
    public final String axiom;

    public Decision(String question, Map<String, String> answer_target_map, String axiom){
        this.question = question;
        this.answer_target_map = answer_target_map;
        this.axiom = axiom;
    }
    
    public String getAxiom() throws NullPointerException {
        return this.axiom;
    }
    
    public String getQuestion() throws NullPointerException {
        return this.question;
    }
    
    public Set<String> getAllAnswers() throws NullPointerException {
        return answer_target_map.keySet();
    }
    
    public void setAnswerTargetMapping(Map<String, String> map){
        this.answer_target_map = map;
    }
    
    public void addAnswerTargetPair(String answer, String target){
        this.answer_target_map.put(answer, target);
    }
    
    public String getTargetID(String answer) throws NullPointerException {
        return this.answer_target_map.get(answer);
    }
    
    public Boolean pointsToTargetID(String target){
        if (this.isLeaf()) { return false; }
        for(String key: this.answer_target_map.keySet()){
            if (target.equals(this.answer_target_map.get(key)))
                return true;
        }
        return false;
    }
    
    public Boolean hasAnswer(String answer){
        if (this.isLeaf()) { return false; }
        return this.answer_target_map.containsKey(answer);
    }
    
    public List<String> getAllChildrenNodeId() throws NullPointerException {
        List<String> childrenNodeId = new ArrayList<String>();
        
        for(String key: this.answer_target_map.keySet()){
            childrenNodeId.add(this.answer_target_map.get(key));
        }
        
        return childrenNodeId;
    }
    
    public void addChildrenNode(String answer, String childNodeId) throws Exception{
        if (hasAnswer(answer))
            throw new Exception("Duplicate answer, current target child node for " + answer + " is node id " + this.answer_target_map.get(answer));
        else
            this.answer_target_map.put(answer, childNodeId);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("\t")
                .append("Axiom = ")
                .append(this.axiom);
        
        if (question != null){
            sb.append("\n\tQuestion = ")
                    .append(this.question);
        }
        
        if (this.answer_target_map != null){
            for (String key: this.answer_target_map.keySet()){
                sb.append("\n\t")
                        .append("Answer = ")
                        .append(key)
                        .append(" : target id = ")
                        .append(this.answer_target_map.get(key));
            }
        }
        
        return sb.toString();
    }
    
    public Boolean equals(Decision other){
        for (String key : this.answer_target_map.keySet()){
            if (!this.answer_target_map.get(key).equals(other.getTargetID(key)))
                return false;
        }
        
        return (this.question.equals(other.getQuestion()) && this.axiom.equals(other.getAxiom()));
    }

    public Boolean isLeaf(){
        if (this.answer_target_map == null) { 
            return true; 
        }
        return this.answer_target_map.isEmpty();
    }
    
}