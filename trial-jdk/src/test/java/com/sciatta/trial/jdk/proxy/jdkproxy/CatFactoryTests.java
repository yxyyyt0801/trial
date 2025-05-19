package com.sciatta.trial.jdk.proxy.jdkproxy;

import com.sciatta.trial.jdk.proxy.Animal;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yangxiaoyu on 2025/5/16<br>
 * All Rights Reserved(C) 2017 - 2025 SCIATTA<br><p/>
 * CatFactoryTests
 */
public class CatFactoryTests {
    @Test
    public void testGetCat() {
        Animal cat = CatFactory.getCat();
        assertNotNull(cat);
        
        cat.eat();
        
        System.out.println();
        
        cat.sleep();
    }
    
    @Test
    public void testCacheClass() {
        Animal cat = CatFactory.getCat();
        cat = CatFactory.getCat();
        assertNotNull(cat);
    }
}
