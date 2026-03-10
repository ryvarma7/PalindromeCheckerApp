import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;

public class PalindromeAPPv1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check palindrome:");
        String input = sc.nextLine();

        PalindromeStrategy strategy;

        // Choose strategy dynamically (example: StackStrategy)
        strategy = new StackStrategy();
        if (strategy.isPalindrome(input)) {
            System.out.println("StackStrategy: The string is a palindrome.");
        } else {
            System.out.println("StackStrategy: The string is not a palindrome.");
        }

        // Another example: DequeStrategy
        strategy = new DequeStrategy();
        if (strategy.isPalindrome(input)) {
            System.out.println("DequeStrategy: The string is a palindrome.");
        } else {
            System.out.println("DequeStrategy: The string is not a palindrome.");
        }

        sc.close();
    }
}

interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        for (char c : str.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}