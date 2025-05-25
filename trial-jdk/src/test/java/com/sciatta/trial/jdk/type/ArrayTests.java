package com.sciatta.trial.jdk.type;

import lombok.AllArgsConstructor;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * Created by Rain on 2025/5/25<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA <br> <p/>
 * ArrayTests
 */
public class ArrayTests {
    @Test
    public void testArrayCopy() {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        int[] b = new int[20];
        System.arraycopy(a, 0, b, a.length, a.length);
        System.out.println(Arrays.toString(b));
    }

    @Test
    public void testArrayClone() {
        @AllArgsConstructor
        class Obj {
            private int value;
        }

        Obj[] objs = new Obj[10];
        for (int i = 0; i < objs.length; i++) {
            objs[i] = new Obj(i + 1);
        }

        // 底层用到了System.arraycopy
        // 浅拷贝
        Obj[] result = Arrays.copyOf(objs, 10);
        for (int i = 0; i < result.length; i++) {
            assertSame(objs[i], result[i]);
            assertEquals(objs[i].value, result[i].value);
        }
    }
}
