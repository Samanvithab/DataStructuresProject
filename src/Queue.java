import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of Queue for use in our final project
 * Utilizes FIFO sequence for adding and removing new items
 */
public class Queue<E> implements Iterable<E>{
	private Node<E> first;
	private Node<E> last;
	private int length;
	
	private static class Node<E> {
		private E element;
		private Node<E> next;
	}
	
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
	 * @return the first element
	 */
	public E peek() {
		if (isEmpty()) throw new NoSuchElementException("Queue is empty.");
		return first.element;
	}
	
	/**
	 * Adds an element into the queue; into the back of the line
	 * @param element: the element to be added
	 */
	public void enqueue(E element) {
		Node<E> secondToLast = last;
		last = new Node<E>();
		last.element = element;
		last.next = null;
		
		if (isEmpty()) first = last;
		else secondToLast.next = last;
		length++;
	}
	
	
	/**
	 * Removes the first element into the queue
	 * @return the element that was first in line
	 */
	public E dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue is empty.");
		E element = first.element;
		first = first.next;
		length--;
		
		if (isEmpty()) last = null;
		return element;
	}
	
	/**
	 * Prints out the entire queue into a readable format
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
			E element = current.element;
			current = current.next;
			return element;
		}
	}
	
}
