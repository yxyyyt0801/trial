package com.sciatta.trial.jdk.hash;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yangxiaoyu on 2025/5/13<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * StringTests
 */
public class StringTests {
    @Test
    public void testIntern() {
        String a = "abc";
        String b = a.intern();  // 查找字符串常量池，有则返回；没有则置入字符串常量池，返回字符串常量池引用
        assertSame(a, b);
        
        String c = new String("abc");
        String d = c.intern();  // 返回字符串常量池引用
        assertNotSame(c, d);
        assertSame(a, d);
        
        String s1 = "str";
        String s2 = "ing";
        String s3 = s1 + s2;    // 编译期无法确定
        String s4 = "str" + "ing";
        String s5 = "string";
        // 对于编译期可以确定值的字符串，如 s4，jvm 会将其存入字符串常量池
        assertSame(s4, s5);
        assertNotSame(s3, s4);
        
        final String t1 = "str";
        final String t2 = "ing";
        String t3 = t1 + t2;    // 声明为 final 的变量，在编译期可以确定，jvm 会将其存入字符串常量池
        String t4 = "str" + "ing";
        String t5 = "string";
        assertSame(t4, t5);
        assertSame(t3, t4);
    }
    
    @Test
    public void testString() {
        String a = "abc";   // private final char value[];
        System.out.println(a);
        
        StringBuilder sb = new StringBuilder("a");  // char[] value; 可以扩容
        sb.append("b");
        sb.append("c");
        System.out.println(sb);
        
        StringBuffer sb2 = new StringBuffer("a");   // 类似StringBuilder，增加synchronized方法同步
        sb2.append("b");
        sb2.append("c");
        System.out.println(sb2);
    }
}
