package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
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
}
