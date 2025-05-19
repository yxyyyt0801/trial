package com.sciatta.trial.jdk.proxy.cglibproxy;

import com.sciatta.trial.jdk.proxy.Dog;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yangxiaoyu on 2025/5/17<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * DogFactoryTests
 */
public class DogFactoryTests {
    @Test
    public void test() {
        DogFactory factory = new DogFactory();
        
        Dog dogA = factory.create();
        dogA.eat();
        dogA.sleep();
        
        Dog dogB = factory.create();
        
        assertNotSame(dogA, dogB);
    }
}
