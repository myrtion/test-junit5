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
