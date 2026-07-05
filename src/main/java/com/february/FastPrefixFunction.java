package com.february;

public class FastPrefixFunction implements PrefixFunction {

    @Override
    public int[] calculate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input is null");
        }
        final var result = new int[input.length()];

        if (input.isEmpty()) {
            return result;
        }
        result[0] = 0;
        for (int i = 1; i < input.length(); i++) {

            int j = result[i - 1];

            while (j > 0 && input.charAt(i) != input.charAt(j)) {
                j = result[j - 1];
            }
            if (input.charAt(i) == input.charAt(j)) {
                result[i] = j + 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}
