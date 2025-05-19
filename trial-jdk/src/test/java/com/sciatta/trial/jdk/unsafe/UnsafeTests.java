package com.sciatta.trial.jdk.unsafe;

import org.junit.Test;

import static org.junit.Assert.*;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

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
            
            System.out.println(unsafe.getInt(addr));    // 16843009
            System.out.println(unsafe.getLong(addr3));  // 72340172838076673
            
        } finally {
            unsafe.freeMemory(addr);
            unsafe.freeMemory(addr3);
        }
    }
    
    @Test
    public void testSetField(){
        class Obj {
            private int value;
        }
        
        Unsafe unsafe = getUnsafe();
        
        //unsafe.objectFieldOffset()
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


