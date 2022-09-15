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
        int sum = 0;
        for (String strNumber : strNumbers) {
            sum += Integer.parseInt(strNumber);
        }
        return sum;
    }

}
