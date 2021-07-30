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

	public void goToPreviousQuestion(){
		this.currentQuestion = (DecisionNode)this.currentQuestion.getParent();
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
}