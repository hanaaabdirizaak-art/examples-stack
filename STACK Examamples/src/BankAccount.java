
    import java.util.Stack;

    class BankAccount {
        private double balance;
        private Stack<Double> history = new Stack<>();

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance = balance + amount;
            history.push(amount);
            System.out.println("Deposit " + amount + " -> balance " + balance);
        }

        public void undoLastDeposit() {
            if (history.isEmpty()) {
                System.out.println("Nothing to undo");
                return;
            }

            double last = history.pop();
            balance = balance - last;
            System.out.println("Undo " + last + " -> balance " + balance);
        }
    }

    class UndoDepositDemo {
        public static void main(String[] args) {
            BankAccount acc = new BankAccount(100);

            acc.deposit(50);
            acc.deposit(20);
            acc.deposit(30);

            acc.undoLastDeposit();
            acc.undoLastDeposit();
        }
    }



    //example5


    class Registration {
        private String studentName;
        private Stack<String> courses = new Stack<>();

        public Registration(String studentName) {
            this.studentName = studentName;
        }

        public void addCourse(String code) {
            courses.push(code);
            System.out.println("Added " + code + " -> " + courses);
        }

        public void undoLastCourse() {
            if (courses.isEmpty()) {
                System.out.println("Nothing to undo");
                return;
            }

            String removed = courses.pop();
            System.out.println("Removed " + removed + " -> " + courses);
        }
    }

     class UndoCourseDemo {
        public static void main(String[] args) {
            Registration reg = new Registration("Hodan");

            reg.addCourse("CA314");
            reg.addCourse("CA301");
            reg.addCourse("MA210");

            reg.undoLastCourse();
        }
    }


    //exampl6

    class Reverser {
        public String reverse(String input) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                stack.push(input.charAt(i));
            }

            String reversed = "";

            while (!stack.isEmpty()) {
                reversed += stack.pop();
            }

            return reversed;
        }
    }




    //examples7
