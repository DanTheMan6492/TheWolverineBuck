package ADT;
import java.util.ArrayList; 

public class Stack<T> {
	
	ArrayList<T> stack;
	
	public Stack() {
		stack = new ArrayList<T>();
	}
	
	/*
	 * Add to the stack
	 */
	public void push(T t) {
		stack.add(t);
	}
	
	/*
	 * Pop from the stack if not empty
	 */
	public T pop() {
		if(empty()) return null;
		return stack.remove(size()-1);
	}
	
	/*
	 * Returns the number of elements in the Stack
	 */
	public int size() {
		return stack.size();
	}
	
	public boolean empty() {
		return size() == 0;
	}
	
	public T peek() {
		if(empty()) return null;
		return stack.get(size()-1);
	}
}