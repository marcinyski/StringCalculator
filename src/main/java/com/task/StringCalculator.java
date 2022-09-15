package com.task;

import java.util.Optional;

public class StringCalculator {
    public static final String COMMA_OR_NEWLINE_DELIMITER = "\\R|,";
    public static final String NEW_LINE_DELIMITER = "\\R";

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
        for (String strNumber : strNumbers) {
            sum += Integer.parseInt(strNumber);
        }
        return sum;
    }

}
