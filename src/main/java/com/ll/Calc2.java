package com.ll;

import java.util.Arrays;

public class Calc2 {
    public static void main(String[] args) {
        System.out.println(expSplit("5 - 3"));
    }

    public static void run(String exp){

    }

    public static int expSplit(String exp){
        String[] operators = exp.splitWithDelimiters("\\s*[+\\-*/]\\s*",-1);
        System.out.println(Arrays.toString(operators));

        int op1 = Integer.valueOf(operators[0]);
        String operand = operators[1].strip();
        int op2 = Integer.parseInt(operators[2]);

        switch (operand){
            case "+": return op1 + op2;
            case "-": return op1 - op2;
            case "*": return op1 * op2;
            case "/": return op1 / op2;
            default: return 0;
        }
    }
}
