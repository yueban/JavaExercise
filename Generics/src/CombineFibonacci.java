import java.util.Iterator;

/**
 * Created by yueban on 2017/1/24.
 */
public class CombineFibonacci implements Iterable<Integer> {
    private Fibonacci fibonacci = new Fibonacci();
    private int n;

    public CombineFibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return fibonacci.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int num : new CombineFibonacci(20)) {
            System.out.println(num);
        }
    }
}
