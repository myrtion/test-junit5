package com.vsct.vsc.junit5tests.xspeedit.flux;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 */
class XSpeeditFluxImplementationTest {

    @Test
    void testItemsSending() {

        Random random = new Random(System.currentTimeMillis());
        XSpeeditFluxImplementation toTest = new XSpeeditFluxImplementation();

        ExecutorService executorService = Executors.newFixedThreadPool(200);
        
        IntStream.range(0, 100000).forEach(i -> 
            executorService.submit(() -> toTest.registerItem(random.nextInt(10)))
        );


    }
}