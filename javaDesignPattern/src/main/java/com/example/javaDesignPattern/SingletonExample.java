package com.example.javaDesignPattern;

import org.w3c.dom.ls.LSInput;

class SingletonEager{
    private static SingletonEager instance = new SingletonEager();
    private SingletonEager(){}

    public static SingletonEager getInstance() {
        return instance;
    }
}

class SingletonLazy{
    private static SingletonLazy instance;

    private SingletonLazy(){}

    public static SingletonLazy getInstance() {
        if (instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}

class SingletonThreadSafeMethod{
    private static SingletonThreadSafeMethod instance;

    private SingletonThreadSafeMethod(){}

    public static synchronized SingletonThreadSafeMethod getInstance() {
        if (instance == null){
            instance = new SingletonThreadSafeMethod();
        }
        return instance;
    }
}

class SingletonThreadSafeBlock{
    private static SingletonThreadSafeBlock instance;

    private SingletonThreadSafeBlock(){}

    public static SingletonThreadSafeBlock getInstance() {
        if (instance == null){
            synchronized (SingletonThreadSafeBlock.class){
                if (instance == null)
                {
                    instance = new SingletonThreadSafeBlock();
                }
            }
        }
        return instance;
    }
}

class SingletonExample {
    public static void main(String[] args) {
        SingletonEager instance1 = SingletonEager.getInstance();
        SingletonEager instance2 = SingletonEager.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);

    }

}
