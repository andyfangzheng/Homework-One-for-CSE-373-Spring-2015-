//CSE 373 A
//Homework 1
//Fangzheng Sun
//04/07/2015

//For extra credit(doubling the size when the array is full.

//The class ArrayQueue constructs the structure ArrayQueue and provides several 
//types of methods such as enqueue and dequeue.

public class ArrayQueue {
	private String[] queueArray;
	private int size;
	private int front;
	private int back;
	
   //The constructor initializes the ArrayQueue to an enmpty one. If no given 
   //size, the defult should be 100.
	public ArrayQueue(){
		queueArray = new String[100];
		size = 0;
		front = 0;
		back = -1;
	}
	
   //The constructor initializes the ArrayQueue to an enmpty one. The size of the 
   //arrayqueue is given.
	public ArrayQueue(int startSize){
		queueArray = new String[startSize];
		size = 0;
		front = 0;
		back = -1;
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
    * if the queue is full, size will be doubled.
	 */
	public void enqueue(String toEnqueue){
      if(isFull()){
         doubleSize(size);
      }
      size++;
      back = (back + 1) % size;
      queueArray[back] = toEnqueue;
	}
   
   //The private method doubleSize is uesd to double the size of the queue 
   //when the queue is full.
   private void doubleSize(int oldSize){
       String[] temp = new String[oldSize * 2];
       for(int i = 0; i < oldSize; i++){
          temp[i] = queueArray[i];
       }
       queueArray = temp;
   }
	
	/**
	 * @function removes the string from the front of the queue
	 * @return the string from the front of the queue
	 */
	public String dequeue(){
      if(isEmpty()){
         return null;
      }
      String result = queueArray[front];
      front = (front + 1) % size;
      size--;
		return result;
	}
	
	/**
	 * 
	 * @return returns true if the queue is empty, false otherwise
	 */
	public boolean isEmpty(){
      return size == 0;
	}

	/**
	 * 
	 * @return returns true if the queue is full, false otherwise
	 */
	public boolean isFull(){
      return back == queueArray.length - 1;
	}
	
}
