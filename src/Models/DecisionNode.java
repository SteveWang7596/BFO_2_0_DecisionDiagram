// Tree Node BFO decision diagram
package Models;

import java.util.Vector;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;

public class DecisionNode implements TreeNode{

	private DecisionNode parent;
	private boolean allowsChildren;
	private Vector<DecisionNode> children;

	/// TODO: constructor(s), compare, equals

	// interface method getChildAt
	public TreeNode getChildAt(int childIndex){
		/* Returns the child TreeNode at index childIndex. */
		return this.children.elementAt(childIndex);
	}
	
	// interface method getChildCount
	public int getChildCount(){
		/* Returns the number of children TreeNodes the receiver contains. */
		return this.children.size();
	}
	
	// interface method getParent
	public TreeNode getParent(){
		/* Returns the parent TreeNode of the receiver. */
		return this.parent;
	}
	
	// interface method getIndex
	public int getIndex(TreeNode node){
		/* Returns the index of node in the receivers children. 
		If the receiver does not contain node, -1 will be returned. */
		return this.children.indexOf(node);
		/// TODO: replace above with below
		// return this.children.indexOf(DecisionNode(node));
	}
	
	// interface method getAllowsChildren
	public boolean getAllowsChildren(){
		/* Returns true if the receiver allows children. */
		return this.allowsChildren;
	}
	
	// interface method isLeaf
	public boolean isLeaf(){
		/* Returns true if the receiver is a leaf. */
		return this.children.isEmpty();
	}
	
	// interface method children
	public Enumeration children(){
		/* Returns the children of the receiver as an Enumeration. */
		return this.children.elements();
	}
}