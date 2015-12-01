package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of Queue for use in our final project
 * Utilizes FIFO sequence for adding and removing new items
 * @author Aidan Nguyen
 */
public class Queue<E> implements Iterable<E>{
	private Node<E> first;
	private Node<E> last;
	private int length;
	
	/**
	 * Creates an empty queue
	 */
	public Queue() {
		first = null;
		last = null;
		length = 0;
	}
	
	/**
	 * Checks if queue is empty
	 * @return true if queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * Checks for the size of the queue
	 * @return the length of the queue
	 */
	public int size() {
		return length;
	}
	
	
	/**
	 * Checks the element first in line of the queue
         * @return element of first node
	 */
	public E peek() {
		if (isEmpty()) throw new NoSuchElementException("Queue is empty.");
		else
                        return peek(first);
	}
	
        /**
         * Gets the element first in line of the queue
         * @param node first node
         * @return element of node
         */
	private E peek(Node<E> node) {
		return node.getData();
	}
	
	/**
	 * Adds an element into the queue; into the back of the line
	 * @param element: the element to be added
	 */
	public void enqueue(E element) {
		Node<E> secondToLast = last;
		last = new Node<E>();
		last.setData(element);
		last.setNextNode(null);
		
		if (isEmpty()) first = last;
		else secondToLast.setNextNode(last);
		length++;
	}
	
	/**
	 * Removes the first element into the queue
	 * @return the element that was first in line
	 */
	public E dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue is empty.");
		else
			return dequeue(first);
	}
	
        /**
         * Removes the first element into the queue
         * @param node first node
         * @return element of first node
         */
	private E dequeue(Node<E> node) {
		
		E element = node.getData();
		first = node.getNextNode();
		length--;
		
		if (isEmpty()) last = null;
		return element;
	}
	
        @Override
	/**
	 * Prints out the entire queue into a readable format
         * @return list of entries in queue in order
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(E element: this) {
			str.append(element + " ");
		}
		return str.toString();
	}

	@Override
	/**
	 * An iterator to traverse through the queue
         * @return iterator for queue
	 */
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator<E>(first);
	}
	
	/**
	 * 
	 * Iterator class takes collection and goes over its elements
	 */
	private class MyIterator<E> implements Iterator<E> { 
		private Node<E> current;
		
		/**
		 * Creates an iterator
		 * @param first: current element
		 */
		public MyIterator(Node<E> first) {
			current = first;
		}
		
		/**
		 * Checks whether there is a next element in the iteration
		 */
		public boolean hasNext() {return current != null;}
		
		/**
		 * Removes last element returned by iterator
		 */
		public void remove() {throw new UnsupportedOperationException(); }
		
		/**
		 * Returns next element in the iteration
		 */
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E element = current.getData();
			current = current.getNextNode();
			return element;
		}
	}
	
}
