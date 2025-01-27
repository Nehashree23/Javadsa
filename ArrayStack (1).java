public class ArrayStack {
    int[] stack;
    int top;
    int capacity;

    public ArrayStack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = 0; 
    }
	public void push(int value) {
        if (top == capacity) { 
            System.out.println("Stack Overflow");
        } else {
            stack[top] = value;
            top++;
            System.out.println(value + " pushed to stack");
        }
    }
	public int pop() {
        if (top == 0) { 
            System.out.println("Stack Underflow");
            return -1;
        } else {
            top--;
            return stack[top];
        }
    }
	public int peek() {
        if (top == 0) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top - 1];
        }
    }
	public boolean isEmpty() {
        return top == 0;
    }
	public int size() {
        return top;
    }
	public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5); 
		stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());

        System.out.println(stack.pop() + " popped from stack");

        System.out.println("Current size of stack is: " + stack.size());

        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }
}