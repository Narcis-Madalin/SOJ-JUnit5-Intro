package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p02.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputationUtilsTest {

    @Test
    @DisplayName("0 + 0 = 0")
    @Order(5)
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
    @Order(3)
    void zeroShouldNotChangePositive() {
        Assertions.assertEquals(2, sum(0,2));
    }

    @Test
    @DisplayName("-33 + 0 = -33")
    @Order(4)
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-33, 0)).isEqualTo(-33);
    }

    @Test
    @DisplayName("2 + 3 = 5")
    @Order(6)
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(2,3)).isEqualTo(5);
    }

    @Test
    @DisplayName("-3 - 2 = -5")
    @Order(1)
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-3,-2)).isEqualTo(-5);
    }

    @Test
    @DisplayName("-2 + 3 = 1")
    @Order(7)
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-2, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("-3 + 2 = -1")
    @Order(2)
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-3,2)).isEqualTo(-1);
    }

}
