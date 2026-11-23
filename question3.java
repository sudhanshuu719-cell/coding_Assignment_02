public class Main {

    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }
        Stack charStack = new Stack();
        for (int i = 0; i < input.length(); i++) {
            charStack.pushSilent(input.charAt(i));
        }
        StringBuilder reversed = new StringBuilder();
        while (!charStack.isEmpty()) {
            reversed.append((char) charStack.popSilent());
        }
        return reversed.toString();
    }

    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        Stack charStack = new Stack();
        for (int i = 0; i < input.length(); i++) {
            charStack.pushSilent(input.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != (char) charStack.popSilent()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Sample Test Case ===");
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        stack.peek();
        stack.pop();
        stack.display();
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
        stack.pop();

        System.out.println("\n=== 2. Challenge Questions ===");

        String sampleStr = "hello";
        System.out.println("Original: " + sampleStr + " | Reversed: " + reverseString(sampleStr));

        String pal1 = "madam";
        String pal2 = "java";
        System.out.println("Is \"" + pal1 + "\" palindrome? " + isPalindrome(pal1));
        System.out.println("Is \"" + pal2 + "\" palindrome? " + isPalindrome(pal2));

        Stack revStack = new Stack();
        revStack.pushSilent(10);
        revStack.pushSilent(20);
        revStack.pushSilent(30);
        revStack.pushSilent(40);
        System.out.print("Before reverse (top to bottom): ");
        revStack.display();
        revStack.reverseUsingAnotherStack();
        System.out.print("After reverse (top to bottom):  ");
        revStack.display();

        System.out.println("Middle element of reversed stack: " + revStack.findMiddle());
    }
}
