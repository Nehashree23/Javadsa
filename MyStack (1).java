import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;
	public MyStack() {
        queue = new LinkedList<>();
    }
	public void push(int x) {
        queue.add(x);
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }
	public int pop() {
        if (empty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; 
        }
        return queue.remove();
    }

    public int top() {
        if (empty()) {
            System.out.println("Stack is empty.");
            return -1; 
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); 
        System.out.println("Popped element: " + stack.pop()); 
        System.out.println("Top element after pop: " + stack.top()); 
        System.out.println("Is stack empty? " + stack.empty()); 
        
        stack.pop(); 
        stack.pop(); 
        System.out.println("Is stack empty after popping all elements? " + stack.empty()); // Should print true
    }
}
