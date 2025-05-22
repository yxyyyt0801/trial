package com.sciatta.trial.jdk.spi;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Created by Rain on 2025/5/21<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA <br> <p/>
 * PersonService
 */
public class PersonService implements Person {
    @Getter
    private static final PersonService INSTANCE = new PersonService();
    private final List<Person> services = new ArrayList<>();

    private PersonService() {
        ServiceLoader<Person> loader = ServiceLoader.load(Person.class);
        loader.forEach(services::add);
    }

    @Override
    public void sayHello() {
        if (services.isEmpty()) {
            System.out.println("No services found");
            return;
        }

        services.get(0).sayHello();
    }
}
