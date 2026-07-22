import java.util.Scanner;

public class LongestValidParentheses {

    public static int longestValidParentheses(String text) {

        int[] dp = new int[text.length()];
        int answer = 0;

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == ')') {
                 if (text.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i >= 2) {
                        dp[i] += dp[i - 2];
                    }
                } else {
                    int previous = i - dp[i - 1] - 1;

                    if (previous >= 0 && text.charAt(previous) == '(') {
                        dp[i] = dp[i - 1] + 2;

                        if (previous > 0) {
                            dp[i] += dp[previous - 1];
                        }
                    }
                }

                answer = Math.max(answer, dp[i]);
            }
        }
return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
System.out.print("Enter the parentheses string: ");
        String text = sc.nextLine();
System.out.println("Longest Valid Parentheses Length: " + longestValidParentheses(text));

        
    }
}
