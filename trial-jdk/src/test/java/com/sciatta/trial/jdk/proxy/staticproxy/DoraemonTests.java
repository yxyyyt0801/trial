package com.sciatta.trial.jdk.proxy.staticproxy;

import com.sciatta.trial.jdk.proxy.Cat;
import org.junit.Test;

/**
 * Created by yangxiaoyu on 2025/5/16<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * DoraemonTests
 */
public class DoraemonTests {
    @Test
    public void test() {
        Doraemon cat = new Doraemon(new Cat());
        System.out.println("cat eat:");
        cat.eat();
        
        System.out.println("cat sleep:");
        cat.sleep();
        
    }
}
