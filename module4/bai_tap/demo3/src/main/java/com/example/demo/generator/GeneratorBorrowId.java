package com.example.demo.generator;

import com.example.demo.service.impl.BorrowService;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.stream.Stream;

public class GeneratorBorrowId implements IdentifierGenerator {

    @Autowired
    private BorrowService borrowService;
    private String prefix = "MS-";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Stream<String> ids = borrowService.findAllId().stream();
        Long max = ids.map(i -> i.replace(prefix, ""))
                .mapToLong(Long::parseLong)
                .max().orElse(0L);
        return prefix + String.format("%04d", max + 1);
    }

}
