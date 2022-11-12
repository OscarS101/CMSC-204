/**
 * Author:Oscar Saravia
 * CMSC 204
 * Assignment 5
 * MorseCodeTree-This class is designed to create a binary tree through recursive
 * methods. 
 */
package abc;

import java.util.ArrayList;

public class MorseCodeTree  implements  LinkedConverterTreeInterface <String>{

	private TreeNode<String> root;
	public String info="";
	
	public MorseCodeTree(){
		buildTree();

		
	}
	
	/**
	 * @return the reference pointing to the root of the tree
	 */
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * @param newNode-the treenode to be set as the new root
	 */
	public void setRoot(TreeNode<String> newNode) {
		

		
		//Assign root and add the prev root as a child
		newNode.leftChild=root;
			
		root=newNode;
		
		
	}

	/**
	 * @param result- the data to be added into the tree in the correct spot using addNode
	 * @param code-The code by which the node is added
	 */
	public void insert(String code, String result) {

		//Make sure the root exists
		if(root==null) {
			TreeNode<String> work=new TreeNode<>(" ");
			root=work;
		}
		//Call recursive method 
		addNode(root,code,result);

	}

	/**
	 * @param root-root of that particular tree
	 * @param code-Way in which the data is added
	 * @param letter-the data to be added to the tree
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		//Walk left on tree
		if(code.charAt(0)=='.') {
			//Assign node with letter at null
			if(root.leftChild==null) {
				TreeNode<String> node=new TreeNode<String>(letter);
				root.leftChild=node;
				
			}//Otherwise keep walking tree
			else {
				addNode(root.leftChild,code.substring(1),letter);
			}
		}//Walk right on the tree
		if(code.charAt(0)=='-') {
			//Assign node and letter at null
			if(root.rightChild==null) {
				TreeNode<String> node=new TreeNode<String>(letter);
				root.rightChild=node;
			}//Otherwise walk right on tree
			else 
				addNode(root.rightChild,code.substring(1),letter);
			}
		
		
		
	}

	/**
	 * @param code-way in which to traverse the tree
	 * @return-the data that corresponds to the code
	 */
	public String fetch(String code) {
		//Call recursive method
		return fetchNode(root,code);
	}

	/**
	 * @param root-the instance of that paritcular tree's root
	 * @param code-the way to traverse the tree
	 * @return the data in the node
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		//Add space for /
		if(code.charAt(0)=='/') {
			info=" ";
			return info;
		}
		//Base case walk left for . and right for -
		if(code.length()==1){
			if(code.charAt(0)=='.')
				info=root.leftChild.getData();
			else info=root.rightChild.getData();
			return info;
		}
		//Call recursive step to go left 
		if(code.charAt(0)=='.') {
			fetchNode(root.leftChild,code.substring(1));
		}//Call recursive step for right
		else if (code.charAt(0)=='-'){
			fetchNode(root.rightChild,code.substring(1));
		}
		
		return info;
	}

	/**
	 * @param- the data to find the node to delete
	 * @return the node to be deleted
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Builds LinkedConverterTree by adding the TreeNodes<T> 
	 * in the right spot
	 */
	public void buildTree() {
		
		//Insert all letter by level
		insert(".","e");
		insert("-","t");
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
		
		
	}

	/**
	 * @return-An arraylist of the items in the tree in in-order traversal
	 */
	public ArrayList<String> toArrayList() {
		ArrayList<String> list=new ArrayList<String>();
		//Create list and pass to method
		
		return LNR(root,list);
	}

	/**
	 * @param root-root of the tree for that instance
	 * @param list-Arraylist to hold the items in the tree
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		//Go to lowest left child
		if(root.leftChild!=null) {
			LNRoutputTraversal(root.leftChild,list);
		}//Add data
		list.add(root.getData());
		System.out.print(root.data+" ");
		//Go to right child
		if(root.rightChild!=null)
			LNRoutputTraversal(root.rightChild,list);
		
	}

	public ArrayList<String> LNR(TreeNode<String> root, ArrayList<String> list) {
		//Go to lowest left child
		if(root.leftChild!=null) {
			LNR(root.leftChild,list);
		}
		//Add data
		list.add(root.getData());
		//Go to right child
		if(root.rightChild!=null) {
			LNR(root.rightChild,list);
		}
		return list;
		
	}
	
		
	
}
