package com.vsct.vsc.junit5tests.xspeedit;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 */
public class PackagingSerializer {

    public static String serialize(List<Packaging> packages) {
        final Function<Packaging, String> packagingStreamFunction = Packaging::description;

        return packages.stream()
                .map(packagingStreamFunction)
                .collect(Collectors.joining("/"));
    }

}
