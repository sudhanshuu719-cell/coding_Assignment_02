public class Stack {
    private Node top;
    private int count;

    public Stack() {
        this.top = null;
        this.count = 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        count++;
        System.out.println(data + " inserted");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int poppedValue = top.data;
        top = top.next;
        count--;
        System.out.println(poppedValue + " removed");
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        System.out.println(top.data);
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return count;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        System.out.println(sb.toString());
    }

    public void reverseUsingAnotherStack() {
        if (isEmpty() || count == 1) {
            return;
        }
        Stack auxStack = new Stack();
        while (!this.isEmpty()) {
            auxStack.pushSilent(this.popSilent());
        }
        Stack tempStack = new Stack();
        while (!auxStack.isEmpty()) {
            tempStack.pushSilent(auxStack.popSilent());
        }
        while (!tempStack.isEmpty()) {
            this.pushSilent(tempStack.popSilent());
        }
    }

    public int findMiddle() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        Node slow = top;
        Node fast = top;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    private void pushSilent(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        count++;
    }

    private int popSilent() {
        if (isEmpty()) {
            return -1;
        }
        int val = top.data;
        top = top.next;
        count--;
        return val;
    }
}
