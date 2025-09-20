package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    void testDefaultConstructor() {
        User user = new User();

        assertThat(user.getId()).isNull();
        assertThat(user.getName()).isNull();
        assertThat(user.getFamilyName()).isNull();
        assertThat(user.getFractions()).isEmpty();
    }

    @Test
    void testParameterizedConstructor() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        User user = new User("123", "John", "Doe", fractions);

        assertThat(user.getId()).isEqualTo("123");
        assertThat(user.getName()).isEqualTo("John");
        assertThat(user.getFamilyName()).isEqualTo("Doe");
        assertThat(user.getFractions()).containsExactlyElementsOf(fractions);
    }

    @Test
    void testAddFraction() {
        User user = new User();
        Fraction fraction = new Fraction(2, 5);

        user.addFraction(fraction);

        assertThat(user.getFractions()).hasSize(1)
                .containsExactly(fraction);
    }

    @Test
    void testFullName() {
        User user = new User("1", "Jane", "Doe", new ArrayList<>());

        assertThat(user.fullName()).isEqualTo("Jane Doe");
    }

    @Test
    void testInitials() {
        User user = new User("1", "Mark", "Twain", new ArrayList<>());

        assertThat(user.initials()).isEqualTo("M.");
    }

    @Test
    void testToString() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        User user = new User("1", "Tom", "Hanks", fractions);

        String result = user.toString();

        assertThat(result)
                .contains("User{")
                .contains("id='1'")
                .contains("name='Tom'")
                .contains("familyName='Hanks'")
                .contains("fractions=");
    }
}
