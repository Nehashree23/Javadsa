import java.util.*;
class BalancedParenthesesChecker {
    public static void main(String[] args) {
        String expression = "{(a+b)*[c-d)}";
		Stack<Character> stack = new Stack<>();
		boolean isBalanced = true; 
		for (char ch : expression.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == '}' || ch == ')' || ch == ']') {
				if (stack.isEmpty()){
					isBalanced = false; 
					break;
				}
				char tem = stack.pop();
                if (!(tem == '(' && ch == ')') && !(tem == '[' && ch == ']') && !(tem == '{' && ch == '}')) {
                    isBalanced = false;
					break;
				}
            }
        }
		if (!stack.isEmpty()) {
            isBalanced = false; 
        }
		System.out.println(isBalanced);
    }
}

 




/*import java.util.Stack;
import java.util.Scanner;

class BalancedParenthesesChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();
		boolean result = isBalanced(expression);
		System.out.println(result);
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
		for (char ch : expression.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false; 
                }
            }
        }
        return stack.isEmpty();
    }
		private static boolean isMatchingPair(char open, char close) {
        return (open == '{' && close == '}') ||
               (open == '(' && close == ')') ||
               (open == '[' && close == ']');
    }
}
*/