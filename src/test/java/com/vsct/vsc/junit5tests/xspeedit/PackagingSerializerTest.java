package com.vsct.vsc.junit5tests.xspeedit;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 */
class PackagingSerializerTest {

    @Test
    void should_ignore_empty_packages() {

        Packaging emptyPackage = new Packaging();
        Packaging packaging1 = new Packaging();
        packaging1.addItem(new Item(1));
        Packaging packaging4 = new Packaging();
        packaging4.addItem(new Item(4));

        assertAll(
                () -> assertEquals(
                        "1/4",
                        PackagingSerializer.serialize(Arrays.asList(packaging1, emptyPackage, packaging4)),
                        "empty middle package ko"
                ),
                () -> assertEquals(
                        "1/4",
                        PackagingSerializer.serialize(Arrays.asList(emptyPackage, packaging1, packaging4)),
                        "empty leading package ko"
                ),
                () -> assertEquals(
                        "1/4",
                        PackagingSerializer.serialize(Arrays.asList(packaging1, packaging4, emptyPackage)),
                        "empty trailing package ko"
                ),
                () -> assertEquals(
                        "4/1",
                        PackagingSerializer.serialize(Arrays.asList(packaging4, packaging1, emptyPackage)),
                        "order not respected ( does it matter ? )"
                ),
                () -> assertEquals(
                        "1",
                        PackagingSerializer.serialize(Arrays.asList(packaging1, emptyPackage, emptyPackage)),
                        "leading single not empty package"
                ),
                () -> assertEquals(
                        "4",
                        PackagingSerializer.serialize(Arrays.asList(emptyPackage, packaging4, emptyPackage)),
                        "middle single not empty package"
                )
                ,
                () -> assertEquals(
                        "4",
                        PackagingSerializer.serialize(Arrays.asList(emptyPackage, emptyPackage, packaging4)),
                        "trailing single not empty package"
                )
        );

    }
}