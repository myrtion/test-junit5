package com.vsct.vsc.junit5tests.xspeedit;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class XSpeeditRunner {

    private static Pattern onlyNumbers = Pattern.compile("[1-9]+");

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Expecting only one argument : a chain of items as numbers from 1 to 9");
            return;
        }

        String itemsAsString = args[0];
        Matcher matcher = onlyNumbers.matcher(itemsAsString);

        if (!matcher.matches()) {
            System.out.println("Expecting items as a chain of numbers from 1 to 9");
            return;
        }

        System.out.println("Naive implementation result : " + executeXspeedItNaiveimplementation(itemsAsString));
        System.out.println("Improved implementation result : " + executeXspeedIt(itemsAsString));

    }

    public static String executeXspeedIt(String itemsAsString) {

        List<Item> items = ItemsDeserializer.deserialize(itemsAsString);

        XSpeedItImplementation xspeedit = new XSpeedItImplementation();
        return PackagingSerializer.serialize(xspeedit.pack(items));
    }

    public static String executeXspeedItNaiveimplementation(String itemsAsString) {

        List<Item> items = ItemsDeserializer.deserialize(itemsAsString);

        XSpeedItNaiveImplementation xspeedit = new XSpeedItNaiveImplementation();
        return PackagingSerializer.serialize(xspeedit.pack(items));
    }

}
