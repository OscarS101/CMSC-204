/**
 * Author:Oscar Saravia
 * CMSC 204
 * Assignment 5
 * TreeNode:Generic class that creates nodes and keeps track
 * of the left and right children.
 */
package abc;

public class TreeNode <T>{

	T data;
	TreeNode<T> leftChild,rightChild;
	
	
	
	
	/**
	 * 
	 * @param dataNode-data to assign to new Node
	 * Assigns null to left and right child
	 */
	public TreeNode(T dataNode) {
		
		this.data=dataNode;
		
		this.leftChild=this.rightChild=null;
	}
	
	/**
	 * 
	 * @param node-The node to make a deep copy of
	 */
	public TreeNode(TreeNode<T> node) {
		//Make a copy of the node with the data
		TreeNode<T> copy=new TreeNode<T>(node.data);
		
	}
	
	/**
	 * 
	 * @return-the data of the node
	 */
	public T getData() {
		return data;
	}
	
	
	
	
	
	
}
