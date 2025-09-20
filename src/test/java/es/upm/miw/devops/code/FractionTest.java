package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FractionTest {

    @Test
    void testDefaultConstructor() {
        Fraction fraction = new Fraction();

        assertThat(fraction.getNumerator()).isEqualTo(1);
        assertThat(fraction.getDenominator()).isEqualTo(1);
    }

    @Test
    void testParameterizedConstructor() {
        Fraction fraction = new Fraction(3, 5);

        assertThat(fraction.getNumerator()).isEqualTo(3);
        assertThat(fraction.getDenominator()).isEqualTo(5);
    }

    @Test
    void testSettersAndGetters() {
        Fraction fraction = new Fraction();
        fraction.setNumerator(4);
        fraction.setDenominator(7);

        assertThat(fraction.getNumerator()).isEqualTo(4);
        assertThat(fraction.getDenominator()).isEqualTo(7);
    }

    @Test
    void testDecimalPositiveFraction() {
        Fraction fraction = new Fraction(1, 4);

        assertThat(fraction.decimal()).isEqualTo(0.25);
    }

    @Test
    void testDecimalNegativeFraction() {
        Fraction fraction = new Fraction(-3, 6);

        assertThat(fraction.decimal()).isEqualTo(-0.5);
    }

    @Test
    void testDecimalZeroNumerator() {
        Fraction fraction = new Fraction(0, 7);

        assertThat(fraction.decimal()).isZero();
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(2, 3);

        String result = fraction.toString();

        assertThat(result)
                .contains("Fraction{")
                .contains("numerator=2")
                .contains("denominator=3")
                .endsWith("}");
    }
}
