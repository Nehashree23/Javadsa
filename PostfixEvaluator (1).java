import java.util.*;
class PostfixEvaluator{
	public static void main(String[] args){
		String expression = "2 3 1 * + 9 -"; 
		
		Stack<Integer> stack = new Stack<>();
		
		String[] tokens = expression.split(" ");
		
		for (String token : tokens) {
            if (token.equals("+") ||token.equals("-") ||token.equals("*") ||token.equals("/")) {
                int operand2 = stack.pop(); 
                int operand1 = stack.pop();
				switch (token) {
					case "+":
						stack.push( operand1 + operand2);
						break;
					case "-":
						stack.push( operand1 - operand2);
						break;
					case "*":
						stack.push( operand1 * operand2);
						break;
					case "/":
						stack.push( operand1 / operand2);
						break;
					default:
						System.out.println("Invalid operator");
				}				
            } 
			else {
                stack.push(Integer.parseInt(token));
            }
        }
        System.out.println( stack.pop());
    }
}


/*
import java.util.*;
class PostfixEvaluator{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine(); 
		int result = evaluatePostfix(expression);
        System.out.println(result);
        
    }

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
		for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop(); 
                int operand1 = stack.pop(); 
                int result = applyOperator(operand1, operand2, token); 
                stack.push(result); 
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
	private static int applyOperator(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
	}
}
*/