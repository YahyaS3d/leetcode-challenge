public class ValidParenthesesTest {
    public static void main(String[] args) {
        Validator validator = new Validator();

        String[] testCases = {
            "(())",
            "()[]{}",
            "([{}])",
            "()",
            "({[)}]",
            "(((",
            ")()",
            "({{[()]}})"
        };

        for (String s : testCases) {
            boolean isValid = validator.isValid(s);
            System.out.println("Input: " + s);
            System.out.println("Output: " + isValid);
            System.out.println();
        }
    }
}