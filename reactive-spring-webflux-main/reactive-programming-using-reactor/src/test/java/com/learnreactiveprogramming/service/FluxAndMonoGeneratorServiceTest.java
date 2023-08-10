package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {
    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void namesFlux() {
        var namesFlux = fluxAndMonoGeneratorService.namesFLux();
        StepVerifier.create(namesFlux)
                //.expectNext("alex","ben","chloe")
                .expectNext("alex")
                .expectNextCount(2)
                .verifyComplete();
    }


    @Test
    void namesFLux_map() {
        int stringLength = 3;
        var namesFlux = fluxAndMonoGeneratorService.namesFLux_map(stringLength);
        StepVerifier.create(namesFlux)
                //.expectNext("ALEX","BEN","CHLOE")
                .expectNext("4-ALEX", "5-CHLOE")
                .verifyComplete();
    }

    @Test
    void namesFLux_immutability() {
        var namesFlux = fluxAndMonoGeneratorService.namesFLux_immutability();
        StepVerifier.create(namesFlux)
                .expectNext("alex", "ben", "chloe")
                .verifyComplete();
    }

    @Test
    void namesFLux_flatmap() {
        int stringLength = 3;
        var namesFlux = fluxAndMonoGeneratorService.namesFLux_flatmap(stringLength);
        StepVerifier.create(namesFlux)
                .expectNext("A", "L", "E", "X", "C", "H", "L", "O", "E")
                .verifyComplete();
    }


    @Test
    void namesFLux_flatmap_async() {
        int stringLength = 3;
        var namesFlux = fluxAndMonoGeneratorService.namesFLux_flatmap_async(stringLength);
        StepVerifier.create(namesFlux)
                .expectNext("A", "L", "E", "X", "C", "H", "L", "O", "E")
                .verifyComplete();
    }
}