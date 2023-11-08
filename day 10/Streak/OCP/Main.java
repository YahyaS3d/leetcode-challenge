public class Main {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };

        // Use the Pattern132Finder interface to find the 132 pattern
        Pattern132Finder finder = new Solution();
        boolean result = finder.find132pattern(nums);

        System.out.println("Pattern found: " + result);
    }
}