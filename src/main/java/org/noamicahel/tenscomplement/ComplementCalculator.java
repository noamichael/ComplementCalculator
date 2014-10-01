package org.noamicahel.tenscomplement;

import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class ComplementCalculator {

    public void startCalculationProcess() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter the minuend. Newline terminates.");
            String minuend = sc.nextLine().trim();
            if (minuend.isEmpty()) {
                break;
            }
            if (!isNumeric(minuend)) {
                System.out.println("Minued must be numeric");
                continue;
            }
            System.out.println("Please enter the subtrahend. Newline terminates.");
            String subtrahend = sc.nextLine().trim();
            if (subtrahend.isEmpty()) {
                break;
            }
            if (!isNumeric(subtrahend)) {
                System.out.println("Subtrahend must be numeric");
                continue;
            }
            System.out.println(parseAndCalculate(minuend, subtrahend));

        }

    }

    private Integer parseAndCalculate(String minuend, String subtrahend) {
        Integer valueOne = Integer.parseInt(minuend);
        Integer valueTwo = Integer.parseInt(subtrahend);
        return valueOne > valueTwo
                ? calculate(valueOne, valueTwo, false) : calculate(valueTwo, valueOne, true);
    }

    private Integer calculate(Integer minuend, Integer subtrahend, boolean negative) {
        Integer subtrahendComplement = getNinesComplement(subtrahend, String.valueOf(minuend).length());
        Integer undroppedAnswer = (minuend + subtrahendComplement) + 1;
        String signed = String.valueOf(undroppedAnswer).substring(1);
        if (negative) {
            signed = "-" + signed;
        }
        return Integer.parseInt(signed);
    }

    private boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        return s.matches("[0-9]+");
    }

    public Integer getNinesComplement(Integer subtrahend, int length) {
        int padding = length - String.valueOf(subtrahend).length();
        String complment = "";
        for (int i = 0; i < padding; i++) {
            complment += "9";
        }
        char[] subtrahendArray = String.valueOf(subtrahend).toCharArray();
        for (char c : subtrahendArray) {
            complment += getNinesComplement(c);
        }
        return Integer.parseInt(complment);
    }

    public char getNinesComplement(char c) {
        switch (c) {
            case '0':
                return '9';
            case '1':
                return '8';
            case '2':
                return '7';
            case '3':
                return '6';
            case '4':
                return '5';
            case '5':
                return '4';
            case '6':
                return '3';
            case '7':
                return '2';
            case '8':
                return '1';
            case '9':
                return '0';
            default:
                return 0;
        }
    }

}
