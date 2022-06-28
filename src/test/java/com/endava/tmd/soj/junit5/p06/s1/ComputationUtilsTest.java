package com.endava.tmd.soj.junit5.p06.s1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest
class ComputationUtilsTest {

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
            x,              y,              x + y
            0,              0,              0
            0,              2,              2
            -33,            0,              -33
            2,              3,              5
            -3,             -2,             -5
            -2,             3,              1
            -3,             2,              -1
            0,              2147483647,     2147483647
            -3,             2147483647,     2147483644
            0,              -2147483648,    -2147483648
            2,              -2147483648,    -2147483646
            -2147483648,    2147483647,     -1
            """)
    void testareSuma(int x, int y, int expectedResult) {
            assertThat(sum(x,y)).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "{0} + {1} \u21D2 Overflow")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
            x,              y
            2147483647,     1
            -2147483648,    -1
            """)
    void testareExceptiiSuma(int x, int y) {
            assertThatThrownBy(() -> sum(x, y))
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessage("Overflow while computing the sum");
    }

}
