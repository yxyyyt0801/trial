package com.sciatta.trial.jdk.spi;

import org.junit.jupiter.api.Test;

/**
 * Created by Rain on 2025/5/21<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA <br> <p/>
 * PersonServiceTests
 */
public class PersonServiceTests {
    @Test
    public void test() {
        PersonService personService = PersonService.getINSTANCE();
        personService.sayHello();
    }
}
