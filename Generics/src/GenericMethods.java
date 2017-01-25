/**
 * Created by yueban on 2017/1/24.
 */
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods methods = new GenericMethods();
        methods.f(0);
        methods.f(1.1f);
        methods.f(1.1);
        methods.f("");
        methods.f('1');
        methods.f(true);
        methods.f(methods);
    }
}
