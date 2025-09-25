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

    @Test
    void testIsProperWhenNumeratorLessThanDenominator() {
        Fraction fraction = new Fraction(3, 5);

        assertThat(fraction.isProper()).isTrue();
    }

    @Test
    void testIsProperWhenNumeratorGreaterThanDenominator() {
        Fraction fraction = new Fraction(7, 4);

        assertThat(fraction.isProper()).isFalse();
    }

    @Test
    void testIsProperWhenNumeratorEqualsDenominator() {
        Fraction fraction = new Fraction(3, 3);

        assertThat(fraction.isProper()).isFalse();
    }

    // --- isImproper ---
    @Test
    void testIsImproperWhenNumeratorGreaterThanDenominator() {
        Fraction fraction = new Fraction(7, 4);

        assertThat(fraction.isImproper()).isTrue();
    }

    @Test
    void testIsImproperWhenNumeratorEqualsDenominator() {
        Fraction fraction = new Fraction(3, 3);

        assertThat(fraction.isImproper()).isTrue();
    }

    @Test
    void testIsImproperWhenNumeratorLessThanDenominator() {
        Fraction fraction = new Fraction(3, 5);

        assertThat(fraction.isImproper()).isFalse();
    }

    // --- isEquivalent ---
    @Test
    void testIsEquivalentWhenFractionsAreEquivalent() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);

        assertThat(f1.isEquivalent(f2)).isTrue();
    }

    @Test
    void testIsEquivalentWhenFractionsAreNotEquivalent() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);

        assertThat(f1.isEquivalent(f2)).isFalse();
    }

    // --- add ---
    @Test
    void testAddWithSameDenominator() {
        Fraction f1 = new Fraction(1, 4);
        Fraction f2 = new Fraction(2, 4);

        Fraction result = f1.add(f2);

        assertThat(result.getNumerator()).isEqualTo(12);  // (1*4 + 2*4)
        assertThat(result.getDenominator()).isEqualTo(16);
    }

    @Test
    void testAddWithDifferentDenominator() {
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(1, 6);

        Fraction result = f1.add(f2);

        assertThat(result.getNumerator()).isEqualTo(9);   // (1*6 + 1*3)
        assertThat(result.getDenominator()).isEqualTo(18);
    }

    // --- multiply ---
    @Test
    void testMultiplyPositiveFractions() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);

        Fraction result = f1.multiply(f2);

        assertThat(result.getNumerator()).isEqualTo(6);
        assertThat(result.getDenominator()).isEqualTo(12);
    }

    @Test
    void testMultiplyWithNegativeFraction() {
        Fraction f1 = new Fraction(-1, 2);
        Fraction f2 = new Fraction(1, 3);

        Fraction result = f1.multiply(f2);

        assertThat(result.getNumerator()).isEqualTo(-1);
        assertThat(result.getDenominator()).isEqualTo(6);
    }

    // --- divide ---
    @Test
    void testDividePositiveFractions() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);

        Fraction result = f1.divide(f2);

        assertThat(result.getNumerator()).isEqualTo(8);   // 2*4
        assertThat(result.getDenominator()).isEqualTo(9); // 3*3
    }

    @Test
    void testDivideWithNegativeFraction() {
        Fraction f1 = new Fraction(-1, 2);
        Fraction f2 = new Fraction(1, 3);

        Fraction result = f1.divide(f2);

        assertThat(result.getNumerator()).isEqualTo(-3);  // (-1*3)
        assertThat(result.getDenominator()).isEqualTo(2); // (2*1)
    }
}
