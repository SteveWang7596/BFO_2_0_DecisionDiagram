// Tree Node BFO decision diagram
package za.ac.uct.cs.models;

import java.util.Vector;
import java.util.Collection;
import java.util.Enumeration;
import java.lang.RuntimeException;
import javax.swing.tree.TreeNode;

public class DecisionNode implements TreeNode{

	private static int DEFAULT_CHILD_CAPACITY = 3;

	private DecisionNode parent;
	private boolean allowsChildren;
	private Vector<DecisionNode> children;
	private Object value;

	/// TODO: compare, setters (maybe?), (protected) addChildAtIndex
	public DecisionNode(){
		this.value = null;
		this.parent = null;
		this.children = new Vector<DecisionNode>(DEFAULT_CHILD_CAPACITY);
		this.allowsChildren = true;
	}

	public DecisionNode(TreeNode node){
		this.parent = new DecisionNode(node.getParent());
		this.parent.addChild(this);

		this.allowsChildren = node.getAllowsChildren();
		if (this.allowsChildren) { 
			this.children = new Vector<DecisionNode>(DEFAULT_CHILD_CAPACITY); 
			for (Enumeration e = node.children(); e.hasMoreElements();) {
				TreeNode childNode = (TreeNode)(e.nextElement());
				this.children.addElement((DecisionNode)childNode); 
			}
		}
		else {
			this.children = new Vector<DecisionNode>(0, 0);
		}
		
		this.value = null;
	}

	public DecisionNode(DecisionNode parent, Object value, boolean allowsChildren, Collection<DecisionNode> children){
		this.parent = parent;
		this.parent.addChild(this);

		this.children = new Vector<DecisionNode>(children);
		this.allowsChildren = allowsChildren;
		this.value = value;
	}

	public DecisionNode(DecisionNode parent, Object value){
		this.parent = parent;
		this.parent.addChild(this);

		this.value = value;
		this.allowsChildren = true;
		this.children = new Vector<DecisionNode>(DEFAULT_CHILD_CAPACITY);
	}

	public DecisionNode(DecisionNode parent, Object value, boolean allowsChildren){
		this.parent = parent;
		this.parent.addChild(this);

		this.value = value;
		this.allowsChildren = allowsChildren;
		this.children = new Vector<DecisionNode>(DEFAULT_CHILD_CAPACITY);
	}

	public Object getValue(){
		return this.value;
	}

	private void addChild(DecisionNode node) throws RuntimeException {
		if (!this.allowsChildren){ 
			throw new RuntimeException ("Attempting to add children to a node that doesn't allow children.");
		}
		this.children.addElement(node);
	}

	public boolean equals(DecisionNode node){
		/// TODO: other checks
		if (node == this) { return true; }
		return false;
	}

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
		return this.children.indexOf((DecisionNode)node);
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