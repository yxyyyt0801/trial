package com.sciatta.trial.jdk.juc;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Rain on 2025/5/30<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA <br> <p/>
 * LongAdderTests
 */
public class LongAdderTests {
    @Test
    public void test() {
        LongAdder adder = new LongAdder();
        adder.add(1);
        adder.add(2);
        adder.add(3);
        assertEquals(6, adder.sum());   // 结果非事实，最终一致

    }
}
