package coffee;

/**
 * Created by yueban on 2017/1/23.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return id + " " + getClass().getSimpleName();
    }
}
