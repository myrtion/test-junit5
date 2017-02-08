/*
 * Copyright (c) 2012, vsc-technologies - www.voyages-sncf.com
 * All rights reserved.
 * 
 * Les presents codes sources sont proteges par le droit d'auteur et 
 * sont la propriete exclusive de VSC Technologies.
 * Toute representation, reproduction, utilisation, exploitation, modification, 
 * adaptation de ces codes sources sont strictement interdits en dehors 
 * des autorisations formulees expressement par VSC Technologies, 
 * sous peine de poursuites penales. 
 * 
 * Usage of this software, in source or binary form, partly or in full, and of
 * any application developed with this software, is restricted to the
 * customer.s employees in accordance with the terms of the agreement signed
 * with VSC-technologies.
 */

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
