
    import java.util.Arrays;
import java.util.EmptyStackException;

     class ArrayStack<T> {
        private final static int DEFAULT_CAPACITY = 2;
        private int top;
        private T[] stack;

        public ArrayStack() {
            this(DEFAULT_CAPACITY);
        }

        public ArrayStack(int initialCapacity) {
            top = 0;
            stack = (T[]) (new Object[initialCapacity]);
        }

        public void push(T element) {
            if (size() == stack.length)
                expandCapacity();

            stack[top] = element;
            top++;
        }

        private void expandCapacity() {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }

        public T pop() throws EmptyStackException {
            if (isEmpty())
                throw new EmptyStackException();

            top--;
            T result = stack[top];
            stack[top] = null;

            return result;
        }

        public T peek() throws EmptyStackException {
            if (isEmpty())
                throw new EmptyStackException();

            return stack[top - 1];
        }

        public int size() {
            return top;
        }

        public boolean isEmpty() {
            return top == 0;
        }

        public int capacity() {
            return stack.length;
        }
    }



    //example8
    class ArrayStackTraceDemo {
        public static void main(String[] args) {
            ArrayStack<String> s = new ArrayStack<>();

            s.push("A");
            s.push("B");

            System.out.println("size " + s.size()
                    + ", capacity " + s.capacity());

            s.push("C");

            System.out.println("size " + s.size()
                    + ", capacity " + s.capacity());

            System.out.println("peek: " + s.peek());

            System.out.println("pop: " + s.pop());
            System.out.println("pop: " + s.pop());
            System.out.println("pop: " + s.pop());
            System.out.println("pop: " + s.pop());
        }
    }

//ex9
class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException(String collection) {
        super("The " + collection + " is empty.");
    }
}

class main {
    public static void main(String[] args) {
        try {
            throw new EmptyCollectionException("stack");
        } catch (EmptyCollectionException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}


//exampl11
 class ReversedStepsDemo {

    static void print(String label, Node<String> head) {
        System.out.print(label);

        Node<String> cur = head;

        for (int i = 0; i < 5 && cur != null; i++) {
            System.out.print(cur.getElement() + " -> ");
            cur = cur.getNext();
        }

        System.out.println(cur == null ? "null" : "...");
    }

    public static void main(String[] args) {

        // Correct order
        Node<String> head = new Node<>("B");
        Node<String> newNode = new Node<>("A");

        newNode.setNext(head);
        head = newNode;

        print("Correct: ", head);

        // Swapped order
        head = new Node<>("B");
        newNode = new Node<>("A");

        head = newNode;
        newNode.setNext(head);

        print("Swapped: ", head);
    }
}
