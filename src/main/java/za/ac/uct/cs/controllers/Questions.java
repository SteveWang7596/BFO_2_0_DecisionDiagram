// methods: processAnswer(answer) or nextQuestion(answer), previousQuestion(), getAnswerOptions()
// enum for different answer types (YES/NO)(ONE/TWO/THREE/ZERO)(...)
package za.ac.uct.cs.controllers;

import za.ac.uct.cs.models.DecisionNode;

public class Questions{
	/// TODO
	private DecisionNode currentQuestion;

	public void processAnswer(int answer){
		// process answer
	}

	public void goToPreviousQuestion(){
		//currentQuestion = currentQuestion.getParent();
	}

	public String getQuestion(){
		//return currentQuestion.getValue().question;
                return null;
	}
}