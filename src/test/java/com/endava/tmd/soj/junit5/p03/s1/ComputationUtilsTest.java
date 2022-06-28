package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p02.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise

@TestMethodOrder(MethodOrderer.MethodName.class)
class ComputationUtilsTest {

    @Test
    @DisplayName("0 + 0 = 0")
    void a() {
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
    void c() {
        Assertions.assertEquals(2, sum(0,2));
    }

    @Test
    @DisplayName("-33 + 0 = -33")
    void e() {
        assertThat(sum(-33, 0)).isEqualTo(-33);
    }

    @Test
    @DisplayName("2 + 3 = 5")
    void d() {
        assertThat(sum(2,3)).isEqualTo(5);
    }

    @Test
    @DisplayName("-3 - 2 = -5")
    void b() {
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

}
