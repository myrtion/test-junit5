package com.vsct.vsc.junit5tests.xspeedit;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class ItemsDeserializer {

    public static List<Item> deserialize(String itemsAsString) {

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < itemsAsString.length(); ++i) {
            Item item = new Item(Integer.parseInt(String.valueOf(itemsAsString.charAt(i))));
            items.add(item);
        }
        return items;

    }

}
