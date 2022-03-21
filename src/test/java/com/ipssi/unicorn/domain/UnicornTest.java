package com.ipssi.unicorn.domain;

import com.ipssi.unicorn.domain.Gender;
import com.ipssi.unicorn.domain.Unicorn;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;
import java.time.Month;

import static com.ipssi.unicorn.domain.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;

public class UnicornTest {

    private final String nick = "Arc en ciel";
    private final LocalDateTime birthday = LocalDateTime.of(2015, Month.JUNE, 29, 9, 28, 45);
    private final Gender sex = MALE;
    private final String numberOfWorld = "75012";
    private final String ranch = "FLYING U RANCH";
    private final String stable = "number 12";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_validate_user() {
        Unicorn unicorn = new Unicorn(nick, birthday, sex, numberOfWorld, ranch, stable);

        System.out.print(birthday);

        assertThat(unicorn.getNick()).isEqualTo(nick);
        assertThat(unicorn.getBirthday()).isEqualTo(birthday);
        assertThat(unicorn.isSex()).isEqualTo(sex);
        assertThat(unicorn.getNumberOfWorld()).isEqualTo(numberOfWorld);
        assertThat(unicorn.getRanch()).isEqualTo(ranch);
        assertThat(unicorn.getStable()).isEqualTo(stable);
    }

    @Test
    public void should_thrown_exception_when_nick_is_blank() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("nick name cannot be blank");

        new Unicorn(null, birthday, sex, numberOfWorld, ranch, stable);
    }

    @Test
    public void should_thrown_exception_when_birthday_is_null() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("birthday cannot be null");

        new Unicorn(nick, null, sex, numberOfWorld, ranch, stable);
    }

    @Test
    public void should_thrown_exception_when_birthday_is_after_current_date() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("birthday cannot be after the current day");

        LocalDateTime now = LocalDateTime.now();
        new Unicorn(nick, now.plusDays(1), sex, numberOfWorld, ranch, stable);
    }

    @Test
    public void should_thrown_exception_when_number_of_world_is_null() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("number of world cannot be null");

        new Unicorn(nick, birthday, sex, null, ranch, stable);
    }

    @Test
    public void should_thrown_exception_when_number_of_world_is_to_short() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("the number of unicorn's world must be composed of 5 characters");

        String toShortNumber = "012";
        new Unicorn(nick, birthday, sex, toShortNumber, ranch, stable);
    }

    @Test
    public void should_thrown_exception_when_number_of_world_is_to_long() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("the number of unicorn's world must be composed of 5 characters");

        String toLongNumber = "012345";
        new Unicorn(nick, birthday, sex, toLongNumber, ranch, stable);
    }

    @Test
    public void should_thrown_exception_when_ranch_is_null() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("ranch cannot be null");

        new Unicorn(nick, birthday, sex, numberOfWorld, null, stable);
    }

    @Test
    public void should_thrown_exception_when_stable_is_null() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("stable cannot be null");

        new Unicorn(nick, birthday, sex, numberOfWorld, ranch, null);
    }
}