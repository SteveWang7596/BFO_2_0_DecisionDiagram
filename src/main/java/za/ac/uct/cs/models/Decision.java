// Tree Node BFO decision diagram
package za.ac.uct.cs.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Decision{
    
    public final String question;
    private Map<String, String> answer_target_map;
    private String concept;

    public Decision(String question, Map<String, String> answer_target_map, String concept){
        this.question = question;
        this.answer_target_map = answer_target_map;
        this.concept = concept;
    }
    
    public String getConcept(){
        return this.concept;
    }
    
    public String getQuestion(){
        return this.question;
    }
    
    public Set<String> getAllAnswers(){
        return answer_target_map.keySet();
    }
    
    public void setAnswerTargetMapping(Map<String, String> map){
        this.answer_target_map = map;
    }
    
    public void addAnswerTragetPair(String answer, String target){
        this.answer_target_map.put(answer, target);
    }
    
    public String getTarget(String answer){
        return this.answer_target_map.get(answer);
    }
    
    public Boolean hasTarget(String target){
        for(String key: this.answer_target_map.keySet()){
            if (target.equals(this.answer_target_map.get(key)))
                return true;
        }
        return false;
    }
    
    public Boolean hasAnswer(String answer){
        return this.answer_target_map.containsKey(answer);
    }
    
    public List<String> getAllChildrenNodeId(){
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
                .append("Concept = ")
                .append(this.concept);
        
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
    
    public Boolean equalTo(Decision other){
        for (String key : this.answer_target_map.keySet()){
            if (!this.answer_target_map.get(key).equals(other.getTarget(key)))
                return false;
        }
        
        return (this.question.equals(other.getQuestion()) && this.concept.equals(other.getConcept()));
    }
    
}