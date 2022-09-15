package com.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringCalculator {
    public static final String COMMA_OR_NEWLINE_DELIMITER = "\\R|,";
    public static final String NEW_LINE_DELIMITER = "\\R";
    public static final int ONE_THOUSAND = 1000;
    public static final int ZERO = 0;

    public int add(String numbers) {
        String numbersSafe = Optional.ofNullable(numbers).orElse("");
        if (numbersSafe.isEmpty()) {
            return 0;
        }
        String delimiter = COMMA_OR_NEWLINE_DELIMITER;
        if (numbersSafe.startsWith("//")) {
            delimiter = numbersSafe.split(NEW_LINE_DELIMITER)[0].substring(2);
            numbersSafe = numbersSafe.split(NEW_LINE_DELIMITER)[1];
        }
        String[] strNumbers = numbersSafe.split(delimiter);

        int sum = 0;
        List<String> negatives = new ArrayList<>();
        for (String strNumber : strNumbers) {
            int number = Integer.parseInt(strNumber);
            if (number < ZERO) {
                negatives.add(strNumber);
            } else if (number <= ONE_THOUSAND) {
                sum += number;
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + String.join(",", negatives));
        }
        return sum;
    }

}
