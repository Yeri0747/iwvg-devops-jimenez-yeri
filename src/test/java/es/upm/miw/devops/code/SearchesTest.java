package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class SearchesTest {

    @Test
    void testFindHighestFractionReturnsFractionWithGreatestDecimal() {
        Searches searches = new Searches();

        Fraction result = searches.findHighestFraction();

        assertThat(result.decimal()).isEqualTo(2.0);
    }

    @Test
    void testFindHighestFractionIsNotNull() {
        Searches searches = new Searches();

        Fraction result = searches.findHighestFraction();

        assertThat(result).isNotNull();
    }

    @Test
    void testFindHighestFractionValueCorrectness() {
        Searches searches = new Searches();

        Fraction result = searches.findHighestFraction();

        assertThat(result.getNumerator()).isEqualTo(2);
        assertThat(result.getDenominator()).isEqualTo(1);
    }

    @Test
    void testFindFractionSubtractionByUserNameWithMultipleFractions() {
        Searches searches = new Searches();

        Fraction result = searches.findFractionSubtractionByUserName("Oscar");

        assertThat(result).isNotNull();
        assertThat(result.getNumerator()).isEqualTo(1008);
        assertThat(result.getDenominator()).isEqualTo(-240);
    }

    @Test
    void testFindFractionSubtractionByUserNameWithNegativeFractions() {
        Searches searches = new Searches();

        Fraction result = searches.findFractionSubtractionByUserName("Ana");

        assertThat(result.getNumerator()).isEqualTo(22);
        assertThat(result.getDenominator()).isEqualTo(60);
    }

    @Test
    void testFindFractionSubtractionByUserNameWithNoValidFractions() {
        Searches searches = new Searches();

        Fraction result = searches.findFractionSubtractionByUserName("Paula");

        assertThat(result.getNumerator()).isEqualTo(-8);
        assertThat(result.getDenominator()).isEqualTo(8);
    }

    @Test
    void testFindFractionSubtractionByUserNameNonExistentUser() {
        Searches searches = new Searches();

        Fraction result = searches.findFractionSubtractionByUserName("NoExiste");

        assertThat(result).isNull();
    }

    @Test
    void testFindUserFamilyNameBySomeImproperFractionReturnsExpected() {
        Searches searches = new Searches();

        List<String> result = searches.findUserFamilyNameBySomeImproperFraction()
                .collect(Collectors.toList());

        List<String> expected = List.of(
                "Fernandez",
                "Blanco",
                "López",
                "Torres",
                "Torres"
        );

        assertThat(result).containsExactlyElementsOf(expected);
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyNameWithValidFractions() {
        Searches searches = new Searches();

        Fraction result = searches.findFractionMultiplicationByUserFamilyName("Blanco");

        assertThat(result).isNotNull();

        assertThat(result.getNumerator()).isZero();
        assertThat(result.getDenominator()).isEqualTo(-360);
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyNameWithInvalidFractions() {
        Searches searches = new Searches();

        Fraction result = searches.findFractionMultiplicationByUserFamilyName("Torres");

        assertThat(result).isNotNull();

        assertThat(result.getNumerator()).isEqualTo(8);
        assertThat(result.getDenominator()).isEqualTo(8);
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyNameNonExistent() {
        Searches searches = new Searches();

        Fraction result = searches.findFractionMultiplicationByUserFamilyName("NoExiste");

        assertThat(result).isNull();
    }
}
