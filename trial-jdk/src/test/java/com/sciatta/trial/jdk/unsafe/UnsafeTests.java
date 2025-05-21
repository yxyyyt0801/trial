package com.sciatta.trial.jdk.unsafe;

import org.junit.Test;

import static org.junit.Assert.*;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;

/**
 * Created by yangxiaoyu on 2025/5/19<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * UnsafeTests
 */
public class UnsafeTests {
    @Test(expected = SecurityException.class)
    public void testGetUnsafeHasSecurityException() {
        // 类必须由 BootstrapClassLoader 加载，否则有安全隐患
        Unsafe.getUnsafe();
    }

    @Test
    public void testGetUnsafe() {
        Unsafe unsafe = getUnsafe();    // 通过反射获得
        assertNotNull(unsafe);
    }

    @Test
    public void testMemory() {
        Unsafe unsafe = getUnsafe();

        int size = 4;
        long addr = unsafe.allocateMemory(size);    // 分配 4 字节长度的内存
        long addr3 = unsafe.reallocateMemory(addr, size * 2);   // 重新分配 8 字节长度的内存
        System.out.println("addr: " + addr);
        System.out.println("addr3: " + addr3);

        try {
            // 起始字节地址addr的全部4个字节赋值 1
            // 00000001 00000001 00000001 00000001
            unsafe.setMemory(null, addr, size, (byte) 1);

            for (int i = 0; i < 2; i++) {
                // 00000001 00000001 00000001 00000001 00000001 00000001 00000001 00000001
                unsafe.copyMemory(null, addr, null, addr3 + size * i, 4);
            }

            assertEquals(16843009, unsafe.getInt(addr));
            assertEquals(72340172838076673L, unsafe.getLong(addr3));
        } finally {
            //unsafe.freeMemory(addr);
            //unsafe.freeMemory(addr3);
        }
    }

    @Test
    public void testSetField() throws NoSuchFieldException {
        class Obj {
            private int value;
        }

        Unsafe unsafe = getUnsafe();

        long valueOffset = unsafe.objectFieldOffset(Obj.class.getDeclaredField("value"));
        Obj obj = new Obj();
        unsafe.putInt(obj, valueOffset, 100);
        assertEquals(100, obj.value);
    }

    @Test
    public void testCAS() throws Exception {
        class Obj {
            private int value;
        }

        Unsafe unsafe = getUnsafe();
        CountDownLatch latch = new CountDownLatch(2);
        Obj obj = new Obj();
        obj.value = 0;
        int times = 1000000;
        long valueOffset = unsafe.objectFieldOffset(Obj.class.getDeclaredField("value"));

        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (i < (times / 2)) {

                try {
                    plusOne(unsafe, obj, valueOffset);
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
            latch.countDown();
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            int i = 0;
            while (i < (times / 2)) {
                try {
                    plusOne(unsafe, obj, valueOffset);
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
            latch.countDown();
        });
        thread2.start();

        latch.await();

        assertEquals(times, obj.value);
    }

    private void plusOne(Unsafe unsafe, Object obj, long valueOffset) throws NoSuchFieldException {
        int anInt = unsafe.getInt(obj, valueOffset);
        while (!unsafe.compareAndSwapInt(obj, valueOffset, anInt, ++anInt)) {
            anInt = unsafe.getInt(obj, valueOffset);
        }
    }

    private Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
}


