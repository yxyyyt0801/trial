package com.sciatta.trial.jdk.proxy.cglibproxy;

import com.sciatta.trial.jdk.proxy.Dog;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by yangxiaoyu on 2025/5/17<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * DogFactory
 */
public class DogFactory {
    private final Enhancer enhancer = new Enhancer();
    
    public DogFactory() {
        enhancer.setClassLoader(Dog.class.getClassLoader());
        enhancer.setSuperclass(Dog.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("~hello~" + method.getName());
                Object ans = methodProxy.invokeSuper(o, objects);
                System.out.println("~bye~" + method.getName());
                return ans;
            }
        });
    }
    
    public Dog create() {
        return (Dog) enhancer.create();
    }
}
