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
            String minuend = sc.next().trim();
            if (minuend.isEmpty()) {
                break;
            }
            if (!isNumeric(minuend)) {
                System.out.println("Minued must be numeric");
                continue;
            }
            System.out.println("Please enter the subtrahend. Newline terminates.");
            String subtrahend = sc.next().trim();
            if (subtrahend.isEmpty()) {
                break;
            }
            if (!isNumeric(subtrahend)) {
                System.out.println("Subtrahend must be numeric");
                continue;
            }
            parseAndCalculate(minuend, subtrahend);

        }

    }

    private double parseAndCalculate(String minuend, String subtrahend) {
        double valueOne = Double.parseDouble(minuend);
        double valueTwo = Double.parseDouble(subtrahend);
        double answer = 0;
        if(valueOne > valueTwo){
        
        }
        else{
        
        }
        return answer;
    }
    
    private double calculate(double minuend, double subtrahend){
        return 0;
    }

    private boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        return s.matches("^[0-9]+.?[0-9]+$");
    }

}
