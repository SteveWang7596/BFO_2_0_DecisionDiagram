// Tree Node BFO decision diagram
package za.ac.uct.cs.models;

import java.lang.RuntimeException;

enum YES_NO_OPTIONS{
	Yes(1), No(2);
	
	public final int value;
	
	private YES_NO_OPTIONS(int value){
		this.value = value;
	}
} /// TODO: Move to tree creation ctrl class (make private)

public class Decision{
	// each decision has a question and potential answers.
	public final String question;
	private String axiom;
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

	public void setChoices(Enum[] choices) throws RuntimeException {
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

	public void setAxiom(String axiom){
		this.axiom = axiom;
	}

	public String getAxiom(){
		return this.axiom;
	}
}