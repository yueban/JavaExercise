package transaction;

import java.io.File;
import java.lang.reflect.Proxy;

/**
 * Created by yueban on 2016/11/2.
 */
public class TransactionProxy {
    public static void main(String[] args) {
        File file = new File("1.txt");
        FileMethods fileMethods = (FileMethods) proxyFor(new CustomFile(file));
        fileMethods.append("append");
        fileMethods.appendWithException("appendWithException");
    }

    public static Object proxyFor(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new
                TransactionInvocationHandler(object));
    }
}
