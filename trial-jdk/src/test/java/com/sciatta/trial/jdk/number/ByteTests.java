package com.sciatta.trial.jdk.number;

import org.junit.Test;

/**
 * Created by yangxiaoyu on 2025/5/19<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * ByteTests
 */
public class ByteTests {
    @Test
    public void test() {
        Integer i = Integer.parseInt("00000001000000010000000100000001", 2);
        System.out.println(i);
        
        long l = Long.parseLong("0000000100000001000000010000000100000001000000010000000100000001", 2);
        System.out.println(l);
        
    }
}
