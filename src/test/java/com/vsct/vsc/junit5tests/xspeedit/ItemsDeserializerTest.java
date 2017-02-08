package com.vsct.vsc.junit5tests.xspeedit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 */
class ItemsDeserializerTest {

    @Test
    void should_not_get_sizes_above_9() {

        String input = "400768";
        List<Item> items = ItemsDeserializer.deserialize(input);

        assertAll(
                () -> assertEquals(6, items.size()),
                () -> assertEquals(4, items.get(0).getSize()),
                () -> assertEquals(0, items.get(1).getSize()),
                () -> assertEquals(0, items.get(2).getSize()),
                () -> assertEquals(7, items.get(3).getSize()),
                () -> assertEquals(6, items.get(4).getSize()),
                () -> assertEquals(8, items.get(5).getSize())
        );
    }
}