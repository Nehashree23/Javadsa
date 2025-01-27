import java.util.*;

class InfixToPostfixConverter {
    
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3; 
            default:
                return -1; 
        }
    }
	public static void main(String[] args) {
        String infix = "( ( D - Q ) * G + ( A / H ) ) - R";
		StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
		for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c).append(' ');
            }  
            else if (c == '(') {
                stack.push(c);
            } 
             else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.pop(); 
            } 
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
					postfix.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }
		while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }

        System.out.println( postfix.toString().trim());

         
    }
}
/*
import java.util.*;

class InfixToPostfixConverter {
    
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3; 
            default:
                return -1; 
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c).append(' ');
            } 
            else if (c == '(') {
                stack.push(c);
            } 
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.pop(); 
            } 
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    if (c == '^' && stack.peek() == '^') {
                        break; 
                    }
                    postfix.append(stack.pop()).append(' ');
                }
                stack.push(c); 
            }
        }
		while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }

        return postfix.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String infix = scanner.nextLine();

        String postfix = infixToPostfix(infix);
        System.out.println(postfix);

        scanner.close(); 
    }
}
*/
