package org.noamicahel.tenscomplement;

import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class ComplementCalculator {

    /**
     * Prompts the user for input and calculates the difference of the two
     * numbers using nine's complement.
     */
    public void startCalculationProcess() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter the minuend. Newline terminates.");
            String minuend = sc.nextLine().trim();
            if (minuend.isEmpty()) {
                break;
            }
            while (!isNumeric(minuend)) {
                System.out.println("Minued must be numeric");
                minuend = sc.nextLine().trim();
            }
            System.out.println("Please enter the subtrahend. Newline terminates.");
            String subtrahend = sc.nextLine().trim();
            if (subtrahend.isEmpty()) {
                break;
            }
            while (!isNumeric(subtrahend)) {
                System.out.println("Subtrahend must be numeric");
                subtrahend = sc.nextLine().trim();
            }
            System.out.println("The answer is " + parseAndCalculate(minuend, subtrahend));

        }

    }

    /**
     * Parses a number and performs the actual operation
     *
     * @param minuend The number to subtract from
     * @param subtrahend The number to be subtracted
     * @return
     */
    private Long parseAndCalculate(String minuend, String subtrahend) {
        Long valueOne = Long.parseLong(minuend);
        Long valueTwo = Long.parseLong(subtrahend);
        return valueOne > valueTwo
                ? calculate(valueOne, valueTwo, false) : calculate(valueTwo, valueOne, true);
    }

    /**
     * Performs the subtraction of the given numbers using only addition.
     *
     * @param minuend The number to subtract from
     * @param subtrahend The number to be subtracted
     * @param negative A boolean to indicate whether the operation will produce
     * a negative number
     * @return
     */
    private Long calculate(Long minuend, Long subtrahend, boolean negative) {
        Long subtrahendComplement = getNinesComplement(subtrahend, String.valueOf(minuend).length());
        Long undroppedAnswer = (minuend + subtrahendComplement) + 1;
        String signed = String.valueOf(undroppedAnswer).substring(1);
        if (negative) {
            signed = "-" + signed;
        }
        return Long.parseLong(signed);
    }

    /**
     * Returns true if the string matches the numeric regular expression
     *
     * @param s
     * @return
     */
    private boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        return s.matches("^[0-9]+$");
    }

    /**
     * Converts a {@link Long} into nine's complement with padding based on the
     * length of the minuend
     *
     * @param subtrahend The number to take the complement of
     * @param length The length of the minuend
     * @return The complement of the number
     */
    private Long getNinesComplement(Long subtrahend, int length) {
        int padding = length - String.valueOf(subtrahend).length();
        String complment = "";
        for (int i = 0; i < padding; i++) {
            complment += "9";
        }
        char[] subtrahendArray = String.valueOf(subtrahend).toCharArray();
        for (char c : subtrahendArray) {
            complment += getNinesComplement(c);
        }
        return Long.parseLong(complment);
    }

    /**
     * Finds nine's complement of the given character if the character is
     * numeric. Returns 0 otherwise.
     *
     * @param c The character to find the complement of
     * @return The complement of the parameter
     */
    private char getNinesComplement(char c) {
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
