package com.sciatta.trial.jdk.proxy.jdkproxy;

import com.sciatta.trial.jdk.proxy.Animal;
import com.sciatta.trial.jdk.proxy.Cat;

import java.lang.reflect.Proxy;

/**
 * Created by yangxiaoyu on 2025/5/16<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * 基于JDK动态代理
 */
public class CatFactory {
    
    public static Animal getCat() {
        return getCat(new Cat());
    }
    
    public static Animal getCat(Animal animal) {
        return (Animal) Proxy.newProxyInstance(animal.getClass().getClassLoader(), animal.getClass().getInterfaces(),
                (proxy1, method, args) -> {
                    System.out.println("Jdk proxy start");
                    Object ans = method.invoke(animal, args);
                    System.out.println("Jdk proxy end");
                    return ans;
                });
    }
}
