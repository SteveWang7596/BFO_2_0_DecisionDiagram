// methods: processAnswer(answer) or nextQuestion(answer), previousQuestion(), getAnswerOptions()
// enum for different answer types (YES/NO)(ONE/TWO/THREE/ZERO)(...)
package Controllers;

import Models.DecisionNode;

public class Questions{
	/// TODO
	private DecisionNode currentQuestion;

	public void processAnswer(int answer){
		// process answer
	}

	public void goToPreviousQuestion(){
		currentQuestion = currentQuestion.getParent();
	}

	public String getQuestion(){
		return currentQuestion.question;
	}
}