package com.sciatta.trial.jdk.proxy.staticproxy;

import com.sciatta.trial.jdk.proxy.Animal;
import lombok.AllArgsConstructor;

/**
 * Created by yangxiaoyu on 2025/5/16<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * 静态代理必须实现目标实例实现接口的所有方法
 */
@AllArgsConstructor
public class Doraemon implements Animal {
    private Animal target;
    
    @Override
    public void eat() {
        System.out.println("don't eat");
        target.eat();
        System.out.println("~\n");
    }
    
    @Override
    public void sleep() {
        System.out.println("don't sleep");
        target.sleep();
        System.out.println("~\n");
    }
}
