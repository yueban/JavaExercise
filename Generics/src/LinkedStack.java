/**
 * Created by yueban on 2016/11/29.
 */
public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        public Node() {
            new Node<U>(null, null);
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }

        @Override
        public String toString() {
            if (end()) {
                return "end";
            }
            return item.toString() + " " + next.toString();
        }
    }

    private Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + top.toString() + "]";
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack);
        System.out.println("pop " + stack.pop());
        System.out.println(stack);
        System.out.println("pop " + stack.pop());
        System.out.println("pop " + stack.pop());
        System.out.println(stack);
        System.out.println("pop " + stack.pop());
        System.out.println(stack);
    }
}
