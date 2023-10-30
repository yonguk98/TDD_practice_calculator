package com.ll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    Calc calc = new Calc();

    @Test
    @DisplayName("Calc.run은 정수를 반환한다")
    void run(){
        int result = calc.run("");
    }

    @Test
    @DisplayName("10 - 10 = 0")
    void cal1(){
        int result = calc.run("10 - 10");
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("3 * 1 + (1 - (4 * 1 - (1 - 1))")
    void cal2() {
        String input = "";
        int result = calc.run(input);
        int answer = 0;

        Assertions.assertThat(result).isEqualTo(answer);
    }
}