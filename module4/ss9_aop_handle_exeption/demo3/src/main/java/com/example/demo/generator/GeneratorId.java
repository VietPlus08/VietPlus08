package com.example.demo.generator;

import java.util.List;
import java.util.stream.Stream;

public class GeneratorId {
    private static final String PREFIX_BORROW = "MS-";

    public static String getGeneratorId(List<String> data){
        Stream<String> ids = data.stream();
        Long max = ids.map(i -> i.replace(PREFIX_BORROW, ""))
                .mapToLong(Long::parseLong)
                .max().orElse(0L);
        return PREFIX_BORROW + String.format("%04d", max + 1);
    }
}
