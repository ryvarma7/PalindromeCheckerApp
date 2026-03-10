import java.util.Scanner;

public class PalindromeAPPv1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check palindrome:");
        String input = sc.nextLine();
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        if (isPalindrome(normalized, 0, normalized.length() - 1)) {
            System.out.println("The string is a palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The string is not a palindrome (ignoring spaces and case).");
        }
        sc.close();
    }

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }
}