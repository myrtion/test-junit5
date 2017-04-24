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
package com.vsct.vsc.junit5tests.xspeedit.flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.vsct.vsc.junit5tests.xspeedit.Item;
import com.vsct.vsc.junit5tests.xspeedit.Packaging;

/**
 */
public class ItemsStorage {

    private List<Packaging> itemPackages = new ArrayList<>();

    public synchronized Optional<Packaging> store(final Item item) {
        
        final Supplier<Packaging> createNewPackage = () -> {
            Packaging packaging = new Packaging();
            packaging.addItem(item);
            itemPackages.add(packaging);
            return packaging;
        };
        
        Packaging packaging = itemPackages.stream()
                .filter(p -> p.addItem(item))
                .findFirst()
                .orElseGet(createNewPackage);

        final Packaging packageToDeliver = packaging.isFull() ? packaging : null;
        return Optional.ofNullable(packageToDeliver);
    }

    public synchronized List<Packaging> getItemPackages() {
        return itemPackages;
    }
}
