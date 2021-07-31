/// TODO: DOCUMENTATION
package za.ac.uct.cs.controllers;

import za.ac.uct.cs.models.DecisionNode;

public class TreeBuilder{
	// make everything static?
	// think about how to indicate that en early stop is possible...
	private DecisionNode root;
	private boolean builtTree = false;

	public void buildTree(){
		/// TODO
		if (this.builtTree) { return; }
		// ...
		this.builtTree = true;
	}

	public DecisionNode getRoot(){
		if (!this.builtTree) { return null; }
		return this.root;
	}
}