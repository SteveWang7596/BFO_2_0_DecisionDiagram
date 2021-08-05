/// TODO: DOCUMENTATION
package za.ac.uct.cs.controllers;

import javax.xml.parsers.SAXParserFactory;

import za.ac.uct.cs.models.DecisionNode;

public class TreeBuilder{
	// make everything static?
	// think about how to indicate that an early stop is possible...
	private DecisionNode root;
	private boolean builtTree = false;
        
    private static final String BFO_2_0_DEFAULT_PATH = "za/ac/uct/cs/xml/BFO_2_0_decision_tree.xml";

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

	private class DecisionTreeXMLHandler{
		private bool tree = false; // check if true before making any nodes
		private bool title = false; // skip (or display)
		private bool description = false; // skip (or display)
		private bool branch = false; // new decision node
		private bool content = false; // question (+ maybe example text)
		private bool fork = false; // options
		private bool concept = false; // axiom

		//...
	}
}