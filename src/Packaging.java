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
import java.util.List;

/**
 */
public class Packaging {

    private final static int MAX_PACKAGING_SIZE = 10;
    private static final int MIN_ITEM_SIZE = 1;
    private static final int MAX_ITEM_SIZE = 9;

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        int itemSize = item.getSize();

        if (itemSize < MIN_ITEM_SIZE || itemSize > MAX_ITEM_SIZE) {
            return false;
        }
        if ((size() + itemSize) > MAX_PACKAGING_SIZE) {
            return false;
        } else {
            items.add(item);
            return true;
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isFull() {
        return size() == 10;
    }

    public int size() {
        return items.stream().mapToInt(Item::getSize).sum();
    }
}
