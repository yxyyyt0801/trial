package com.sciatta.trial.jdk.spi.impl;

import com.sciatta.trial.jdk.spi.Person;

/**
 * Created by Rain on 2025/5/21<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA <br> <p/>
 * Robot
 */
public class Robot implements Person {
    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
