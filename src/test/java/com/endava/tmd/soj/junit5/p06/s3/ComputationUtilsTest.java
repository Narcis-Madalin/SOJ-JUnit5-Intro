package com.endava.tmd.soj.junit5.p06.s3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;



import static com.endava.tmd.soj.junit5.p06.s3.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.
class ComputationUtilsTest {

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("TestareCazuriValide")
    void testareSuma(int x, int y, int expectedResult) {
        assertThat(sum(x,y)).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "{0} + {1} \u21D2 Overflow")
    @MethodSource("TestareCazuriInvalide")
    void testareExceptiiSuma(int x, int y) {
        assertThatThrownBy(() -> sum(x, y))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    static List<Arguments> TestareCazuriValide(){
        return List.of(
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(0, 2, 2),
                Arguments.arguments(-33, 0, -33),
                Arguments.arguments(2, 3, 5),
                Arguments.arguments(-3, -2, -5),
                Arguments.arguments(-2, 3, 1),
                Arguments.arguments(-3, 2, -1),
                Arguments.arguments(0, Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.arguments(-3, Integer.MAX_VALUE, Integer.MAX_VALUE - 3),
                Arguments.arguments(0, Integer.MIN_VALUE, Integer.MIN_VALUE),
                Arguments.arguments(2, Integer.MIN_VALUE, Integer.MIN_VALUE + 2),
                Arguments.arguments(Integer.MIN_VALUE, Integer.MAX_VALUE, -1)
        );
    }

    static List<Arguments> TestareCazuriInvalide(){
        return List.of(
                Arguments.arguments(Integer.MAX_VALUE, 1),
                Arguments.arguments(Integer.MIN_VALUE, -1)
        );
    }
}
