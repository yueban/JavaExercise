package demo;

import java.lang.reflect.Proxy;

/**
 * Created by yueban on 2016/11/2.
 */
public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(), new
                Class[]{SomeMethods.class}, new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("boom");
        proxy.boring3();
    }
}