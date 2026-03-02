/*
 * Program starts.
 * JVM invokes the main() method.
 * Application name is displayed.
 * Application version is displayed.
 * Program continues to next use case or exits
 * @author midhunreddy(jagan mavayya)
 */

public class PalindromeAPPv1 {

    public static void main(String[] args) {

        // Hardcoded string
        String word = "madam";

        // Reverse the string
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        // Check if palindrome
        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System Initialized......");
    }
}