package com.curiousnerds.streams.tests.test21;

import com.curiousnerds.streams.common.Data;

import java.util.stream.Stream;

public class Problem extends Data {

    public Stream<Integer> createStreamMultiplesOfThree() {

        return Stream.iterate(0, integer -> integer + 3).limit(10);
    }

}

