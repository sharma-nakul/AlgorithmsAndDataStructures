package cmpe.sjsu.Stack;

/* Algorithm

 1. Create a stack
 2. For each character t in the expression
 - If t is an operand, append it to the output
 - Else if t is ')',then pop from the stack till '(' is encountered and append
 it to the output. do not append '(' to the output.
 - If t is an operator or '('
 -- If t has higher precedence than the top of the stack, then push t
 on to the stack.
 -- If t has lower precedence than top of the stack, then keep popping
 from the stack and appending to the output until either stack is
 empty or a lower priority operator is encountered.

 After the input is over, keep popping and appending to the output until the
 stack is empty.

 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Naks on 26-Oct-15.
 * Conversion of Infix to Postfix expression using Stack
 */
public class ExpressionConversion extends StackArray {

    ArrayList<String> expressionList;

    ExpressionConversion(int maxSize) {
        super(maxSize);
        this.expressionList = new ArrayList<>();
    }

    public ArrayList<String> readExpression(String fileName) {
        File expressionFile = new File(fileName);
        try {
            Scanner sc = new Scanner(expressionFile);
            while (sc.hasNext()) {
                expressionList.add(sc.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expressionList;
    }

    private int operatorPriority(char operatorToCheck) {
        switch (operatorToCheck) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'
                || c == '(' || c == ')';
    }

    public String InfixToPostFix(String infixExpression) {
        String postFixExpression = "";
        Object operator;
        String e = infixExpression;
        int encounteredCharacter = 0;
        while (encounteredCharacter < infixExpression.length()) {
            char currentCharacter = infixExpression.charAt(encounteredCharacter);

            if (currentCharacter == '(')
                push(currentCharacter);

            else if (currentCharacter == ')') {
                operator = peek();
                //Iterate & pop till you find opening parentheses and stack is not empty
                while (!(operator.equals('(')) && !(isEmptyStack())) {
                    postFixExpression += operator.toString();
                    pop();
                    operator = peek();
                }
                pop(); // To pop opening parentheses as we have already resolved this sub-expression
            }
                    /* Here we check if stack is empty, push the operator. Otherwise check whether
                        operator at top of the stack is of higher precedence or not.
                     */
            else if (currentCharacter == '-' || currentCharacter == '+') {
                if (isEmptyStack())
                    push(currentCharacter);
                else {
                    operator = peek();
                    while (!(isEmptyStack() || operator.equals('(') || operator.equals(')'))) {
                        pop();
                        postFixExpression += operator.toString();
                    }
                    push(currentCharacter);
                }
            } else if (currentCharacter == '*' || currentCharacter == '/') {
                if (isEmptyStack())
                    push(currentCharacter);
                else {
                    operator = peek();
                    while (!operator.equals('+') && !operator.equals('-') && !isEmptyStack()) {
                        pop();
                        postFixExpression += operator.toString();
                    }
                    push(currentCharacter);
                }
            } else
                postFixExpression += currentCharacter;
            encounteredCharacter++;
        }
        while (!isEmptyStack()) {
            operator = peek();
            if (!operator.equals('(')) {
                pop();
                postFixExpression += operator.toString();
            }
        }
        return postFixExpression;
    }

    public static void main(String[] args) {
        ExpressionConversion infix2Postfix = new ExpressionConversion(100);
        ArrayList<String> expressionList = infix2Postfix.readExpression("resources/expression.txt");
        for (int i = 0; i < expressionList.size(); i++) {
            System.out.println("Working on Expression -> " + expressionList.get(i));
            System.out.println("The Equivalent Postfix Expression is :\n" + infix2Postfix.InfixToPostFix(expressionList.get(i)));
        }

    }
}

