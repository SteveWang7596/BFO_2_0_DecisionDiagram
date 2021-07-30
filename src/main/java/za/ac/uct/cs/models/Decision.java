// Tree Node BFO decision diagram
package za.ac.uct.cs.models;

import java.lang.RuntimeException;

public enum YES_NO_OPTIONS{
	1("Yes"), 2("No");
	
	private String text;
	
	public YES_NO_OPTIONS(String text){
		this.text = text;
	}

	@Override
	public String toString(){
		return this.text;
	}
} /// TODO: Move to tree creation ctrl class

public class Decision{
	// each decision has a question and potential answers.
	public final String question;
	private Enum[] choices;
	private boolean fixedChoices;

	public Decision(String question){
		this.question = question;
		this.choices = null;
		this.fixedChoices = false;
	}

	public Decision(String question, Enum[] choices, boolean fixed){
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

	public Enum[] getChoices(){
		return this.choices;
	}
}