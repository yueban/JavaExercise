package transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yueban on 2016/11/2.
 */
public class TransactionInvocationHandler implements InvocationHandler {
    private Object proxied;

    public TransactionInvocationHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TransactionManager.beginTransaction();
        Object result = null;
        try {
            System.out.println("method: " + method.getName());
            result = method.invoke(proxied, args);
            TransactionManager.commit();
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getCause().getMessage());
            TransactionManager.rollback();
        } finally {
            TransactionManager.endTransaction();
        }
        System.out.println();
        return result;
    }
}
