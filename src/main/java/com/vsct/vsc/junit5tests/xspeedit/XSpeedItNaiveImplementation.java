package com.vsct.vsc.junit5tests.xspeedit;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class XSpeedItNaiveImplementation {

    public List<Packaging> pack(final List<Item> items) {

        List<Packaging> packages = new ArrayList<>();
        Packaging currentPackage = new Packaging();

        for (Item item : items) {

            if (!currentPackage.addItem(item)) {
                packages.add(currentPackage);
                currentPackage = new Packaging();
                currentPackage.addItem(item);
            }

        }

        return packages;
    }
}
