
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

public class Foo{
    public static void main(String[] args) throws IOException{
        System.out.println("Hello world!");
//        DataInputStream di = new DataInputStream(System.in);
//        String str = di.read(args[0]);
        //System.out.println(args[0]);

        //String  str = "2 + 4 + 67";
        String[] strArr = args[0].split("/*\\s");
        for(String strm:args) {
            System.out.println(strm);
        }

        Stack<String> ss = new Stack<>();
        ss.addElement("Pratik");
        ss.push("kulkarni");
        System.out.println(ss.pop());
        System.out.println(ss.pop());
    }

    /**
     * Created by Pratik on 8/29/2015.
     */

//    import java.io.IOException;
//    import java.util.Stack;
//
//    public class Calculator {
//
//        private static Stack<String> operands = new Stack<>();
//        private static Stack<String> operators = new Stack<>();
//        private static boolean eval = false;
//
//        public static void main(String[] args) throws IOException {
//            if (args[0] == null) {
//                System.out.println("Please enter some string");
//                System.exit(0);
//            }
//            int result;
//            for (String str: args) {
//                if(isDigit(str)) {
//                    operands.push(str);
//                    if(eval) {
//                        result = calculate(operands.pop(), operators.pop().charAt(0),operands.pop());
//                        operands.push(String.valueOf(result));
//                        eval = false;
//                    }
//                } else if(isOperator(str)) {
//                    processOperator(str.charAt(0));
//                }else {
//                    System.out.println("Invalid input... Please check your expression");
//                    System.exit(0);
//                }
//            }
//            evaluateExpression();
//        }
//
//        public static boolean isDigit(String input) {
//            return input.matches("\\d+");
//        }
//
//        public static boolean isOperator(String input) {
//            return (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("%"));
//        }
//
//        public static void processOperator(char input) {
//            if (!operators.empty()) {
//                char currentOperator = operators.peek().charAt(0);
//                int precedence = checkPrecedence(input, currentOperator);
//                if (precedence == 0) {
//                    eval = true;
//                }
//            }
//            operators.push(String.valueOf(input));
//        }
//
//        public static int checkPrecedence(char input, char currentOperator) {
//            switch (currentOperator) {
//                case '*':
//                case '/':
//                    return 1;
//                case '%':
//                    if(input == '*' || input == '/')
//                        return 0;
//                    else
//                        return 1;
//                case '+':
//                case '-':
//                    if(input == '*' || input == '/' || input == '%')
//                        return 0;
//                    else
//                        return 1;
//                default: return -1;
//            }
//        }
//
//        public static int calculate(String operand1, char operator, String operand2) {
//            int firstOperand = Integer.parseInt(operand1);
//            int secondOperand = Integer.parseInt(operand2);
//            switch (operator) {
//                case '+':
//                    return (firstOperand + secondOperand);
//                case '-':
//                    return (secondOperand - firstOperand);
//                case '*':
//                    return (firstOperand * secondOperand);
//                case '/':
//                    return (secondOperand / firstOperand);
//                case '%':
//                    return (secondOperand % firstOperand);
//                default:
//                    return 0;
//            }
//        }
//
//        public static void evaluateExpression() {
//            while ((!operators.empty()) || (operands.size() > 1)) {
//                try {
//                    String op1 = operands.pop();
//                    String op2 = operands.pop();
//                    String operator = operators.pop();
//                    operands.push(String.valueOf(calculate(op1, operator.charAt(0), op2)));
//                } catch (Exception e) {
//                    System.out.println("Invalid input");
//                    System.exit(0);
//                }
//            }
//            System.out.println(operands.pop());
//        }
//    }
}
