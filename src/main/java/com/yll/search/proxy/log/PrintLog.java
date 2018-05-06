package main.java.com.yll.search.proxy.log;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PrintLog {
    int id();

    String desc();

}

