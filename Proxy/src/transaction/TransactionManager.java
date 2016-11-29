package transaction;

/**
 * Created by yueban on 2016/11/2.
 */
public class TransactionManager {
    public static void beginTransaction() {
        System.out.println("beginTransaction");
    }

    public static void endTransaction() {
        System.out.println("endTransaction");
    }

    public static void commit() {
        System.out.println("commit");
    }

    public static void rollback() {
        System.out.println("rollback");
    }
}
