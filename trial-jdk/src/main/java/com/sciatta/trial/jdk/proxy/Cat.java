package com.sciatta.trial.jdk.proxy;

/**
 * Created by yangxiaoyu on 2025/5/16<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * Cat
 */
public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("cat eat");
    }
    
    @Override
    public void sleep() {
        System.out.println("cat sleep");
    }
}
