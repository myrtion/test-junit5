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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 */
public class XSpeedItImplementation {

    public List<Packaging> pack(final List<Item> items) {

        final List<Packaging> packages = new ArrayList<>();

        items.stream()
                .sorted(Comparator.comparingInt(Item::getSize).reversed())
                .forEach(item -> tryingToAddToPackages(item, packages));

        return packages;
    }

    private void tryingToAddToPackages(final Item item, final List<Packaging> packages) {

        for (Packaging packaging : packages) {
            if (packaging.addItem(item)) {
                return;
            }
        }

        Packaging packaging = new Packaging();
        if (packaging.addItem(item)) {
            packages.add(packaging);
        }
    }
}

