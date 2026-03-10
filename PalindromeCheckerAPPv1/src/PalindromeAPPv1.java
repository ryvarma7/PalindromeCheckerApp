import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeAPPv1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check palindrome performance:");
        String input = sc.nextLine();

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        long startTime = System.nanoTime();
        boolean stackResult = stackStrategy.isPalindrome(input);
        long endTime = System.nanoTime();
        System.out.println("StackStrategy result: " + stackResult + ", Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        boolean dequeResult = dequeStrategy.isPalindrome(input);
        endTime = System.nanoTime();
        System.out.println("DequeStrategy result: " + dequeResult + ", Time: " + (endTime - startTime) + " ns");

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
            if (stack.pop() != c) return false;
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}