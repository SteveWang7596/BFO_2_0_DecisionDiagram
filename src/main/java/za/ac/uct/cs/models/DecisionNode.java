// Tree Node BFO decision diagram
package za.ac.uct.cs.models;

import java.util.Vector;
import java.util.Collection;
import java.util.Enumeration;
import java.lang.RuntimeException;
import java.util.List;
import javax.swing.tree.TreeNode;

public class DecisionNode{

    private final String id;
    private final String concept;
    private DecisionNode parent;
    private boolean leafNode;
    private List<DecisionNode> children;
    private List<String> childrenNodeId;
    private Decision decision;
        
    public DecisionNode(String id, String concept, boolean leafNode, List<String> childrenNodeId, Decision decision)
    {
        this.id = id;
        this.concept = concept;
        this.parent = null;
        this.leafNode = leafNode;
        this.childrenNodeId = childrenNodeId;
        this.children = null;
        this.decision = decision;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("\t")
                .append(this.concept);
                
        if (this.decision != null){
            sb.append("\n\t")
                    .append(this.decision.toString());
        }
        
        return sb.toString();
    }
        
        /*
	/// TODO: compare, setters (maybe?), (protected) addChildAtIndex
	public DecisionNode(String id){
		this.id = id;x
		this.value = null;
		this.parent = null;
		this.children = new Vector<DecisionNode>(DEFAULT_CHILD_CAPACITY);
		this.allowsChildren = true;
	}

	public DecisionNode(String id, TreeNode node){
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
		
		this.id = id;
		this.value = null;
	}

	public DecisionNode(String id, DecisionNode parent, Decision value, boolean allowsChildren, Collection<DecisionNode> children){
		this.id = id;

		this.parent = parent;
		this.parent.addChild(this);

		this.children = new Vector<DecisionNode>(children);
		this.allowsChildren = allowsChildren;
		this.value = value;
	}

	public DecisionNode(String id, DecisionNode parent, Decision value){
		this.id = id;

		this.parent = parent;
		this.parent.addChild(this);

		this.value = value;
		this.allowsChildren = true;
		this.children = new Vector<DecisionNode>(DEFAULT_CHILD_CAPACITY);
	}

	public DecisionNode(String id, DecisionNode parent, Decision value, boolean allowsChildren){
		this.id = id;

		this.parent = parent;
		this.parent.addChild(this);

		this.value = value;
		this.allowsChildren = allowsChildren;
		this.children = new Vector<DecisionNode>(DEFAULT_CHILD_CAPACITY);
	}

	public Decision getValue(){
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
        */

}