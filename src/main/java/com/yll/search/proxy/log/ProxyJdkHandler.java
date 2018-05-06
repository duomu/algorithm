package main.java.com.yll.search.proxy.log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 接口无返回类型的jdk代理实现
 */
public class ProxyJdkHandler implements InvocationHandler {
    private Object target;

    public Object getProxy(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if (method.getAnnotation(PrintLog.class) != null) {
            long start = System.currentTimeMillis();
            result = method.invoke(this.target, args);
            long end = System.currentTimeMillis();
            System.out.println(this.target.getClass().getSimpleName() + " " + method.getName() + " spend time：" + (end - start) + "ms");
        } else {
            result = method.invoke(this.target, args);
        }

        return result;
    }
}
