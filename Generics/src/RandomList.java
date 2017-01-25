import java.util.*;

/**
 * Created by yueban on 2017/1/23.
 */
public class RandomList<T> {
    private final List<T> storage = new ArrayList<T>();

    private final Random random = new Random();

    public void add(T t) {
        storage.add(t);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<Integer> randomList = new RandomList<>();
        for (int i = 0; i < 10; i++) {
            randomList.add(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(randomList.select());
        }
    }
}
