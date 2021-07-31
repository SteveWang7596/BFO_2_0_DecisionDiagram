// methods: processAnswer(answer) or nextQuestion(answer), previousQuestion(), getAnswerOptions()
// enum for different answer types (YES/NO)(ONE/TWO/THREE/ZERO)(...)
package za.ac.uct.cs.controllers;

import za.ac.uct.cs.models.DecisionNode;

public class Questions{
	/// TODO
	private DecisionNode currentQuestion;

	public void begin(){
		TreeBuilder decisionTree = new TreeBuilder();
		decisionTree.buildTree();
		this.currentQuestion = decisionTree.getRoot();
	}

	public void processAnswer(int answer){
		// process answer
	}

	public void goToPreviousQuestion() throws NullPointerException {
		if (!this.isFirstQuestion()){
			this.currentQuestion = (DecisionNode)this.currentQuestion.getParent();
			return;
		}
		throw new NullPointerException("There is no previous question.");
	}

	public String getQuestion(){
		return this.currentQuestion.getValue().question;
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
}