package com.february;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NaivePrefixFunctionTest {

    private final PrefixFunction prefixFunction = new NaivePrefixFunction();

    private static Stream<Arguments> prefixFunctionTestCases() {
        return Stream.of(
                arguments("", new int[]{}),
                arguments("A", new int[]{0}),
                arguments("AA", new int[]{0, 1}),
                arguments("ABACABB", new int[]{0, 0, 1, 0, 1, 2, 0}),
                arguments("AAAABA", new int[]{0, 1, 2, 3, 0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("prefixFunctionTestCases")
    void gives_expected_result(String input, int[] expected) {
        var result = prefixFunction.calculate(input);

        assertThat(result).isEqualTo(expected);
    }
}
