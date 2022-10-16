/**
 * Author:Oscar Saravia
 * CMSC 204
 * This class and inner generic classes serve to create a double linked list. 
 * It is implemented using the iterable interface. As well as the use of
 * inner classes node and double linked list iterator that implements
 * list iterator. 
 */

package abc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	
	//Fields used to keep track of size,head, and tail. Protected
	//to be used by subclasses
	protected Node<T> head=null;
	protected Node<T> tail=null;
	protected int size;
	protected Node<T> pointer;
	
	//Constructor to set fields to default values.
	public BasicDoubleLinkedList() {
		pointer=tail=head=null;
		size=0;
	}
	
	/**
	 * 
	 * @return-size variable that keeps track of nodes
	 */
	public int getSize() {
		return size;
	}
	
	
	/**
	 * 
	 * @param data-The T object to be added to the end of the list
	 */
	public void addToEnd(T data) {
		Node<T> current=tail;
		
		//If nothing in list
		if(tail==null) {
			//Assign tail and head
			tail=new Node(data,null,null);
			head=tail;
		}else {
			//Mark node for previous tail and create new tail
			tail.next=tail=new Node(data,current,null);
			
		}
		size++;
	}
	/**
	 * 
	 * @param data-The T object to be added to the front of the list
	 */
	public void addToFront(T data) {
		//In case of nothing in list
		if(head==null) {
			//Assign head and tail
			head=new Node(data,null,null); 
			tail=head;	
			}
			else {
				//Assign previous head and create new head
				head.prev=head=new Node(data,null,head);
			}
		size++;
		//Keep track of pointer
		pointer=head;

	}
	
	/**
	 * 
	 * @return-The first element in the linked list, null if there is none
	 */
	public T getFirst() {
		if(size==0)
			return null;
		
		return head.data;
	}
	
	/**
	 * 
	 * @return-The last element in list, null if none in list.
	 */
	public T getLast() {
		if(size==0)
			return null;
		
		return tail.data;
	}
	
	/**
	 * @return-Object from list iterator from inner class
	 */
	public ListIterator<T> iterator(){
		
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * 
	 * @param targetData-The data to be removed
	 * @param comparator-The measure to which the data will be determined
	 * @return-The node containing the data or null
	 */
	public Node<T> remove(T targetData, Comparator<T> comparator) {
		Node<T> result=head;
		
		//Go through list
		for(int n=0;n<size;n++) {
			
			//Found the data to be deleted
			if(result.data==targetData) {
				if(result==head) {
					//Case of pointer beind deleted
					if(pointer==head)
						pointer=head.next;
					//Assign new head before breaking
					head=head.next;
					break;
				}
				//Case of target being tail
				else if(result==tail) {
					//Make sure to not deleted pointer/cursor
					if(pointer==tail)
						pointer=tail.prev;
					//Assign new tail before finishing
					tail=tail.prev;
					break;
				}
				//Case of deletion not being head or tail
				else {
					result.prev.next=result.next;
					break;
				}
			}
			//Make sure to not delete pointer
			if(result==pointer)
				pointer=result.next;
			result=result.next;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return-The first element in the list or null.And removes from list.
	 */
	public T retrieveFirstElement() {
		T temp=head.data;
		if(pointer==head)
			pointer=head.next;
		head=head.next;
		size--;
		return temp;
		
	}
	
	/**
	 * 
	 * @return-The last element in list or null.And removes from list.
	 */
	public T  retrieveLastElement() {
		T temp=tail.data;
		tail=tail.prev;
		size--;
		return temp;
	}
	
	/**
	 * 
	 * @return-The linked list in array list format with generic type
	 */
	public ArrayList<T> toArrayList(){
		int n=0;
		Node<T> current=head;
		//Initialize array list
		ArrayList<T> result=new ArrayList<>(size);
		
		//Loop to add data
		while(n<size&&result!=null) {
			//Add data to array list
			result.add(current.data);
			//Progress loop
			n++;
			//Progress through nodes
			current=current.next;
		}
		return result;
		
	}
	
	
	
	//Generic Inner class node to be used as nodes for linked list
	public class Node<T>{
		protected T data;
		protected Node<T> prev;
		protected Node<T> next;
		
		public Node(T data) {
			new Node(data, null, null);
			
		}
		//Wrapper constructor
		public Node(T data,Node<T> prev,Node<T> next) {
			this.data=data;
			this.prev=prev;
			this.next=next;
		}
	}
	
	//Generic Inner class that implements ListIterator
	public class DoubleLinkedListIterator implements ListIterator<T>{
		int counter=0;
		
		/**
		 * @return-True if value after node, else false
		 */
		@Override
		public boolean hasNext() {
			//If there is no next node
			if(pointer.next==null&&pointer.prev==tail)
			return false;
			
			//Next node exists
			else return true;
			
		}
		
		/**
		 * @return-The data in the next node
		 */
		@Override
		public T next() throws NoSuchElementException {
			//In case of nothing in list
			if(counter==getSize())
				throw new NoSuchElementException();
			
			//Pass data into variable
			T info=pointer.data;
			
			//Move node to next node;
			if(pointer.next!=null)
			pointer=pointer.next;
			
			else pointer=pointer;
			
			counter+=1;
			
			//Return variable
			return info;
			
			
		}
		
		/**
		 * @return-True if node has previous value,else false
		 */
		@Override
		public boolean hasPrevious() {
			
			
			//Nothing in previous node
			if(pointer.prev==null) {
				
				return false;
			}
			
			else return true;
		}
		
		/**
		 * @return-Data from node and move node back
		 */
		@Override
		public T previous() throws NoSuchElementException{
			//Nothing in list
			if(counter==0)
					throw new NoSuchElementException();
			
			T info=pointer.data;
			
			pointer=pointer.prev;
			
			
			counter-=1;
			return info;
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
	}

	

}
