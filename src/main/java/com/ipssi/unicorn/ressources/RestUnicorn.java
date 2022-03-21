package com.ipssi.unicorn.ressources;

import com.ipssi.unicorn.domain.Gender;
import com.ipssi.unicorn.domain.Unicorn;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;

public class RestUnicorn {

    private final String nick;
    private final String birthday;
    private final String sex;
    private final String numberOfWorld;
    private final String ranch;
    private final String stable;

    public RestUnicorn(@Nonnull Unicorn unicorn) {
        nick = unicorn.getNick();
        birthday = String.valueOf(unicorn.getBirthday());
        sex = String.valueOf(unicorn.isSex());
        numberOfWorld = unicorn.getNumberOfWorld();
        ranch = unicorn.getRanch();
        stable = unicorn.getStable();
    }

    @Nonnull
    public Unicorn toDomainUnicorn() {
        return new Unicorn(nick, LocalDateTime.parse(birthday), Gender.valueOf(sex), numberOfWorld, ranch, stable);
    }

    public String getNick() {
        return nick;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public String getNumberOfWorld() {
        return numberOfWorld;
    }

    public String getRanch() {
        return ranch;
    }

    public String getStable() {
        return stable;
    }

}
