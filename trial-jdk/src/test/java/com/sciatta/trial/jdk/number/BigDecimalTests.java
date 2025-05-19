package com.sciatta.trial.jdk.number;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by yangxiaoyu on 2025/5/17<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * BigDecimalTests
 */
public class BigDecimalTests {
    @Test
    public void test() {
        float a = 1f - 0.9f;
        float b = 1.8f - 1.7f;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        assertNotSame(a, b);
        
        BigDecimal c1 = new BigDecimal("1");
        BigDecimal c2 = new BigDecimal("0.9");
        BigDecimal c = c1.subtract(c2);
        System.out.println("c = " + c);
        
        BigDecimal d1 = new BigDecimal("1.8");
        BigDecimal d2 = new BigDecimal("1.7");
        BigDecimal d = d1.subtract(d2);
        System.out.println("d = " + d);
        
        assertEquals(0, c.compareTo(d));
        
    }
}
