package com.ll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Calc2Test {
    Calc2 calc = new Calc2();

    @Test
    @DisplayName("binary expression without blank")
    void expSplit1() {
        String input = "5-3";
        int answer = 2;
        int result = calc.expSplit(input);

        Assertions.assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("binary expression with blank")
    void expSplit2() {
        String input = "5 - 3";
        int answer = 2;
        int result = calc.expSplit(input);

        Assertions.assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("expression with blank")
    void expSplit3() {
        String input = "5 - 3";
        int answer = 2;
        int result = calc.expSplit(input);

        Assertions.assertThat(result).isEqualTo(answer);
    }
}