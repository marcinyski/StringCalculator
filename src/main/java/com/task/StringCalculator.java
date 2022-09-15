package com.task;

import java.util.Optional;

public class StringCalculator {
    public static final String DEFAULT_DELIMITER = ",";

    public int add(String numbers) {
        String numbersSafe = Optional.ofNullable(numbers).orElse("");
        if (numbersSafe.isEmpty()) {
            return 0;
        }
        String[] strNumbers = numbersSafe.split(DEFAULT_DELIMITER);
        return strNumbers.length == 1
                ? Integer.valueOf(strNumbers[0])
                : Integer.valueOf(strNumbers[0]) + Integer.valueOf(strNumbers[1]);
    }

}
