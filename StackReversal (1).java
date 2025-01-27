import java.util.*;

public class StackReversal {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(" ");
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> result = new Stack<>();
		    
        for (String s : input) {
            stack.push(Integer.parseInt(s));
        }
		int n = stack.size();
		for (int i = 0; i < n; i++){
			result.push(stack.pop());
		}
        for (int i = 0; i < n; i++) {
            System.out.print(result.get(i) + " ");
        }
        
        scanner.close();
    }
	
   
}
/*
import java.util.*;

public class StackReversal {

    // Basic stack operations
    public static void push(Stack<Integer> stack, int item) {
        stack.push(item);
    }

    public static int pop(Stack<Integer> stack) {
        return stack.pop();
    }

    public static void show(Stack<Integer> stack) {
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    public static boolean empty(Stack<Integer> stack) {
        return stack.isEmpty();
    }

    // Method to insert an element at the bottom of the stack
    public static void BottomInsertion(Stack<Integer> stack, int item) {
        if (empty(stack)) {
            push(stack, item);
        } else {
            int temp = pop(stack);
            BottomInsertion(stack, item);
            push(stack, temp);
        }
    }

    // Recursive method to reverse the stack
    public static void Reverse(Stack<Integer> stack) {
        if (!empty(stack)) {
            int temp = pop(stack);
            Reverse(stack);
            BottomInsertion(stack, temp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input handling
        Stack<Integer> stack = new Stack<>();
        String[] input = scanner.nextLine().split(" ");
        
        for (String s : input) {
            stack.push(Integer.parseInt(s));
        }

        // Reverse the stack
        Reverse(stack);

        // Display the reversed stack
        show(stack);
        
        scanner.close();
    }
}
*/