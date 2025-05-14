package com.sciatta.trial.jdk.hash;

import lombok.AllArgsConstructor;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashSet;

/**
 * Created by yangxiaoyu on 2025/5/13<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * HashCodeTests
 */
public class HashCodeTests {
    @Test
    public void testStringHashCode() {
        String test = "test";
        int hashCode = test.hashCode(); // String的equals和hashCode方法都被重写
        System.out.println(hashCode);
    }
    
    @Test
    public void testObjectHashCode() {
        Object test = new Object();
        int hashCode = test.hashCode(); // Object的hashCode是native方法，equals用==比较
        System.out.println(hashCode);
    }
    
    @Test
    public void testNotSameHashCode() {
        @AllArgsConstructor
        class Obj {
            private int a;
            
            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Obj) {
                    return a == ((Obj) obj).a;
                }
                return false;
            }
        }
        
        // 本意是创建两个相同的对象，但因为没有重写 hashcode，导致全部插入成功
        Obj a = new Obj(1);
        Obj b = new Obj(1);
        
        HashSet<Obj> set = new HashSet<>();
        set.add(a);
        set.add(b);
        assertEquals(2, set.size());
    }
    
    @Test
    public void testSameHashCode() {
        @AllArgsConstructor
        class Obj {
            private int a;
            
            @Override
            public int hashCode() {
                return a;
            }
            
            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Obj) {
                    return a == ((Obj) obj).a;
                }
                return false;
            }
        }
        
        // 创建两个相同的对象
        Obj a = new Obj(1);
        Obj b = new Obj(1);
        
        HashSet<Obj> set = new HashSet<>();
        set.add(a);
        set.add(b);
        assertEquals(1, set.size());
    }
}
