package main.java.com.yll.search.proxy.demo;

import main.java.com.yll.search.proxy.log.ProxyCglibHandler;
import main.java.com.yll.search.proxy.log.ProxyJdkHandler;

public class Client {
    public static void main(String[] args) {
        IHuman woman = new Woman();
        woman.say();

        //jdk proxy
        ProxyJdkHandler proxyJdkHandler = new ProxyJdkHandler();

        IHuman womanProxy = (IHuman) proxyJdkHandler.getProxy(new Woman());
        womanProxy.say();

        IHuman manProxy = (IHuman) proxyJdkHandler.getProxy(new Man());
        manProxy.say();

        //cglib proxy
        ProxyCglibHandler proxyCglibHandler = new ProxyCglibHandler();
        womanProxy = (IHuman) proxyCglibHandler.getProxy(new Woman());
        womanProxy.say();
        manProxy = (IHuman) proxyCglibHandler.getProxy(new Man());
        manProxy.say();
    }
}
