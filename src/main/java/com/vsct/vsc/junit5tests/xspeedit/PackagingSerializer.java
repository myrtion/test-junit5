package com.vsct.vsc.junit5tests.xspeedit;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 */
public class PackagingSerializer {

    public static String serialize(List<Packaging> packages) {
        final Function<Packaging, String> packagingStreamFunction =
                packaging -> packaging.getItems().stream().map(item -> String.valueOf(item.getSize())).collect(Collectors.joining());

        return packages.stream()
                .filter(packaging -> packaging.getItems().size() > 0)
                .map(packagingStreamFunction)
                .collect(Collectors.joining("/"));
    }

}
