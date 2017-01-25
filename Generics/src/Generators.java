import coffee.Coffee;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by yueban on 2017/1/24.
 */
public class Generators {
    public static <T> void fill(Collection<T> collection, Generator<T> generator, int count) {
        for (int i = 0; i < count; i++) {
            collection.add(generator.next());
        }
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = new ArrayList<>();
        fill(coffees, new CoffeeGenerator(), 10);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }

        System.out.println("---------------");

        Collection<Integer> fibonacci = new ArrayList<>();
        fill(fibonacci, new Fibonacci(), 10);
        for (int num : fibonacci) {
            System.out.println(num);
        }
    }
}
