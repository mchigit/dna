package hackerrank;


import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {



    static boolean checkBalance(String expression) {
        boolean balanced = true;
        Stack<Character> bracketStack = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++) {
            char bracket = expression.charAt(i);
            if (bracket == '(') {
                bracketStack.push(')');
            } else if (bracket == '{') {
                bracketStack.push('}');
            } else if (bracket == '['){
                bracketStack.push(']');
            } else {
                if (bracketStack.empty()) {
                    balanced = false;
                    break;
                }
                if (bracket != bracketStack.pop()) {
                    balanced = false;
                }
            }
        }

        if (!bracketStack.empty()) balanced = false;

        return balanced;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            boolean isBalanced = checkBalance(expression);
            System.out.println(isBalanced ? "YES" : "NO");
        }

        scanner.close();
    }
}