import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    // Method to check odd/even
    public static PerformOperation isOdd() {
        return (int a) -> (a % 2 != 0);
    }

    // Method to check prime
    public static PerformOperation isPrime() {
        return (int a) -> {
            if (a <= 1) return false;
            if (a == 2) return true;
            if (a % 2 == 0) return false;
            for (int i = 3; i <= Math.sqrt(a); i += 2) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    // Method to check palindrome
    public static PerformOperation isPalindrome() {
        return (int a) -> {
            String s = String.valueOf(a);
            return new StringBuilder(s).reverse().toString().equals(s);
        };
    }

    // Method to execute the operation
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        MyMath ob = new MyMath();
        while (T-- > 0) {
            int ch = sc.nextInt();
            int num = sc.nextInt();
            PerformOperation op;
            boolean ret = false;
            String ans = null;
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
