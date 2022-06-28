package com.endava.tmd.soj.junit5.p04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema de la p02, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare. La ultima metoda, in cazul in care testul nu trece,
// adaugati adnotarea necesara astfel incat sa apara ca si "skipped"
class ComputationUtilsTest {

    @Test
    @DisplayName("0 + 0 = 0")
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        // assertEquals(0, sum(0, 0));
        Assertions.assertEquals(0, sum(0,0));
        //Assertions.assertEquals(5, sum(3,0));

        // AssertJ Assertion
        // assertThat(sum(0, 0)).isZero();
        assertThat(sum(0,0)).isZero();
    }

    @Test
    @DisplayName("0 + 2 = 2")
    void zeroShouldNotChangePositive() {
        Assertions.assertEquals(2, sum(0,2));
    }

    @Test
    @DisplayName("-33 + 0 = -33")
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-33, 0)).isEqualTo(-33);
    }

    @Test
    @DisplayName("2 + 3 = 5")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(2,3)).isEqualTo(5);
    }

    @Test
    @DisplayName("-3 - 2 = -5")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-3,-2)).isEqualTo(-5);
    }

    @Test
    @DisplayName("-2 + 3 = 1")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-2, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("-3 + 2 = -1")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-3,2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("0 + max_int = max_int")
    void zeroShouldNotChangeMaxInt() {
        int maxValue = Integer.MAX_VALUE;
        assertThat(sum(0, maxValue)).isEqualTo(maxValue);
    }

    @Test
    @DisplayName("-3 + 2147483647 = 2147483644")
    void maxIntAndANegativeNumber() {
        assertThat(sum(-3, Integer.MAX_VALUE)).isEqualTo(2147483644);
    }

    @Test
    @DisplayName("0 + min_int = min_int")
    void zeroShouldNotChangeMinInt() {
        int minValue = Integer.MIN_VALUE;
        assertThat(sum(0, minValue)).isEqualTo(minValue);
    }

    @Test
    @DisplayName("2 - 2147483648 = -2147483646")
    void minIntAndAPositiveNumber() {
        assertThat(sum(2, Integer.MIN_VALUE)).isEqualTo(-2147483646);
    }

    @Test
    @DisplayName("max_int + min_int = -1")
    void minIntAndMaxInt() {
        assertThat(sum(Integer.MAX_VALUE, Integer.MIN_VALUE)).isEqualTo(-1);
    }

    @Test
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(sum(2, Integer.MAX_VALUE)).isEqualTo(2147483649L);
    }

}
