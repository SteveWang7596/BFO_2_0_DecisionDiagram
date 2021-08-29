package za.ac.uct.cs.controllers;

import za.ac.uct.cs.models.DecisionNode;

import java.util.Map;
import java.util.Set;

/**
 * A controller class for navigating the questions in the BFO 2.0 decision diagram.
 * @author Chiadika Emeruem
 * @author Steve Wang
 */
public class Questions {
    private static final String ROOT_ID = "1";
    private Map<String, DecisionNode> decisionTree;
    private DecisionNode currentQuestion;
    private String currentAxiom;

    public void begin(){
        NodeListBuilder decisionTreeBuilder = new NodeListBuilder();
        this.decisionTree = decisionTreeBuilder.buildNodeList();
        this.currentQuestion = this.decisionTree.get(ROOT_ID);
        String axiom = this.currentQuestion.getValue().getAxiom();
        // if axiom property of current question is not null,
        // set current axiom to current question's axiom.
        this.currentAxiom = (axiom != null)? axiom : "";
    }

    public void processAnswer(String answer) throws RuntimeException {
        if (!this.currentQuestion.getValue().hasAnswer(answer)){
            // answer is not among the options for current question
            String errorMessage = String.format(
                "\"%s\" is not a valid option for the question: %s",
                answer,
                this.currentQuestion.getValue().question
            );
            throw new RuntimeException(errorMessage);
        }
        String childId = this.currentQuestion.getValue().getTargetID(answer);
        this.currentQuestion = this.decisionTree.get(childId);
        String axiom = this.currentQuestion.getValue().getAxiom();
        if (axiom != null) { this.currentAxiom = axiom; }
    }

    public void goToPreviousQuestion() throws NullPointerException {
        if (!this.isFirstQuestion()){
            this.currentQuestion = this.decisionTree.get(this.currentQuestion.getParentNodeId());
            this.currentAxiom = this.findPreviousAxiom();
            return;
        }
        throw new NullPointerException("There is no previous question.");
    }

    public String getQuestion(){
        String question = this.currentQuestion.getValue().question;
        return (question == null)? "" : question;
    }

    public String getAxiom(){
        return this.currentAxiom;
    }

    public String[] getAnswerOptions(){
        /// TODO: documentation
        if (this.isFinalQuestion()) {
            // there are no more options
            return new String[0];
        }
        Set<String> choices = this.currentQuestion.getValue().getAllAnswers();
        String[] answerOptions = choices.toArray(new String[0]);
        return answerOptions;
    }

    public boolean isFirstQuestion(){
        if (this.currentQuestion == null) { return false; } // yes/no?
        if (this.currentQuestion.getParentNodeId().equals("")) { return true; }
        return (this.currentQuestion.getId() == ROOT_ID);
    }

    public boolean isFinalQuestion(){
        if (this.currentQuestion == null) { return true; } // yes/no?
        return this.currentQuestion.isLeaf();
    }

    protected String findPreviousAxiom(){
        /// TODO: documentation and testing
        if (this.isFirstQuestion()) { 
            String axiom = this.currentQuestion.getValue().getAxiom(); 
            return (axiom != null)? axiom : "";
        }

        if (this.currentQuestion.getValue().getAxiom() == null){ 
            return this.currentAxiom; 
        }

        DecisionNode q = this.currentQuestion;
        while(q != null){
            if (q.getValue() == null) {
                    return "";
            }

            if (q.getValue().getAxiom() != null){
                    break;
            }

            q = this.decisionTree.get(q.getParentNodeId());
        }

        String a = q.getValue().getAxiom();
        return (a != null)? a : "";
    }
}