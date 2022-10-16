/**
 * Author:Oscar Saravia
 * CMSC 204
 * SortedDoubleLinkedList class-creates double linked list sorted
 * without use of addToEnd/addToFront
 */

package abc;

import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

import abc.BasicDoubleLinkedList.Node;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList <T> {

	
	 Node<T> head=null;
	 Node<T> tail=null;
	 Node<T> current=new Node(null,head,null);
	 
	 /**
	  * 
	  * @param comparatorObject-
	  */
	public SortedDoubleLinkedList(Comparator<T> comparatorObject) {
		super();
	}
	
	public void add(T data) {
		
		Comparator<T> comparator = new Comparator<T>();
		//In case of no entry in list
		if(tail==null) {
			tail=new Node(data,null,null);
			head=tail;
		}
		else {
			Node<T> recent=new Node(data,null,tail);
			current=tail;
			tail.prev=recent;
			//Keep going as long as prev isn't null
				while(current!=null) {

							
						if(comparator.compare(current.prev.data, current.data)>0) {
							//Swap data from nodes
							T temp=current.prev.data;
							current.prev.data=current.data;
							current.data=temp;
							}
					
					//Move back in list
					current=current.prev;
				}
			}
			
			
		
		
		
		
		
	}
	
	
	public void addToEnd(T data) {
		
		throw new UnsupportedOperationException();
	}
	
	
	public void addToFront(T data) {
		
		throw new UnsupportedOperationException();

	}
	
	
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	public Node remove(T data,Comparator<T> comparator) {
		return super.remove(data, comparator);
	}
	
	
}
