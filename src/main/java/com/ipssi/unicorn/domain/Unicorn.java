package com.ipssi.unicorn.domain;

import com.ipssi.unicorn.domain.Gender;
import org.apache.commons.lang3.Validate;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

public class Unicorn {

    private String nick;
    private LocalDateTime birthday;
    private Gender sex;
    private String numberOfWorld;
    private String ranch;
    private String stable;

    public Unicorn(@Nonnull String nick, @Nonnull LocalDateTime birthday, @Nonnull Gender sex,
                   @Nonnull String numberOfWorld, @Nonnull String ranch, @Nonnull String stable) {
        validateBirthday(birthday);
        validateZipCode(numberOfWorld);

        this.nick = requireNonNull(nick, "nick name cannot be blank");
        this.birthday = birthday;
        this.sex = requireNonNull(sex, "gender cannot be null");
        this.numberOfWorld = numberOfWorld;
        this.ranch = requireNonNull(ranch, "ranch cannot be null");
        this.stable = requireNonNull(stable, "stable cannot be null");
    }

    @Nonnull
    private void validateBirthday(@Nonnull LocalDateTime birthday) {
        LocalDateTime now = LocalDateTime.now();

        requireNonNull(birthday, "birthday cannot be null");
        Validate.isTrue(birthday.isBefore(now), "birthday cannot be after the current day");
    }

    @Nonnull
    private void validateZipCode(@Nonnull String numberOfWorld) {
        requireNonNull(numberOfWorld, "number of world cannot be null");

        Validate.isTrue(numberOfWorld.length() == 5,
                "the number of unicorn's world must be composed of 5 characters");
    }

    @Nonnull
    public String getNick() {
        return nick;
    }

    @Nonnull
    public LocalDateTime getBirthday() {
        return birthday;
    }

    @Nonnull
    public Gender isSex() {
        return sex;
    }

    @Nonnull
    public String getNumberOfWorld() {
        return numberOfWorld;
    }

    @Nonnull
    public String getRanch() {
        return ranch;
    }

    @Nonnull
    public String getStable() {
        return stable;
    }
}
