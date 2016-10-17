import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 表达式求值，考虑负数
 * Created by MarsWang on 2016/10/16.
 */
public class Expression {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String expression = in.next();
        Integer res = getExpressionResult(expression);
        System.out.println(res);
    }

    private static Integer getExpressionResult(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int i = 0;
        boolean negative = false;
        while (i < expression.length()){
            char c = expression.charAt(i);
            if (isOperand(expression.charAt(i))) {
                int j = i;
                while (j < expression.length() && isOperand(expression.charAt(j)))
                    j++;
                operandStack.add(Integer.parseInt(expression.substring(i, j)));
                if (negative) {
                    negative = false;
                    operandStack.add(operandStack.pop() * (-1));
                    if (j < expression.length() && expression.charAt(j) == ')')
                        j++;
                    if (!operatorStack.isEmpty())
                        operatorStack.pop();
                }
                i = j;
            } else{
                //碰到右括号则直接弹出操作符和操作数进行括号内的最后一步运算
                if (c == '-' && (i == 0 || expression.charAt(i-1) == '(')) {
                    negative = true;
                    i++;
                    continue;
                }
                if (c == ')'){
                    while (operatorStack.peek() != '(')
                        operandStack.push(doOperation(operandStack.pop(), operatorStack.pop(),operandStack.pop()));
                    operatorStack.pop();//弹出左括号
                }else if (c == '(' || operatorStack.isEmpty() || getOperatorPriority(c) > getOperatorPriority(operatorStack.peek()))
                    operatorStack.add(c);//左括号或者遇到的运算符优先级高于操作符栈顶运算符就入栈
                else {
                    //遇到的运算符优先级比操作符栈顶优先级低则使用操作符栈顶运算符进行一次运算
                    operandStack.push(doOperation(operandStack.pop(), operatorStack.pop(),operandStack.pop()));
                    operatorStack.add(c);
                }
                ++i;
            }
        }
        while (!operatorStack.isEmpty()){
            operandStack.push(doOperation(operandStack.pop(), operatorStack.pop(),operandStack.pop()));
        }
        return operandStack.pop();
    }

    private static Integer doOperation(Integer operand1, Character operator, Integer operand2) {
       int res = 0;
        switch (operator){
            case '*': res = operand2 * operand1; break;
            case '/': res = operand2 / operand1; break;
            case '+': res = operand2 + operand1; break;
            case '-': res = operand2 - operand1; break;
        }
        return res;
    }

    private static int getOperatorPriority(char c) {
        int priority;
        switch (c){
            case '*': priority = 2;break;
            case '/': priority = 2;break;
            case '+': priority =  1;break;
            case '-': priority =  1;break;
            default: priority = 0;//左括号
        }
        return priority;
    }


    private static boolean isOperand(char c) {
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }
}
