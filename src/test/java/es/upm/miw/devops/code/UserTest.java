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
    }

    @Test
    void testFullName() {
        User user = new User("1", "Jane", "Doe");

        assertThat(user.fullName()).isEqualTo("Jane Doe");
    }

    @Test
    void testInitials() {
        User user = new User("1", "Mark", "Twain");

        assertThat(user.initials()).isEqualTo("M.");
    }
}
