package com.endava.tmd.soj.junit5.p01;

// Provocari:
// 1. Adaugati adnotarea neecesara pentru a rula prima metoda ca si un test unitar
// 2. Rulati prima metoda ca si un test unitar
// 3. Decomentati asertiile din primul test, si efectuati importurile necesare. Rulati testul din nou.
// 4. Adaugati o linie care sa determine testul sa fie "failed". La sfarsit commentati acea linie
// 5. Completati celelalte metode astfel incat sa reprezinte scenarii de testare

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.*;

//@DisplayName("Tests for my sum method")
class ComputationUtilsTest {

    //@DisplayName("Tests for my sum method")
    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        // assertEquals(0, sum(0, 0));
        Assertions.assertEquals(0, com.endava.tmd.soj.junit5.p02.ComputationUtils.sum(0,0));
        //Assertions.assertEquals(5, sum(3,0));

        // AssertJ Assertion
        // assertThat(sum(0, 0)).isZero();
        assertThat(com.endava.tmd.soj.junit5.p02.ComputationUtils.sum(0,0)).isZero();
    }

    @Test
    void zeroShouldNotChangePositive() {
        Assertions.assertEquals(2, com.endava.tmd.soj.junit5.p02.ComputationUtils.sum(0,2));
    }

    @Test
    void zeroShouldNotChangeNegative() {
        assertThat(com.endava.tmd.soj.junit5.p02.ComputationUtils.sum(-33, 0)).isEqualTo(-33);
    }

    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(com.endava.tmd.soj.junit5.p02.ComputationUtils.sum(2,3)).isEqualTo(5);
    }

    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(com.endava.tmd.soj.junit5.p02.ComputationUtils.sum(-3,-2)).isEqualTo(-5);
    }

    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(com.endava.tmd.soj.junit5.p02.ComputationUtils.sum(-2, 3)).isEqualTo(1);
    }

    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(com.endava.tmd.soj.junit5.p02.ComputationUtils.sum(-3,2)).isEqualTo(-1);
    }

}
