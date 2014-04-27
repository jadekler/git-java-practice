package com.jadekler.sheri;

import java.util.HashMap;

/**
 * Write some code that will accept an amount and convert it to the appropriate string representation.
 * Example: Convert 2523.04 to "Two thousand five hundred twenty-three and 04/100 dollars"
 */
public class NumberWords {
    char inputStringBeforePeriod[];
    char inputStringAfterPeriod[];
    String simpleDigits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    public NumberWords(float inputNumber) {
        this.inputStringBeforePeriod = Float.toString(inputNumber).split("\\.")[0].toCharArray();
        this.inputStringAfterPeriod = Float.toString(inputNumber).split("\\.")[1].toCharArray();
    }

    public String compile() {
        String compiledString = "";
        boolean beforeDecimal = true;

        for (int i = 0; i < this.inputStringBeforePeriod.length; i++) {
            if (i == this.inputStringBeforePeriod.length-2) {
                // Last two (teen) characters
                String teenNum = String.valueOf(this.inputStringBeforePeriod[i])+String.valueOf(this.inputStringBeforePeriod[i+1]);
                int charInt = Integer.parseInt(teenNum);
                compiledString += simpleDigits[charInt];
                i++; // (to skip the single digit after the 'teens', since we account for it in this block)
            } else {
                // Other characters before the teens
                char charChar = this.inputStringBeforePeriod[i];
                int charInt = Character.getNumericValue(charChar);
                compiledString += simpleDigits[charInt];
            }
        }

        char charChar = this.inputStringAfterPeriod[0];
        compiledString += " and "+charChar+"/10";
        
        return compiledString;
    }
}