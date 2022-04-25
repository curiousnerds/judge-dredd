package com.curiousnerds.streams.tests.test20;

import com.curiousnerds.streams.common.Data;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem extends Data {


    public Stream<String> streamOf() {
        return Stream.of("a", "b", "c");
    }



}

