import java.util.Scanner;

public class PalindromeAPPv1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check palindrome:");
        String input = sc.nextLine();
        PalindromeChecker checker = new PalindromeChecker();
        if (checker.checkPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        sc.close();
    }
}

class PalindromeChecker {
    public boolean checkPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        return isPalindrome(normalized, 0, normalized.length() - 1);
    }

    private boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }
}