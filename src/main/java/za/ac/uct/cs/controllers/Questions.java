// methods: processAnswer(answer) or nextQuestion(answer), previousQuestion(), getAnswerOptions()
// enum for different answer types (YES/NO)(ONE/TWO/THREE/ZERO)(...)
package za.ac.uct.cs.controllers;

import za.ac.uct.cs.models.DecisionNode;

public class Questions{
	/// TODO
	private DecisionNode currentQuestion;
    private String currentAxiom;

	public void begin(){
		TreeBuilder decisionTree = new TreeBuilder();
		decisionTree.buildTree();
		this.currentQuestion = decisionTree.getRoot();
		String axiom = this.currentQuestion.getValue().getAxiom();
	    // if axiom property of current question is not null,
        // set current axiom to current question's axiom.
        this.currentAxiom = (axiom != null)? axiom : "";
	}

	public void processAnswer(int answer){
		// process answer
	}

	public void goToPreviousQuestion() throws NullPointerException {
		if (!this.isFirstQuestion()){
			this.currentQuestion = (DecisionNode)this.currentQuestion.getParent();
			this.currentAxiom = this.findPreviousAxiom();
			return;
		}
		throw new NullPointerException("There is no previous question.");
	}

	public String getQuestion(){
		return this.currentQuestion.getValue().question;
	}
        
    public String getAxiom(){
        return this.currentAxiom;
    }

	public String[] getAnswerOptions(){
		/// TODO: documentation
		Enum[] choices = this.currentQuestion.getValue().getChoices();
		String[] answerOptions = new String[choices.length];
		int index = 0;
		for (Enum choice : choices){
	    	answerOptions[index] = choice.toString();
	        ++index;
	    }
	    return answerOptions;
	}

	public boolean isFirstQuestion(){
		if (this.currentQuestion == null) { return true; } // yes/no?
		return (this.currentQuestion.getParent() == null);
	}

	public boolean isFinalQuestion(){
		if (this.currentQuestion == null) { return true; } // yes/no?
		return this.currentQuestion.isLeaf();
	}

	protected String findPreviousAxiom(){
		/// TODO: documentation and testing
		if (this.currentQuestion.getAxiom() == null){ return this.currentAxiom; }
		DecisionNode q = this.currentQuestion;
		while(q != null && q.getAxiom() == null){
			q = q.getParent();
		}
		String a = q.getAxiom();
		return (a != null)? a : "";
	}
}