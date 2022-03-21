package com.ipssi.unicorn.ressources;

import com.ipssi.unicorn.domain.Gender;
import com.ipssi.unicorn.domain.Unicorn;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static com.ipssi.unicorn.domain.Gender.FEMALE;
import static org.assertj.core.api.Assertions.assertThat;


public class RestUnicornTest {


    private final String nick = "chaussons aux pommes";
    private final LocalDateTime birthday = LocalDateTime.of(2015, Month.JUNE, 29, 9, 28, 45);
    private final Gender sex = FEMALE;
    private final String numberOfWorld = "75012";
    private final String ranch = "ECHO VALLEY RANCH";
    private final String stable = "numero 22";

    private final RestUnicorn restUnicorn = createRestUnicorn();

    @Test
    public void should_create_unicorn() {
        // Then
        assertThat(restUnicorn.getNick()).isEqualTo(nick);
        assertThat(restUnicorn.getBirthday()).isEqualTo(birthday.toString());
        assertThat(restUnicorn.getSex()).isEqualTo(sex.toString());
        assertThat(restUnicorn.getNumberOfWorld()).isEqualTo(numberOfWorld);
        assertThat(restUnicorn.getRanch()).isEqualTo(ranch);
        assertThat(restUnicorn.getStable()).isEqualTo(stable);
    }

    @Test
    public void should_create_unicorn_with_to_domain_unicorn() {
        // When
        Unicorn unicorn = new Unicorn(nick, birthday, sex, numberOfWorld, ranch, stable);
        // Then
        AssertionsForClassTypes.assertThat(restUnicorn.toDomainUnicorn().getNick()).isEqualTo(unicorn.getNick());
        AssertionsForClassTypes.assertThat(restUnicorn.toDomainUnicorn().getBirthday()).isEqualTo(unicorn.getBirthday());
        AssertionsForClassTypes.assertThat(restUnicorn.toDomainUnicorn().isSex()).isEqualTo(unicorn.isSex());
        AssertionsForClassTypes.assertThat(restUnicorn.toDomainUnicorn().getNumberOfWorld()).isEqualTo(unicorn.getNumberOfWorld());
        AssertionsForClassTypes.assertThat(restUnicorn.toDomainUnicorn().getRanch()).isEqualTo(unicorn.getRanch());
        AssertionsForClassTypes.assertThat(restUnicorn.toDomainUnicorn().getStable()).isEqualTo(unicorn.getStable());


    }


    private RestUnicorn createRestUnicorn() {

        return new RestUnicorn(new Unicorn(nick, birthday, sex, numberOfWorld, ranch, stable));
    }
}