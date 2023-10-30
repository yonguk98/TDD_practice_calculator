package com.ll;

public class Calc {
    public int run(String eq){
        return evaluateExpression(eq);
    }

    private static int evaluateExpression(String expression) {
        int length = expression.length();
        int index = 0;
        int operand1 = 0;
        char operator = '\0';
        boolean waitingForOperand = true;

        while (index < length) {
            char currentChar = expression.charAt(index);
            if (Character.isDigit(currentChar)) {
                int operand = 0;
                while (index < length && Character.isDigit(expression.charAt(index))) {
                    operand = operand * 10 + Character.getNumericValue(expression.charAt(index));
                    index++;
                }
                if (waitingForOperand) {
                    operand1 = operand;
                } else {
                    operand1 = applyOperator(operand1, operand, operator);
                }
                waitingForOperand = false;
            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                operator = currentChar;
                waitingForOperand = false;
                index++;
            } else if (currentChar == '(') {
                // 괄호 안의 식을 평가하고 결과를 현재 연산에 적용
                int endIndex = findClosingParenthesis(expression, index);
                int subExpressionValue = evaluateExpression(expression.substring(index + 1, endIndex));
                if (waitingForOperand) {
                    operand1 = subExpressionValue;
                } else {
                    operand1 = applyOperator(operand1, subExpressionValue, operator);
                }
                waitingForOperand = false;
                index = endIndex + 1;
            } else if (currentChar == ' ') {
                index++;
            } else {
                throw new IllegalArgumentException("잘못된 문자가 포함되어 있습니다.");
            }
        }

        return operand1;
    }

    private static int findClosingParenthesis(String expression, int startIndex) {
        int count = 1;
        for (int i = startIndex + 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                count++;
            } else if (expression.charAt(i) == ')') {
                count--;
                if (count == 0) {
                    return i;
                }
            }
        }
        throw new IllegalArgumentException("올바른 괄호가 없습니다.");
    }

    private static int applyOperator(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
            default:
                throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
        }
    }
}
