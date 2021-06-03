package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        AddressAscByCity comp = new AddressAscByCity();
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(comp)
                .distinct()
                .collect(Collectors.toList());
    }
}
