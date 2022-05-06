package com.curiousnerds.streams.tests.test20;

import com.curiousnerds.streams.common.Data;

import java.util.stream.Stream;

public class Problem extends Data {


    public Stream<String> streamOf() {
        return Stream.of("a", "b", "c");
    }



}

