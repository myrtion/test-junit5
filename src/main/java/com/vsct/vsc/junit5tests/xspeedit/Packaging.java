package com.vsct.vsc.junit5tests.xspeedit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 */
public class Packaging {

    private final static int MAX_PACKAGING_SIZE = 10;
    private static final int MIN_ITEM_SIZE = 1;
    private static final int MAX_ITEM_SIZE = 9;

    private List<Item> items = new ArrayList<>();

    public synchronized boolean addItem(Item item) {
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

    public String description() {
        return items.stream().map(i -> String.valueOf(i.getSize())).collect(Collectors.joining());
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
