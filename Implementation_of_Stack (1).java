import java.util.Stack;

public class Implementation_of_Stack {

    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
		stack.push(10);
        stack.push("srikanth");
        stack.push(30);
		System.out.println("Popped element: " + stack.pop());
		System.out.println("Top element: " + stack.peek());
		System.out.println("Is stack empty? " + stack.isEmpty());
		System.out.println("Stack size: " + stack.size());
    }
}
