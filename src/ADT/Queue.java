package ADT;

public class Queue<T>{

    /* to be completed */
    //instance variables
    Stack<T> pushStack;
    Stack<T> popStack;
    /* to be completed */
    //constructor
    
    public Queue() {
    	pushStack = new Stack<T>();
        popStack = new Stack<T>();
    }

    //remove and return the element at the beginning of the list
    public T dequeue(){
        if(popStack.size() == 0){
            while(pushStack.size() > 0){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }


    //add element at the end of the list
    public void enqueue(T el){
      pushStack.push(el);
    }

    //return a String representation of the list
    //formatted as [el1, el2, el3, ..., elN]
    public String toString(){
    	Stack<T> temp = new Stack<T>();
    	while(popStack.size() > 0){
    		temp.push(popStack.pop());
        }
    	while(pushStack.size() > 0){
            popStack.push(pushStack.pop());
        }
    	while(popStack.size() > 0){
    		temp.push(popStack.pop());
        }
    	pushStack = temp;
    	String result = "";
    	while(pushStack.size() > 0){
    		T el = pushStack.pop();
    		result = ", " + el + result;
            popStack.push(el);
        }
        return "[" + result.substring(2) + "]";
    }


    public int size(){
      return pushStack.size() + popStack.size();
    }
    
    public boolean empty() {
    	return size() == 0;
    }
    
    public T peek() {
    	if(popStack.size() == 0){
            while(pushStack.size() > 0){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

}
