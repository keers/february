package com.february;

public class VeryNaivePrefixFunction implements PrefixFunction {

    @Override
    public int[] calculate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input is null");
        }
        final var result = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            result[i] = maxBorder(input.substring(0, i + 1));
        }
        return result;
    }

    private int maxBorder(String input) {
        final var length = input.length();
        int result = 0;
        for (int i = 1; i < length; i++) {
            if (input.substring(0, i).equals(input.substring(length - i, length))) {
                result = i;
            }
        }
        return result;
    }
}
