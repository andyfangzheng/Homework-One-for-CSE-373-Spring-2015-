//CSE 373 A
//Homework 1
//Fangzheng Sun
//04/07/2015

//The class ListQueue constructs the structure ListQueue and provides several 
//types of methods such as enqueue and dequeue.

public class ListQueue {
	
	private int size;
	private ListQueueNode front;
	private ListQueueNode back;
   
   //The private class ListQueueNode is uesed to help constructing the Listqueue.
   //It gives the format of constructing the new ListQueueNode.
   private static class ListQueueNode {
      private String data;
      private ListQueueNode next;
      
      //This defines what the given values do in a new LIstQueueNode.
      public ListQueueNode(String data, ListQueueNode next) {
         this.data = data;
         this.next = next;
      }
   }
	
   //The constructor gives the initial values of an empty Listqueue.
	public ListQueue(){
		front = null;
		back = null;
		size = 0;
	}
	

	/**
	 * @function returns the number of elements in the queue
	 * @return size
	 */
	public int getSize(){
		return size;
	}
	/**
	 * @function adds a string to the end of the queue
	 * @param toEnqueue: the input to be inserted
	 */
	public void enqueue(String toEnqueue){
      ListQueueNode node = new ListQueueNode(toEnqueue, null);
		size++;
      if(front == null){
         front = node;
      }else{
         back.next = node;
	   }
      back = node;
   }
	
	/**
	 * @function removes the string from the front of the queue
	 * @return the string from the front of the queue
	 */
	public String dequeue(){
		if(isEmpty()){
         return null;
      }
      size--;
      String result = front.data;
      front = front.next;
      return result;
	}
	
	/**
	 * 
	 * @return returns true if the queue is empty, false otherwise
	 */
	public boolean isEmpty(){
		return size == 0;
	}


}
