// Tree Node BFO decision diagram
package Models;

import java.lang.RuntimeException;

public class Decision{
	// each decision has a question and potential answers.
	public final String question;
	private Enum choices;
	private boolean fixedChoices;

	public Decision(String question){
		this.question = question;
		this.fixedChoices = false;
	}

	public Decision(String question, Enum choices, boolean fixed){
		this.question = question;
		this.choices = choices;
		this.fixedChoices = fixed;
	}

	public void setChoices(Enum choices) throws RuntimeException {
		if (!this.fixedChoices){
			this.choices = choices;
			return;
		}
		// throw exception if choices are fixed
		throw new RuntimeException(
			"Attempting to change immutable choices for the following decision: " 
			+ this.question
		);
	}
}