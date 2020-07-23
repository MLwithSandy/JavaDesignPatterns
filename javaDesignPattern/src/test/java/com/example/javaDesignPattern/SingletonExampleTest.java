package com.example.javaDesignPattern;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonExampleTest {

    @Test
    @DisplayName("Singleton Lazy ")
    public void SingletonLazyTest(){
        assertEquals(SingletonLazy.getInstance(), SingletonLazy.getInstance(), "Both instances should be same");
    }

    @Test
    @DisplayName("Singleton ThreadSafe Method ")
    public void SingletonTSMTest(){
        assertEquals(SingletonThreadSafeMethod.getInstance(), SingletonThreadSafeMethod.getInstance(), "Both instances should be same");
    }
    @Test
    @DisplayName("Singleton ThreadSafe Block ")
    public void SingletonTSBTest(){
        assertEquals(SingletonThreadSafeBlock.getInstance(), SingletonThreadSafeBlock.getInstance(), "Both instances should be same");
    }

}