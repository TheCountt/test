package com.ipssi.unicorn.service;

import com.ipssi.unicorn.domain.Unicorn;
import com.ipssi.unicorn.ressources.RestUnicorn;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static com.ipssi.unicorn.domain.Gender.FEMALE;
import static com.ipssi.unicorn.domain.Gender.MALE;
import static java.util.Arrays.asList;

@Service
public class Display {

    public List<RestUnicorn> getUnicorns() {

        final LocalDateTime birthday1 = LocalDateTime.of(2015, Month.JUNE, 29, 9, 28, 45);
        final LocalDateTime birthday2 = LocalDateTime.of(2012, Month.JUNE, 29, 9, 28, 45);
        final LocalDateTime birthday3 = LocalDateTime.of(2018, Month.JUNE, 29, 9, 28, 45);

        RestUnicorn unicorn1 = new RestUnicorn(new Unicorn("arc en ciel", birthday1, MALE,
                "75012", "ECHO VALLEY RANCH", "number 12x"));
        RestUnicorn unicorn2 = new RestUnicorn(new Unicorn("chaussons aux pommes", birthday2, FEMALE,
                "75013", "PINK ECHO VALLEY RANCH", "number 52"));
        RestUnicorn unicorn3 = new RestUnicorn(new Unicorn("rose", birthday3, MALE,
                "75014", "BIG BAR GUEST RANCH", "number 1"));

        return asList(unicorn1, unicorn2, unicorn3);
    }

}
