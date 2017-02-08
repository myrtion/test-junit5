package com.vsct.vsc.junit5tests.xspeedit;

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

