//import java.util.Stack;
//import java.lang.Math;
//
///**
// * Created by Pratik on 9/2/2015.
// */
//public class MyCalculator {
//    private static Stack<String> OPERANDS = new Stack<>(); // stack for operands
//    private static Stack<String> OPERATORS = new Stack<>();// stack for operator
//    private String[] expression;
//
//
//    public MyCalculator(String[] expression) {
//        this.expression = expression;
//    }
//
//    public void makeExpression() {
//        for (String str: this.expression) {
//            if(isDigit(str)) {
//                OPERANDS.push(str);
//            } else if(isOperator(str)) {
//                processOperator(str.charAt(0));
//            }//else if(isOpenParenthesis(str)) {
//
//                MyCalculator innerExpression = new MyCalculator();
//            }else {
//                System.out.println("Invalid input... " +
//                        "Please check your expression");
//                System.exit(0);
//            }
//        }
//    }
//
//    /**
//     * This method checks if the string input is numeric.
//     *
//     * @param       input    String input that needs to be checked.
//     *
//     * @return               boolean true if the input is numeric else false.
//     */
//    public static boolean isDigit(String input) {
//        return input.matches("\\d+");
//    }
//
//    /**
//     * This method checks if the string input is an operator.
//     *
//     * @param       input    String input that needs to be checked.
//     *
//     * @return               boolean true if the input is operator else false.
//     */
//    public static boolean isOperator(String input) {
//        return (input.equals("^") || input.equals("+") || input.equals("-") || input.equals("*") ||
//                input.equals("/") || input.equals("%"));
//    }
//
//    /**
//     * This method will process an operator based on its precedence. It checks
//     * the precedence of last pushed operator with the input. If the input has
//     * lower precedence then it will evaluate the operator on the stack and then
//     * it will push the input.
//     *
//     * @param       input    Single char input which is the input operator.
//     */
//    public static void processOperator(char input) {
//        int result;
//        if (!OPERATORS.empty()) {
//            char currentOperator = OPERATORS.peek().charAt(0);
//            if (precedenceOf(input) < precedenceOf(currentOperator)) {
//                result = calculate(OPERANDS.pop(), OPERATORS.pop().charAt(0),
//                        OPERANDS.pop());
//                OPERANDS.push(String.valueOf(result));
//                processOperator(input);
//            } else {
//                OPERATORS.push(String.valueOf(input));
//            }
//        } else {
//            OPERATORS.push(String.valueOf(input));
//        }
//    }
//
//    /**
//     * This method will return precedence value of an operator.
//     *
//     * @param       operator    Single char input which is the input operator.
//     *
//     * @return                  Integer between 1-5 as precedence value of the
//     *                          operator
//     */
//    public static int precedenceOf(char operator) {
//        switch (operator) {
//            case '^':
//                return 6;
//            case '*':
//                return 5;
//            case '/':
//                return 4;
//            case '%':
//                return 3;
//            case '-':
//                return 2;
//            case '+':
//                return 1;
//            default: return -1;
//        }
//    }
//
//    /**
//     * This method will perform arithmetic operation on given operands.
//     *
//     * @param       operator    Single char input which is the input operator.
//     * @param       operand1    String first operand.
//     * @param       operand2    String second operand.
//     *
//     * @return                  Result of evaluation of expression.
//     */
//    public static int calculate(String operand1, char operator, String operand2) {
//        int firstOperand = Integer.parseInt(operand1);
//        int secondOperand = Integer.parseInt(operand2);
//        switch (operator) {
//            case '+':
//                return (firstOperand + secondOperand);
//            case '-':
//                return (secondOperand - firstOperand);
//            case '*':
//                return (firstOperand * secondOperand);
//            case '/':
//                return (secondOperand / firstOperand);
//            case '%':
//                return (secondOperand % firstOperand);
//            case '^':
//                return (int)Math.pow(secondOperand, firstOperand);
//            default:
//                return 0;
//        }
//    }
//
//    /**
//     * This method will evaluate all the operators on operator stack.
//     */
//    public static void evaluateExpression() {
//        while ((!OPERATORS.empty()) || (OPERANDS.size() > 1)) {
//            try {
//                String op1 = OPERANDS.pop();
//                String op2 = OPERANDS.pop();
//                String operator = OPERATORS.pop();
//                OPERANDS.push(String.valueOf(calculate(op1, operator.charAt(0),
//                        op2)));
//            } catch (Exception e) {
//                System.out.println("Invalid input");
//                System.exit(0);
//            }
//        }
//        System.out.println(OPERANDS.pop());
//    }
//}
