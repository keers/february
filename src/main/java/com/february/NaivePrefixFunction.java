package com.february;

public class NaivePrefixFunction implements PrefixFunction {

    @Override
    public int[] calculate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input is null");
        }
        final var result = new int[input.length()];

        // substrings from input
        for (int i = 0; i < input.length(); i++) {
            var currentResult = 0;

            // prefix & suffix
            for (int j = 1; j < i + 1; j++) {

                boolean prefixMatchesSuffix = true;

                for (int k = 0; k < j; k++) {
                    if (input.charAt(k) != input.charAt(i - j + 1 + k)) {
                        prefixMatchesSuffix = false;
                        break;
                    }
                }

                if (prefixMatchesSuffix) {
                    currentResult = j;
                }
            }

            result[i] = currentResult;
        }
        return result;
    }
}
