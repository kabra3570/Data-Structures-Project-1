/**Author: Kevin Abrahams
 * Date: 01-06-2020
 * Description: ExpressionConverter - Provide a class which implements an algorithm to convert postfix to prefix expressions and vice-versa.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionConverter {
	
    public static String prefixToPostfix(String exp) throws SyntaxError {
        if (null != exp && !exp.trim().isEmpty()) {
            Stack<String> operandStack = new Stack<>();
            Stack<String> reversalStack = new Stack<>();
            // Parse the expression and create stack of tokens
            String token = "";
            StringBuffer sb = new StringBuffer(exp);
            if (exp.length() == 3) 
            	sb.insert(2, " ");
            
         
            for (char c : sb.toString().toCharArray()) {
            	

                if (isOperator(c)) {
                    if (!token.isEmpty()) {
                        reversalStack.push(token);
                        token = "";
                    }
                    reversalStack.push(String.valueOf(c));
                } else {
                    if (!Character.isSpaceChar(c)) {
                        token += c;
                    } else {
                        if (!token.isEmpty()) {
                            reversalStack.push(token);
                            token = "";
                        }
                    }
                }
            }
            if (!token.isEmpty()) {
                reversalStack.push(token);
                token = "";
            }
            // Loop over the stack and convert post fix expression to prefix
            try {
                while (!reversalStack.empty()) {
                    if (!isOperator(reversalStack.peek())) {
                        operandStack.push(reversalStack.pop());
                    } else {
                        operandStack.push(operandStack.pop() + " " + operandStack.pop() + " " + reversalStack.pop());
                    }
                }
            } catch (Exception e) {
                throw new SyntaxError("Invalid expression");
            }
            return operandStack.pop();
        } else {
            throw new SyntaxError("Expression is required");
        }
    }

    public static String postToPrefix(String exp) throws SyntaxError {
        if (null != exp && !exp.trim().isEmpty()) {
            Stack<String> operandStack = new Stack<>();

            // Create Queue of tokens
            Queue<String> queue = new LinkedList<>();
            String token = "";
            StringBuffer sb = new StringBuffer(exp);
            if (exp.length() == 3)
            	sb.insert(1, " ");

            for (char c : sb.toString().toCharArray()) {

                if (isOperator(c)) {
                    if (!token.isEmpty()) {
                        queue.add(token);
                        token = "";
                    }
                    queue.add(String.valueOf(c));
                } else {
                    if (!Character.isSpaceChar(c)) {
                        token += c;
                    } else {
                        if (!token.isEmpty()) {
                            queue.add(token);
                            token = "";
                        }
                    }
                }
            }
            if (!token.isEmpty()) {
                queue.add(token);
                token = "";
            }
            try {
                // Loop over the queue and convert post fix expression to prefix
                while (!queue.isEmpty()) {
                    if (!isOperator(queue.peek())) {
                        operandStack.push(queue.poll());
                    } else {
                        String op1 = operandStack.pop();
                        String op2 = operandStack.pop();
                        operandStack.push(queue.poll() + " " + op2 + " " + op1);
                    }
                }
            } catch (Exception e) {
                throw new SyntaxError("Invalid expression");
            }
            return operandStack.pop();
        } else {
            // Expression is throw
            throw new SyntaxError("Expression is required");
        }
    }
    /**
     * given character is operator or not Check
     *
     * @param c - Character
     * @return True/false
     */
    public static boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }

    /**
     * given character is operator or not Check
     *
     * @param c - Character
     * @return True/false
     */
    public static boolean isOperator(String c) {
        switch (c) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
        }
        return false;
    }
}