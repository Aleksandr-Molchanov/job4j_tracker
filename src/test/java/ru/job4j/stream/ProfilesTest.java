package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Address ruslan = new Address("Moskva", "Lenina", 1, 1);
        Address olga = new Address("Moskva", "Priborostroiteley", 8, 8);
        Address igor = new Address("Moskva", "Krasnoprudnaya", 10, 10);
        List<Profile> addresses = List.of(
                new Profile(ruslan),
                new Profile(olga),
                new Profile(igor)
        );
        Profiles pr = new Profiles();
        List<Address> rsl = pr.collect(addresses);
        List<Address> expected = List.of(
                ruslan,
                olga,
                igor
        );
        assertThat(rsl, is(expected));
    }
}