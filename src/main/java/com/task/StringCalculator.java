package com.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final String COMMA_OR_NEWLINE_DELIMITER = "\\R|,";
    public static final String NEW_LINE_DELIMITER = "\\R";
    public static final int ONE_THOUSAND = 1000;
    public static final int ZERO = 0;
    public static final String DOUBLE_SLASH = "//";

    public int add(String numbers) {
        String numbersSafe = Optional.ofNullable(numbers).orElse("");
        if (numbersSafe.isEmpty()) {
            return 0;
        }
        String[] strNumbers = checkDelimiterAndSplit(numbersSafe);
        List<String> negatives = new ArrayList<>();
        int sum = calculateSum(strNumbers, negatives);
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + String.join(",", negatives));
        }
        return sum;
    }

    private String[] checkDelimiterAndSplit(String numbersSafe) {
        String delimiter = COMMA_OR_NEWLINE_DELIMITER;
        if (numbersSafe.startsWith(DOUBLE_SLASH)) {
            delimiter = numbersSafe.split(NEW_LINE_DELIMITER)[0].substring(2);
            delimiter = delimiter.length() > 1
                    ? delimiter.substring(1, delimiter.length() - 1)
                    : delimiter;
            numbersSafe = numbersSafe.split(NEW_LINE_DELIMITER)[1];
            return delimiter.length() > 1
                    ? numbersSafe.split(Pattern.quote(delimiter))
                    : numbersSafe.split(delimiter);
        } else {
            return numbersSafe.split(delimiter);
        }
    }

    private int calculateSum(String[] strNumbers, List<String> negatives) {
        int sum = 0;
        for (String strNumber : strNumbers) {
            int number = Integer.parseInt(strNumber);
            if (number < ZERO) {
                negatives.add(strNumber);
            } else if (number <= ONE_THOUSAND) {
                sum += number;
            }
        }
        return sum;
    }

}
