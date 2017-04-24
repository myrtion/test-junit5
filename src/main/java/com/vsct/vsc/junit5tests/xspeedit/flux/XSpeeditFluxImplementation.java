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

import io.reactivex.Flowable;

import com.vsct.vsc.junit5tests.xspeedit.Item;

/**
 */
public class XSpeeditFluxImplementation {

    private ItemsStorage itemsStorage = new ItemsStorage();

    public void registerItem(int item) {

        Flowable.fromCallable(
                () -> itemsStorage.store(new Item(item))
        ).subscribe(packaging -> packaging.ifPresent(p -> System.out.println(p.description())));

    }

}
